package com.gamification.api.core.challenge;

import com.gamification.api.interfaces.core.challenge.IChallengeAdmin;
import com.gamification.api.interfaces.persistence.challenge.IChallengeDao;

public class ChallengeAdmin implements IChallengeAdmin {
	
	private IChallengeDao challengeDao;

	public void setChallengeDao(final IChallengeDao challengeDao) {
		this.challengeDao = challengeDao;
	}
	
	
	
	
}
