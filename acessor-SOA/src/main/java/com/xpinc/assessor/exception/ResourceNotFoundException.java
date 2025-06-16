package com.xpinc.assessor.exception;

public class ResourceNotFoundException extends RuntimeException {
	
    private static final long serialVersionUID = 5069480668849449727L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}