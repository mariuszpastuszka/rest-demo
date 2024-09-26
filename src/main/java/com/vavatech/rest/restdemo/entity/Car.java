package com.vavatech.rest.restdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.Year;

@Entity
@Data
public class Car {

	@Id
	Long id;

	String brand;
	String model;
	Year year;
}
