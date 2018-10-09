package com.sapient.sapestore.model;


import java.sql.Timestamp;



public class Customer extends Message {

	
	Integer userId;
	
	String password;
	
	String name;
	
	String gender;
	
	String email;
	
	Long phoneNumber;
	
	String userStatus;
	
	boolean admin;
	
	boolean active;
	
	Timestamp createdDate;
	
	Timestamp updateDate;
	
	private String addressLine1;
	
	private String addressLine2;
	
	public Customer(String successMessage, String failiureMessage, Integer userId, String password, String name,
			String gender, String email, Long phoneNumber, String userStatus, boolean admin, boolean active,
			Timestamp createdDate, Timestamp updateDate, String addressLine1, String addressLine2, String city,
			String state, Integer pin) {
		super(successMessage, failiureMessage);
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userStatus = userStatus;
		this.admin = admin;
		this.active = active;
		this.createdDate = createdDate;
		this.updateDate = updateDate;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.pin = pin;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String successMessage, String failiureMessage) {
		super(successMessage, failiureMessage);
		// TODO Auto-generated constructor stub
	}

	private String city;
	
	private String state;
	
	private Integer pin;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public boolean getAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	
	

}
