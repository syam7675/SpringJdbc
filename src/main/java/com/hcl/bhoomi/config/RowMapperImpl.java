package com.hcl.bhoomi.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hcl.bhoomi.beans.Todo;

public class RowMapperImpl implements RowMapper<Todo>{

	public Todo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		Todo todo=new Todo();
		todo.setId(resultSet.getInt(1));
		todo.setTitle(resultSet.getString(2));
		todo.setDescription(resultSet.getString(3));
		return todo;
	}
	
	

}
