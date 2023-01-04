package com.masai.webapp.example.exception;

public class UsernameLength extends RuntimeException{

	public UsernameLength() {}
	
	public UsernameLength(String msg) {
		super(msg);
	}
}
