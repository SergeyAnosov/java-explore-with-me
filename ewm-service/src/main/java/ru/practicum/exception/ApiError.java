package ru.practicum.exception;


import lombok.Data;


@Data
public class ApiError {

    private String errors;
    private String message;
    private String status;
    private String timestamp;
}