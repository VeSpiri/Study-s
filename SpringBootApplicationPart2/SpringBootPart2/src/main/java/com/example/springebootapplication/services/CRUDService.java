package com.example.springebootapplication.services;

import org.springframework.http.ResponseEntity;

public interface CRUDService<T> {
    ResponseEntity getById(Long id);
    ResponseEntity getAll();
    ResponseEntity create(T news);
    ResponseEntity update(T news);
    ResponseEntity delete(Long id);
}
