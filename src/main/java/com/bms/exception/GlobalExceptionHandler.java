package com.bms.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return ResponseEntity.badRequest().body(errors);
	}
	
	@ExceptionHandler()
	protected ResponseEntity<Object> handleNoBookAvailableException(NoBooksAvailableException nb){
		Map<String, Object> error = new HashMap<String, Object>();
		error.put("errorCode", 301);
		error.put("timestamp", LocalDateTime.now());
		error.put("errorMessage", nb.getMessage());
		return ResponseEntity.badRequest().body(error);
	}

}
