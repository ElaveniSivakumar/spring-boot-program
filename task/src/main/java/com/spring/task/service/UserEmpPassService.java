package com.spring.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.task.entity.ClassPassword;
import com.spring.task.entity.UserEmpPass;
import com.spring.task.entity.UserTask;
import com.spring.task.repository.UserEmpPassRep;
import com.spring.task.repository.UserRepository;

@Service
public class UserEmpPassService {
    @Autowired
	private UserEmpPassRep userEmpPassRep;
    
    @Autowired
	private UserRepository userRepository;
    
    
    public UserEmpPass create(UserTask user) {
    	
    	String phoneObj = ClassPassword.getPassword(user.getPhoneNo());
    
    	UserTask usertaskObj = userRepository.save(user);
    	UserEmpPass userEmpPass = new UserEmpPass();
    	userEmpPass.setPassword(phoneObj);
    	userEmpPass.setEmpId(usertaskObj.getId());
		//ClassPassword.getPassword(usertaskObj.getPhoneNo());
		userEmpPass.setEmployeeName(usertaskObj.getUserName());
		usertaskObj.getEmailId();
		usertaskObj.getFirstName();
		usertaskObj.getLastName();
		usertaskObj.getJoiningDate();
    	
    	return userEmpPassRep.save(userEmpPass);
    }
    
	
}
