package com.vavatech.rest.restdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	Long id;

	String brand;
	String model;

	@Column(name = "productionYear")
	Year year;
}
