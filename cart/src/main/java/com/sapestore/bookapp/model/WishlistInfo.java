package com.sapestore.bookapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WishlistInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer wishlisItemId;
	private Integer userId;

	private Integer isbn;

	public WishlistInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WishlistInfo(Integer wishlisItemId, Integer userId, Integer isbn) {
		super();
		this.wishlisItemId = wishlisItemId;
		this.userId = userId;
		this.isbn = isbn;
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

	@Override
	public String toString() {
		return "WishlistInfo [wishlisItemId=" + wishlisItemId + ", userId=" + userId + ", isbn=" + isbn + "]";
	}
	
	

}
