package com.vavatech.rest.restdemo.github;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class GithubService {
	private final RestTemplate restTemplate;
	private final String url;

	public GithubService(RestTemplateBuilder restTemplateBuilder, @Value("${github.repositories.url}") String url) {
		this.restTemplate = restTemplateBuilder.build();
		this.url = url;

		log.info("url = [{}]", url);
	}

	public String getMyRepositories() {
		return null;
	}
}
