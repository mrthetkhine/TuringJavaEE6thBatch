package com.javaee6.webmvc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClient;

import com.javaee6.webmvc.demo.model.dto.TodoDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	RestClient restClient;

	@GetMapping
	String fetchAllTodos(Model model)
	{
		List<TodoDto> todoList = restClient.get()
			    .uri("/todos")
			    .accept(MediaType.APPLICATION_JSON)
			    .retrieve()
			    .body(List.class);
		log.info("Todo list "+todoList.size());
		model.addAttribute("todos", todoList);
		return "todos/todo.html";
	}
}
