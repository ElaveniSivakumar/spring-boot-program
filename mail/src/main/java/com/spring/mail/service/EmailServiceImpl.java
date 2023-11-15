package com.spring.mail.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.spring.mail.entity.EmailEntity;


@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String sender;
	

	public String sendSimpleMail(EmailEntity emailEntity) {
		
		try {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setFrom(sender);
		mailMessage.setTo(emailEntity.getRecipient());
		mailMessage.setText(emailEntity.getMsgBody());
		mailMessage.setSubject(emailEntity.getSubject());
		
		javaMailSender.send(mailMessage);
		return "Mail Send Successfully...";
	}
		catch (Exception e) {
			e.printStackTrace();
            return "Error while Sending Mail";
        }
	}

	
	public String sendAttachedMail(EmailEntity emailEntity) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		try {
			mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
			
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(emailEntity.getRecipient());
			mimeMessageHelper.setText(emailEntity.getMsgBody());
			mimeMessageHelper.setSubject(emailEntity.getSubject());
			
			FileSystemResource file = new FileSystemResource( new File(emailEntity.getAttachment()));
			
			mimeMessageHelper.addAttachment(file.getFilename(),file);
			
			javaMailSender.send(mimeMessage);
			
			return "Mail sent Successfully";	
		}
		catch(MessagingException e) {
			e.printStackTrace();
			return "Error while Sending Mail";
		}
		
	}

}
