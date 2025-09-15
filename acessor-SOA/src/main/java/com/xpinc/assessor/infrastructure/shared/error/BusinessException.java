package com.xpinc.assessor.infrastructure.shared.error;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -1120451538956117507L;

	public BusinessException(String m) {
		super(m);
	}
}