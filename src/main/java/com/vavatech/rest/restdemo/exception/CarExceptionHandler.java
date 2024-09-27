package com.vavatech.rest.restdemo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CarExceptionHandler {

	@ExceptionHandler(CarNotFoundException.class)
	public String handleCarNotFoundException(CarNotFoundException ex) {
		return "not found:(";
	}
}
