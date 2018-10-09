package com.sapient.sapestore.model;

public class OrderItemInfo {

	private Integer orderItemId;
	private double orderItemPrice;
	private int orderItemQuantity;

	private OrderInfo orderInfo;
	private Integer isbn;

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public double getOrderItemPrice() {
		return orderItemPrice;
	}

	public void setOrderItemPrice(double orderItemPrice) {
		this.orderItemPrice = orderItemPrice;
	}

	public int getOrderItemQuantity() {
		return orderItemQuantity;
	}

	public void setOrderItemQuantity(int orderItemQuantity) {
		this.orderItemQuantity = orderItemQuantity;
	}

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}


	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public OrderItemInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItemInfo(Integer orderItemId, double orderItemPrice, int orderItemQuantity, OrderInfo orderInfo,
			Integer isbn) {
		super();
		this.orderItemId = orderItemId;
		this.orderItemPrice = orderItemPrice;
		this.orderItemQuantity = orderItemQuantity;
		this.orderInfo = orderInfo;
		this.isbn = isbn;
	}

	
	

}
