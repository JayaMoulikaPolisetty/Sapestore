package com.sapient.sapestore.model;

public class ItemsDisplay {
	
	private String bookName;
	private double bookPrice;
	private double subtotal;
	private Integer quantity;
	private String bookImg;
	private Integer id;
	private Integer isbn;
	private Integer bookQuantity;
	
	
	public ItemsDisplay() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ItemsDisplay(String bookName, double bookPrice, double subtotal, Integer quantity, String bookImg,
			Integer id,Integer isbn, Integer bookQuantity) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.subtotal = subtotal;
		this.quantity = quantity;
		this.bookImg = bookImg;
		this.id = id;
		this.isbn=isbn;
		this.bookQuantity=bookQuantity;
	}


	public Integer getIsbn() {
		return isbn;
	}


	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public double getBookPrice() {
		return bookPrice;
	}


	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}


	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public String getBookImg() {
		return bookImg;
	}


	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	

	public Integer getBookQuantity() {
		return bookQuantity;
	}


	public void setBookQuantity(Integer bookQuantity) {
		this.bookQuantity = bookQuantity;
	}


	@Override
	public String toString() {
		return "ItemsDisplay [bookName=" + bookName + ", bookPrice=" + bookPrice + ", subtotal=" + subtotal
				+ ", quantity=" + quantity + ", bookImg=" + bookImg + ", id=" + id + ", isbn=" + isbn
				+ ", bookQuantity=" + bookQuantity + "]";
	}



}
