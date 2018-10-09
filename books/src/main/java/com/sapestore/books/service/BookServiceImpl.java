package com.sapestore.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapestore.books.dao.IBookRepository;
import com.sapestore.books.exception.AuthorNotFoundException;
import com.sapestore.books.exception.BookNotFoundException;
import com.sapestore.books.exception.CategoryNotFoundException;
import com.sapestore.books.model.Books;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired 
	IBookRepository bookrepository;
	@Override
	public void addBook(Books book) {
		
		 bookrepository.save(book);
		 
	}

	@Override
	public List<Books> getAllBook() {
		return bookrepository.findAll();
	}

	@Override
	public boolean deleteBook(Integer iSBN) {
		bookrepository.deleteById(iSBN);
		return true;
	}

	
	
	@Override
	public Books getBookByISBN(Integer iSBN) {
		return bookrepository.findById(iSBN).get();
		
	}


	@Override
	public 	List<Books> getBookBytitle(String title) throws BookNotFoundException {
	
		return bookrepository.findByTitle(title);

	}

	@Override
	public Books updateBook(Books book) {
		
		return  bookrepository.save(book);
	}

	@Override
	public List<Books> getBookByAuthor(String author) throws AuthorNotFoundException {
		return bookrepository.findAllByAuthor(author);
	}

	@Override
	public List<Books> getBookByCategory(String category) throws CategoryNotFoundException {
		return bookrepository.findAllByCategory(category);
	}

}
