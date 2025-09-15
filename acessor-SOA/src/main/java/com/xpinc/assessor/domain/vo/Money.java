package com.xpinc.assessor.domain.vo;

import java.math.BigDecimal;
import java.util.Currency;

public record Money(BigDecimal amount, Currency currency) {
	public Money {
		if (amount == null || amount.signum() < 0)
			throw new IllegalArgumentException("amount >= 0");
		if (currency == null)
			throw new IllegalArgumentException("currency required");

	}
}