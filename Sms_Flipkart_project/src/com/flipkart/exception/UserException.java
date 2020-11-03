package com.flipkart.exception;

public class UserException extends Exception{

	private String message;
	public UserException(String message) {
		super();
		this.message=message;
	}
	@Override
	public String getMessage() {
		return this.message;
	}
}
