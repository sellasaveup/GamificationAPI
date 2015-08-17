<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<script src="./js/jquery.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="./js/jquery.canvasjs.min.js"></script>

<script type="text/javascript">

window.onload = function() {

	var columnChart = new CanvasJS.Chart("columnChart", {
		animationEnabled : true,
		title : {
			text : "Challenges Trend"
		},
		data : [ {
			type : "splineArea", //change type to bar, line, area, pie, etc
			dataPoints : [ {
				label : "JAN",
				y : 18
			}, {
				label : "FEB",
				y : 29
			}, {
				label : "MAR",
				y : 40
			}, {
				label : "APR",
				y : 34
			}, {
				label : "MAY",
				y : 24
			} ]
		} ]
	});
	
	columnChart.render();
}

</script>
</head>
<body>

	<div class="row">
	
	
	      
		<div class="col-sm-7">
  
			<div class="panel panel-success panel-heading">
				<div class="panel-heading"><h4><b>Leader Board</b></h4></div>
				<div class="panel-body" style="max-height: 450px;overflow-y: auto;">
					<div class="row">
						<div class="col-sm-15">
							<div id="points">
								<div class="well well-lg">
								
									<div class="row">
										<div class="col-sm-5">
											<center>
												<img src="./img/profile/profilepic.jpg" class="img-rounded" width="100" height="80">
											</center>
										</div>
										<div class="col-sm-5"><b>Federico</b></div>
										<div class="col-sm-3 well well-sm" style="background-color: #6FDE00;">
											<center>
												<h4>1000 points</h4>
											</center>
										</div>
									</div>
									
									<br>
									<div class="row">
										<div class="col-sm-5">
											<center>
												<img src="./img/profile/profilepic.jpg" class="img-rounded" width="100" height="80">
											</center>
										</div>
										<div class="col-sm-5"><b>Alessandro</b></div>
										<div class="col-sm-3 well well-sm" style="background-color: #6FDE00;">
											<center>
												<h4>890 points</h4>
											</center>
										</div>
									</div>
									
									<br>
									<div class="row">
										<div class="col-sm-5">
											<center>
												<img src="./img/profile/profilepic.jpg" class="img-rounded" width="100" height="80">
											</center>
										</div>
										<div class="col-sm-5"><b>Fabiana</b></div>
										<div class="col-sm-3 well well-sm" style="background-color: #6FDE00;">
											<center>
												<h4>650 points</h4>
											</center>
										</div>
									</div>
									
									<br>
									<div class="row">
										<div class="col-sm-5">
											<center>
												<img src="./img/profile/profilepic.jpg" class="img-rounded" width="100" height="80">
											</center>
										</div>
										<div class="col-sm-5"><b>Franco</b></div>
										<div class="col-sm-3 well well-sm" style="background-color: #6FDE00;">
											<center>
												<h4>157 points</h4>
											</center>
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-5">
											<center>
												<img src="./img/profile/profilepic.jpg" class="img-rounded" width="100" height="80">
											</center>
										</div>
										<div class="col-sm-5"><b>Sebastiana</b></div>
										<div class="col-sm-3 well well-sm" style="background-color: #6FDE00;">
											<center>
												<h4>100 points</h4>
											</center>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="col-sm-5" class="row well">
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
			<br>
			<br>
			<br>
			
	<table height="30%" width ="30%">
<tr>
<td>
<div id="columnChart"></div>
</td>
</tr>
</table>
	
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
        <td>Unlock a Gaol</td>
        <td>2</td>
        <td>12/09/2015</td>
      </tr>
     
    </tbody>
  </table>
</div>


</body>
</html>