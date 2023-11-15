package com.spring.mail.service;

import com.spring.mail.entity.EmailEntity;

public interface EmailService {

	String sendSimpleMail(EmailEntity emailEntity);
	
	String sendAttachedMail(EmailEntity emailEntity);
}
