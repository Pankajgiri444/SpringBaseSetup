package com.base.code.api.data.exception;

public class AppErrorData {

	private int code;
	private String message;
	private String description;

	public AppErrorData() {
	}
	
	public AppErrorData(int code, String message, String description) {
		super();
		this.code = code;
		this.message = message;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
