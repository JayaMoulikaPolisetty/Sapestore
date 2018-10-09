package com.sapestore.books.exception;



public class AuthorNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public AuthorNotFoundException(){
		 super();
		 }
	 
	 public AuthorNotFoundException(String msg) {
		 super( msg);
	 }

}