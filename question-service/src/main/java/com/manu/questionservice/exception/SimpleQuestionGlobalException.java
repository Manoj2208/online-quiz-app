package com.manu.questionservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleQuestionGlobalException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String message;

	public SimpleQuestionGlobalException(String message) {
		super(message);
	}

}
