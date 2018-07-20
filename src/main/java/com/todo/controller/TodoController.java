package com.todo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.todo.service.TodoService;
import com.todo.model.Todo;

@SuppressWarnings("rawtypes")
@Controller
@RequestMapping(value = "/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@RequestMapping(value = "/getTodoList", method = RequestMethod.GET)
	@ResponseBody
	public String returnTodoList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ArrayList<Todo> todo2 = todoService.getAllTodoTask();
		System.out.println(todo2);

		return todo2.toString();

	}

	@RequestMapping(value = "/getTodoById", method = RequestMethod.GET)
	@ResponseBody
	public String returnOneTodoById(@RequestParam("id") String id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Todo todo1 = todoService.getTodoTaskById(Integer.parseInt(id));
		System.out.println(todo1);

		return todo1.toString();

	}

	@RequestMapping(value = "/createTodo", method = RequestMethod.POST, headers = "content-type=application/json")
	@ResponseBody
	public String createTodoTask(HttpServletRequest request, HttpServletResponse response, @RequestBody Todo todo)
			throws Exception {

		Todo newTodo = new Todo(todo.getId(), todo.getName(), false);
		todoService.addTodoTask(newTodo);

		return "Successfully Added";
	}

}
