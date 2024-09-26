package com.vavatech.rest.restdemo.dto;

import java.time.Year;
import java.util.Objects;

public class CarDto {
	private String brand;
	private String model;
	private Year year;

	public CarDto(String brand, String model, Year year) {
		this.brand = brand;
		this.model = model;
		this.year = year;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CarDto carDto = (CarDto) o;
		return Objects.equals(brand, carDto.brand) && Objects.equals(model, carDto.model) &&
				Objects.equals(year, carDto.year);
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, model, year);
	}

	@Override
	public String toString() {
		return "CarDto{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + ", year=" + year + '}';
	}
}
