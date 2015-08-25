<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<head>
<title>My Goals</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="./css/bootstrap.min.css">
<script src="./js/jquery.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min.js" type="text/javascript"></script>
<title>challenges</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#hypeStory").hide();
		$('[data-toggle="tooltip"]').tooltip({
			position : {
				my : "center bottom-50",
				at : "center top",
				using : function(position, feedback) {
					$(this).css(position);
					$("<div>").addClass("tool").appendTo(this);
				}
			}

		});
	});

	function funcOnChange() {
		$("#hype").click(function() {
			$("#hypeStory").show();
		});
		$("#TownHallMeet").click(function() {
			$("#hypeStory").hide();
		});
		$("#pdu").click(function() {
			$("#hypeStory").hide();
		});
	}
</script>

</head>
<style>
.tool {
	width: 70px;
	height: 16px;
	overflow: hidden;
	position: absolute;
	left: 50%;
	margin-left: -35px;
	background-color: #c6e5f6;
	background: #CABA75;
	color: black;
	font-size: 11px;
}

</style>
<body>
	<div class="container">
		<div class="row well">
			<div class="col-sm-12">
				<center>
					<h2>Select a Mission</h2>
				</center>
			</div>
		</div>
		<div class="row well">
			<div class="col-sm-4">
				<label class="radio-inline"><input type="radio"
					id="hype" name="goalType" onchange="funcOnChange()">Hype</label>
			</div>
			<div class="col-sm-4">
				<label class="radio-inline"><input type="radio"
					id="TownHallMeet" name="goalType" onchange="funcOnChange()">Town Hall Event</label>
			</div>
			<div class="col-sm-4">
				<label class="radio-inline"><input type="radio"
					id="pdu" name="goalType" onchange="funcOnChange()">PDU</label>
			</div>
		</div>
		<br>
		<hr>
		<br>
		<div id="hypeStory">

			<div class="row">
				<div class="col-sm-12">
					<div class="row">
						<h1>
							<center>HOW IT WORKS</center>
						</h1>
					</div>
					<div class="row">
						<div class="col-sm-3">
							<a href="#" data-toggle="tooltip"
								data-original-title="Connect to Sella SaveUp Network"> <img
								src="./img/profile/user.jpg">
							</a>
						</div>
						<div class="col-sm-3">
							<a href="#" data-toggle="tooltip"
								data-original-title="Create Hype Goals, Share Goal with your Buddy, Accomplish
									your Goal">
								<img src="./img/profile/system.jpg">
							</a>
						</div>
						<div class="col-sm-3">
							<a href="#" data-toggle="tooltip"
								data-original-title="Every activities you perform, you earn reward points and unlock badges">
								<img src="./img/profile/saving.jpg">
							</a>
						</div>
						<div class="col-sm-3">
							<a href="#" data-toggle="tooltip"
								data-original-title="Use Points to earn Gifts from our Redemption Catalogue">
								<img src="./img/profile/support.jpg">
							</a>
						</div>
					</div>
				</div>
				<div class="row well">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-3">
								<p>Register on Sella Save Up</p>
								<p>Sign Up on Hype</p>
							</div>
							<div class="col-sm-3">
								<p>Perform Activities on Hype</p>
							</div>
							<div class="col-sm-3">
								<p>Earn Points and Unlock Badges</p>
							</div>
							<div class="col-sm-3">
								<p>Redeem Points for Free Gifts</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>