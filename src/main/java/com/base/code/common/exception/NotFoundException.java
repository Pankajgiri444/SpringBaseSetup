package com.base.code.common.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends AppException{

	private static final long serialVersionUID = -3221239635301329174L;

	public NotFoundException(String message) {
		super(HttpStatus.NOT_FOUND.value(),message);
	}
}
