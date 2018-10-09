package com.sapient.sapestore.model;

import java.sql.Timestamp;

public class Transaction {
	private Integer orderId;
	private double price;
	private String name;
	private Timestamp orderDate;
	private String bookImage;
	private String orderStatus;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}

	public Transaction(Integer orderId, double price, String name, Timestamp orderDate, String bookImage,
			String orderStatus) {
		super();
		this.orderId = orderId;
		this.price = price;
		this.name = name;
		this.orderDate = orderDate;
		this.bookImage = bookImage;
		this.orderStatus = orderStatus;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

}
