package com.nt.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(value=NoProductFoundException.class)
	public ResponseEntity<ApiError> handleNoProductFoundException()
	{
		ApiError error=new ApiError(400, "No Product Found", new Date());
		return new ResponseEntity<ApiError>(error,	HttpStatus.NOT_FOUND);
	}
}
