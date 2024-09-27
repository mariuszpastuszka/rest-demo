package com.vavatech.rest.restdemo.component;

import com.vavatech.rest.restdemo.entity.Car;
import com.vavatech.rest.restdemo.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Year;

@Component
public class CarInitializer implements CommandLineRunner {

	private final CarRepository carRepository;

	public CarInitializer(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Car car = Car.builder()
				.brand("mazda")
				.model("6")
				.year(Year.of(2000))
				.build();
		Car car2 = Car.builder()
				.brand("Maluch")
				.model("maly")
				.year(Year.of(1980))
				.build();

		carRepository.save(car);
		carRepository.save(car2);
	}
}
