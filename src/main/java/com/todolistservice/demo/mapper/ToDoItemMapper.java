package com.todolistservice.demo.mapper;

import com.todolistservice.demo.dto.CreateToDoItemRequest;
import com.todolistservice.demo.dto.ToDoItemResponse;
import com.todolistservice.demo.entity.ToDoItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ToDoItemMapper {
    ToDoItemMapper INSTANCE = Mappers.getMapper(ToDoItemMapper.class);

    ToDoItem toEntity(CreateToDoItemRequest request);

    // Mapping for returning a ToDoItemResponse
    ToDoItemResponse toResponse(ToDoItem toDoItem);

    // Mapping for a list of ToDoItem to a list of ToDoItemResponse
    List<ToDoItemResponse> toResponseList(List<ToDoItemResponse> toDoItems);
}
