package com.sapestore.books.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapestore.books.model.Book_Rating_Comments;
import com.sapestore.books.model.Books;

@Repository
public interface IBookRatingComments extends JpaRepository<Book_Rating_Comments, Integer> {

	public List<Book_Rating_Comments> findByBooks(Books books);

  
	
}
