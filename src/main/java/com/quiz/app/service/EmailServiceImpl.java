package com.quiz.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.quiz.app.repo.UserInfoRepo;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	public UserInfoRepo userInfoRepo;
	
//	@Value("${staging.mail.host}")
//	private String smtpserver;
////	@Value("${staging.mail.password}")
////	private String smtpPassword;
//	@Value("${staging.mail.username}")
//	private String fromemail;
//	@Value("${staging.mail.username}")
//	private String smtpaccount;
//	@Value("${staging.mail.port}")
//	private String smtpPort;
//	@Value("${staging.mail.smtpIsSecure}")
//	private String smtpIsSecure;
	
	@Value("${spring.mail.username}")
	private String smtpaccount;

	@Override
	public boolean sendSimpleMail(String email) {
		
		String password = userInfoRepo.getUserPassword(email);
		System.out.println("got password & that is "+password);
		if(password != null) {
			String to = email;
			String subject = "Get Your Credentials";
			String body = "Your Credential number: "+password ;
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(smtpaccount);
			message.setTo(to);
			message.setSubject(subject);
			message.setText(body);
			
			
			
			try {
				System.out.println(message);
				mailSender.send(message);
				System.out.println("email sent successfully to:" +to);
			} catch (Exception e) {
			    System.out.println("Error while sending email: " + e.getMessage());
			}
			
			return true;
		}else {
			return false;
		}
		
	}
}
