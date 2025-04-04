package com.example.springebootapplication.controllers;

import com.example.springebootapplication.dto.CategoryDto;
import com.example.springebootapplication.dto.NotFoundResponse;
import com.example.springebootapplication.services.CategoryCRUDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryCRUDService categoryService;
    private NotFoundResponse notFound;

    public CategoryController(CategoryCRUDService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategoryById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @GetMapping
    public ResponseEntity getAllCategory() {
        return categoryService.getAll();
    }

    @PostMapping
    public ResponseEntity crateCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.create(categoryDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCategory(@RequestBody Long id, CategoryDto categoryDto) {
        categoryDto.setId(id);
        return categoryService.update(categoryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id) {
        return categoryService.delete(id);
    }
}

