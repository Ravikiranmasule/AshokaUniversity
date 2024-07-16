package com.ashokclass.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	public boolean sendMail(String to,String sub,String body) {
		boolean isMailSent=false;
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true, "UTF-8");
			helper.setTo(to);
			helper.setSubject(sub);
			helper.setText(body,true);
			javaMailSender.send(mimeMessage);
			isMailSent=true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isMailSent;
	}

}
