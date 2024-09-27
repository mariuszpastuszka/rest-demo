package com.vavatech.rest.restdemo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CarExceptionHandler {

	@ExceptionHandler({CarNotFoundException.class, CarValidationException.class})
	public String handleCarNotFoundException(RuntimeException ex) {

		return switch (ex) {
			case CarNotFoundException exception -> "car not found:(";
			case CarValidationException exception -> "car validation failed:(";
			case RuntimeException exception -> "unknown exception:(";
		};
	}
}
