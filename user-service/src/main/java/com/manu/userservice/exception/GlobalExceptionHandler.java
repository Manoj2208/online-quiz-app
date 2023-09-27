package com.manu.userservice.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.manu.userservice.response.ApiResponse;

@RestControllerAdvice
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

	@ExceptionHandler(ResourceConflictExists.class)
	public ResponseEntity<ApiResponse> handleResourceConflictExists(ResourceConflictExists exception) {

		return ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
				.body(new ApiResponse(exception.getMessage(), HttpStatus.ALREADY_REPORTED));

}
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFound exception){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(exception.getMessage(),HttpStatus.BAD_REQUEST));
	}
}
