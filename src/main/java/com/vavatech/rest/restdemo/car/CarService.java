package com.vavatech.rest.restdemo.car;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
class CarService {
	private final CarRepository carRepository;

		CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public Car getCarById(Long id) {
		log.info("finding car with id: [{}]", id);
		return carRepository.findById(id)
				.orElseThrow(() -> new CarNotFoundException("No car with id: " + id));
	}
}
