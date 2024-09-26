package com.vavatech.rest.restdemo.controller;

import com.vavatech.rest.restdemo.dto.CarRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Year;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

	// Read all - /cars
	@GetMapping
	public List<CarRecord> getAllCars() {
		return List.of(
				new CarRecord("Fiat", "Duży", Year.of(1980)),
				new CarRecord("Fiat", "Mały", Year.of(1980))
		);
	}

	// /cars/{id}
	@GetMapping(path = "/{id}")
	public CarRecord getCarById(@PathVariable("id") Integer idik) {
		System.out.println("id = [" + idik + "]");
		return new CarRecord("Fiat", "Duży", Year.of(1980));
	}
}
