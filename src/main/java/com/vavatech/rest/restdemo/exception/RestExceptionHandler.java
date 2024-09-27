package com.vavatech.rest.restdemo.exception;

import com.vavatech.rest.restdemo.car.CarNotFoundException;
import com.vavatech.rest.restdemo.car.CarValidationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler({CarNotFoundException.class, CarValidationException.class})
	public String handleCarNotFoundException(Exception ex) {

		return switch (ex) {
			case CarNotFoundException exception -> "car not found:(";
			case CarValidationException exception -> "car validation failed:(";
			case MethodArgumentNotValidException exception -> "validation failed:(";
			case Exception exception -> "unknown exception:(";
		};
	}

//	@ExceptionHandler({CarNotFoundException.class, CarValidationException.class})
//	public String handleCarNotFoundException(RuntimeException ex) {
//
//		if (ex instanceof CarNotFoundException exception) {
//			return "car not found:( " + exception.getMessage();
//		} else if (ex instanceof CarValidationException exception) {
//			return "car validation failed:( " + exception.getMessage();
//		} else {
//			return "unknown exception:( " + ex.getMessage();
//		}
//	}
}
