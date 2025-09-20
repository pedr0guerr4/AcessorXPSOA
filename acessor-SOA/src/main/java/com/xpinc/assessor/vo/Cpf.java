package com.xpinc.assessor.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record Cpf(String value) {
	@JsonCreator(mode = JsonCreator.Mode.DELEGATING)
	public Cpf {
		if (value == null)
			throw new IllegalArgumentException("CPF vazio");
		var digits = value.replaceAll("\\D", "");
		if (digits.length() != 11 || digits.chars().distinct().count() == 1 || !check(digits))
			throw new IllegalArgumentException("CPF inválido");
	}

	private static boolean check(String d) {
		int s1 = 0, s2 = 0;
		for (int i = 0; i < 9; i++) {
			int n = d.charAt(i) - '0';
			s1 += n * (10 - i);
			s2 += n * (11 - i);
		}
		int c1 = (s1 * 10) % 11;
		if (c1 == 10)
			c1 = 0;
		int c2 = ((s2 + c1 * 2) * 10) % 11;
		if (c2 == 10)
			c2 = 0;
		return c1 == d.charAt(9) - '0' && c2 == d.charAt(10) - '0';
	}

	@JsonValue
	public String asString() {
		return value;
	}
}
