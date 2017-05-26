package com.example.emailDemo.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.example.emailDemo.endpoint.EmailEndpoint;

@Configuration
public class AppConfig extends ResourceConfig {
	
	public AppConfig() {
		register(EmailEndpoint.class);
	}
}
