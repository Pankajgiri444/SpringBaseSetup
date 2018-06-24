package com.base.code.common.exception;

import org.springframework.http.HttpStatus;

public class InternalErrorException extends AppException{

	private static final long serialVersionUID = 745885730213914080L;

	public InternalErrorException(String message) {
		super(HttpStatus.INTERNAL_SERVER_ERROR.value(),message);
	}
}
