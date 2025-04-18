package com.infosys.lms.exceptionclasses;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class InValidUserIdException extends RuntimeException {
	private String message;

	
	
	
	
	public InValidUserIdException() {
		super();
	}



	public InValidUserIdException(String message) {
		super();
		this.message = message;
	}
	
	
	
	@Override
	public String getMessage() {
		return this.message;
	}

	
	
}
