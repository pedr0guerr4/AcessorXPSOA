package com.xpinc.assessor.advice;

import java.time.OffsetDateTime;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.xpinc.assessor.infrastructure.shared.error.BusinessException;

@RestControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Map<String, Object>> business(BusinessException ex) {
		return ResponseEntity.badRequest().body(base("BUSINESS", ex.getMessage()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> bean(MethodArgumentNotValidException ex) {
		var msg = ex.getBindingResult().getFieldErrors().stream().map(e -> e.getField() + ": " + e.getDefaultMessage())
				.toList();
		return ResponseEntity.unprocessableEntity().body(base("VALIDATION", String.join(", ", msg)));
	}

	private Map<String, Object> base(String code, String message) {
		return Map.of("timestamp", OffsetDateTime.now().toString(), "code", code, "message", message);
	}
}