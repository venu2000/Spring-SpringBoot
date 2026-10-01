package com.flmfood.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// This classs is written to returun Both Return message & Status Code 

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<String> HandleItemNotFountException(ItemNotFoundException itemNotFoundException){
		return new ResponseEntity<String>(itemNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
		
		
	}
	

	@ExceptionHandler(InvalidRatingException.class)
	public ResponseEntity<String>HandleInvalidRatingException(InvalidRatingException InvalidRatingException){
		return new ResponseEntity<String>(InvalidRatingException.getMessage(), HttpStatus.BAD_REQUEST);
		
	}

}
