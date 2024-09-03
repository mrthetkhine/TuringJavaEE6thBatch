package com.javaee6.webmvc.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.javaee6.webmvc.demo.model.dto.TodoDto;
import com.javaee6.webmvc.demo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService{

	@Override
	public List<TodoDto> getAllTodos() {
		List<TodoDto> todos = new ArrayList<>();
		todos.add(new TodoDto(1L,1L,"Title 1",true));
		todos.add(new TodoDto(1L,2L,"Title 2",false));
		todos.add(new TodoDto(1L,3L,"Title 3",false));
		todos.add(new TodoDto(1L,4L,"Title 4",true));
		todos.add(new TodoDto(1L,5L,"Title 5",true));
		return todos;
	}

}
