<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Badge Listing</title>
<link href="./css/imageflip.css" rel="stylesheet">
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/masterpage.css" rel="stylesheet">
<link rel="stylesheet" href="./css/thermometer.css"></link>
<script type="text/javascript" src="./js/termometer.js"></script>
<link rel="stylesheet" href="./css/common.css">
<script src="./js/jquery.min.js"></script>
<script src="./js/session.js"></script>
<script src="./js/rewardswidget.js" type="text/javascript"></script>
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
	
	 
	getMyRewards('MyRewards', userCode, goalCode, commonUrl);
	getAllMyLockedRewards('MyLockedRewards', userCode, goalCode, commonUrl); 
});
</script>
<style type="text/css">
br {
	padding-top: 88px;
}

body {
	margin-bottom: 80px;
}
</style>

</head>
<body bgcolor="#FFDD6E">
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<h3 class="well barwell">You have earned below Rewards, you can redeem them..</h3>
				<hr>
			</div>
		</div>
		<div class="row">
		
		<div class="col-sm-12">
			<div id='MyRewards'></div>
		</div>
		</div>		
		<br> <br> <br>
	</div>
</body>
</html>