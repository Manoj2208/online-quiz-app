package com.manu.questionservice.exception;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}

	@ExceptionHandler(SimpleQuestionGlobalException.class)
	protected ResponseEntity<ErrorResponse> handleGlobalException(SimpleQuestionGlobalException simpleQuestionGlobalException,
			Locale locale) {
		return ResponseEntity.badRequest().body(ErrorResponse.builder().code(simpleQuestionGlobalException.getCode())
				.message(simpleQuestionGlobalException.getMessage()).build());
	}

	@ExceptionHandler({ Exception.class })
	protected ResponseEntity<?> handleException(Exception e, Locale locale) {
		return ResponseEntity.badRequest().body("Exception occur inside API " + e);
	}

}
