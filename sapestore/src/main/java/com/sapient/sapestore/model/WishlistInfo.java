package com.sapient.sapestore.model;



public class WishlistInfo {


	private Integer wishlisItemId;
	private Integer userId;
	
	private Integer isbn;
	public WishlistInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getWishlisItemId() {
		return wishlisItemId;
	}
	public void setWishlisItemId(Integer wishlisItemId) {
		this.wishlisItemId = wishlisItemId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getIsbn() {
		return isbn;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	public WishlistInfo(Integer wishlisItemId, Integer userId, Integer isbn) {
		super();
		this.wishlisItemId = wishlisItemId;
		this.userId = userId;
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "WishlistInfo [wishlisItemId=" + wishlisItemId + ", userId=" + userId + ", isbn=" + isbn + "]";
	}
	
}