package com.spring.jpa.repository;

import java.util.List;

import java.util.Optional;
import java.util.UUID;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.jpa.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, UUID>{

	// interface allow only declaration 
	// interface don't allow definition(body) for method
	
	public List<User> findAllByUserName(String username);  //class variables name (userName) and its method name UserName
	
	public Optional<User> findById(UUID id); // single record
	
	//public List<User> findAllByUserNameAndEmailId(String username , String emailId); // both data is true
	
	//public List<User> findAllByUserNameOrEmailId(String username , String emailId);  // any one data is true
}

