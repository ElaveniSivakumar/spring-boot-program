package com.springboot.demo.springbootdemo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.springbootdemo.dto.GenericResponse;
import com.springboot.demo.springbootdemo.dto.User;
import com.springboot.demo.springbootdemo.service.UserService;


@RestController
@RequestMapping("/user")


public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/post")
	private GenericResponse<User> createUser(@RequestBody User user) {
		userService.save(user);
		GenericResponse<User> response = new GenericResponse();
		response.setData(null);
		response.setDatalist(null);
		response.setStatus("SUCCESS");
		response.setMessage("Saved Successfully");
	
	return response;
	

}
	@GetMapping(value = "/get")
	private GenericResponse getAllUser() {
		
		List<User> users =userService.getAllUsers();
		GenericResponse<User> response = new GenericResponse();
		response.setData(null);
		response.setDatalist(null);
		response.setStatus("SUCCESS");
		response.setMessage("Fetched Successfully");
	
	return response;
	

}
}
