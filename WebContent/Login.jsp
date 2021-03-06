<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/common.css">
<script src="./js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="./js/jquery.popupoverlay.js"></script>
<link href="./css/loginprofile.css" rel="stylesheet">
<script src="./js/goalwidget.js" type="text/javascript"></script>


<style>
.lineheight {
	line-height: 3em;
}

.initialism {
	font-weight: bold;
	letter-spacing: 1px;
	font-size: 12px;
}
body {
	margin-bottom: 80px;
	background: #336699;
	
}


.headstyle {
	background: #F2F2F2;
	font: normal small-caps normal 75px/1.4 Georgia;
	color: #086A87;
}

.signstyle {
	font: normal small-caps normal 25px/1.4 Georgia;
	color: white;
}

.registerstyle {
	font: normal 25px/1.4 Georgia;
	color: white;
	align: left;
}

.userstyle {
	font: normal small-caps normal 25px/1.4 Arial;
	color: black;
}

.submitstyle {
	font-family: "Times New Roman", Georgia, Serif;
	font: 22px/1.4 Arial;
	color: white;
}

p::before {
	content: "Gamification";
	color: black;
}

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

.transUpdate {
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	border-radius: 10px;
	background: #fff;
	/* fallback for browsers that don't understand rgba */
	border: #solid 10px #000;
	/* fallback for browsers that don't understand rgba */
	background-color: rgba(255, 255, 255, 0.8)
		/* slighly transparent white */
  border-color: rgba(0, 0, 0, 0.2) /*Very transparent black*/
}

.divspace {
	margin-right: 30px;
}

