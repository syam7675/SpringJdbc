package com.hcl.bhoomi.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.hcl.bhoomi.beans.Todo;
import com.hcl.bhoomi.config.RowMapperImpl;

@Component
public class TodoDaoImpl implements TodoDao{
	//AutoWired annotataion is used to inject any class so that you will get automatically
	//Object provided by container
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int saveTodo(Todo todo) {
		
		String insertQuery="insert into todo values(?,?,?)";
		int count = jdbcTemplate.update(insertQuery, todo.getId(),todo.getTitle(),todo.getDescription());
		return count;
	}
	

	public int updateTodo(Todo todo) {
		String updateQuery="update todo set title=?,description=? where id=?";
		int count=jdbcTemplate.update(updateQuery,todo.getTitle(),todo.getDescription(),todo.getId());
		return count;
	}

	public int deleteTodo(int id) {
		String deleteQuery="delete from todo where id=?";
		int count=jdbcTemplate.update(deleteQuery,id);
		return count;
	}

	public Todo getTodo(int id) {
		
		String selectQuery="select * from todo where id=?";
		Todo todo=jdbcTemplate.queryForObject(selectQuery,new RowMapperImpl(), id);
		return todo;
	}

	public List<Todo> getAllTodo() {
		String selectQuery="select * from todo";
		List<Todo> todo=jdbcTemplate.query(selectQuery, new RowMapperImpl());
		return todo;
	}

	

}
