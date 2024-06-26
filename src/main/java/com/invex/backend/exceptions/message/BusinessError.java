package com.invex.backend.exceptions.message;

import org.springframework.http.HttpStatus;

public interface BusinessError {

	String getCode();
	
	String getMessage();
	
	HttpStatus getStatus();
	
	
}
