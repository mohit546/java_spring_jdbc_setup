package com.todo.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.dao.TodoDao;
import com.todo.model.Todo;
import com.todo.service.TodoService;

@SuppressWarnings({"rawtypes","unchecked"})
@Service
@Transactional
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	private TodoDao todoDao;

	public void addTodoTask(Todo todo) {
		Todo newTodo = new Todo(todo.getId(), todo.getName(), todo.getStatus());
        todoDao.addTodoTask(newTodo);
	}
	
	public Todo getTodoTaskById(int id) {
		Todo todo = todoDao.getTodoTaskById(id);
        return todo;
	}
	
	public ArrayList<Todo> getAllTodoTask(){
		ArrayList<Todo> todo = todoDao.getAllTodoTask();
		return todo;
	}
}
