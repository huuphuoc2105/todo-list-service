package com.todolistservice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todolistservice.demo.entity.ToDoItem;
import java.util.List;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {
    List<ToDoItem> findByUserId(Long userId);
}
