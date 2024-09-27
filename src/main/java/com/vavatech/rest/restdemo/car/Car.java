package com.vavatech.rest.restdemo.car;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	Long id;

	String brand;
	String model;

	@Column(name = "productionYear")
	Year year;
}
