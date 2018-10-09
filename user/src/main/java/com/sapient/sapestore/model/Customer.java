package com.sapient.sapestore.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="CUSTOMER_INFO")
public class Customer extends Message{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "User_Id" )
	Integer userId;
	
	@Column(name = "Password")
	String password;
	
	@Column(name = "Name")	
	String name;
	
	@Column(name = "Gender")
	String gender;
	
	@Column(name = "Email",nullable=false,unique=true)
	String email;
	
	@Column(name = "Phone_Num")
	Long phoneNumber;
	
	@Column(name = "User_Status")
	String userStatus;
	
	@Column(name = "Is_Admin")
	boolean isAdmin;
	
	@Column(name = "Is_Active")
	boolean isActive;
	
	@Column(name = "Created_Date")
	Timestamp createdDate;
	
	@Column(name="Updated_Date")
	Timestamp updateDate;
	
	@Column(name="Address_Line1")
	private String addressLine1;
	
	@Column(name="Address_Line2")
	private String addressLine2;
	
	@Column(name="City")
	private String city;
	
	@Column(name="State")
	private String state;
	
	@Column(name="Pincode")
	private Integer pin;
	
	public Customer() {
		super();
	}


	




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







	public boolean isAdmin() {
		return isAdmin;
	}







	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}







	public boolean isActive() {
		return isActive;
	}







	public void setActive(boolean isActive) {
		this.isActive = isActive;
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







	public Customer(String successMessage, String failiureMessage, Integer userId, String password, String name,
			String gender, String email, Long phoneNumber, String userStatus, boolean isAdmin, boolean isActive,
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
		this.isAdmin = isAdmin;
		this.isActive = isActive;
		this.createdDate = createdDate;
		this.updateDate = updateDate;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.pin = pin;
	}







	public Customer(String successMessage, String failiureMessage) {
		super(successMessage, failiureMessage);
	
	}


		
}
