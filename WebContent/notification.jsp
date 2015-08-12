<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Notification Admin Page</title>
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="css/starter-template.css" rel="stylesheet">
<script src="./js/bootstrap.min.js"></script>
<script src="./js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="./js/application.js" type="text/javascript"></script>
<script>
	
	$( document ).ready(function() {
		pushNotificationOnChange();
		awardPointsOnChange();
		awardBadgeOnChange();
	});
	
	function pushNotificationOnChange() {
		if ($("#checkPushNotify").is(':checked')) {
			
			$("#pushNotificationPanel").show();
			
		} else {
			
			$("#pushNotificationPanel").hide();
		}
	 }
	
	function awardPointsOnChange() {
		if ($("#checkAwardPoints").is(':checked')) {
			
			$("#awardPointsPanel").show();
			
		} else {
			
			$("#awardPointsPanel").hide();
		}
	 }
	
	function awardBadgeOnChange() {
		if ($("#checkAwardBadge").is(':checked')) {
			
			$("#awardBadgePanel").show();
			
		} else {
			
			$("#awardBadgePanel").hide();
		}
	 }

	function onSubmit() {
		if ($("#checkPushNotify").is(':checked')) {
			
			var pushNotificationUrl = 'http://localhost:8080/GamificationAPI/sella/api/PUSH_NOTIFICATION?';
			var notificationType = $( "#notificationType" ).val();
			var target = $( "#target" ).val();
			var message = $( "#message" ).val();
			var image = $( "#image" ).val();
			var notificationCustomerId = $( "#notificationCustomerId" ).val();
			var subjectType = $( "#subjectType" ).val();
			pushNotificationUrl = pushNotificationUrl+"notificationType="+notificationType;
			pushNotificationUrl = pushNotificationUrl+"&target="+target;
			pushNotificationUrl = pushNotificationUrl+"&message="+message;
			pushNotificationUrl = pushNotificationUrl+"&imageUrl="+image;
			pushNotificationUrl = pushNotificationUrl+"&custId="+notificationCustomerId;
			pushNotificationUrl = pushNotificationUrl+"&subjectType="+subjectType;
			
			$.ajax({
	            type: "GET",
	            data: "",
	            url: pushNotificationUrl,
	            dataType : "json",
	            contentType: "application/json; charset=utf-8",
	            crossDomain: true,

	            success: function (data) {
	            	alert("Push Notification Success");
	            },

	            error: function (e) {
	            	alert("Push Notification Failure");
	            }
	         });
		}  
		
		if ($("#checkAwardPoints").is(':checked')) {
			
			var awardPointsUrl = 'http://localhost:8080/GamificationAPI/sella/api/POST_ACTIONE?';
			
			var pointCustomerId = $( "#pointCustomerId" ).val();
			var pointAction = $("#pointAction").val();
			awardPointsUrl = awardPointsUrl+"custId="+pointCustomerId;
			awardPointsUrl = awardPointsUrl+"&action="+pointAction;
			
			
			$.ajax({
	            type: "GET",
	            data: "",
	            url: awardPointsUrl,
	            dataType : "json",
	            contentType: "application/json; charset=utf-8",
	            crossDomain: true,

	            success: function (data) {
	            	alert("Award Point Success");
	            },

	            error: function (e) {
	            	alert("Award Point Failure");
	            }
	         });
		}
		
		if ($("#checkAwardBadge").is(':checked')) {
			
			var awardBadgeUrl = 'http://localhost:8080/GamificationAPI/sella/api/AWARD_BADGE?';
			
			var badgeCustomerId = $( "#badgeCustomerId" ).val();
			var badgeId = $("#badgeId").val();
			var activity = $("#activity").val();
			
			awardBadgeUrl = awardBadgeUrl+"custId="+badgeCustomerId;
			awardBadgeUrl = awardBadgeUrl+"&badgeId="+badgeId;
			awardBadgeUrl = awardBadgeUrl+"&activity="+activity;
			
			$.ajax({
	            type: "GET",
	            data: "",
	            url: awardBadgeUrl,
	            dataType : "json",
	            contentType: "application/json; charset=utf-8",
	            crossDomain: true,

	            success: function (data) {
	            	alert("Award Badge Success");
	            },

	            error: function (e) {
	            	alert("Award Badge Failure");
	            }
	         });
		}
	}
	
