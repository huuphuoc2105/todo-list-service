package com.todolistservice.demo.controller;

import com.todolistservice.demo.dto.CreateToDoItemRequest;
import com.todolistservice.demo.dto.ToDoItemResponse;
import com.todolistservice.demo.entity.ToDoItem;
import com.todolistservice.demo.service.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoItemController {
    @Autowired
    private ToDoItemService toDoItemService;

    @PostMapping("/{username}")
    public ResponseEntity<Void> createToDoItem(@PathVariable String username, @RequestBody CreateToDoItemRequest toDoItemReq) {
        toDoItemService.createToDoItem(username, toDoItemReq);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{username}")
    public List<ToDoItemResponse> getToDoItemsByUser(@PathVariable String username) {
        return toDoItemService.getToDoItemsByUser(username);
    }
}
