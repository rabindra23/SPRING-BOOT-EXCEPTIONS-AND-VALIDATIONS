package com.masai.webapp.example.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	/*
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> myExceptionHandler(IllegalArgumentException ex) {
		System.out.println("In my Exception Handler for illegal argument");
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MessageLimitExceeded.class)
	public ResponseEntity<String> myExceptionHandler2(MessageLimitExceeded ex) {
		System.out.println("In my Exception Handler for illegal message limit");
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	*/
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> validationHandler(MethodArgumentNotValidException ex, WebRequest request){
		
		ErrorDetails error = new ErrorDetails();
		error.setError_time(LocalDateTime.now());
		error.setError_message("Validation error");
		String msg = ex.getBindingResult().getFieldError().getDefaultMessage();
		error.setUri_details(msg);
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> myExceptionHandler(NoHandlerFoundException ex, WebRequest request){
		System.out.println("In my Exception Handler for 404");
		ErrorDetails error = new ErrorDetails();
		error.setError_time(LocalDateTime.now());
		error.setError_message(ex.getMessage());
		error.setUri_details(request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> otherExceptions(Exception ex){
		System.out.println("Other Exceptions");
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);

	}
	
//	@ExceptionHandler(MessageLimitExceeded.class)
//	public ResponseEntity<ErrorDetails> myExceptionHandler(MessageLimitExceeded ex, WebRequest request){
//		System.out.println("In my Exception Handler for illegal message limit");
//		ErrorDetails error = new ErrorDetails();
//		error.setError_time(LocalDateTime.now());
//		error.setError_message(ex.getMessage());
//		error.setUri_details(request.getDescription(false));
//		return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
//	}
//	
//	@ExceptionHandler(UsernameLength.class)
//	public ResponseEntity<ErrorDetails> myExceptionHandler(UsernameLength ex, WebRequest request){
//		System.out.println("In my Exception Handler for username length");
//		ErrorDetails error = new ErrorDetails();
//		error.setError_time(LocalDateTime.now());
//		error.setError_message(ex.getMessage());
//		error.setUri_details(request.getDescription(false));
//		return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
//	}
	
	
}
