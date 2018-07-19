package com.todo.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.todo.dao.TodoDao;
import com.todo.model.Todo;

@Controller
@RequestMapping(value = "/todo")
public class TodoController {
	
//	@Autowired
//	private TodoDao todoDao;
	
	@RequestMapping(value = "/getTodoList", method = RequestMethod.GET)
	@ResponseBody
	public String returnCampaigns(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<Todo> todoList = new ArrayList<Todo>();
		System.out.println(request);
		return todoList.toString();
	}
	
	@RequestMapping(value = "/createTodo", method = RequestMethod.POST, headers = "content-type=application/json")
	@ResponseBody
	public String createCampaign(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Todo todo) throws Exception {
		
		return "Successfully Added";
	}
}