.roundedbox {
	border-radius: 25px;
	border: 2px solid yellow;
	width: 380px;
	height: 80px;
}
</style>
<script type="text/javascript">
	var commonUrl = "http://localhost:8080/GamificationAPI/sella/api/";
	localStorage.setItem("sessionUrl", commonUrl);

	$(document).ready(
			function() {
				$("#goalsform").hide();
				updateLatestActivity();
				updateLatestBadgeActivity();
				updateLatestRedeemActivity();
				updateLatestRewardActivity();
				updateLatestLevelActivity();
				updateLatestUserActivity();

				$('#registerform').popup({
					pagecontainer : '.container',
					transition : 'all 0.3s'
				});
				
				var performedActivitiesUrl = commonUrl
						+ "GET_PERFORMED_ACTIVITIES_COUNT";
				var unlockedBadgeUrl = commonUrl + "GET_UNLOCKED_BADGE_COUNT";
				var engagedUserCountUrl = commonUrl + "GET_ENGAGED_USER_COUNT";

				getPerformedActivitiesCount(performedActivitiesUrl);
				getUnlockedBadgeCount(unlockedBadgeUrl);
				getEngagedUserCount(engagedUserCountUrl);

				setInterval(function() {
					updateLatestActivity()
				}, getRandomRange(9000, 10000));
				setInterval(function() {
					updateLatestBadgeActivity()
				}, getRandomRange(9000, 10000));
				setInterval(function() {
					updateLatestRedeemActivity()
				}, getRandomRange(9000, 10000));
				setInterval(function() {
					updateLatestRewardActivity()
				}, getRandomRange(9000, 10000));
				setInterval(function() {
					updateLatestLevelActivity()
				}, getRandomRange(9000, 10000));
				setInterval(function() {
					updateLatestUserActivity()
				}, getRandomRange(9000, 10000));

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

	function getPerformedActivitiesCount(requestUrl) {

		$.ajax({
			type : "GET",
			url : requestUrl,
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				getDelayedIncrement(data.performedActivitiesCount,
						"performedActivitiesCount", 100);
			},
			error : function(e) {
				console.log('getPerformedActivitiesCount failure : ' + e);
			}
		});
	}

	function getUnlockedBadgeCount(requestUrl) {

		$.ajax({
			type : "GET",
			url : requestUrl,
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				getDelayedIncrement(data.unlockedBadgeCount,
						"unlockedBadgeCount", 100);
			},
			error : function(e) {
				console.log('getUnlockedBadgeCount failure : ' + e);
			}
		});
	}

	function getEngagedUserCount(requestUrl) {

		$.ajax({
			type : "GET",
			url : requestUrl,
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				getDelayedIncrement(data.engagedUserCount, "engagedUserCount",
						100);
			},
			error : function(e) {
				console.log('getEngagedUserCount failure : ' + e);
			}
		});
	}

	function getDelayedIncrement(maxValue, applyingPeoperty, delayTime) {
		for (i = 1; i <= maxValue; i++) {
			(function(i) {
				setTimeout(function() {
					document.getElementById(applyingPeoperty).innerHTML = i;
				}, delayTime * i);
			}(i));
		}
	}

	function updateLatestActivity() {
		var latestActivityUrl = commonUrl + "GET_LATEST_ACTION";
		$.ajax({
			type : "GET",
			url : latestActivityUrl,
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				var finaDate = data.latestAction.split("#");
				var text = finaDate[0];
				var image = getProfileImagePath() + finaDate[1];
				var randomPosition = getRandomRange(1, 3);
				if(text && image) {
					$('#textPanel' + randomPosition).html("<b>"+text+"</b>");
					$('#imagePanel' + randomPosition).attr('src', image);
				} else {
					$('#textPanel' + randomPosition).html("<b>Onboard into Our System and get fun</b>");
					$('#textPanel' + randomPosition).css({"color":"#fff","font-size": "20px", "font-family": "'Source Sans Pro'"});
					$('#imagePanel' + randomPosition).attr('src', './img/profile/logo.jpg');
			}
			},
			error : function(e) {
				console.log('updateLatestActivity failure : ' + e);
			}
		});
	}

	function updateLatestBadgeActivity() {
		var latestBadgeActivityUrl = commonUrl + "GET_LATEST_BADGE";
		$.ajax({
			type : "GET",
			url : latestBadgeActivityUrl,
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				var finaData = data.latestBadgeAction.split("#");
				
				var text = finaData[0];
				var image = getProfileImagePath() + finaData[1];
				var randomPosition = getRandomRange(1, 3);
				if(text && image) {
					$('#textPanel' + randomPosition).html("<b>"+text+"</b>");
					$('#imagePanel' + randomPosition).attr('src', image);
				} else {
					$('#textPanel' + randomPosition).html("<b>Get Rewards for your activities</b>");
					$('#textPanel' + randomPosition).css({"color":"#fff","font-size": "20px", "font-family": "'Source Sans Pro'"});
					$('#imagePanel' + randomPosition).attr('src', './img/profile/logo.jpg');
				}
			},
			error : function(e) {
				console.log('latestBadgeAction failure : ' + e);
			}
		});
	}

	function updateLatestRedeemActivity() {
		var latestRedeemActivityUrl = commonUrl + "GET_LATEST_REDEEM";
		$.ajax({
			type : "GET",
			url : latestRedeemActivityUrl,
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				var finaData = data.latestRedeemAction.split("#");
				var text = finaData[0];
				var image = getProfileImagePath() + finaData[1];
				var randomPosition = getRandomRange(1, 3);
				if(text && image) {
					$('#textPanel' + randomPosition).html("<b>"+text+"</b>");
					$('#imagePanel' + randomPosition).attr('src', image);
				} else {
					$('#textPanel' + randomPosition).html("<b>Share in Social Media</b>");
					$('#textPanel' + randomPosition).css({"color":"#fff","font-size": "20px", "font-family": "'Source Sans Pro'"});
					$('#imagePanel' + randomPosition).attr('src', './img/profile/logo.jpg');
				}
			},
			error : function(e) {
				console.log('updateLatestRedeemActivity failure : ' + e);
			}
		});
	}

	function updateLatestRewardActivity() {
		var latestRewardActivityUrl = commonUrl + "GET_LATEST_REWARD";
		$.ajax({
			type : "GET",
			url : latestRewardActivityUrl,
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				var finaData = data.latestRewardAction.split("#");
				var text = finaData[0];
				var image = getProfileImagePath() + finaData[1];
				var randomPosition = getRandomRange(4, 7);
				if(text && image) {
					$('#textPanel' + randomPosition).html("<b>"+text+"</b>");
					$('#imagePanel' + randomPosition).attr('src', image);
				} else {
					$('#textPanel' + randomPosition).html("<b>Gamify your system with our framework</b>");
					$('#textPanel' + randomPosition).css({"color":"#fff","font-size": "20px", "font-family": "'Source Sans Pro'"});
					$('#imagePanel' + randomPosition).attr('src', './img/profile/logo.jpg');
				}
			},
			error : function(e) {
				console.log('latestRewardAction failure : ' + e);
			}
		});
	}

	function updateLatestLevelActivity() {
		var latestLevelActivityUrl = commonUrl + "GET_LATEST_LEVEL";
		$.ajax({
			type : "GET",
			url : latestLevelActivityUrl,
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				var finaData = data.latestlevelAction.split("#");
				var text = finaData[0];
				var image = getProfileImagePath() + finaData[1];
				var randomPosition = getRandomRange(1, 3);
				if(text && image) {
					$('#textPanel' + randomPosition).html("<b>"+text+"</b>");
					$('#imagePanel' + randomPosition).attr('src', image);
				} else {
					$('#textPanel' + randomPosition).html("<b>Get feedback for your progress</b>");
					$('#textPanel' + randomPosition).css({"color":"#fff","font-size": "20px", "font-family": "'Source Sans Pro'"});
					$('#imagePanel' + randomPosition).attr('src', './img/profile/logo.jpg');
				}
			},
			error : function(e) {
				console.log('latestRewardAction failure : ' + e);
			}
		});
	}

	function updateLatestUserActivity() {
		var latestUserActivityUrl = commonUrl + "GET_LATEST_USER";
		$.ajax({
			type : "GET",
			url : latestUserActivityUrl,
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				var finaData = data.latestUserAction.split("#");
				var text = finaData[0];
				var image = getProfileImagePath() + finaData[1];
				var randomPosition = getRandomRange(1, 3);
				if(text && image) {
					$('#textPanel' + randomPosition).html("<b>"+text+"</b>");
					$('#imagePanel' + randomPosition).attr('src', image);
				} else {
					$('#textPanel' + randomPosition).html("<b>Unlock super badges and share your status</b>");
					$('#textPanel' + randomPosition).css({"color":"#fff","font-size": "20px", "font-family": "'Source Sans Pro'"});
					$('#imagePanel' + randomPosition).attr('src', './img/profile/logo.jpg');
				}
			},
			error : function(e) {
				console.log('latestRewardAction failure : ' + e);
			}
		});
	}

	function getRandomRange(min, max) {
		return Math.floor(Math.random() * (max - min + 1)) + min;
	}

	function getProfileImagePath() {
		return "./img/profile/";
	}

	

			$("#BackSubmit").click(function() {
				window.location.replace("Login.jsp");
			});
			
	function setSessionValue() {
		localStorage.setItem("sessionUserCode", $("#loginUserCode").val());
      
       var enteredUserName = $("#loginUserCode").val();
       if(enteredUserName) {
    	   var userCode = enteredUserName;
    	   $("#goalTemplate").html("");	
			getAllGoalList('goalTemplate', userCode, commonUrl);
			
			$('#goalsform').popup({
				pagecontainer : '.container',
				transition : 'all 0.3s'
			});
			
			$("#ButtonSubmit").click(function() {
				
				if($('input:radio:checked').length > 0){
					var selectedGoalCode = $('.list input[type="radio"]:checked:first').val();
					localStorage.setItem("sessionGoalCode", selectedGoalCode);
					localStorage.setItem("sessionUserCode", $("#loginUserCode").val());
					window.location.replace("MasterTemplate.jsp");
				}else{
				    alert("Please Select a Goal");
				}
			});
    	   
       } else {
    	   
    	   alert('Please enter your user name');

    	   
       }

	}
