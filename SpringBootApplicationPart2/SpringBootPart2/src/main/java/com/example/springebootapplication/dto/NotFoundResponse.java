package com.example.springebootapplication.dto;

import lombok.Setter;

@Setter
public class NotFoundResponse {
    private Long id;
    private String message;

    public String getMessage() {
        return message = "Новость с ID " + id + " не найдена.";
    }
}
