package com.base.code.common.exception.handler;

import java.text.MessageFormat;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.base.code.common.exception.BadRequestException;
import com.base.code.common.exception.IllegalAccessException;
import com.base.code.common.exception.InternalErrorException;
import com.base.code.common.exception.NotFoundException;
import com.base.code.common.exception.ServiceException;
import com.base.code.api.data.exception.AppErrorData;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public AppErrorData serviceError(NoHandlerFoundException e) {
		AppErrorData appErrorData = new AppErrorData();
		appErrorData.setCode(HttpStatus.NOT_FOUND.value());
		appErrorData.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
		appErrorData.setDescription(MessageFormat.format("The requested resource (path={0}, method={1} is not available)", e.getRequestURL(), e.getHttpMethod()));
		return appErrorData;
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public AppErrorData resourceIllegalAccessExceptionHandler(IllegalAccessException e) {
		return new AppErrorData(e.getCode(), HttpStatus.FORBIDDEN.getReasonPhrase(), e.getMessage());
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public AppErrorData resourceNotFoundExceptionHandler(NotFoundException e) {
		return new AppErrorData(e.getCode(), HttpStatus.NOT_FOUND.getReasonPhrase(), e.getMessage());
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public AppErrorData badRequestExceptionHandler(BadRequestException e) {
		return new AppErrorData(e.getCode(), HttpStatus.FORBIDDEN.getReasonPhrase(), e.getMessage());
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public AppErrorData illegalArgumentExceptionHandler(IllegalArgumentException e) {
		return badRequestExceptionHandler(new BadRequestException(e.getMessage()));
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public AppErrorData internalErrorExceptionHandler(InternalErrorException e) {
		return new AppErrorData(e.getCode(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage());
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
	public AppErrorData serviceExceptionHandler(ServiceException e) {
		return new AppErrorData(e.getCode(), HttpStatus.FAILED_DEPENDENCY.getReasonPhrase(), e.getMessage());
	}

}
