
package com.sapestore.books.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Book_Rating_Comments")
public class Book_Rating_Comments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer comment_id;

	private Integer book_rating;
	private String book_comment;
	private Timestamp book_comment_date;

	private Integer userId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isbn", nullable = false)
	private Books books;
	
	public Book_Rating_Comments() {
		super();
	}

	public Book_Rating_Comments(Integer comment_id, Integer book_rating, String book_comment,
			Timestamp book_comment_date, Integer userId, Books books) {
		super();
		this.comment_id = comment_id;
		this.book_rating = book_rating;
		this.book_comment = book_comment;
		this.book_comment_date = book_comment_date;
		this.userId = userId;
		this.books = books;
	}

	public Integer getComment_id() {
		return comment_id;
	}

	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}

	public Integer getBook_rating() {
		return book_rating;
	}

	public void setBook_rating(Integer book_rating) {
		this.book_rating = book_rating;
	}

	public String getBook_comment() {
		return book_comment;
	}

	public void setBook_comment(String book_comment) {
		this.book_comment = book_comment;
	}

	public Timestamp getBook_comment_date() {
		return book_comment_date;
	}

	public void setBook_comment_date(Timestamp book_comment_date) {
		this.book_comment_date = book_comment_date;
	}


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Book_Rating_Comments [comment_id=" + comment_id + ", book_rating=" + book_rating + ", book_comment="
				+ book_comment + ", book_comment_date=" + book_comment_date + ", userId=" + userId + ", books=" + books
				+ "]";
	}
}