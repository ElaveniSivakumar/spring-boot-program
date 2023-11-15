package com.spring.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.task.entity.UserEmpTask;
import com.spring.task.entity.UserTask;
import com.spring.task.repository.UserEmpRepository;
import com.spring.task.repository.UserRepository;

@Service
public class UserEmpService {
	@Autowired
	private UserEmpRepository userEmpRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public UserEmpTask create(UserTask user) {
		UserTask userTaskObj = userRepository.save(user);
		UserEmpTask userEmpTask = new UserEmpTask();
		userEmpTask.setEmpId(userTaskObj.getId());
		userEmpTask.setAmount(userTaskObj.getPhoneNo());
		userTaskObj.getEmailId();
		userTaskObj.getFirstName();
		userTaskObj.getLastName();
		userTaskObj.getUserName();
		userTaskObj.getJoiningDate();
		
		
		return userEmpRepository.save(userEmpTask);
		
	}

	

	}
	
	
	
	
	



