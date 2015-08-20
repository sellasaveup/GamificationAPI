package com.gamification.api.persistence.config;

import com.gamification.api.interfaces.persistence.GFPersistenceException;

public final class ClassInstantiator {

	public static Class<?> loadClass(String className) throws GFPersistenceException {
		
		try {
			return Class.forName(className);
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
			throw new GFPersistenceException("Technical Problem", e);
		}
	}
}
