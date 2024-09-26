package com.vavatech.rest.restdemo;

import com.vavatech.rest.restdemo.component.MyFirstBean;
import com.vavatech.rest.restdemo.component.SecondBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
	}


	@Bean
	SecondBean secondBean(MyFirstBean myFirstBean) {
		return new SecondBean(myFirstBean);
	}

	@Bean
	MyFirstBean myFirstBean() {
		return new MyFirstBean();
	}
}
