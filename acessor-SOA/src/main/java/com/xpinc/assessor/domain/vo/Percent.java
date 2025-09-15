package com.xpinc.assessor.domain.vo;

public record Percent(int value) {
	public Percent {
		if (value < 0 || value > 100)
			throw new IllegalArgumentException("percent 0..100");
	}
}