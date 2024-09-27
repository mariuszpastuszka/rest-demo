package com.vavatech.rest.restdemo.github;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Repository(
		String name,
		@JsonProperty("full_name")
		String fullName,
		RepoOwner owner
) {

}
