package com.manu.userservice.exception;

public class ResourceConflictExists extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceConflictExists() {
		super("Resource Conflict Exists");
	}

	public ResourceConflictExists(String message) {
		super(message);
	}
}
