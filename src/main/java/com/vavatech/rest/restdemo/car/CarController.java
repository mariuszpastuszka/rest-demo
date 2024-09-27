package com.vavatech.rest.restdemo.car;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/cars")
class CarController {

	@RequestMapping
	String getAllCars() {
		return "cars";
	}
}
