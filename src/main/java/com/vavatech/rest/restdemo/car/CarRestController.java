package com.vavatech.rest.restdemo.car;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.Year;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
@Log4j2
class CarRestController {

	private final CarService carService;

	CarRestController(CarService carService) {
		this.carService = carService;
	}

	// Read all - /cars
	@GetMapping
	public List<CarDtoRequest> getAllCars() {
		return List.of(
				new CarDtoRequest("Fiat", "Duży", Year.of(1980)),
				new CarDtoRequest("Fiat", "Mały", Year.of(1980))
		);
	}

	// /cars/{id}
	@GetMapping(path = "/{id}")
	public CarDtoRequest getCarById(@PathVariable("id") Integer idik) {
		log.info("finding car with id: [{}]", idik);

		var car = carService.getCarById(idik.longValue());
		return new CarDtoRequest(car.getBrand(), car.getModel(), car.getYear());
	}

	// TODO: location header
	// 201
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public CarDtoResponse createCar(@RequestBody @Valid CarDtoRequest car) {
		log.info("car = [{}]", car);

		return CarDtoResponse.builder()
				.id(1)
				.brand(car.brand())
				.year(car.year())
				.model(car.model())
				.build();
	}

	// id = 1 - exists
	// id = 2 - no entity with this id
	// ok - 204
	// not - 404
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteCarById(@PathVariable("id") int id) {
		log.info("trying to delete car with id = [{}]", id);
		// call service with given id
		if (id == 1) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping(path = "/{id}")
	public CarDtoResponse updateCarById(@PathVariable("id") int id, @RequestBody CarDtoRequest car) {
		log.info("trying to update car with id = [{}]", id);

		// call service

		return CarDtoResponse.builder()
				.id(id)
				.brand(car.brand())
				.year(car.year())
				.model(car.model())
				.build();
	}
}
