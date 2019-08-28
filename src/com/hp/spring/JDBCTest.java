package com.hp.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

}
