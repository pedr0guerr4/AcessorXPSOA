package com.xpinc.assessor.infrastructure.shared.error;

public class NotFoundException extends RuntimeException {
	public NotFoundException(String m) {
		super(m);
	}
}