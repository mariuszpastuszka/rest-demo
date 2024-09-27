package com.vavatech.rest.restdemo.exception;

import com.vavatech.rest.restdemo.car.CarNotFoundException;
import com.vavatech.rest.restdemo.car.CarValidationException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler({CarNotFoundException.class, CarValidationException.class, MethodArgumentNotValidException.class})
	public ResponseEntity<ExceptionRecord> handleCarNotFoundException(Exception ex, HttpServletRequest request) {

		return switch (ex) {
			case CarNotFoundException exception -> new ResponseEntity<>(
					ExceptionRecord.builder()
					.status(HttpStatus.NOT_FOUND.value())
					.errorMessage(exception.getMessage())
							.timestamp(LocalDateTime.now())
					.url(request.getRequestURL().toString())
					.build(), HttpStatus.NOT_FOUND);
			case CarValidationException exception -> new ResponseEntity<>(
					ExceptionRecord.builder()
							.status(HttpStatus.BAD_REQUEST.value())
							.errorMessage(exception.getMessage())
							.url("")
							.timestamp(LocalDateTime.now())
							.build(), HttpStatus.BAD_REQUEST);
			case MethodArgumentNotValidException exception -> new ResponseEntity<>(
					ExceptionRecord.builder()
							.status(HttpStatus.BAD_REQUEST.value())
							.errorMessage(exception.getMessage())
							.url(request.getRequestURL().toString())
							.timestamp(LocalDateTime.now())
							.build(), HttpStatus.BAD_REQUEST);
			case Exception exception -> new ResponseEntity<>(createExceptionRecord(exception, request, HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
		};
	}

	private ExceptionRecord createExceptionRecord(Exception ex, HttpServletRequest request, int status) {
		return ExceptionRecord.builder()
				.status(status)
				.errorMessage(ex.getMessage())
				.url(request.getRequestURL().toString())
				.timestamp(LocalDateTime.now())
				.build();
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
