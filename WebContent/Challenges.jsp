<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<head>
<title>GAMIFICATION FRAMEWORK</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<script src="./js/jquery.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min.js" type="text/javascript"></script>
<script src="./js/challengeswidget.js" type="text/javascript"></script>
<script src="./js/session.js"></script>
<title>challenges</title>
<script type="text/javascript">
	var commonUrl = getSessionUrl();
	var userCode = getSessionUserCode();
	var goalCode = getSessionGoalCode();

	$(document).ready(function() {
		getChallengesByGoal('ChallengesByGoal', goalCode, commonUrl);
		getLevelByGoal('LevelByGoal', goalCode, commonUrl);
	});
</script>
<style>
.panel-body:hover {
  background-color: #ffffff !important;
}
body {
	margin-bottom: 80px;
}
</style>


</head>
<body>
	<div class="row" style="width: 100%">
		<div class="col-sm-12">
			<div class=" panel-success panel-heading">
				<div class="panel-heading">
					<h4 class="element">
						<b>Challenges on your way..</b>
					</h4>
				</div>
				<div class="panel-body" style="max-height: 450px; overflow-y: auto;">
					<div class="row">
						<div class="col-sm-12">
							<div id="ChallengesByGoal"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<br>
	<br>
	<div class="row" style="width: 100%">
		<div class="col-sm-12">
			<div class=" panel-danger panel-heading">
				<div class="panel-heading">
					<h4 class="element">
						<b>Complete Levels..</b>
					</h4>
				</div>
				<div class="panel-body" style="max-height: 450px; overflow-y: auto;">
					<div class="row">
						<div class="col-sm-12">
							<div id="LevelByGoal"></div>
						</div>
					</div>
				</div>
			</div>
		</div>


	</div>

</body>
</html>