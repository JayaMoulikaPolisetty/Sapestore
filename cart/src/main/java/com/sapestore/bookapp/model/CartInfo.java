package com.sapestore.bookapp.model;


import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CartInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer cartId;
	private double cartPrice;
	private Integer userId;
	private int quantity;
	private Timestamp createdDate;
	private Timestamp updatedDate;

	@OneToMany(mappedBy ="cartInfo",fetch = FetchType.EAGER)
	@JsonIgnore
	List<CartItems> cartItems;

	public CartInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartInfo(Integer cartId, double cartPrice, Integer userId, int quantity, Timestamp createdDate,
			Timestamp updatedDate) {
		super();
		this.cartId = cartId;
		this.cartPrice = cartPrice;
		this.userId = userId;
		this.quantity = quantity;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public double getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(double cartPrice) {
		this.cartPrice = cartPrice;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<CartItems> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "CartInfo [cartId=" + cartId + ", cartPrice=" + cartPrice + ", userId=" + userId + ", quantity="
				+ quantity + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

	


}
