package com.vavatech.rest.restdemo.github;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class GithubService {
	// TODO: replace with RestClient
	private final RestTemplate restTemplate;
	private final String url;

	public GithubService(RestTemplateBuilder restTemplateBuilder, @Value("${github.repositories.url}") String url) {
		this.restTemplate = restTemplateBuilder.build();
		this.url = url;

		log.info("url = [{}]", url);
		ParameterizedTypeReference<List<String>> typeRef = new ParameterizedTypeReference<List<String>>() {};
	}
// TODO: fixme :)
	public List<Repository> getMyRepositories() {
		return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Repository>>(){}).getBody();
	}
}
