package com.gamification.api.core.level;

import com.gamification.api.interfaces.core.level.ILevelAdmin;
import com.gamification.api.interfaces.persistence.level.ILevelDao;

public class LevelAdmin implements ILevelAdmin {

	private ILevelDao levelDao;

	public void setLevelDao(final ILevelDao levelDao) {
		this.levelDao = levelDao;
	}
	
}
