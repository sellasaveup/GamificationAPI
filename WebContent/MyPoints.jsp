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
<link rel="stylesheet" href="./css/common.css">
<script type="text/javascript" src="./js/termometer.js"></script>
<script src="./js/jquery.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="./js/jquery.canvasjs.min.js"></script>
<script type="text/javascript" src="./js/leaderboard.js"></script>
<script type="text/javascript" src="./js/leaderboardalltime.js"></script>
<script src="./js/session.js"></script>
<script src="./js/pointswidget.js" type="text/javascript"></script>
<script src="./js/rankwidget.js" type="text/javascript"></script>
<script src="./js/pointlinechart.js" type="text/javascript"></script>
<link href="./css/masterpage.css" rel="stylesheet">
<script src="./js/Chart.js" type="text/javascript"></script>
<script src="./js/notify.js"></script>
<style type="text/css">
	.notifyjs-corner {
    	top: 60px !important;
		}
</style>
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
	getAllTimeLeaderBoard(goalCode, commonUrl);
	getThisMonthLeaderBoard(goalCode, commonUrl);
	drawlinechart('canvas', userCode, goalCode);
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
     <h4 class="well barwell">My points journey...</h4>

     <div class="container-canvas">
                <canvas id="canvas" width="600" height="300" onclick="drawlinechart('canvas');">
                    This is my fallback content.
                </canvas>
            </div>
    </div>
     </div>
   </article>
 

   	<article class="col-sm-12 col-md-6" style="padding-left:30px;height:500px">
     <!--ROW RIGHT-->
     <div class="row">
      <div class="col-sm-6"><div class='pull-left'>
   		 <h4 class="well barwell">&nbsp;&nbsp;Leaderboard</h4>
    
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

	</section>
<div class="row">
 <div class="col-sm-12">
     <h4 class="well barwell">My Achievements...</h4>
     <div id="ChallengeList" style="padding-left:30px;"></div>
</div>
 </div>
	</div>
</body>
</html>