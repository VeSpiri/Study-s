package com.example.springebootapplication.services;

import com.example.springebootapplication.dto.NewsDto;
import com.example.springebootapplication.dto.NotFoundResponse;
import com.example.springebootapplication.entities.Category;
import com.example.springebootapplication.entities.News;
import com.example.springebootapplication.repository.CategoryRepository;
import com.example.springebootapplication.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@RequiredArgsConstructor
@Service
public class NewsCRUDService implements CRUDService<NewsDto> {
    private final NotFoundResponse notFoundResponse = new NotFoundResponse();
    private final CategoryRepository categoryRepository;
    private final NewsRepository newsRepository;


    @Override
    public ResponseEntity getById(Long id) {
        if(newsRepository.findById(id).isPresent()) {
            log.info("Get by id {}", id);
            News news = newsRepository.findById(id).orElseThrow();
            return new ResponseEntity(mapToDto(news), HttpStatus.OK);
        } else {
            return new ResponseEntity(notFoundResponse.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity getAll() {
        log.info("Get all");
        return new ResponseEntity(newsRepository.findAll()
                .stream()
                .map(NewsCRUDService::mapToDto)
                .toList(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity create(NewsDto newsDto) {
        log.info("Create");
        News news = mapToEntity(newsDto);
        Long categoryId = newsDto.getCategoryId();
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        news.setCategory(category);
        news.setDate(Instant.now());
        newsRepository.save(news);
        return new ResponseEntity(mapToDto(news), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity update(NewsDto newsDto) {
        if (newsRepository.findById(newsDto.getId()).isEmpty()) {
            log.info("Update");
            News news = mapToEntity(newsDto);
            Long categoryId = newsDto.getCategoryId();
            Category category = categoryRepository.findById(categoryId).orElseThrow();
            news.setCategory(category);
            newsRepository.save(news);
            return new ResponseEntity(mapToDto(news), HttpStatus.OK);
        } else {
            return new ResponseEntity(notFoundResponse.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity delete(Long id) {
        log.info("Delete id {}", id);
        if(!newsRepository.findById(id).isEmpty()) {
            newsRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } else
            return new ResponseEntity(notFoundResponse.getMessage(), HttpStatus.NOT_FOUND);
    }

    public static NewsDto mapToDto(News news) {
        NewsDto newsDto = new NewsDto();
        newsDto.setId(news.getId());
        newsDto.setTitle(news.getTitle());
        newsDto.setText(news.getText());
        newsDto.setCategoryId(news.getCategory().getId());
        return newsDto;
    }

    public static News mapToEntity(NewsDto newsDto) {
        News news = new News();
        news.setId(newsDto.getId());
        news.setTitle(newsDto.getTitle());
        news.setText(newsDto.getText());
        return news;
    }
}
