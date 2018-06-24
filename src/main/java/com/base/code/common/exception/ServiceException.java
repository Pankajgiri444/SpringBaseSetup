package com.base.code.common.exception;

import org.springframework.http.HttpStatus;

public class ServiceException extends AppException{
	
	private static final long serialVersionUID = 3977606946517341181L;

	public ServiceException(String message) {
		super(HttpStatus.FAILED_DEPENDENCY.value(),message);
	}
}
