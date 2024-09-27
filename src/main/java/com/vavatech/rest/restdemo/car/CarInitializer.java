package com.vavatech.rest.restdemo.car;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.Year;

@Profile("dev")
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
