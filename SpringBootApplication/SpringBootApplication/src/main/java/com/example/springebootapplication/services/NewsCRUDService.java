package com.example.springebootapplication.services;

import com.example.springebootapplication.dto.NewsDto;
import com.example.springebootapplication.dto.NotFoundResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class NewsCRUDService implements CRUDService<NewsDto> {
    private NotFoundResponse notFoundResponse = new NotFoundResponse();
    private final ConcurrentHashMap<Long, NewsDto> storage = new ConcurrentHashMap<>();

    @Override
    public ResponseEntity getById(Long id) {
        if (storage.containsKey(id)) {
            return new ResponseEntity(storage.get(id), HttpStatus.OK);
        } else {
            notFoundResponse.setId(id);
            return new ResponseEntity(notFoundResponse.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity getAll() {
        return new ResponseEntity(storage.values(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity create(NewsDto news) {
        Long nextId = Long.valueOf(storage.isEmpty() ? 1 : storage.size() + 1);
        news.setId(nextId);
        news.setDate(new Date().toInstant());
        storage.put(nextId, news);
        return new ResponseEntity(storage.get(nextId), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity update(Long id, NewsDto news) {
        if (storage.containsKey(id)) {
            news.setId(id);
            news.setDate(new Date().toInstant());
            storage.put(id, news);
            return new ResponseEntity(storage.get(id), HttpStatus.OK);
        } else {
            notFoundResponse.setId(id);
            return new ResponseEntity(notFoundResponse.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity delete(Long id) {
        if (!storage.containsKey(id)) {
            notFoundResponse.setId(id);
            return new ResponseEntity(notFoundResponse.getMessage(), HttpStatus.NOT_FOUND);
        } else {
            storage.remove(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
