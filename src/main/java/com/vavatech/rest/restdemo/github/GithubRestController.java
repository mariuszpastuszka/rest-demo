package com.vavatech.rest.restdemo.github;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/github")
class GithubRestController {

	private final GithubService githubService;

	GithubRestController(GithubService githubService) {
		this.githubService = githubService;
	}
}
