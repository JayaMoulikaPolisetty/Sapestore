package com.sapient.sapestore.exception;

public class AddressNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddressNotFoundException() {
		
	}

	public AddressNotFoundException(String message) {
		super(message);
		
	}

	public AddressNotFoundException(Throwable cause) {
		super(cause);
		
	}

	public AddressNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AddressNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
