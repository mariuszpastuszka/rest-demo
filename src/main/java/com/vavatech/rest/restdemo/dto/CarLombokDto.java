package com.vavatech.rest.restdemo.dto;

import lombok.Data;

import java.time.Year;

@Data
public class CarLombokDto {
	private String brand;
	private String model;
	private Year year;
}
