package com.todolistservice.demo.service;

import com.todolistservice.demo.dto.CreateToDoItemRequest;
import com.todolistservice.demo.dto.ToDoItemResponse;
import com.todolistservice.demo.entity.ToDoItem;

import java.util.List;

public interface ToDoItemService {
    void createToDoItem(String username, CreateToDoItemRequest toDoItem);

    List<ToDoItemResponse> getToDoItemsByUser(String username);
}
