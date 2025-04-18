package com.infosys.lms.exceptionclasses;

public class DeleteUserByIdException  extends RuntimeException{
	
	private String message;

	public DeleteUserByIdException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "DeleteUserByIdException [message=" + message + "]";
	}
	
	
	
	
	
	
	

}
