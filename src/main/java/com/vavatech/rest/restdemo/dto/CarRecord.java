package com.vavatech.rest.restdemo.dto;

import java.time.Year;

public record CarRecord(
		String brand,
		String model,
		Year year
) {
}
