package com.vavatech.rest.restdemo.car;

public class CarNotFoundException extends RuntimeException {

	public CarNotFoundException(String message) {
		super(message);
	}
}
