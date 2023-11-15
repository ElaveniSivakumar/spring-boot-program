package com.springboot.demo.springbootdemo.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.springbootdemo.dto.HelloWorld;

@RestController
@RequestMapping("/hello-world")

public class HelloWorldController {
		
	    @GetMapping(value = "/get")
		public String gethelloWorldMappingMessage() {
			return "WELCOME TO SPRING BOOT HELLO WORLD DEMO TRAINING";
		}
	    

	    @PostMapping(value = "/post")
		public HelloWorld posthelloWorldMappingMessage(@RequestBody HelloWorld request) {
	    	
	    	System.out.println("Name:"+request.getName());
	    	
	    	request.setMessage("Post Mapping Called Successfully.."); // response
	    	
			return request;
		}

}


