package com.sapient.sapestore.model;

public class ShippingAddress {

	private Integer shippingAddressId;
	private String addressLine1;
	private String addressLine2;
	private Integer userId;
	private String city;
	private String state;
	private Long phoneNumber;
	private Integer pin;
	public ShippingAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShippingAddress(Integer shippingAddressId, String addressLine1, String addressLine2, Integer userId,
			String city, String state, Long phoneNumber, Integer pin) {
		super();
		this.shippingAddressId = shippingAddressId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.userId = userId;
		this.city = city;
		this.state = state;
		this.phoneNumber = phoneNumber;
		this.pin = pin;
	}
	public Integer getShippingAddressId() {
		return shippingAddressId;
	}
	public void setShippingAddressId(Integer shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "ShippingAddress [shippingAddressId=" + shippingAddressId + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", userId=" + userId + ", city=" + city + ", state=" + state
				+ ", phoneNumber=" + phoneNumber + ", pin=" + pin + "]";
	}
		
	
}
