package com.vavatech.rest.restdemo.service;

import com.vavatech.rest.restdemo.entity.Car;
import com.vavatech.rest.restdemo.repository.CarRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class CarService {
	private final CarRepository carRepository;

	public CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public Optional<Car> getCarById(Long id) {
		log.info("finding car with id: [{}]", id);
		return carRepository.findById(id);
	}
}
