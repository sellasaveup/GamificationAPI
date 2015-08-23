<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/leaderboard.css">
<link rel="stylesheet" href="./css/style.css"></link>

	<script type="text/javascript" src="./js/termometer.js"></script>
<script src="./js/jquery.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="./js/jquery.canvasjs.min.js"></script>
<script type="text/javascript" src="./js/leaderboard.js"></script>
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
		<link href="./css/masterpage.css" rel="stylesheet">


<style type="text/css">

</style>

<script type="text/javascript">

</script>
<script type="text/javascript">

//This function will animate the termometer. First one is total value of termometer, second one is ending value  
termometer(1000,500,function(){
	$(".donation-meter").show();
});
</script>
</head>
<body>
	
<div class="container">

	<div  class="row">
	<div class="col-sm-5">
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
	<div class="col-sm-7">
	<div class="pull-right" style="margin-right:300px;">
				<ul id="myTab" class="nav nav-tabs">
					<li class="active"><a href="#pointsmonth" data-toggle="tab">This Month </a></li>
					<li><a href="#pointswhole" data-toggle="tab">All Time</a></li>
				</ul>
				
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="pointsmonth">
								<b>&nbsp;&nbsp;Points &nbsp;&nbsp;<label id="CurrentMonthPoint">100</label></b>
							
					</div>

					<div class="tab-pane fade" id="pointswhole">
								<b>&nbsp;&nbsp;Points&nbsp;&nbsp;<label id="AllTimePoint">1000</label></b>
								
					</div>
				</div>
				</div>
				<br>
				<br>
				<div>
			<div class='leaderboard'>
    <h1><span>Leader Board</span></h1>
    <div class="content"></div>
</div>
				
				
	      </div>
	   
		
				<div>

			
			
	</div>
	
	      
		</div>
		
	
	<div class="row">
	
	<table class="table">
    <thead>
      <tr>
        <th>Challenges</th>
        <th>Points</th>
        <th>Date</th>
      </tr>
    </thead>
    <tbody>
      <tr class="success">
        <td>Download Hype App</td>
        <td>10</td>
        <td>12/09/2015</td>
      </tr>
      <tr class="danger">
         <td>Create a Goal</td>
        <td>10</td>
        <td>10/09/2015</td>
      </tr>
      <tr class="info">
         <td>Create first Milestone for a Goal</td>
        <td>5</td>
        <td>15/09/2015</td>
      </tr>
      <tr class="success">
        <td>Unlock a Goal</td>
        <td>2</td>
        <td>12/09/2015</td>
      </tr>
     
    </tbody>
  </table>
</div>
</div>
</div>

</body>
</html>