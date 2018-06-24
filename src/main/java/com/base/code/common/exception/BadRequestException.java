package com.base.code.common.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends AppException{

	private static final long serialVersionUID = 7947234056787549786L;
	
	public BadRequestException(String message) {
		super(HttpStatus.BAD_REQUEST.value(),message);
	}

}
