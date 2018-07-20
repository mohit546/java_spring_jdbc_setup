package com.todo.dao;

import java.util.ArrayList;

import com.todo.model.Todo;

public interface TodoDao {
	
	public void addTodoTask(Todo todo);
	public Todo getTodoTaskById(int todoId);
	public ArrayList<Todo> getAllTodoTask();
	
}
