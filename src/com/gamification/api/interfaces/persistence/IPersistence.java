package com.gamification.api.interfaces.persistence;

import java.io.Serializable;
import java.util.List;

public interface IPersistence<ENTITY> {
	
	void create(ENTITY entity);
	void update(ENTITY entity);
	void delete(final Serializable id);
	ENTITY retrieve(final Serializable id);
	List<ENTITY> retrieveAll();
}
