package com.sapient.sapestore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderItemInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer orderItemId;
	private double orderItemPrice;
	private int orderItemQuantity;
	@ManyToOne
	private OrderInfo orderInfo;

	@OneToOne
	@JoinColumn(name="isbn")
	private Books book;
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
	
	
	public OrderItemInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books getBook() {
		return book;
	}
	public void setBook(Books book) {
		this.book = book;
	}
	public OrderItemInfo(Integer orderItemId, double orderItemPrice, int orderItemQuantity, OrderInfo orderInfo,
			Books book) {
		super();
		this.orderItemId = orderItemId;
		this.orderItemPrice = orderItemPrice;
		this.orderItemQuantity = orderItemQuantity;
		this.orderInfo = orderInfo;
		this.book = book;
	}
	@Override
	public String toString() {
		return "OrderItemInfo [orderItemId=" + orderItemId + ", orderItemPrice=" + orderItemPrice
				+ ", orderItemQuantity=" + orderItemQuantity + ", orderInfo=" + orderInfo + ", book=" + book + "]";
	}
	
	
}
