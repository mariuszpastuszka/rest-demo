package com.vavatech.rest.restdemo.github;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GithubService {
	private final RestTemplate restTemplate;

	public GithubService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public String getMyRepositories() {
		return null;
	}
}
