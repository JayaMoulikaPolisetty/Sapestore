package com.sapestore.books.service;

import java.util.List;

import com.sapestore.books.exception.AuthorNotFoundException;
import com.sapestore.books.exception.BookNotFoundException;
import com.sapestore.books.exception.CategoryNotFoundException;
import com.sapestore.books.model.Books;

public interface BookService {
	
	void addBook(Books book);
	List<Books> getAllBook();
	Books updateBook(Books book);
	boolean deleteBook(Integer iSBN) throws BookNotFoundException;
	
    List<Books> getBookByAuthor(String author) throws AuthorNotFoundException;
	List<Books> getBookByCategory(String category) throws CategoryNotFoundException;
	List<Books> getBookBytitle(String title) throws BookNotFoundException;
    Books getBookByISBN(Integer iSBN) ;

}
