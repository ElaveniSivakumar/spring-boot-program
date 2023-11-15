package com.springboot.demo.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.springbootdemo.dto.User;
import com.springboot.demo.springbootdemo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
 
	private UserRepository userRespository; //variable based injection
	public void save(User user) {
		userRespository.save(user);
	}
	
	public List<User> getAllUsers() {
		return userRespository.getAllUsers();
	}
}
