package com.sapestore.books.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapestore.books.model.Books;

@Repository
public interface IBookRepository extends JpaRepository<Books, Integer> {





     public List<Books> findBooksByCategory(String category);

	

	public List<Books> findBooksByTitle(String title);
	
	List<Books> findAllByAuthor(String author);
	List<Books> findAllByCategory(String category);
	List<Books> findByTitle(String title);



	public List<Books> findByActive(boolean b);



	public List<Books> findBooksByCategoryAndActive(String category, boolean b); 

	



	

	
	
	
}
