package com.spring.jpa.controller;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.entity.User;
import com.spring.jpa.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
    
	//________ Method 1 _________
	
	/*@PostMapping(value = "/create")
	public User createUser(@RequestBody User user) {
		
		user.setCreateDate(LocalDateTime.now());
		userService.saveUser(user);
		return user;
	}*/
	
	//_________ Method 2 ________
	
	@PostMapping(value = "/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		user.setCreateDate(LocalDateTime.now());
		userService.saveUser(user);
		return ResponseEntity.ok(user);
	}
	
	//________ Method 1 _________
	
	
	@GetMapping(value = "/fetch")
	public List<User> getAllUser() {
		
		return userService.getAll();
	}
	
	
	//_________ Method 2 ________
	
	/*@GetMapping(value = "/fetch")
	public ResponseEntity<List<User>> getAllUser() {
		
		return ResponseEntity.ok(userService.getAll());
	}
	*/
	@GetMapping(value = "/search/{name}")
	public List<User> searchuserByName(@PathVariable("name") String name) {
		
		return userService.searchAllUserByName(name);
	}
	
	//________ Method 1 _________
	
	/*@GetMapping(value = "/get/{id}")
	public Optional<User> getById(@PathVariable("id") UUID id) {
	
		return userService.getById(id);
	}*/
	
	//_________ Method 2 ________
	
	@GetMapping(value = "/get/{id}")
	public User getById(@PathVariable("id") UUID id) {
		Optional<User> userOptional = userService.getById(id);
	
		return userOptional.get();
	}
	
		
}
