package com.example.springebootapplication.services;

import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface CRUDService<T> {
    ResponseEntity getById(Long id);
    ResponseEntity getAll();
    ResponseEntity create(T news);
    ResponseEntity update(Long id, T news);
    ResponseEntity delete(Long id);
}