</script>
</head>
<body>
	<form id="notificationForm" action="notification.jsp" method="post">
		<div class="container">

			<div class="row">
			<h3>
				<div class="label label-default">
					<label for="checkPush">Do you want to push notifications?</label>
				</div>
				<div class="label label-default">
					<input type="checkbox" id="checkPushNotify" onchange="pushNotificationOnChange()">
				</div>
			</h3>
			</div>
			<table width="35%">
			<tr>
			  <td>
			  	<div class="panel panel-blue panel-primary" id="pushNotificationPanel">
					<div class="panel-heading">Push Notification</div>
					<div class="panel-body">
					<div class="form-group">
					<label for="notificationType">Notification Type</label>
					<select class="form-control" name="notificationType" id="notificationType">
						<option value="">Choose Notification Type</option>
						<option value="Message">Message</option>
						<option value="Warning">Warning</option>
						<option value="Info">Info</option>
					</select>
					</div>
					
					<div class="form-group">
					<label for="target">Target</label>
					<select class="form-control" name="target" id="target">
						<option value="">Choose Target</option>
						<option value="ALL">All</option>
						<option value="SUBJECT">Subject</option>
						<option value="CUST">Customer</option>
					</select>
					</div>
					<div class="form-group">
					<label for="message">Message</label>
					<input type="text" class="form-control" id="message" placeholder="Message">
					</div>
					<div class="form-group">
					<label for="image">Image</label>
					<input type="text" class="form-control" id="image" placeholder="image">
					</div>
					<div class="form-group">
					<label for="notificationCustomerId">Customer Id</label>
					<select class="form-control" name="notificationCustomerId" id="notificationCustomerId">
						<option value="">Choose Customer</option>
						<option value="4">Boobathi</option>
						<option value="5">Ajay</option>
						<option value="6">Kumar</option>
					</select>
					</div>
					<div class="form-group">
					<label for="subjectType">Subject Type</label>
					<select class="form-control" name="subjectType" id="subjectType">
						<option value="">Choose Subject Type</option>
						<option value="EMP">Employee</option>
						<option value="Customer">Customer</option>
					</select>
					</div>
					
					</div>
			</div>
			  </td>
			</tr>
			
			</table>
			
			<h3>		
			<div class="row">
				<div class="label label-default">
					<label for="checkPush">Do you want to Award Points?</label>
				</div>
				<div class="label label-default">
					<input type="checkbox" id="checkAwardPoints" onChange="awardPointsOnChange()">
				</div>
			</div>
			</h3>
			<table width="35%">
			<tr>
			  <td>
			<div class="panel panel-blue panel-primary" id="awardPointsPanel">
					<div class="panel-heading">Award points</div>
					<div class="panel-body">
					
					<div class="form-group">
					<label for="pointCustomerId">Customer Id</label>
					<select class="form-control" name="pointCustomerId" id="pointCustomerId">
						<option value="">Choose Customer</option>
						<option value="4">Boobathi</option>
						<option value="5">Ajay</option>
						<option value="6">Kumar</option>
					</select>
					</div>
					<div class="form-group">
					<label for="pointAction">Action</label>
					<input type="text" class="form-control" id="pointAction" placeholder="Action">
					</div>
					</div>
			</div>
			</td></tr></table>
			<h3>	
			<div class="row">
				<div class="label label-default">
					<label for="checkPush">Do you want to Award Badge?</label>
				</div>
				<div class="label label-default">
					<input type="checkbox" id="checkAwardBadge" onChange="awardBadgeOnChange()">
				</div>
			</div>
			</h3>
			<table width="35%">
			<tr>
			  <td>
			<div class="panel panel-blue panel-primary" id="awardBadgePanel">
					<div class="panel-heading">Award Badge</div>
					<div class="panel-body">
					
					<div class="form-group">
					<label for="badgeCustomerId">Customer Id</label>
					<select class="form-control" name="badgeCustomerId" id="badgeCustomerId">
						<option value="">Choose Customer</option>
						<option value="4">Boobathi</option>
						<option value="5">Ajay</option>
						<option value="6">Kumar</option>
					</select>
					</div>
					
					<div class="form-group">
					<label for="point">Badge</label>
					<select class="form-control" name="badgeId" id="badgeId">
						<option value="">Choose Badge</option>
						<option value="1">Well Done</option>
						<option value="2">Payment Guru</option>
					</select>
					</div>
					<div class="form-group">
					<label for="activity">Activity</label>
					<input type="text" class="form-control" id="activity" placeholder="Action">
					</div>
					</div>
			</div>
			</td></tr></table>
			<br>
			<div class="row">
				<div class="col-sm-12">
						<button type="button" class="btn btn-primary" onclick="onSubmit()">Submit</button>
				</div>
			</div>
			<div id="tablePoints"></div>
			<div id="tableBadge"></div>
		</div>
	</form>	
</body>
</html>
