package com.vavatech.rest.restdemo.exception;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ExceptionRecord(
		LocalDateTime timestamp,
		int status,
		String url,
		String errorMessage
) {
}
