package com.xpinc.assessor.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record Ticker(String value) {
	@JsonCreator(mode = JsonCreator.Mode.DELEGATING)
	public Ticker {
		if (value == null || !value.matches("^[A-Za-z]{4}\\d{1,2}$"))
			throw new IllegalArgumentException("Ticker inválido");
	}

	@JsonValue
	public String asString() {
		return value.toUpperCase();
	}
}
