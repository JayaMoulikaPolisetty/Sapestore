package com.sapestore.bookapp.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderItemInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer orderItemId;
	private double orderItemPrice;
	private int orderItemQuantity;
	private String status;
	private Timestamp orderedDate;
	private Timestamp deliveredDate;
	private Timestamp dispatchedDate;
	private String modeOfPayment;
	private boolean paymentReceived;
	@ManyToOne
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
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(Timestamp orderedDate) {
		this.orderedDate = orderedDate;
	}
	public Timestamp getDeliveredDate() {
		return deliveredDate;
	}
	public void setDeliveredDate(Timestamp deliveredDate) {
		this.deliveredDate = deliveredDate;
	}
	public Timestamp getDispatchedDate() {
		return dispatchedDate;
	}
	public void setDispatchedDate(Timestamp dispatchedDate) {
		this.dispatchedDate = dispatchedDate;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public boolean isPaymentReceived() {
		return paymentReceived;
	}
	public void setPaymentReceived(boolean paymentReceived) {
		this.paymentReceived = paymentReceived;
	}
	public OrderItemInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItemInfo(Integer orderItemId, double orderItemPrice, int orderItemQuantity, String status,
			Timestamp orderedDate, Timestamp deliveredDate, Timestamp dispatchedDate, String modeOfPayment,
			boolean paymentReceived, OrderInfo orderInfo, Integer isbn) {
		super();
		this.orderItemId = orderItemId;
		this.orderItemPrice = orderItemPrice;
		this.orderItemQuantity = orderItemQuantity;
		this.status = status;
		this.orderedDate = orderedDate;
		this.deliveredDate = deliveredDate;
		this.dispatchedDate = dispatchedDate;
		this.modeOfPayment = modeOfPayment;
		this.paymentReceived = paymentReceived;
		this.orderInfo = orderInfo;
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "OrderItemInfo [orderItemId=" + orderItemId + ", orderItemPrice=" + orderItemPrice
				+ ", orderItemQuantity=" + orderItemQuantity + ", status=" + status + ", orderedDate=" + orderedDate
				+ ", deliveredDate=" + deliveredDate + ", dispatchedDate=" + dispatchedDate + ", modeOfPayment="
				+ modeOfPayment + ", paymentReceived=" + paymentReceived + ", orderInfo=" + orderInfo + ", isbn=" + isbn
				+ "]";
	}
	
	
	
}
