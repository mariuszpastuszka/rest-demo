package com.vavatech.rest.restdemo.car;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.Year;

@Builder
public record CarRecord(
		String brand,
		String model,
		@JsonProperty("production-year")
		Year year
) {
}
