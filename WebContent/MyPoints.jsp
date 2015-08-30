<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<head>
<title>My Points</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/leaderboard.css">
<link rel="stylesheet" href="./css/leaderboardalltime.css">

<script type="text/javascript" src="./js/termometer.js"></script>
<script src="./js/jquery.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="./js/jquery.canvasjs.min.js"></script>
<script type="text/javascript" src="./js/leaderboard.js"></script>
<script type="text/javascript" src="./js/leaderboardalltime.js"></script>
<script src="./js/session.js"></script>
<script src="./js/pointswidget.js" type="text/javascript"></script>
<script src="./js/rankwidget.js" type="text/javascript"></script>
<link href="./css/masterpage.css" rel="stylesheet">
<script type="text/javascript">

var commonUrl = getSessionUrl();
var userCode = getSessionUserCode();
var goalCode = getSessionGoalCode();

$(document).ready(function() {
	getMyAllTimePoints('AllTimePoint', userCode, goalCode, commonUrl);
	getMyCurrentMonthPoints('CurrentMonthPoint',  userCode, goalCode, commonUrl);
	getMyCurrentMonthRank('CurrentMonthRank',  userCode, goalCode, commonUrl);
	getMyAllTimeRank('AllTimeRank', userCode, goalCode, commonUrl);
	getMyChallengesList('ChallengeList', userCode, goalCode, commonUrl); 
	getAllTimeLeaderBoard(userCode, commonUrl);
	getThisMonthLeaderBoard(userCode, commonUrl)
});

</script>
</head>
<body>

<div class="container"><section class="row" style="height:500px">

   <article class="col-sm-12 col-md-6" style="padding-right:30px;">
     <!--ROW LEFT-->
     <div class="row" >
      <div class="col-sm-6"><div class="well" >
				<ul id="myTab" class="nav nav-tabs">
					<li class="active"><a href="#pointsmonth" data-toggle="tab">This Month </a></li>
					<li><a href="#pointswhole" data-toggle="tab">All Time</a></li>
				</ul>
				
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="pointsmonth">
					<br>
							<font size="4">	<b>&nbsp;&nbsp;My Points &nbsp;&nbsp;&nbsp;<label id="CurrentMonthPoint"></label></b></font>
							
					</div>

					<div class="tab-pane fade" id="pointswhole"><br>
								<font size="4"><b>&nbsp;&nbsp;My Points&nbsp;&nbsp;&nbsp;<label id="AllTimePoint"></label></b></font>
								
					</div>
				</div>
				</div></div>
      <div class="col-sm-6"><div class="well">
				<ul id="myTab" class="nav nav-tabs">
					<li class="active"><a href="#rankmonth" data-toggle="tab">This Month </a></li>
					<li><a href="#rankwhole" data-toggle="tab">All Time</a></li>
				</ul>
				
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="rankmonth">
					<br>
							<font size="4">	<b>&nbsp;&nbsp;My Rank&nbsp;&nbsp;&nbsp;<label id="CurrentMonthRank"></label></b></font>
							
					</div>

					<div class="tab-pane fade" id="rankwhole"><br>
								<font size="4"><b>&nbsp;&nbsp;My Rank&nbsp;&nbsp;&nbsp;<label id="AllTimeRank"></label></b></font>
								
					</div>
					</div></div>
    
     </div></div>
    
     <div class="row">
     <div class="col-sm-12">
     <h4 style="padding-left:20px;" class="element">My points journey...</h4>
     <img src="./img/banners/pointChart.jpeg" width="550px" height="300px">
     </div>
     </div>
   </article>
 

   	<article class="col-sm-12 col-md-6" style="padding-left:30px;height:500px">
     <!--ROW RIGHT-->
     <div class="row">
      <div class="col-sm-6"><div class='pull-left'>
   		 <img src="./img/banners/leaderboard.png">
    
    		<ul id="myTab" class="nav nav-tabs">
    
				<li class="active"><a href="#thismonthleader" data-toggle="tab">This Month </a></li>
				<li><a href="#alltimeleader" data-toggle="tab">All Time</a></li>
		
			</ul>
			<div id="myTabContentleader" class="tab-content">
	
    			<div   id="thismonthleader" class="contentthistime tab-pane fade in active"></div>
    			<div  id="alltimeleader"  class="contentalltime tab-pane fade"></div>
    
    		</div></div></div>
      
     		</div>
   		</article>

	</section></div>

 <div id="ChallengeList" style="padding-left:30px;"></div>
	
</body>
</html>