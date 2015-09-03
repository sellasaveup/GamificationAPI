<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Gamification Framework</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		
		<link href="./css/bootstrap.min.css" rel="stylesheet">
		
		<link href="./css/masterpage.css" rel="stylesheet">
		<link href="./css/glphycons.css" rel="stylesheet">
		<script src="./js/jquery.min.js"></script>
		<script src="./js/session.js"></script>
		<script src="./js/profilewidget.js" type="text/javascript"></script>
		<script src="./js/bootstrap.min.js"></script>
		<script src="./js/notify.js"></script>
		
<script>

     var notificationType;
     var notificationMessage;
     var notificationImage;
     
     var commonUrl = getSessionUrl();
     var userCode = getSessionUserCode();
     var goalCode = getSessionGoalCode();	
     
      $(document).ready(function() {
    	 	
		 getUserProfile('userProfileTemplate', userCode, goalCode, commonUrl);
		 
		 $.notify.defaults({
			 clickToHide: true,
			 autoHide: false,
			 autoHideDelay:null,
			 elementPosition: 'top left',
			 globalPosition: 'top right'
			 });
		 
		 getNotification();
		});
      
      function loadMyPoints() {
    	  $("#content").load("MyPoints.jsp");
      }
      
      function loadMyBadges() {
    	  $("#content").load("MyBadges.jsp");
      }
      
      function loadChallenges() {
    	  $("#content").load("Challenges.jsp");
      }
      
      function loadMyRewards() {
    	  $("#content").load("MyRewards.jsp");
      }
      
      function loadAdminMaster() {
    	  $("#content").load("Admin.jsp");
      }
      
      function loadAwardNotify() {
    	  $("#content").load("Notification.jsp");
      }
      function loadGoalTrend() {
    	  $("#content").load("MyTrend.html");
      }
      
      function getNotification() {
    		 
    	  var notificationUrl = commonUrl + "GET_NOTIFICATION?userCode="+userCode;
    	$.ajax({
    		type : "GET",
    		url : notificationUrl,
    		dataType : "json",
    		contentType : "application/json; charset=UTF-8",
    		success : function(data) {
    			var count = data.Count;
    			if(count>0) {
    				 $("#notificationCount").html(count);
    			} else {
    				 $("#notificationCount").html("");
    			}
    			parseNotificationResponse(data);
    		},
    		error : function(e) {
    			console.log('latestBadgeAction failure : ' + e);
    		}
    	});
    	 
    }

    function parseNotificationResponse(data) {
    	var notificationArray = data.Response;
    	notificationType = new Array(notificationArray.length);
    	notificationMessage = new Array(notificationArray.length);
    	notificationImage = new Array(notificationArray.length);
    	
    	for(var i=0; i<notificationArray.length; i++) {
    		
    		notificationType[i] = notificationArray[i].notificationType;
    		notificationMessage[i] = notificationArray[i].message;
    		notificationImage[i] = notificationArray[i].imageUrl;
    	}
    }

    function showNotification() {
    	for(var i=0; i<notificationType.length; i++) {
    		if(notificationType[i] == "Message") {
    			notifyMessage(notificationMessage[i]);
    		}
    		
    		if(notificationType[i] == "Warning") {
    			notifyWarning(notificationMessage[i]);
    		}
    		
    		if(notificationType[i] == "Info") {
    			notifyInfo(notificationMessage[i]);
    		}
    	}
    }


    function notifyMessage(message) {
    	  $.notify(message, "success");
    }

    function notifyInfo(info) {
    	  $.notify(info, "info");
    }

    function notifyWarning(warning) {
    	  $.notify("Warning:"+warning, "warn");
    }

      
</script>
	</head>
	<body onload="loadMyPoints()">
<!-- header -->
<div id="top-nav" class="navbar navbar-inverse navbar-static-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="Login.jsp">Gamification Framework</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
             	 <li class="active"> <a href="#" onclick="loadMyPoints();"><i class="glyphicon glyphicon-piggy-bank"></i><b> My Points</b></a></li>
                 <li><a href="#" onclick="loadMyBadges();"><i class="glyphicon glyphicon-star-empty"></i><b> My Badges</b></a></li>
                 <li><a href="#" onclick="loadChallenges();"><i class="glyphicon glyphicon-thumbs-up"></i><b>Challenges</b></a></li>
                 <li><a href="#" onclick="loadMyRewards();"><i class="glyphicon glyphicon-gift"></i><b>My Rewards</b></a></li>
                 <!--<li><a href="#" onclick="loadAdminMaster();"><i class="glyphicon glyphicon-folder-open"></i><b> Admin Master</b></a></li>
                  <li><a href="#" onclick="loadAwardNotify();"><i class="glyphicon glyphicon-globe"></i> <b>Award Notify </b></a></li> -->
                 <li><a href="#" onclick="loadGoalTrend();"><i class="glyphicon glyphicon-globe"></i> <b>Trend </b></a></li>
                 <li><a href="#"  title="Check statistics" class="tipN" onCLick="showNotification()"><div style="position:relative;" id="notificationIcon"><img src="img/logo/dialogs.png" alt="" /></div><div id="notificationCount"></div></a></li>
                <li><a href="#"><i class="glyphicon glyphicon-off"></i> Logout</a></li>
            </ul>
        </div>
    </div>
    <!-- /container -->
</div>
<!-- /Header -->

<!-- Main -->
<div class="container-fluid">

<div class="row">

</div>
    <div class="row">
        <div class="col-sm-2 profile-sidebar" style="width:280px;height:1000px">
        	<div id="userProfileTemplate">
             </div>
          </div>
<!--           Loading page dynamically -->
	     <br>
        <div class="col-sm-8" id="content">

           

     </div>
    </div>
    
</div>

<div class="row">
<div class="footer navbar-fixed-bottom">
<footer class="text-center">Banca Sella, 2015</footer>
</div>
</div>
	
	
	     
	</body>
</html>