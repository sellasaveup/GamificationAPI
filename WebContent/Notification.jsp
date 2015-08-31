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
<script src="./js/session.js"></script>

<script>
	
var commonUrl = getSessionUrl();
var sessionUserCode = getSessionUserCode();
var sessionGoalCode = getSessionGoalCode();

	$( document ).ready(function() {
		pushNotificationOnChange();
		awardPointsOnChange();
		awardBadgeOnChange();
	});
	
	
	function pushNotificationOnChange() {
		if ($("#checkPushNotify").is(':checked')) {
			getGoalListNotification(document.getElementById("goalCode"));
			$("#pushNotificationPanel").show();
			
		} else {
			
			$("#pushNotificationPanel").hide();
		}
	 }
	
	function awardPointsOnChange() {
		if ($("#checkAwardPoints").is(':checked')) {
			getGoalListPoint(document.getElementById("pointGoalCode"));
			$("#awardPointsPanel").show();
			
		} else {

			$("#awardPointsPanel").hide();
		}
	 }
	
	function awardBadgeOnChange() {
		if ($("#checkAwardBadge").is(':checked')) {
			getGoalListBadge(document.getElementById("badgeGoalCode"));
			$("#awardBadgePanel").show();
			
		} else {
			
			$("#awardBadgePanel").hide();
		}
	 }
	
	function getGoalListNotification(loadingGoalObject) {
		$.ajax({
		    url: 'RetrieveGoal',
		    dataType: 'json',
		    type: 'post',
		    contentType: 'application/json',
		    data: JSON.stringify( { "first-name": "Boobathi", "last-name": "Ayyasamy" } ),
		    processData: false,
		    success: function( data, textStatus, jQxhr ){
		        if(data.Result == "OK") {
		        	doParseNotificationGoalResponse(data, loadingGoalObject);
		        }
		    },
		    error: function( jqXhr, textStatus, errorThrown ){
		        console.log( errorThrown );
		    }
		});
	}
	
	function getGoalListPoint(loadingGoalObject) {
		$.ajax({
		    url: 'RetrieveGoal',
		    dataType: 'json',
		    type: 'post',
		    contentType: 'application/json',
		    data: JSON.stringify( { "first-name": "Boobathi", "last-name": "Ayyasamy" } ),
		    processData: false,
		    success: function( data, textStatus, jQxhr ){
		        if(data.Result == "OK") {
		        	doParsePointGoalResponse(data, loadingGoalObject);
		        }
		    },
		    error: function( jqXhr, textStatus, errorThrown ){
		        console.log( errorThrown );
		    }
		});
	}
	
	function getGoalListBadge(loadingGoalObject) {
		$.ajax({
		    url: 'RetrieveGoal',
		    dataType: 'json',
		    type: 'post',
		    contentType: 'application/json',
		    data: JSON.stringify( { "first-name": "Boobathi", "last-name": "Ayyasamy" } ),
		    processData: false,
		    success: function( data, textStatus, jQxhr ){
		        if(data.Result == "OK") {
		        	doParseBadgeGoalResponse(data, loadingGoalObject);
		        }
		    },
		    error: function( jqXhr, textStatus, errorThrown ){
		        console.log( errorThrown );
		    }
		});
	}
	
	function doParseNotificationGoalResponse(data, loadingGoalObject) { 
		var goalArray = data.Records;
		var goalvalueArray = new Array(goalArray.length);
		var goalNameArray = new Array(goalArray.length);
		for(var i=0; i<goalArray.length; i++) {
			
			goalvalueArray[i] = goalArray[i].goalCode;
			goalNameArray[i] = goalArray[i].name;
		}
		
		loadComboBox(loadingGoalObject,goalvalueArray, goalNameArray);
		
	}
	
	function doParsePointGoalResponse(data, loadingGoalObject) { 
		var goalArray = data.Records;
		var goalvalueArray = new Array(goalArray.length);
		var goalNameArray = new Array(goalArray.length);
		for(var i=0; i<goalArray.length; i++) {
			
			goalvalueArray[i] = goalArray[i].goalCode;
			goalNameArray[i] = goalArray[i].name;
		}
		
		loadComboBox(loadingGoalObject,goalvalueArray, goalNameArray);
		
	}
	
	function doParseBadgeGoalResponse(data, loadingGoalObject) { 
		var goalArray = data.Records;
		var goalvalueArray = new Array(goalArray.length);
		var goalNameArray = new Array(goalArray.length);
		for(var i=0; i<goalArray.length; i++) {
			
			goalvalueArray[i] = goalArray[i].goalCode;
			goalNameArray[i] = goalArray[i].name;
		}
		
		loadComboBox(loadingGoalObject,goalvalueArray, goalNameArray);
		
	}
	
	function notificationGoalOnChange(goalObject) {
		
		$( "#target" ).prop('selectedIndex', 0);
		doClearComboBox(document.getElementById("notificationUserCode"));
		doClearComboBox(document.getElementById("userType"));
	}
	
	function badgeGoalOnChange(goalObject) {
		var goalCode = $( "#badgeGoalCode" ).val();
		if(goalCode != "") {
			getUser(document.getElementById("badgeUserCode"),goalCode, "GOAL", "BADGE");	
		} else {
			doClearComboBox(document.getElementById("badgeUserCode"));
			doClearComboBox(document.getElementById("badgeCode"));
		}
		
	}
	
	function pointGoalOnChange(goalObject) {
		
		doClearComboBox(document.getElementById("badgeCode"));
		
		var goalCode = $( "#pointGoalCode" ).val();
		getUser(document.getElementById("pointUserCode"),goalCode, "GOAL", "POINT");
	}

	function badgeUserOnChange(badgeUserCode) {
		if(badgeUserCode != "") {
			doClearComboBox(document.getElementById("badgeCode"));	
		} else {
			getBadge(badgeUserCode);	
		}
	}
	
	function targetOnChange(targetObject) {

		if(targetObject.value == "USER_TYPE") {
			doClearComboBox(document.getElementById("notificationUserCode"));
			getUserType(document.getElementById("userType"));
		} else if(targetObject.value == "USER") {
			doClearComboBox(document.getElementById("userType"));
			var goalCode = $( "#goalCode" ).val();
			getUser(document.getElementById("notificationUserCode"),goalCode, "GOAL", "NOTIFICATION");	
		} else if(targetObject.value == "ALL") {
			doClearComboBox(document.getElementById("userType"));
			doClearComboBox(document.getElementById("notificationUserCode"));
		}
	}
	
	function getUserType(userTypeObject) {
		var channel = "";
		$.ajax({
		    url: 'RetrieveUserChannel?channel=channel',
		    dataType: 'json',
		    type: 'post',
		    contentType: 'application/json',
		    data: channel,
		    processData: false,
		    success: function( data, textStatus, jQxhr ){
		        	doParseuserTypeResponse(data, userTypeObject);
		    },
		    error: function( jqXhr, textStatus, errorThrown ){
		        console.log( errorThrown );
		    }
		});
	}
	
	function doParseuserTypeResponse(data, userTypeObject) { 
		var userTypeArray = data.Options;
		var userTypeNameArray = new Array(userTypeArray.length);
		
		for(var i=0; i<userTypeArray.length; i++) {

			userTypeNameArray[i] = userTypeArray[i];
		}
		 
		loadComboBoxValue(userTypeObject, userTypeNameArray);
		
	}
	
	function loadComboBoxValue(loadingObject,valueArray) {
		loadingObject.innerHTML = "";
		
        
		for(var i=0;i<valueArray.length;i++) {
			var option = document.createElement('option');
	        option.text = valueArray[i];
	        option.value = valueArray[i];
	        loadingObject.add(option, i);
		}
	}
	
	function getUser(userObject, code, requestType, requestFrom) {
		
		$.ajax({
            type: "GET",
            data: "",
            url: commonUrl+"GET_USER?code="+code+"&requestType="+requestType,
            dataType : "json",
            contentType: "application/json; charset=utf-8",
            crossDomain: true,

            success: function (data) {
            	parseUserResponse(data, userObject, requestFrom);
            },

            error: function (e) {
            }
         });
	}
	
	function parseUserResponse(data, userObject,requestFrom) {
		var userArray = data.Response;
		
		var userCodeArray = new Array(userArray.length);
		var userNameArray = new Array(userArray.length);
		for(var i=0; i<userArray.length; i++) {
			
			userCodeArray[i] = userArray[i].userCode;
			userNameArray[i] = userArray[i].name;
		}
		loadComboBox(userObject, userCodeArray, userNameArray);
	}
	
	function getChallenge(userCode) {
		$.ajax({
            type: "GET",
            data: "",
            url: commonUrl+"GET_CHALLENGE?userCode="+userCode,
            dataType : "json",
            contentType: "application/json; charset=utf-8",
            crossDomain: true,

            success: function (data) {
            	parseChallengeResponse(data, document.getElementById("pointAction"));
            },

            error: function (e) {
            }
         });
	}
	
	function parseChallengeResponse(data, actionObject) {
		var challengeArray = data.Response;
		
		var actionCodeArray = new Array(challengeArray.length);
		var actionNameArray = new Array(challengeArray.length);
		for(var i=0; i<challengeArray.length; i++) {
			
			actionCodeArray[i] = challengeArray[i].actionCode;
			actionNameArray[i] = challengeArray[i].story;
		}
		loadComboBox(actionObject, actionCodeArray, actionNameArray);
		
	}
	
	function getBadge(userCode) {
		$.ajax({
            type: "GET",
            data: "",
            url: commonUrl+"GET_USER_BADGE?userCode="+userCode,
            dataType : "json",
            contentType: "application/json; charset=utf-8",
            crossDomain: true,

            success: function (data) {
            	parseBadgeResponse(data, document.getElementById("badgeCode"));
            },

            error: function (e) {
            }
         });
	}
	
	function parseBadgeResponse(data, badgeObject) {
		var badgeArray = data.Response;
		
		var badgeCodeArray = new Array(badgeArray.length);
		var badgeNameArray = new Array(badgeArray.length);
		for(var i=0; i<badgeArray.length; i++) {
			
			badgeCodeArray[i] = badgeArray[i].badgeCode;
			badgeNameArray[i] = badgeArray[i].name;
		}
		loadComboBox(badgeObject, badgeCodeArray, badgeNameArray);
		
	}
	
	function loadComboBox(loadingObject,valueArray, textArray) {
		loadingObject.innerHTML = "";
		
		var selectOption = document.createElement('option');
		selectOption.text = "----Select----";
		selectOption.value = "";
        loadingObject.add(selectOption, 0);
        
		for(var i=0;i<valueArray.length;i++) {
			var option = document.createElement('option');
	        option.text = textArray[i];
	        option.value = valueArray[i];
	        loadingObject.add(option, i+1);
		}
	}
	
	function userTypeOnChange(userTypeObject) {
		
	}
	
	function pointUserCodeChange(pointUserCode) {
		getChallenge(pointUserCode);
	}
	
	function onSubmit() {
		
		if ($("#checkPushNotify").is(':checked')) {
			
			var goalCode = $( "#goalCode" ).val();
			var pushNotificationUrl = commonUrl+'PUSH_NOTIFICATION?';
			var notificationType = $( "#notificationType" ).val();
			var target = $( "#target" ).val();
			var message = $( "#message" ).val();
			var image = $( "#image" ).val();
			var notificationUserCode = $( "#notificationUserCode" ).val();
			var userType = $( "#userType" ).val();
			
			
			pushNotificationUrl = pushNotificationUrl+"notificationType="+notificationType;
			pushNotificationUrl = pushNotificationUrl+"&target="+target;
			pushNotificationUrl = pushNotificationUrl+"&message="+message;
			pushNotificationUrl = pushNotificationUrl+"&imageUrl="+image;
			pushNotificationUrl = pushNotificationUrl+"&userCode="+notificationUserCode;
			pushNotificationUrl = pushNotificationUrl+"&userType="+userType
			pushNotificationUrl = pushNotificationUrl+"&goalCode="+goalCode;
			
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
			
			var awardPointsUrl = commonUrl+'POST_ACTION?';
			var pointUserCode = $( "#pointUserCode" ).val();
			var pointAction = $("#pointAction").val();
			awardPointsUrl = awardPointsUrl+"userCode="+pointUserCode;
			awardPointsUrl = awardPointsUrl+"&actionCode="+pointAction;
			
			
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
			
			var awardBadgeUrl = commonUrl+'AWARD_BADGE?';
			
			var badgeUserCode = $( "#badgeUserCode" ).val();
			var badgeCode = $("#badgeCode").val();
			var badgeGoalCode = $("#badgeGoalCode").val();
			awardBadgeUrl = awardBadgeUrl+"userCode="+badgeUserCode;
			awardBadgeUrl = awardBadgeUrl+"&badgeCode="+badgeCode;
			awardBadgeUrl = awardBadgeUrl+"&goalCode="+badgeGoalCode;
			
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
	
	function doClearComboBox(clearingObject) {
		clearingObject.innerHTML = "";
	}
	
</script>
</head>
<body>
	<form id="notificationForm" action="Notification.jsp" method="post">
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
					<label for="goal">Goal</label>
					<select class="form-control" name="goalCode" id="goalCode" onchange="notificationGoalOnChange(this)">
					</select>
					</div>
					
					<div class="form-group">
					<label for="notificationType">Notification Type</label>
					<select class="form-control" name="notificationType" id="notificationType">
						<option value="Message">Message</option>
						<option value="Warning">Warning</option>
						<option value="Info">Info</option>
					</select>
					</div>
					
					<div class="form-group">
					<label for="target">Target</label>
					<select class="form-control" name="target" id="target" onchange="targetOnChange(this)">
						<option value="ALL">All</option>
						<option value="USER_TYPE">User Type</option>
						<option value="USER">User</option>
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
					<label for="userType">User Type</label>
					<select class="form-control" name="userType" id="userType" onchange="userTypeOnChange(this)">
						
					</select>
					</div>
					
					<div class="form-group">
					<label for="notificationUserCode">User</label>
					<select class="form-control" name="notificationUserCode" id="notificationUserCode">
						
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
					<label for="badgeGoalCode">Goal</label>
					<select class="form-control" name="pointGoalCode" id="pointGoalCode" onchange="pointGoalOnChange(this)">
					</select>
					</div>
					
					<div class="form-group">
					<label for="pointUserCode">User</label>
					<select class="form-control" name="pointUserCode" id="pointUserCode" onchange="pointUserCodeChange(this.value)">
						
					</select>
					</div>
					<div class="form-group">
					<label for="pointAction">Action</label>
					<select class="form-control" name="pointAction" id="pointAction">
					</select>
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
					<label for="badgeGoalCode">Goal</label>
					<select class="form-control" name="badgeGoalCode" id="badgeGoalCode" onchange="badgeGoalOnChange(this)">
					</select>
					</div>
					
					<div class="form-group">
					<label for="badgeUserCode">User</label>
					<select class="form-control" name="badgeUserCode" id="badgeUserCode" onchange="badgeUserOnChange(this.value)">
						
					</select>
					</div>
					
					<div class="form-group">
					<label for="point">Badge</label>
					<select class="form-control" name="badgeCode" id="badgeCode">
						
					</select>
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
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<div id="tablePoints"></div>
			<div id="tableBadge"></div>
		</div>
	</form>	
</body>
</html>
