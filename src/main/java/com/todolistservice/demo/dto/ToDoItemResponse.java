package com.todolistservice.demo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ToDoItemResponse {
    private String description;
    private boolean completed;
    private LocalDateTime createdDate;
    private LocalDateTime latestUpdate;
}
