<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<head>
<title>GAMIFICATION FRAMEWORK</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<script src="./js/jquery.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min.js" type="text/javascript"></script>
<link href="./css/masterpage.css" rel="stylesheet">
  <link href="./css/profilepage.css" rel="stylesheet">

<style>

</style>
</head>
<body>
	<% 
String customerId = (String) request.getParameter("customerId");
%>
	<div class="container">
		<header>
			<h3>
				<p>
				<Center>My profile</Center>
				</p>
			</h3>
		</header>

		<div class="wrapper">

			<div class="myBody">
				<div class="row">
					
					  <div class="col-md-2 pull-left well profilepadding">
					
						<input type="hidden" id="custId" value="<%=customerId%>">
							<center><div id="profile"></div>
							<div id="notifications"><a href="#">Notifications<span class="badge">10</span></a></div></center>
					</div>
					<div class="col-md-4 pull-right">
						<div class="row well">

							<ul id="myTab" class="nav nav-tabs">
								<li class="active"><a href="#pointsmonth" data-toggle="tab">
										This Month </a></li>
								<li><a href="#pointswhole" data-toggle="tab">All Time</a></li>
							</ul>
							<div id="myTabContent" class="tab-content">
								<div class="tab-pane fade in active" id="pointsmonth">
									<div class="row">
										<div class="col-sm-6">
											<h2>Points</h2>
										</div>
										<div class="col-sm-6">
											<h1>
												<label id="CurrentMonthPoint"></label>
											</h1>
										</div>
									</div>
								</div>

								<div class="tab-pane fade" id="pointswhole">
									<div class="row">
										<div class="col-sm-6">
											<h2>Points</h2>
										</div>

										<div class="col-sm-6">
											<h1>
												<label id="AllTimePoint"></label>
											</h1>
										</div>
									</div>
								</div>
							</div>
						</div>
					
						<div class="row well">
							<ul id="myTab" class="nav nav-tabs">
								<li class="active"><a href="#rankmonth" data-toggle="tab">
										This Month </a></li>
								<li><a href="#rankwhole" data-toggle="tab">All Time</a></li>
							</ul>
							<div id="myTabContent" class="tab-content">
								<div class="tab-pane fade in active" id="rankmonth">
									<div class="row">
										<div class="col-sm-6">
											<h2>Rank</h2>
										</div>

										<div class="col-sm-6">
											<h1>
												<label id="CurrentMonthRank"></label>
											</h1>
										</div>
									</div>
								</div>

								<div class="tab-pane fade" id="rankwhole">
									<div class="row">
										<div class="col-sm-6">
											<h2>Rank</h2>
										</div>

										<div class="col-sm-6">
											<h1>
												<label id="AllTimeRank"></label>
											</h1>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="col-md-6">
						<div class="panel panel-primary panel-blue">
							<div class="panel-heading">Badges</div>
							<div class="panel-body badges_scroller">
								<div id="badges">
								</div>
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-sm-12">
					<div class="panel panel-blue panel-primary">
							<div class="panel-heading">LeaderBoard</div>
							<div class="panel-body challenges_scroller">
					<button id="LeaderboardButton" type="button" class="btn btn-success" > See LeaderBoard</button>
				<div id="tableDiv">
					<div class="row">
							<ul id="myLBTab" class="nav nav-tabs">
								<li class="active"><a href="#lbmonth" data-toggle="tab">This Month </a></li>
								<li><a href="#lbwhole" data-toggle="tab">All Time</a></li>
							</ul>
							<div id="myTabContent" class="tab-content">
								<div class="tab-pane fade in active" id="lbmonth">
									<div class="row">
										<div class="col-sm-12 well">
												<div id="CurrentMonthLeaderboard" ><table class="table"><thead><tr><th>Name</th><th>Score</th></tr></thead><tbody></tbody></table></div>
										</div>
									</div>
								</div>

								<div class="tab-pane fade" id="lbwhole">
									<div class="row">
										<div class="col-sm-12 well">
												<div id="AllTimeLeaderboard"><table class="table"><thead><tr><th>Name</th><th>Score</th></tr></thead><tbody></tbody></table></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>	
					
					</div></div>
					
					</div>
				</div>
					<br>
				<div class="row">
					<div class="col-sm-12">
						<div class="panel panel-blue panel-primary">
							<div class="panel-heading">Challenges</div>
							<div class="panel-body challenges_scroller">
								<div class="row">
									<div class="col-sm-12">
										<div id="challenges">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-12">
						<div class="panel panel-blue panel-primary">
							<div class="panel-heading">Rewards</div>
							<div class="panel-body">
							<div class="row">
									<div class="col-sm-12">
										<div id="rewards">
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<footer>
				<p>
				<Center>Banca sella, 2015.</Center>
				</p>
			</footer>
		</div>
	</div>


	<script type="text/javascript">
		$(document).ready(function() {

			getProfile('profile', $('#custId').val());
			getLeaderboard('CurrentMonthLeaderboard', $('#custId').val(), 'M');
			getLeaderboard('AllTimeLeaderboard', $('#custId').val(), 'A');
			getPoints('CurrentMonthPoint', $('#custId').val(), 'M');
			getPoints('AllTimePoint', $('#custId').val(), 'A');
			getRank('CurrentMonthRank', $('#custId').val(), 'M');
			getRank('AllTimeRank', $('#custId').val(), 'A');
			getBadges('badges', $('#custId').val());
			getChallenges('challenges', $('#custId').val());
			getRewards('rewards', $('#custId').val());
			$("#tableDiv").hide();

		});
	</script>
	
	<script src="./js/profilewidget.js" type="text/javascript"></script>
	<script src="./js/leaderboardwidget.js" type="text/javascript"></script>
	<script src="./js/pointswidget.js" type="text/javascript"></script>
	<script src="./js/rankwidget.js" type="text/javascript"></script>
	<script src="./js/badgeswidget.js" type="text/javascript"></script>
	<script src="./js/challengeswidget.js" type="text/javascript"></script>
	<script src="./js/rewardswidget.js" type="text/javascript"></script>
	<script src="./js/application.js" type="text/javascript"></script>
</body>
</html>
