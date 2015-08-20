package com.gamification.api.interfaces.persistence;

import com.gamification.api.interfaces.GFException;

@SuppressWarnings("serial")
public class GFPersistenceException extends GFException {

	public GFPersistenceException() {
		super();
	}

	public GFPersistenceException(String message, Throwable e) {
		super(message, e);
	}

	public GFPersistenceException(String message) {
		super(message);
	}

	public GFPersistenceException(Throwable e) {
		super(e);
	}
}
