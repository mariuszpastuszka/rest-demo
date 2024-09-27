package com.vavatech.rest.restdemo.exception;

import com.vavatech.rest.restdemo.car.CarNotFoundException;
import com.vavatech.rest.restdemo.car.CarValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler({CarNotFoundException.class, CarValidationException.class, MethodArgumentNotValidException.class})
	public ResponseEntity<ExceptionRecord> handleCarNotFoundException(Exception ex) {

		return switch (ex) {
			case CarNotFoundException exception -> ResponseEntity.notFound().build();
			case CarValidationException exception -> ResponseEntity.badRequest().build();
			case MethodArgumentNotValidException exception -> ResponseEntity.badRequest().build();
			case Exception exception -> ResponseEntity.badRequest().build();
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
