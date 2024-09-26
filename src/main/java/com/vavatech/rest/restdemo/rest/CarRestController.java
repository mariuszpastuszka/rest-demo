package com.vavatech.rest.restdemo.rest;

import com.vavatech.rest.restdemo.dto.CarDtoResponse;
import com.vavatech.rest.restdemo.dto.CarRecord;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.Year;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
@Log4j2
public class CarRestController {

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

	// 201
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public CarDtoResponse createCar(@RequestBody CarRecord car) {
		log.info("car = [{}]", car);

		return CarDtoResponse.builder()
				.id(1)
				.brand(car.brand())
				.year(car.year())
				.model(car.model())
				.build();
	}
}
