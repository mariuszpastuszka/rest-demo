package com.vavatech.rest.restdemo.car;

import lombok.Builder;

import java.time.Year;

@Builder
record CarDtoResponse(
		long id,
		String brand,
		String model,
		Year year
) {
}
