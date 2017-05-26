package com.example.emailDemo.service;

import java.util.Objects;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.emailDemo.domain.EmailBean;
import com.example.emailDemo.exception.EmailException;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	JavaMailSenderImpl mailSender;

	@Override
	public String sendMessage(EmailBean emailBean) {
		validate(emailBean);
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage);
			mailMsg.setFrom(emailBean.getFromAddress());
			mailMsg.setTo(emailBean.getToAddress());
			mailMsg.setSubject(emailBean.getSubject());
			mailMsg.setText(emailBean.getMessage(), emailBean.isHtmlMessage());
			mailSender.send(mimeMessage);
			return "Mail Sent Successfully";
		} catch (Exception ex) {
			throw new EmailException("Error While Sending Email : " + ex.getMessage());
		}
	}

	private void validate(EmailBean emailBean) {
		if (emailBean == null) {
			throw new EmailException("Email Details are mandatory");
		} else if (emailBean.getFromAddress() == null || emailBean.getFromAddress().isEmpty()) {
			throw new EmailException("From Address is mandatory");
		} else if (emailBean.getToAddress() == null || emailBean.getToAddress().isEmpty()) {
			throw new EmailException("To Address is mandatory");
		} else if (emailBean.getSubject() == null || emailBean.getSubject().isEmpty()) {
			throw new EmailException("Subject is mandatory");
		}
	}

}
