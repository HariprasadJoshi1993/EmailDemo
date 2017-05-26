package com.example.emailDemo.domain;

public class EmailBean {

	private String fromAddress;
	private String toAddress;
	private String subject;
	private String message;
	private boolean htmlMessage;

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isHtmlMessage() {
		return htmlMessage;
	}

	public void setHtmlMessage(boolean htmlMessage) {
		this.htmlMessage = htmlMessage;
	}

}
