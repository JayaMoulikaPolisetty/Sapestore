package com.sapient.sapestore.model;



import org.springframework.stereotype.Component;
@Component
public class Message {

	private String successMessage;

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
