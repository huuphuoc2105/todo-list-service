package com.todolistservice.demo.service.impl;

import com.todolistservice.demo.dto.CreateToDoItemRequest;
import com.todolistservice.demo.dto.ToDoItemResponse;
import com.todolistservice.demo.entity.ToDoItem;
import com.todolistservice.demo.entity.User;
import com.todolistservice.demo.mapper.ToDoItemMapper;
import com.todolistservice.demo.repository.ToDoItemRepository;
import com.todolistservice.demo.repository.UserRepository;
import com.todolistservice.demo.service.ToDoItemService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDoServiceImpl implements ToDoItemService {
    @Autowired
    private ToDoItemRepository toDoItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ToDoItemMapper toDoItemMapper;

    @Override
    @Transactional
    public void createToDoItem(String username, CreateToDoItemRequest toDoItem) {
        User user = userRepository.findByUsername(username).orElse(null);
        ToDoItem newTodoItem = toDoItemMapper.toEntity(toDoItem);
        if (user == null) {
            User newUser = new User();
            newUser.setUsername(username);
            userRepository.save(newUser);
            newTodoItem.setUser(newUser);
        } else {
            newTodoItem.setUser(user);
        }
        toDoItemRepository.save(newTodoItem);
    }

    @Override
    public List<ToDoItemResponse> getToDoItemsByUser(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        List<ToDoItem> listTodoItems = new ArrayList<>();

        // Check if user is found
        if (user != null) {
            listTodoItems = toDoItemRepository.findByUserId(user.getId());
        }

        // Map ToDoItem to ToDoItemResponse
        List<ToDoItemResponse> responses = listTodoItems.stream()
                .map(toDoItemMapper::toResponse)
                .collect(Collectors.toList());

        return responses;
    }
}
