package com.hp.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

public class JDBCTest {
	
	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext-jdbc.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	}
	
	@Test
	public void testQueryForList() {
		
		String sql = "select id,last_name,email from employees";
		List<Employee> list = new ArrayList();
		
		jdbcTemplate.query(sql, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				
				Employee e = new Employee();
				e.setLastName(rs.getString("last_name"));
				
				list.add(e);
				
			}
			
		});
		
		System.out.println(list);
		
	}

	
	@Test
	public void testQueryForObject() {
		
		String sql = "select count(id) from employees";
		Integer n = jdbcTemplate.queryForObject(sql,Integer.class);
		
		System.out.println(n);
		
	}
	
	@Test
	public void testQueryForList2() {
		
		String sql = "select id,last_name lastName,email from employees where id>?";
		
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		
		List<Employee> employees = jdbcTemplate.query(sql, rowMapper, 1);
		
		System.out.println(employees);
		
	}
}
