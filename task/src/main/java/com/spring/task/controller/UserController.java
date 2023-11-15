package com.spring.task.controller;

import java.util.List;





import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.task.entity.UserEmpTask;
import com.spring.task.entity.UserInfoTask;
import com.spring.task.entity.UserTask;
import com.spring.task.entity.ValitationTask;
import com.spring.task.repository.ValidationRep;
import com.spring.task.service.UserEmpPassService;
import com.spring.task.service.UserEmpService;
import com.spring.task.service.UserService;
import com.spring.task.service.ValidationServices;

@RestController
@RequestMapping("/user")

public class UserController {
	
	//using mapping
	
	/*@Autowired
	private UserService userService;
	
	
	@PostMapping(value = "/create")
	public ResponseEntity<UserTask> createUser(@RequestBody UserTask user){
		userService.saveUser(user);
		return ResponseEntity.ok(user);
		
	}
	
	@GetMapping(value = "/fetch")
	public List<UserTask> getAllUser() {
		
		return userService.getAll();
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteById(@PathVariable("id") UUID id) {
		userService.deletedById(id);
		return "DELETED....";
	}
	
	@DeleteMapping(value = "/delete-child/{id}")
	public ResponseEntity<UserInfoTask> deleteChildById(@PathVariable("id") UUID id) {
		try {
		userService.deletedChild(id);
		return ResponseEntity.noContent().build();
		}
		catch (EmptyResultDataAccessException e) 
		{
			return ResponseEntity.notFound().build();
		}
		
		
	}*/
	
	// without using mapping
	
	/*@Autowired
	private UserEmpService userEmpService;
	
	@PostMapping(value = "/create")
	public ResponseEntity<UserTask> createUser(@RequestBody UserTask user){
		userEmpService.create(user);
		return ResponseEntity.ok(user);
		
	}*/
	
	// password encrypt
	
	/*@Autowired
	private UserEmpPassService userEmpPassService;
	
	@PostMapping(value = "/create")
	public ResponseEntity<UserTask> createUser(@RequestBody UserTask user){
		userEmpPassService.create(user);
		return ResponseEntity.ok(user);
		
	}*/
	
	// Validation  task controller
	
	/*@Autowired
	private ValidationServices validationServices;
	
	@PostMapping(value  = "/create")
	public ResponseEntity<ValitationTask> create(@RequestBody ValitationTask user) throws Exception{
		validationServices.save(user);
		return ResponseEntity.ok(user);
		
	}*/
	
	@Autowired
	private ValidationServices validationServices;
	
	@Autowired
	private ValidationRep validationRep;
	
	@PostMapping(value  = "/create")
	public ResponseEntity<ValitationTask> create(@RequestBody ValitationTask user) throws Exception{
		validationServices.save(user);
			ValitationTask existingUser = validationRep.findByEmailAndPhone(user.getEmail(),user.getPhone());
			try {
				
			if (existingUser != null) {
				throw new Exception("A user with the email= "+ user.getEmail() +"and phone= "+ user.getPhone()+"already exists.");
			}
			else {
				validationRep.save(user);
			}
			//return ResponseEntity.ok("............");
		}
	catch(Exception e){
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		//return ResponseEntity.internalServerError().body("Error sending mail and phone: " + e);
		
	}
			return ResponseEntity.ok(user);
			
	}
	

}
