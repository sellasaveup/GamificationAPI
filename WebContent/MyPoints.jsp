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
<link href="./css/masterpage.css" rel="stylesheet">
<link href="./css/thermometer.css" rel="stylesheet">
<script type="text/javascript">

var commonUrl = getSessionUrl();
var userCode = getSessionUserCode();
var goalCode = getSessionGoalCode();

$(document).ready(function() {
	getMyAllTimePoints('AllTimePoint', userCode, goalCode, commonUrl);
	getMyCurrentMonthPoints('CurrentMonthPoint',  userCode, goalCode, commonUrl);
	getMyChallengesList('ChallengeList', userCode, goalCode, commonUrl); 
});

//This function will animate the termometer. First one is total value of termometer, second one is ending value  
/*termometer(1000,500,function(){
	$(".donation-meter").removeClass("hide");
});*/


</script>
</head>
<body>
	
<div class="container">

	<div  class="row">

			<div class="col-sm-4 well">
				<ul id="myTab" class="nav nav-tabs">
					<li class="active"><a href="#pointsmonth" data-toggle="tab">This Month </a></li>
					<li><a href="#pointswhole" data-toggle="tab">All Time</a></li>
				</ul>
				
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="pointsmonth">
								<b>&nbsp;&nbsp;Points &nbsp;&nbsp;<label id="CurrentMonthPoint"></label></b>
							
					</div>

					<div class="tab-pane fade" id="pointswhole">
								<b>&nbsp;&nbsp;Points&nbsp;&nbsp;<label id="AllTimePoint"></label></b>
								
					</div>
				</div>
				</div>
			<!-- <div class="col-sm-4">
	<div class="termometer">
	<div class="donation-meter hide">
	  <strong class="goal"></strong>
	  <span class="glass">
	  		<div class="currentPosition arrow total"></div>
	      <span class="amount"></span>
	  </span>
	  <div class="bulb">
	      <span class="red-circle"></span>
	      <span class="filler">
	          <span></span>
	      </span>
	  </div>
	</div>
</div> 
	</div>
			</div>-->
			<div class="col-sm-4">
<div class='leaderboardthisMonth'>
    <h1><span>Leader Board</span></h1>
    
    <ul id="myTab" class="nav nav-tabs">
    
		<li class="active"><a href="#thismonthleader" data-toggle="tab">This Month </a></li>
		<li><a href="#alltimeleader" data-toggle="tab">All Time</a></li>
		
	</ul>
	<br>
	<div id="myTabContentleader" class="tab-content">
	
    <div   id="thismonthleader" class="contentthistime tab-pane fade in active"></div>
    <div  id="alltimeleader"  class="contentalltime tab-pane fade"></div>
    
    </div>
</div>
 </div>

		</div>
		<div class="row" id="ChallengeList"></div>

	
</body>
</html>