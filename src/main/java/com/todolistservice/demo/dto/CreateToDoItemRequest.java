package com.todolistservice.demo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class CreateToDoItemRequest {

    @NotBlank(message = "Description is required")
    private String description;

    private boolean completed;
}
