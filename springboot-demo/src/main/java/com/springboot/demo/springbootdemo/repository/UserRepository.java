package com.springboot.demo.springbootdemo.repository;

import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.springboot.demo.springbootdemo.dto.User;

@Repository
public class UserRepository {

	private static Connection connection;
	
	public Connection getConnection() {
		if(!ObjectUtils.isEmpty(connection)) {
			return connection;
		}
		
		// DB Connection
		
		return connection;
	}
	
	public void save(User user) {
		//get connection
		//create preparedStatement
		// save User object by calling executUpdate
		
		
	}
	public List<User> getAllUsers() {
		//get connection
		//create preparedStatement
		// get result set
		// parse result set
		// return user list
		
		return null;
		
		
	}
	
}
