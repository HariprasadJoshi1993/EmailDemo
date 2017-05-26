package com.example.emailDemo.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.emailDemo.domain.EmailBean;
import com.example.emailDemo.service.EmailService;

@Component
@Path("api/email/")
@Produces(value=MediaType.APPLICATION_JSON)
@Consumes(value=MediaType.APPLICATION_JSON)
public class EmailEndpoint {
	
	@Autowired
	EmailService emailService;
	
	@POST
	@Path("sendmail")
	public String sendMail(EmailBean emailBean) {
		return emailService.sendMessage(emailBean);
	}
}
