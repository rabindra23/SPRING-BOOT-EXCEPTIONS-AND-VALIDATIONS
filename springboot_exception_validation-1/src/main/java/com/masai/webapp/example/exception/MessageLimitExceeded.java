package com.masai.webapp.example.exception;

public class MessageLimitExceeded extends RuntimeException{

	public MessageLimitExceeded() {}
	
	public MessageLimitExceeded(String msg) {
		super(msg);
	}
}
