package com.hcl.bhoomi.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan("com.hcl.bhoomi.DAO")
public class JdbcConfig {
	@Bean("datasource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource  dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springJdbc");
		dataSource.setUsername("root");
		dataSource.setPassword("Chinni@123");
		
		return dataSource;
		
	}
	@Bean("JdbcTemplate")
	public JdbcTemplate getJdbcTemplate()
	{
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		//datasource is injected in jdbctemplate
		jdbcTemplate.setDataSource(getDataSource());
		
		return jdbcTemplate;
	}

}
