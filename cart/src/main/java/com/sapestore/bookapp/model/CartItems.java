package com.sapestore.bookapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


//@Table(name="CART_ITEM_INFO")
@Entity
public class CartItems {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cartItemId;
	private double cartItemPrice;
	private int cartItemQuantity;
	//private Integer cartId;
	private double unitPrice;
	
	@ManyToOne
	private CartInfo cartInfo;
	
	private Integer isbn;

	public CartItems() {
		super();
	}
	
	
	public Integer getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(Integer cartItemId) {
		this.cartItemId = cartItemId;
	}
	public double getCartItemPrice() {
		return cartItemPrice;
	}
	public void setCartItemPrice(double cartItemPrice) {
		this.cartItemPrice = cartItemPrice;
	}
	public int getCartItemQuantity() {
		return cartItemQuantity;
	}
	public void setCartItemQuantity(int cartItemQuantity) {
		this.cartItemQuantity = cartItemQuantity;
	}
	
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public CartInfo getCartInfo() {
		return cartInfo;
	}
	public void setCartInfo(CartInfo cartInfo) {
		this.cartInfo = cartInfo;
	}
	public Integer getIsbn() {
		return isbn;
	}


	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	

	public CartItems(Integer cartItemId, double cartItemPrice, int cartItemQuantity, double unitPrice,
			CartInfo cartInfo, Integer isbn) {
		super();
		this.cartItemId = cartItemId;
		this.cartItemPrice = cartItemPrice;
		this.cartItemQuantity = cartItemQuantity;
		this.unitPrice = unitPrice;
		this.cartInfo = cartInfo;
		this.isbn = isbn;
	}


	@Override
	public String toString() {
		return "CartItems [cartItemId=" + cartItemId + ", cartItemPrice=" + cartItemPrice + ", cartItemQuantity="
				+ cartItemQuantity + ", unitPrice=" + unitPrice + ", cartInfo=" + cartInfo + ", isbn=" + isbn + "]";
	}

	
	
	

	
	
	
	
	

	
}
