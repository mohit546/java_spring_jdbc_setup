package com.todo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.todo.dao.TodoDao;
import com.todo.model.Todo;


@SuppressWarnings({"rawtypes","unchecked"})
@Repository
@Transactional
public class TodoDaoImpl implements TodoDao {

	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void addTodoTask(Todo todo) {

		String sql = "INSERT INTO TODO " + "(ID, NAME, STATUS) VALUES (?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			try {
				ps.setInt(1, todo.getId());
				ps.setString(2, todo.getName());
				ps.setBoolean(3, todo.getStatus());
				ps.executeUpdate();
				ps.close();
			} catch (DataIntegrityViolationException e) {
				System.out.println(todo.getName() + "User already exist");
			}

		} catch (SQLException e) {
			System.out.println(todo.getName() + "User already exist");
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
	
	public Todo getTodoTaskById(int id) {

		String sql = "SELECT * FROM TODO WHERE ID = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			Todo customer = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Todo(rs.getInt("ID"), rs.getString("NAME"), rs.getBoolean("STATUS"));
			}
			rs.close();
			ps.close();
			return customer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
	
	public ArrayList<Todo> getAllTodoTask() {

		String sql = "SELECT * FROM TODO";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ArrayList<Todo> todo = new ArrayList<Todo>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				todo.add(new Todo(rs.getInt("ID"), rs.getString("NAME"), rs.getBoolean("STATUS")));
			}
			rs.close();
			ps.close();
			return todo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}
