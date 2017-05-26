package com.example.emailDemo.exception;

public class EmailException extends RuntimeException {

	public String message;

	public EmailException() {
		super();
		message = "Email Exception : ";
	}

	public EmailException(String message) {
		super(message);
		message += this.message;
	}
}
