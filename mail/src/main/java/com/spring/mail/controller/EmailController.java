package com.spring.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mail.entity.EmailEntity;
import com.spring.mail.service.EmailServiceImpl;

@RestController
@RequestMapping("/user")
public class EmailController {
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
    @PostMapping(value = "/email")
    public String sendMail(@RequestBody EmailEntity emailEntity) {
    	String status = emailServiceImpl.sendSimpleMail(emailEntity);
		return status;
    	
    }
    
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
        @RequestBody EmailEntity emailEntity)
    {
        String status
            = emailServiceImpl.sendAttachedMail(emailEntity);
 
        return status;
    }
}
