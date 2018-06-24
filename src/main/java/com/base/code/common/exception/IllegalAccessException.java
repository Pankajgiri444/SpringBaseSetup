package com.base.code.common.exception;

import org.springframework.http.HttpStatus;

public class IllegalAccessException extends AppException{

	private static final long serialVersionUID = 2755091377032325640L;

	public IllegalAccessException(String message) {
		super(HttpStatus.FORBIDDEN.value(),message);
	}
	
}
