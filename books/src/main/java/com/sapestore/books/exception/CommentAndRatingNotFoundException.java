package com.sapestore.books.exception;


public class CommentAndRatingNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CommentAndRatingNotFoundException(){
		 super();
		 }
	 
	 public CommentAndRatingNotFoundException(String msg) {
		 super( msg);
	 }

}
