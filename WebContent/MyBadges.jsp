<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Badge Listing</title>
<link href="./css/imageflip.css" rel="stylesheet">
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/masterpage.css" rel="stylesheet">
<link rel="stylesheet" href="./css/thermometer.css"></link>
<link rel="stylesheet" href="./css/common.css">
<script type="text/javascript" src="./js/termometer.js"></script>
<script src="./js/jquery.min.js"></script>
<script src="./js/session.js"></script>
<script src="./js/badgeswidget.js" type="text/javascript"></script>
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
		
		 
		getMyBadges('MyBadges', userCode, goalCode, commonUrl);
		getAllMyLockedBadges('MyLockedBadges', userCode, goalCode, commonUrl);
		getAllMyBadges('AllMyBadges', userCode, goalCode, commonUrl);
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
				<center>
					<img src="./img/banners/BadgeFactory.gif" />
				</center>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<h3 class="well barwell">&nbsp;Badges you bagged..</h3>
			</div>
		</div>
		<div class="row">
			<div id="MyBadges"></div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<h4 class="well barwell">&nbsp;Yet to unlock..</h4>
				<hr>
			</div>
		</div>
		<div class="row">
			<div id="MyLockedBadges"></div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<h4 class="well barwell">My Earned Badges List...</h4>
				<div id="AllMyBadges" style="padding-left: 30px;"></div>
			</div>
		</div>
	</div>
</body>
</html>