package com.vavatech.rest.restdemo.car;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.Year;

@Builder
record CarDtoRequest(
		@NotNull
		@Size(min = 3)
		String brand,
		@NotNull
		@Size(min = 2)
		String model,
		@Past
		@JsonProperty("production-year")
		Year year
) {
	CarDtoRequest {
		brand = brand.toUpperCase();
		model = model.toUpperCase();
	}
}