</script>
</head>
<body>

	<div class="wrapper">

		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div class="navbar navbar-inverse navbar-fixed-top"
						role="navigation">
						<p class="headstyle">&nbsp;Framework</p>
					</div>
				</div>
			</div>
			<form id="myForm" method="post">
				<div class="row">
					<div class="col-sm-6 pull-left">
						<div class="form-group">
							<div class="row">
								<div class="col-sm-12 border">
									<center>
										<h3 class="signstyle">On-Board</h3>
									</center>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-sm-12">
									<input type="text" placeholder="User Code" id="loginUserCode">
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-sm-12">
									<button class="initialism goalsform_open"  type="submit" id = "loginSubmit" onclick="setSessionValue()">
										<span>Submit</span>
									</button>
								</div>
							</div>
							<br> <br>
						</div>
						<div>
							<section class="col-md-10 col-md-offset-1">


								<span class="lineheight"> <!-- <a
									class="initialism registerform_open" href="#registerform"
									style="color: white; font-size: 18px;"><b>Register in
											GF</b></a> -->

								</span>


							</section>
						</div>
					</div>
					&nbsp;&nbsp;
					<div class="col-sm-6 pull-right">

						<table  style="width:400px">
							<tr>
								<td><font size="6"><b><span
											id="performedActivitiesCount"></span></b></font></td>
								<td><font size="6"><b><span
											id="unlockedBadgeCount"></span></b></font></td>
								<td><font size="6"><b><span
											id="engagedUserCount"></span></b></font></td>
							</tr>
							<tr>
								<td class="loginupdateheading"><font size="3"><b>Activities Performed</b></font></td>
								<td class="loginupdateheading"><font size="3"><b>Badges Unlocked</b></font></td>
								<td class="loginupdateheading"><font size="3"><b>Users Engaged</b></font></td>
							</tr>



							<tr class="roundedbox">
								<td>
									<div>
										<img id="imagePanel1" src="./img/profile/logo.jpg"
												class="img-circle" alt="" width="80px" height="80px">
										
									</div>
								</td>
								<td><div id="textPanel1" class ="loginupdatext">Use our Framework and it will engage you</div></td>
								<td></td>
							</tr>

							<tr class="roundedbox" >
								<td>
									<div>
											<img id="imagePanel2" src="./img/profile/logo.jpg" class="img-circle" alt="" width="80px" height="80px">
									</div>
								</td>
								<td><div id="textPanel2" class ="loginupdatext">Come and try</div></td>
								<td></td>
							</tr>


							<tr class="roundedbox">
								<td>
									<div>
											<img id="imagePanel3" src="./img/profile/logo.jpg" class="img-circle" alt="" width="80px" height="80px">
									</div>
								</td>
								<td><div id="textPanel3" class ="loginupdatext">Perform activities and Earn points</div></td>
								<td></td>
							</tr>

						</table>


						<span><b></b></span>
					</div>
					<span><b></b></span>
				</div>

			</form>
			<div class="row well">
				<div class="col-sm-12">
					<div class="row">
						<h1>
							<center>HOW THIS WORKS</center>
						</h1>
					</div>
					<div class="row">
						<div class="col-sm-2">
							<a href="#" data-toggle="tooltip"
								data-original-title="Connect to Sella SaveUp Network"> <img
								src="./img/profile/user.jpg" width="90%" height="90%">
							</a>
						</div>
						<div class="col-sm-1"> <img src="./img/logo/navigate-right.png" width="100%" height="250%"></div>
						<div>
							<div class="col-sm-2">
								<a href="#" data-toggle="tooltip"
									data-original-title="Create Hype Goals, Share Goal with your Buddy, Accomplish
									your Goal">
									<img src="./img/profile/system.jpg" width="90%" height="90%"> 
								</a>
							</div>
						<div class="col-sm-1"> <img src="./img/logo/navigate-right.png" width="100%" height="250%"></div>
							<div>
								<div class="col-sm-2">
									<a href="#" data-toggle="tooltip"
										data-original-title="Every activities you perform, you earn reward points and unlock badges">
										<img src="./img/profile/saving.jpg" width="90%" height="90%">
									</a>
								</div>
						<div class="col-sm-1"> <img src="./img/logo/navigate-right.png" width="100%" height="250%"></div>
								<div>
									<div class="col-sm-2">
										<a href="#" data-toggle="tooltip"
											data-original-title="Use Points to earn Gifts from our Redemption Catalogue">
											<img src="./img/profile/support.jpg" width="90%" height="90%">
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-3">On Board</div>
							<div class="col-sm-3">Perform activities on our digital
								channel goal (eg: IB, Mobile, Hype)</div>
							<div class="col-sm-3">Earn Points and Unlock Badges</div>
							<div class="col-sm-3">Redeem Points for Free Gifts</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>



	<div id="registerform" class="well" style="display:none">
		<!-- <h4 style="color: black">Register in GF</h4> -->

		<table>
			<tr>
				<td style="color: black">Enter GBSCode&nbsp;</td>
				<td><input type="text" name="userCode" id="userCode"><br>
					<br></td>

			</tr>

			<tr>
				<td style="color: black">Who am I ?</td>
				<td>

					<div class="form-group">
						<div>
							<select id="userType" class="form-control">
								<option value="employee">Employee</option>
								<option value="customer">Customer</option>
								<option value="trainee">Trainee</option>
								<option value="branchUser">Branch user</option>
							</select>
						</div>
					</div>


				</td>
			</tr>
			<tr>
				<td style="color: black">Nick Name</td>
				<td><input type="text" name="nickName" id="nickName"><br>
					<br></td>
			</tr>
			<tr>
				<td style="color: black">Avatar</td>
				<td><button type="submit" class="btn btn-primary start">
						<i class="glyphicon glyphicon-upload"></i> <span>Upload
							Avatar</span>
					</button> <br> <br></td>
			</tr>
			<tr>
				<td style="color: black">Status Message &nbsp;</td>
				<td><input type="text" name="statusMsg" id="statusMsg"><br>
					<br></td>
			</tr>


		</table>


		<button class="registerform_close slide_open btn btn-default">Check
			IN</button>
		<button class="registerform_close btn btn-default">Close</button>


	</div>


	<div id="goalsform" class="well">
		<h3 style="color: black">Select a Goal</h3>
		<div class="list">
			<div id="goalTemplate"></div>
			<br>
			<table>
				<tr>
					<td colspan=2><input id="ButtonSubmit" type="button"
						class="goalsform_close btn btn-default" Value="Submit">
						<input id="BackSubmit" type="button"
						class="goalsform_close btn btn-default" Value="Back"></td>
				</tr>
			</table>
		</div>
	</div>

	<style>
#registerform {
	-webkit-transform: scale(0.8);
	-moz-transform: scale(0.8);
	-ms-transform: scale(0.8);
	transform: scale(0.8);
}

.popup_visible #registerform {
	-webkit-transform: scale(1);
	-moz-transform: scale(1);
	-ms-transform: scale(1);
	transform: scale(1);
}
#goalsform {
	-webkit-transform: scale(0.8);
	-moz-transform: scale(0.8);
	-ms-transform: scale(0.8);
	transform: scale(0.8);
}

.popup_visible #goalsform {
	-webkit-transform: scale(1);
	-moz-transform: scale(1);
	-ms-transform: scale(1);
	transform: scale(1);
}
</style>
</body>
</html>
