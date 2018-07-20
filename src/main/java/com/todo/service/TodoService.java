package com.todo.service;

import java.util.ArrayList;

import com.todo.model.Todo;

public interface TodoService {
	public void addTodoTask(Todo todo);
	public Todo getTodoTaskById(int todoId);
	public ArrayList<Todo> getAllTodoTask();
}
