package com.manu.questionservice.exception;

public class ResourceNotFound extends SimpleQuestionGlobalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFound() {
		super("resource not found", GlobalErrorCode.ERROR_RESOURCE_NOT_FOUND);
	}

	public ResourceNotFound(String message) {
		super(message, GlobalErrorCode.ERROR_RESOURCE_NOT_FOUND);
	}

}
