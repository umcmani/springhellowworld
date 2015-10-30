package com.umc.web.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.umc.web.dao.DreamDAO;

@Repository
public class DreamDAOImpl implements DreamDAO {
	
		@Autowired
	   private JdbcTemplate jdbcTemplate;

	    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public boolean validateUser(String name, String password) {
		try {
			
			String SQL = "select count(*) from user where name=:name and password=:password";

			Map<String,Object> namedParameters = new HashMap<String,Object>();
			namedParameters.put("name", name);
			namedParameters.put("password", password);
			
			int number = namedParameterJdbcTemplate.queryForObject(SQL, namedParameters,Integer.class);
			System.out.println("Result $$$$$$$$$$$$$$$$$$$$$$$$ "+ number);
			
			if (number > 0) {
				return true;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return false;

	}
	
	public void prepareUser() {
		try {
			jdbcTemplate.execute("drop table user");
			jdbcTemplate.execute("create table user(id int not null primary key auto_increment, name varchar(50),password varchar(50))");
			jdbcTemplate.execute("delete from user");
			jdbcTemplate.execute("insert into user values(NULL,'user1','password1')");
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}

}
