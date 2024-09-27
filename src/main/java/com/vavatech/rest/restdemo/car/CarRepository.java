package com.vavatech.rest.restdemo.car;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface CarRepository extends JpaRepository<Car, Long> {

	Optional<Car> findCarByBrandAndModel(String brand, String model);
}
