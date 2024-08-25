package com.javaee6.webmvc.demo.service;

import java.util.List;

import com.javaee6.webmvc.demo.model.dto.TodoDto;

public interface TodoService {
	List<TodoDto> getAllTodos();
}
