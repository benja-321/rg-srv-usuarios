package com.gur.usuarios.exception;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 5374574341953232188L;

	public UserNotFoundException() {
		super();
	}
	
	public UserNotFoundException(String message) {
		super(message);
	}
	
	public UserNotFoundException(String message, Throwable ex) {
		super(message, ex);
	}
}
