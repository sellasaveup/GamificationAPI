-- getAllMyPointsDetail
select ua.ACTION_CODE, ch.STORY, ua.POINTS, ua.DATE from ss_tr_user_action ua, ss_ma_challenge ch where
ch.ACTION_CODE=ua.ACTION_CODE and ua.USER_CODE='GBS03146' and ua.GOAL_CODE='HYPE_GOAL' and ua.STATUS='Active' order by ua.date desc

--getAllTimePoints

select sum(ua.POINTS) from ss_tr_user_action ua, ss_ma_challenge ch where
ch.ACTION_CODE=ua.ACTION_CODE and ua.USER_CODE='GBS03146' and ua.GOAL_CODE='HYPE_GOAL' and ua.STATUS='Active' 

--getThisMonthPoints
select @curRank := @curRank + 1 AS rank, inQuery.*  from 
(SELECT sum(ua.POINTS) as points, month(ua.date), ua.USER_CODE 
 FROM ss_tr_user_action ua 
 where extract(year_month from ua.date)= 201508 and ua.STATUS='Active' 
 group by ua.USER_CODE, month(date)  order by points desc limit 10) as inQuery, (SELECT @curRank := 0) r


--this month leaderboard

select @curRank := @curRank + 1 AS rank, inQuery.*  from 
(SELECT sum(ua.POINTS) as totalpoints, month(ua.DATE), ua.USER_CODE FROM ss_tr_user_action ua where 
 extract(year_month from ua.DATE)= 201507  
 group by ua.USER_CODE, month(ua.DATE)  
 order by totalpoints desc limit 10) as inQuery, (SELECT @curRank := 0) r



--All Time leaderboard


select @curRank := @curRank + 1 AS rank, inQuery.*  from 
(SELECT sum(ua.POINTS) as totalPoints, ua.USER_CODE FROM ss_tr_user_action ua 
	group by ua.USER_CODE order by totalPoints desc limit 10) as inQuery, (SELECT @curRank := 0) r



-- MyPointsGraph
SELECT sum(ua.POINTS) as totalpoints, monthname(ua.DATE) FROM ss_tr_user_action ua where ua.STATUS='Active'
 group by ua.USER_CODE, month(ua.DATE)
