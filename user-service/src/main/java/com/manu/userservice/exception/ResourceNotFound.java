package com.manu.userservice.exception;

public class ResourceNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFound() {
		super("resource not found");
	}
	
	public ResourceNotFound(String message) {
		super(message);
	}

}
