package com.base.code.common.exception;

public class AppException extends Exception{

	private static final long serialVersionUID = 3058668128333568420L;
	private final int code;
	
	public AppException(int code, String message) {
		super(message);
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
}
