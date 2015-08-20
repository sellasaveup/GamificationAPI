--getMyRewards
SELECT ur.REWARD_CODE, r.NAME, r.IMAGE, r.STORY, ur.DATE FROM ss_tr_user_reward ur, ss_ma_reward r WHERE ur.USER_CODE='GBS03146' 
AND ur.GOAL_CODE='HYPE_GOAL' and ur.GOAL_CODE= r.GOAL_CODE and r.REWARD_CODE=ur.REWARD_CODE order by ur.DATE desc

--getMyLockedRewards
select r.NAME, r.IMAGE, r.STORY from ss_ma_reward r where r.REWARD_CODE not in (
SELECT ur.REWARD_CODE FROM ss_tr_user_reward ur WHERE ur.USER_CODE='GBS03146' AND ur.GOAL_CODE='HYPE_GOAL') and r.GOAL_CODE='HYPE_GOAL' and r.EXPIRY_DATE>sysdate()

