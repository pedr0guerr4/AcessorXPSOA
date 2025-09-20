package com.xpinc.assessor.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

import java.time.Instant;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

	record ApiError(Instant timestamp, int status, String error, String message, String path, List<String> details) {
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiError> notFound(ResourceNotFoundException ex, HttpServletRequest req) {
		var body = new ApiError(Instant.now(), 404, "Not Found", ex.getMessage(), req.getRequestURI(), List.of());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}

	// @Valid em DTO (body)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> validation(MethodArgumentNotValidException ex, HttpServletRequest req) {
		var details = ex.getBindingResult().getFieldErrors().stream()
				.map(e -> e.getField() + ": " + e.getDefaultMessage()).toList();
		var body = new ApiError(Instant.now(), 400, "Validation Error", "Entrada inválida", req.getRequestURI(),
				details);
		return ResponseEntity.badRequest().body(body);
	}

	// @Validated em params (@Positive, @Min, etc.)
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ApiError> constraint(ConstraintViolationException ex, HttpServletRequest req) {
		var details = ex.getConstraintViolations().stream().map(v -> v.getPropertyPath() + ": " + v.getMessage())
				.toList();
		var body = new ApiError(Instant.now(), 400, "Constraint Violation", "Parâmetros inválidos", req.getRequestURI(),
				details);
		return ResponseEntity.badRequest().body(body);
	}

	// Enum/param inválido (ex: classeAtivo=FOO)
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ApiError> typeMismatch(MethodArgumentTypeMismatchException ex, HttpServletRequest req) {
		String msg = "Parâmetro inválido: " + ex.getName();
		if (ex.getRequiredType() != null)
			msg += " (esperado: " + ex.getRequiredType().getSimpleName() + ")";
		var body = new ApiError(Instant.now(), 400, "Type Mismatch", msg, req.getRequestURI(),
				List.of(String.valueOf(ex.getValue())));
		return ResponseEntity.badRequest().body(body);
	}

	// JSON malformado, enum inválido no corpo, número fora do formato etc.
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ApiError> unreadable(HttpMessageNotReadableException ex, HttpServletRequest req) {
		var body = new ApiError(Instant.now(), 400, "Malformed JSON", "Corpo da requisição inválido",
				req.getRequestURI(), List.of(ex.getMostSpecificCause().getMessage()));
		return ResponseEntity.badRequest().body(body);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ApiError> dataIntegrity(DataIntegrityViolationException ex, HttpServletRequest req) {
		var body = new ApiError(Instant.now(), 409, "Data Integrity", "Violação de integridade no banco",
				req.getRequestURI(), List.of(ex.getMostSpecificCause().getMessage()));
		return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ApiError> badRequest(IllegalArgumentException ex, HttpServletRequest req) {
		var body = new ApiError(Instant.now(), 400, "Bad Request", ex.getMessage(), req.getRequestURI(), List.of());
		return ResponseEntity.badRequest().body(body);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> generic(Exception ex, HttpServletRequest req) {
		var body = new ApiError(Instant.now(), 500, "Internal Error", ex.getMessage(), req.getRequestURI(), List.of());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
	}
}
