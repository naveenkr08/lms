package com.infosys.lms.exceptionclasses;

public class NoUserFoundException extends RuntimeException {
	
	private String message;
	
	public NoUserFoundException(String message) {
		this.message=message;
	}

	
	
	@Override
	public String toString() {
		return "NoUserFoundException [message=" + message + "]";
	}
	
	
	
	
	
}
	
	

