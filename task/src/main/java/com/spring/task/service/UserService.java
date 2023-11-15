package com.spring.task.service;


import java.util.List;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.task.entity.UserTask;
import com.spring.task.repository.UserInfoRepository;
import com.spring.task.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public void saveUser(UserTask user) {
		userRepository.save(user);
	}
	
	public List<UserTask> getAll() {
		return (List<UserTask>) userRepository.findAll() ;
	}
	public void deletedById(UUID id){
		userRepository.deleteById(id);
	}

	
	public void deletedChild(UUID id){
		if (userInfoRepository == null) {
			throw new NullPointerException("userInforepository is null");
		}
		// delete the child
		userInfoRepository.deleteById(id);

	}
	
}
