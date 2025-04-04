package com.example.springebootapplication.services;

import com.example.springebootapplication.dto.CategoryDto;
import com.example.springebootapplication.dto.NotFoundResponse;
import com.example.springebootapplication.entities.Category;
import com.example.springebootapplication.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryCRUDService implements CRUDService<CategoryDto> {

    private final NotFoundResponse notFoundResponse = new NotFoundResponse();
    private final CategoryRepository categoryRepository;

    @Override
    public ResponseEntity getById(Long id) {
        log.info("Get by id {}", id);
        try {
            Category category = categoryRepository.findById(id).orElseThrow();
            return new ResponseEntity(mapToDto(category), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(notFoundResponse.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity getAll() {
        log.info("Get all");
        return new ResponseEntity(categoryRepository.findAll()
                .stream()
                .map(CategoryCRUDService::mapToDto)
                .toList(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity create(CategoryDto categoryDto) {
        log.info("Create");
        Category category = mapToEntity(categoryDto);
        categoryRepository.save(category);
        return new ResponseEntity(mapToDto(category), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity update(CategoryDto categoryDto) {
        log.info("update");
        Category category = mapToEntity(categoryDto);
        categoryRepository.save(category);
        return new ResponseEntity(category, HttpStatus.OK);
    }

    @Override
    public ResponseEntity delete(Long id) {
        log.info("delete id {}", id);
        try {
            categoryRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(notFoundResponse.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    public static Category mapToEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setTitle(categoryDto.getTitle());
        category.setNews(categoryDto.getNews()
                .stream()
                .map(NewsCRUDService::mapToEntity).toList());
        return category;
    }

    public static CategoryDto mapToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setTitle(category.getTitle());
        categoryDto.setNews(category.getNews()
                .stream()
                .map(NewsCRUDService::mapToDto).toList());
        return categoryDto;
    }
}
