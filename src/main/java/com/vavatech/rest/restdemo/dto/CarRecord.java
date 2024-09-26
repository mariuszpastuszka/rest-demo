package com.vavatech.rest.restdemo.dto;

import lombok.Builder;

import java.time.Year;

@Builder
public record CarRecord(
		String brand,
		String model,
		Year year
) {
}
