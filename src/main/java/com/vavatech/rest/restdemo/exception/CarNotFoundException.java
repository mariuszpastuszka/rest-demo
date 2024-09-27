package com.vavatech.rest.restdemo.exception;

public class CarNotFoundException extends RuntimeException {

	public CarNotFoundException(String message) {
		super(message);
	}
}
