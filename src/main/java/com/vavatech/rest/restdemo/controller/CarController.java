package com.vavatech.rest.restdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/cars")
public class CarController {

	@RequestMapping
	public String getAllCars() {
		return "cars";
	}
}
