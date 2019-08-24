package com.spring.springrestcrud.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler {
	 
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handlerException(CustomNotFoundException exc){
		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		customErrorResponse.setMassage(exc.getMessage());
		customErrorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(customErrorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handlerException(Exception exc){
		
		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		customErrorResponse.setMassage(exc.getMessage());
		customErrorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(customErrorResponse,HttpStatus.BAD_REQUEST);
		
	}

}
