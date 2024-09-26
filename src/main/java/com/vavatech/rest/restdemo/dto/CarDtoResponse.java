package com.vavatech.rest.restdemo.dto;

import lombok.Builder;

import java.time.Year;

@Builder
public record CarDtoResponse(
		long id,
		String brand,
		String model,
		Year year
) {
}
