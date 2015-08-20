package com.gamification.api.interfaces;

@SuppressWarnings("serial")
public class GFException extends RuntimeException{

	public GFException() {
		super();
	}

	public GFException(String message, Throwable e) {
		super(message, e);
	}

	public GFException(String message) {
		super(message);
	}

	public GFException(Throwable e) {
		super(e);
	}
}
