package com.sapient.sapestore.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="BOOKS")
@NamedQuery(name = "Books.findByCategory", query = "SELECT category FROM Books")
@Component
public class Books {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="isbn")
 private Integer iSBN ;
 private String title ;
 private Integer quantity;
 private String book_img ;
 private double price;
 
 
  
 
 private String short_desc ;
 private String long_desc ;

 private Timestamp updated_date;
 private Timestamp date;
 private String status ;

 private String publisher ;
 private String author;
 

 private String category;
 private String language;
 

 


	
 
 
















//-----------------------------------constructors-----------------------------//
 public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
 



















public Books(Integer iSBN, String title, Integer quantity, String book_img, double price, String short_desc,
		String long_desc, Timestamp updated_date, Timestamp date, String status, String publisher, String author,
		String category, String language) {
	super();
	this.iSBN = iSBN;
	this.title = title;
	this.quantity = quantity;
	this.book_img = book_img;
	this.price = price;
	this.short_desc = short_desc;
	this.long_desc = long_desc;
	this.updated_date = updated_date;
	this.date = date;
	this.status = status;
	this.publisher = publisher;
	this.author = author;
	this.category = category;
	this.language = language;
}




















//-------------------------setters- getters------------------------------//
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public Timestamp getUpdated_date() {
	return updated_date;
}
public void setUpdated_date(Timestamp updated_date) {
	this.updated_date = updated_date;
}
public Timestamp getDate() {
	return date;
}
public void setDate(Timestamp date) {
	this.date = date;
}





public String getAuthor() {
	return author;
}








public void setAuthor(String author) {
	this.author = author;
}








public Integer getISBN() {
	return iSBN;
}















public Integer getiSBN() {
	return iSBN;
}




















public void setiSBN(Integer iSBN) {
	this.iSBN = iSBN;
}




















public String getLanguage() {
	return language;
}




















public void setLanguage(String language) {
	this.language = language;
}




















public String getCategory() {
	return category;
}


public void setISBN(Integer iSBN) {
	this.iSBN = iSBN;
}








public void setCategory(String category) {
	this.category = category;
}















public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getBook_img() {
	return book_img;
}
public void setBook_img(String book_img) {
	this.book_img = book_img;
}
public String getShort_desc() {
	return short_desc;
}
public void setShort_desc(String short_desc) {
	this.short_desc = short_desc;
}
public String getLong_desc() {
	return long_desc;
}
public void setLong_desc(String long_desc) {
	this.long_desc = long_desc;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}




















@Override
public String toString() {
	return "Books [iSBN=" + iSBN + ", title=" + title + ", quantity=" + quantity + ", book_img=" + book_img + ", price="
			+ price + ", short_desc=" + short_desc + ", long_desc=" + long_desc + ", updated_date=" + updated_date
			+ ", date=" + date + ", status=" + status + ", publisher=" + publisher + ", author=" + author
			+ ", category=" + category + ", language=" + language + "]";
}







}