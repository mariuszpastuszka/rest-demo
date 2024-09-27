package com.vavatech.rest.restdemo.github;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/github")
@Slf4j
class GithubRestController {

	private final GithubService githubService;

	GithubRestController(GithubService githubService) {
		this.githubService = githubService;
	}

	@GetMapping("/repositories")
	Repository[] getMyRepositories() {
		log.info("List my repositories");
		return githubService.getMyRepositories();
	}
}
