function getProfile(divId, customerID) {

	var buildUrl = 'http://localhost:8080/GamificationAPI/sella/api/GET_PROFILE?custId='
	buildUrl = buildUrl + customerID;
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			console.log('profile call success: ' + data);
			var profileHtml = '<h4><label id="profileName">'
					+ data.Result.customerName
					+ '</label></h4>'
					+ '<img src="./img/profile/'
					+ data.Result.customerAvatar
					+ '" class="img-circle" width="100" height="80"><br>';

			$("#" + divId).append(profileHtml);

		},
		error : function(e) {
			console.log('profile call failure : ' + e);
		}
	});
}

function getUserProfile(divId, userCode, goalCode, commonUrl) {

	var buildUrl = commonUrl + 'GET_PROFILE?userCode='
	buildUrl = buildUrl + userCode + '&goalCode=' + goalCode;
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		
		success : function(data) {
			
			var username = data.Response.name;
			
			
			var imgg = data.Response.image;
			var profileHtml = '<div class="profile-userpic"><center><img src="./img/profile/'+ data.Response.image + 
			'" class="img-rounded width="100" height="80"></center></div>'+
			'<div class="profile-usertitle">' + 
				'<div class="profile-usertitle-name">' + 
			'Hi ' + username +
			'</div><div><img src="./img/profile/'+ data.Response.badgeView.image + '" class="img-rounded width="100" height="50" ></div></div>' +
		'<br>'+
		'<div align="center"><article style="align:center" class = "btn-sm profile-usertitle-job"><font size="3"><b>Total Points</b></font>'+
		'<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size="6">' +
		data.Response.totalPoints +
		'</font></article>' +
		'<article style="align:center" class = "btn-sm profile-usertitle-job"><font size="3"><b>Redeemed Points</b></font> <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size="6">' +
			data.Response.reedemedPoints +
			'</font></article>' +
			'<article style="align:center" class = "btn-sm profile-usertitle-job"><font size="3"><b>Redeemable Points</b></font> <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size="6">' +
				data.Response.redeemablePoints + 
				'</font></article>' +
			 '</div>' ;
					
				
			$("#" + divId).append(profileHtml);

		},
		error : function(e) {
			console.log('profile call failure : ' + e);
		}
	});
}
