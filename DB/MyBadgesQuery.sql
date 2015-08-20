--getMyBadge
select * from ss_ma_badge b where b.BADGE_CODE in (
SELECT ub.BADGE_CODE FROM ss_tr_user_badge ub WHERE ub.USER_CODE='GBS03146' AND ub.GOAL_CODE='HYPE_GOAL') and b.GOAL_CODE='HYPE_GOAL' and b.EXPIRY_DATE>sysdate()
--getMyLockedBadge
select * from ss_ma_badge b where b.BADGE_CODE not in (
SELECT ub.BADGE_CODE FROM ss_tr_user_badge ub WHERE ub.USER_CODE='GBS03146' AND ub.GOAL_CODE='HYPE_GOAL') and b.GOAL_CODE='HYPE_GOAL' and b.EXPIRY_DATE>sysdate()
--getAllMyBadges
SELECT ub.BADGE_CODE FROM ss_tr_user_badge ub WHERE ub.USER_CODE='GBS03146' AND ub.GOAL_CODE='HYPE_GOAL'
