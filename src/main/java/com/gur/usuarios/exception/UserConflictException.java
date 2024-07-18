package com.gur.usuarios.exception;

public class UserConflictException extends Exception {

	private static final long serialVersionUID = -6156198955701329186L;

	public UserConflictException() {
		super();
	}
	
	public UserConflictException(String message) {
		super(message);
	}
	
	public UserConflictException(String message, Throwable ex) {
		super(message, ex);
	}
}
