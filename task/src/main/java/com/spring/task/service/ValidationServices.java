package com.spring.task.service;

import org.apache.catalina.connector.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerException;
import org.springframework.stereotype.Service;

import com.spring.task.entity.ValitationTask;
import com.spring.task.repository.ValidationRep;

@Service
public class ValidationServices {

	@Autowired
	private ValidationRep validationRep;
	
	
	//error on console (exception)
	/*public void save(ValitationTask user) throws Exception {
      ValitationTask existingUser = validationRep.findByEmailAndPhone(user.getEmail(),user.getPhone());
		if (existingUser != null) {
			throw new Exception("A user with the email= "+ user.getEmail() +"and phone= "+ user.getPhone()+"already exists.");
		}
		 validationRep.save(user);
        
	}*/
	
	public void save(ValitationTask user) throws Exception {
			 validationRep.save(user);
	        
		}
	
}