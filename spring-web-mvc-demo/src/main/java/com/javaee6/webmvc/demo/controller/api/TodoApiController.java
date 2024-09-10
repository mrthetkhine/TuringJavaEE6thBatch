package com.javaee6.webmvc.demo.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.javaee6.webmvc.demo.model.dto.TodoDto;
import com.javaee6.webmvc.demo.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/todos")
public class TodoApiController {

	@Autowired
	RestClient restClient;

	@Autowired
	TodoService todoService;

	@GetMapping
	List<TodoDto> getAllTodos()
	{
		log.info("/api/todos threadname "+Thread.currentThread().getName());
		try
		{
			Thread.sleep( (60)*1_000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return this.todoService.getAllTodos();
	}
	@GetMapping(value="heavy")
	List<TodoDto> getTodoHeavy()
	{
		log.info("/api/todos getTodoHeavy ");
		List<TodoDto> todoList = restClient.get()
			    .uri("/todos")
			    .accept(MediaType.APPLICATION_JSON)
			    .retrieve()
			    .body(List.class);
		log.info("Todo list "+todoList.size());
		return todoList;
	}
}
