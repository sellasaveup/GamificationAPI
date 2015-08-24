
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    
<link rel="stylesheet" href="./css/bootstrap.min.css">

<script src="./js/jquery.min.js" type="text/javascript"></script>

    <script src="./js/jquery.popupoverlay.js"></script>
        <link href="./css/loginprofile.css" rel="stylesheet">
    

    <style>
    .lineheight {
        line-height: 3em;
    }
   
    .initialism {
        font-weight: bold;
        letter-spacing: 1px;
        font-size: 12px;
    }
    
body {background: #336699;}
.headstyle { background: #F2F2F2; font: normal small-caps normal 75px/1.4 Georgia; color: #086A87;}
.signstyle {  font: normal small-caps normal 25px/1.4 Georgia; color: white;}
.registerstyle {  font: normal 25px/1.4 Georgia; color: white; align:left;}


.userstyle {  font: normal small-caps normal 25px/1.4 Arial; color: black;}
.submitstyle {  font-family: "Times New Roman", Georgia, Serif; font: 22px/1.4 Arial; color: white;}
    p::before { 
  content: "Gamification";
  color: black;
}
.transUpdate{
  -moz-border-radius:10px;
  -webkit-border-radius:10px;
  border-radius:10px;
  background: #fff; /* fallback for browsers that don't understand rgba */
  border: #solid 10px #000; /* fallback for browsers that don't understand rgba */
  background-color: rgba(255,255,255,0.8)/* slighly transparent white */
  border-color: rgba(0,0,0,0.2) /*Very transparent black*/
}
  .divspace{
   margin-right:30px;
}

        
    .roundedbox{
    border-radius: 25px;
    border: 2px solid yellow;
    width: 380px;
    height: 80px;
}

.textinbox{
    text-align: right;
    margin-top: -10px;
    height: 20px;
    line-height: 20px;
    font-size: 15px;
}

.divbackground{
    background-color: white;
}
    </style>
 <script type="text/javascript">
 
 var commonUrl = "http://localhost:8080/GamificationAPI/sella/api/";
 
 $( document ).ready(function() {
		    $('#registerform').popup({
		        pagecontainer: '.container',
		        transition: 'all 0.3s'
		    });		
	 
	 var performedActivitiesUrl = commonUrl+"GET_PERFORMED_ACTIVITIES_COUNT";
	 var unlockedBadgeUrl = commonUrl+"GET_UNLOCKED_BADGE_COUNT";
	 var engagedUserCountUrl = commonUrl+"GET_ENGAGED_USER_COUNT";
	 
	 getPerformedActivitiesCount(performedActivitiesUrl);
	 getUnlockedBadgeCount(unlockedBadgeUrl);
	 getEngagedUserCount(engagedUserCountUrl);
	 
	 setInterval(function () {updateLatestActivity()}, getRandomRange(3000,5000));
	 setInterval(function () {updateLatestBadgeActivity()}, getRandomRange(3000,5000));
	 setInterval(function () {updateLatestRedeemActivity()}, getRandomRange(3000,5000));
	 setInterval(function () {updateLatestRewardActivity()}, getRandomRange(3000,5000));
	 setInterval(function () {updateLatestLevelActivity()}, getRandomRange(3000,5000));
	 setInterval(function () {updateLatestUserActivity()}, getRandomRange(3000,5000));
	 
 });
 
 
 function getPerformedActivitiesCount(requestUrl) {
	 
			$.ajax({
				type : "GET",
				url : requestUrl,
				dataType : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(data) {
					getDelayedIncrement(data.performedActivitiesCount,"performedActivitiesCount",30);
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
					getDelayedIncrement(data.unlockedBadgeCount,"unlockedBadgeCount",100);
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
					getDelayedIncrement(data.engagedUserCount,"engagedUserCount", 40);
				},
				error : function(e) {
					console.log('getEngagedUserCount failure : ' + e);
				}
			});
 }
 
 function getDelayedIncrement(maxValue, applyingPeoperty, delayTime) {
	 for(i = 1; i <= maxValue; i++){
		    (function(i){
		        setTimeout(function(){
		        	document.getElementById(applyingPeoperty).innerHTML = i;
		        }, delayTime * i);
		    }(i));
		}
 }
 
 function updateLatestActivity() {
	 var latestActivityUrl = commonUrl+"GET_LATEST_ACTION";
	 $.ajax({
			type : "GET",
			url : latestActivityUrl,
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				var finaDate = data.latestAction.split("#");
				var text = finaDate[0];
				var image = getProfileImagePath()+finaDate[1];
				var randomPosition = getRandomRange(1,3);
				$('#textPanel'+randomPosition).html(text);
				$('#imagePanel'+randomPosition).attr('src', image);
			},
			error : function(e) {
				console.log('updateLatestActivity failure : ' + e);
			}
		});
 }
 
 function updateLatestBadgeActivity() {
	 var latestBadgeActivityUrl = commonUrl+"GET_LATEST_BADGE";
	 $.ajax({
			type : "GET",
			url : latestBadgeActivityUrl,
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				var finaData = data.latestBadgeAction.split("#");
				var text = finaData[0];
				var image = getProfileImagePath()+finaData[1];
				var randomPosition = getRandomRange(1,3);
				$('#textPanel'+randomPosition).html(text);
				$('#imagePanel'+randomPosition).attr('src', image);
			},
			error : function(e) {
				console.log('latestBadgeAction failure : ' + e);
			}
		});
 }
 
 function updateLatestRedeemActivity() {
	 var latestRedeemActivityUrl = commonUrl+"GET_LATEST_REDEEM";
	 $.ajax({
			type : "GET",
			url : latestRedeemActivityUrl,
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				var finaData = data.latestRedeemAction.split("#");
				var text = finaData[0];
				var image = getProfileImagePath()+finaData[1];
				var randomPosition = getRandomRange(1,3);
				$('#textPanel'+randomPosition).html(text);
				$('#imagePanel'+randomPosition).attr('src', image);
			},
			error : function(e) {
				console.log('updateLatestRedeemActivity failure : ' + e);
			}
		});
 }
 
 function updateLatestRewardActivity() {
	 var latestRewardActivityUrl = commonUrl+"GET_LATEST_REWARD";
	 $.ajax({
			type : "GET",
			url : latestRewardActivityUrl,
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				var finaData = data.latestRewardAction.split("#");
				var text = finaData[0];
				var image = getProfileImagePath()+finaData[1];
				var randomPosition = getRandomRange(1,3);
				$('#textPanel'+randomPosition).html(text);
				$('#imagePanel'+randomPosition).attr('src', image);
			},
			error : function(e) {
				console.log('latestRewardAction failure : ' + e);
			}
		});
 }
 
 function updateLatestLevelActivity() {
	 var latestLevelActivityUrl = commonUrl+"GET_LATEST_LEVEL";
	 $.ajax({
			type : "GET",
			url : latestLevelActivityUrl,
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				var finaData = data.latestlevelAction.split("#");
				var text = finaData[0];
				var image = getProfileImagePath()+finaData[1];
				var randomPosition = getRandomRange(1,3);
				$('#textPanel'+randomPosition).html(text);
				$('#imagePanel'+randomPosition).attr('src', image);
			},
			error : function(e) {
				console.log('latestRewardAction failure : ' + e);
			}
		});
 }
 
 function updateLatestUserActivity() {
	 var latestUserActivityUrl = commonUrl+"GET_LATEST_USER";
	 $.ajax({
			type : "GET",
			url : latestUserActivityUrl,
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				var finaData = data.latestUserAction.split("#");
				var text = finaData[0];
				var image = getProfileImagePath()+finaData[1];
				var randomPosition = getRandomRange(1,3);
				$('#textPanel'+randomPosition).html(text);
				$('#imagePanel'+randomPosition).attr('src', image);
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
 </script>  
</head>
<body>

<div class="wrapper">

<div class="container">
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	
        
			<p class="headstyle"> Framework<img src="img/logo/logo.gif" width="250"></p>
	</div>
<div>
<form id="myForm"  action="MasterTemplate.jsp" method="post" >
    <div class="row">
    <div class="col-sm-6 pull-left">
			
				<div class="form-group" >
				<div class="row">
						<div class="col-sm-12 border"><center><h3 class="signstyle">Sign In</h3></center></div>
					</div>
					<br>
					
					
			
					<div class="row">
						<div class="col-sm-12">
							<input type="text" placeholder="UserCode">
						</div>
					</div><br>
					<div class="row">
						<div class="col-sm-12">
							<button type="submit"><span>Submit</span></button>
						</div>
					</div>
					<br>
					
					
					<br>
				</div>
					<div>

   

</div>
<div>
<section class="col-md-10 col-md-offset-1">


        <span class="lineheight">
            
            <a class="initialism registerform_open" href="#registerform" style="color:white;font-size: 15px;"><b>Register in GF</b></a>
            
        </span>

     
    </section>
    </div>
    </div>&nbsp;&nbsp;
    <div class="col-sm-6 pull-right">
    <div class="col-sm-6 pull-right">
    
    <table width="400px">
   <tr > <td><font size="5"><b><span id="performedActivitiesCount"></span></b></font></td><td><font size="5"><b><span id="unlockedBadgeCount"></span></b></font></td><td><font size="5"><b><span id="engagedUserCount"></span></b></font></td></font></tr>
   <tr><td><font size="3"><b>Activities Performed</b></font></td><td><font size="3"><b>Badges Unlocked</b></font></td><td><font size="3"><b>Users Engaged</b></font></td></tr>
  
    
    
     <tr class="roundedbox"> <td>
    <div class="profile-userpic">
		<center><img id="imagePanel1" src="./img/profile/sheryl.jpg" class="img-responsive" alt="" width="120px"></center>
	</div></td><td><div id="textPanel1">Boobathi unlocked a badge SUPER SAVER on Hype Goal</div></td><td>
	</td></tr>
	
    <tr class="roundedbox"> <td>
    <div class="profile-userpic">
		<center><img id="imagePanel2" src="./img/profile/sheryl.jpg" class="img-responsive" alt="" width="120px"></center>
	</div></td><td><div id="textPanel2">Steffy redeemed on Hype Goal..250 points for Amazon Gift Voucher</div></td><td>
	
	</td></tr>
	
	
	<tr class="roundedbox"> <td>
    <div class="profile-userpic">
		<center><img id="imagePanel3" src="./img/profile/sheryl.jpg" class="img-responsive" alt="" width="120px"></center>
	</div></td><td><div id="textPanel3">Steffy rewarded on Hype goal with 200 points..</div></td><td>
	</td></tr>
	
	<tr class="roundedbox"> <td>
    <div class="profile-userpic">
		<center><img id="imagePanel4" src="./img/profile/sheryl.jpg" class="img-responsive" alt="" width="120px"></center>
	</div></td><td><div id="textPanel4">Steffy reached BRONZE level	</div></td><td>
	</td></tr>
	
	<tr class="roundedbox"> <td>
    <div class="profile-userpic">
		<center><img id="imagePanel5" src="./img/profile/sheryl.jpg" class="img-responsive" alt="" width="120px"></center>
	</div></td><td><div id="textPanel5">Steffy joined customer community to score on a goal</div></td><td>
	</td></tr>
	
	<tr class="roundedbox"> <td>
    <div class="profile-userpic">
		<center><img id="imagePanel6" src="./img/profile/sheryl.jpg" class="img-responsive" alt="" width="120px"></center>
	</div></td><td><div id="textPanel6">Steffy joined customer community to score on a goal</div></td><td>
	</td></tr>
	
	
    
    </table>
    

<span><b></b></span></div>
<span><b></b></span></div>
		</div>

			</form>
			
		
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
	   
	
	
</div>
<div id="registerform" class="well">
    <h4 style="color:black">Register in GF</h4>
   
    <table>
    <tr>
    <td style="color:black">Enter GBSCode&nbsp;</td>
     <td><input type="text" name = "userCode" id ="userCode" ><br><br></td>
     
    </tr>
    
    <tr>
    <td style="color:black">Who am I ? </td>
     <td><select>
  <option value="select" class="selectpicker show-menu-arrow">--Select User type--</option>
  <option value="employee">Employee</option>
  <option value="customer">Customer</option>
  <option value="trainee">Trainee</option>
  <option value="branchUser">Branch user</option>
</select><br><br></td>
    </tr>
    <tr>
    <td style="color:black">Nick Name  </td>
     <td><input type="text" name = "nickName" id ="nickName" ><br><br></td>
    </tr>
    <tr>
    <td style="color:black">Avatar</td>
     <td><button type="submit" class="btn btn-primary start">
                    <i class="glyphicon glyphicon-upload"></i>
                    <span>Upload Avatar</span>
                </button><br><br></td>
    </tr>
    <tr>
    <td style="color:black">Status Message  &nbsp;</td>
     <td><input type="text" name = "statusMsg" id ="statusMsg" ><br><br></td>
    </tr>


</table>


    <button class="registerform_close slide_open btn btn-default">Check IN</button>
    <button class="registerform_close btn btn-default">Close</button>
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
</style>

<!-- Google Prettify syntax highlighting -->


</body>
</html>
