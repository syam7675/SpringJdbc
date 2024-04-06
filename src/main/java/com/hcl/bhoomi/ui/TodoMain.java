package com.hcl.bhoomi.ui;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hcl.bhoomi.DAO.TodoDao;
import com.hcl.bhoomi.DAO.TodoDaoImpl;
import com.hcl.bhoomi.beans.Todo;
import com.hcl.bhoomi.config.JdbcConfig;

public class TodoMain {

	public static void main(String[] args) {
		
		ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
		TodoDao todoDao=context.getBean(TodoDaoImpl.class);
		Todo todo=new Todo(2,"Reading","to finish the whole chapter");
		//int count=todoDao.saveTodo(todo);
		//System.out.println(count+"Row inserted");
		
		//Todo todo2=new Todo(2,"Read","to finish the  chapter");
		//int count=todoDao.updateTodo(todo2);
		//System.out.println(count+" Row updated");
		
		List<Todo> list=todoDao.getAllTodo();
		for(Todo t:list)
		{
			System.out.println(t);
		}

		
		
		
		
		

	}

}
