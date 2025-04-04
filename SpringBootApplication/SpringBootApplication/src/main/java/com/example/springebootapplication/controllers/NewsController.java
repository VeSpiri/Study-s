package com.example.springebootapplication.controllers;

import com.example.springebootapplication.dto.NewsDto;
import com.example.springebootapplication.dto.NotFoundResponse;
import com.example.springebootapplication.services.NewsCRUDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller

@RestController
@RequestMapping("/api/news")
public class NewsController {
    private final NewsCRUDService newsService;
    private NotFoundResponse notFound;

    public NewsController(NewsCRUDService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getNewsById(@PathVariable Long id) {
        return newsService.getById(id);
    }

    @GetMapping
    public ResponseEntity getAllNews() {
        return newsService.getAll();
    }

    @PostMapping
    public ResponseEntity crateNews(@RequestBody NewsDto newsDto) {
        return newsService.create(newsDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateNews(@PathVariable Long id, @RequestBody NewsDto newsDto) {
        return newsService.update(id, newsDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteNews(@PathVariable Long id) {
        return newsService.delete(id);
    }
}
