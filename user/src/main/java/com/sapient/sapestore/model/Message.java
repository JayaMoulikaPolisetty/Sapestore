package com.sapient.sapestore.model;

import javax.persistence.Transient;

import org.springframework.stereotype.Component;
@Component
public class Message {
	@Transient
	private String successMessage;
	@Transient
	private String failiureMessage;
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getFailiureMessage() {
		return failiureMessage;
	}
	public void setFailiureMessage(String failiureMessage) {
		this.failiureMessage = failiureMessage;
	}
	public Message(String successMessage, String failiureMessage) {
		super();
		this.successMessage = successMessage;
		this.failiureMessage = failiureMessage;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
