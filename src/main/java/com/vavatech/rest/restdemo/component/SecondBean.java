package com.vavatech.rest.restdemo.component;

import org.springframework.stereotype.Component;

@Component
public class SecondBean {
	private final MyFirstBean myFirstBean;

	public SecondBean(MyFirstBean myFirstBean) {
		this.myFirstBean = myFirstBean;
	}
}
