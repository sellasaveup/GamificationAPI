function getChallenges(divId, customerID) {

	var buildUrl = 'http://localhost:8080/GamificationAPI/sella/api/GET_CHALLENGES?custId='
	buildUrl = buildUrl + customerID;
	
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			var challengeList = data.Result;
			var challengeHtml = "";
			 $.each( challengeList, function( index, obj ) {
				 
				 challengesHtml =  '<div class="paddme well well-lg mywell"><div class="row"><div class="col-sm-2"><center>'+
						 '<img src="./img/challenges/'+ challengeList[index].imageUrl + '" class="img-rounded" width="100" height="80">' +
						 '</center></div><div class="col-sm-8">' + challengeList[index].description + '&nbsp;&nbsp;&nbsp;'+
						 '<a href="#">Read More</a></div><div class="col-sm-1 points well well-sm"><center>' +
						 '<h4>' + challengeList[index].point +" points"+'</h4></center></div></div>'
						 
				 $("#"+divId).append(challengesHtml);
				 
			 });
			
		},
		error : function(e) {
			console.log('challenge call failure : ' + e);
		}
	});
}

function getChallengesByGoal(divId, goalCode) {

	var buildUrl = 'http://localhost:8080/GamificationAPI/sella/api/GETCHALLENGESBYGOAL?goalCode='
	buildUrl = buildUrl + goalCode;
	
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			var challengeList = data.Response;
			var challengeHtml = "";
			 $.each( challengeList, function( index, obj ) {
				 
				 challengesHtml =  '<div class="paddme well well-lg mywell"><div class="row"><div class="col-sm-2"><center>'+
						 '<img src="./img/challenges/'+ challengeList[index].image + '" class="img-rounded" width="100" height="80">' +
						 '</center></div><div class="col-sm-8">' + challengeList[index].story + '&nbsp;&nbsp;&nbsp;'+
						 '<a href="#">Read More</a></div><div class="col-sm-1 points well well-sm"><center>' +
						 '<h4>' + challengeList[index].points +" points"+'</h4></center></div></div>'
						 
				 $("#"+divId).append(challengesHtml);
				 
			 });
			
		},
		error : function(e) {
			console.log('challenge call failure : ' + e);
		}
	});
}

  

function getLevelByGoal(divId, goalCode) {

	var buildUrl = 'http://localhost:8080/GamificationAPI/sella/api/GETLEVELBYGOAL?goalCode='
	buildUrl = buildUrl + goalCode;
	
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			var challengeList = data.Response;
			var challengeHtml = "";
			var tableBody = "";
			var tableHeader =  '<table class="table"><thead><tr class="success"> <th>Level</th><th>Level Story</th><th>Rewards</th> <th>Status Badge</th></tr></thead><tbody>';
			 $.each( challengeList, function( index, obj ) {
				 
				 challengesHtml =  tableBody + '<tr class="danger"><td>'+'<img src="./img/challenges/'+ challengeList[index].image + '" class="img-rounded" width="100" height="80">' + '</td>' +
						 '<td>' + challengeList[index].story + '</td>'+
						 '<td>' + challengeList[index].rewardCode  + '</td>' +
						 '<td>'+'<img src="./img/challenges/' + challengeList[index].badgeCode + '" class="img-rounded" width="100" height="80">' +'</td>'+ '</tr>';
						 
				 tableBody = challengesHtml;
				 
			 });
			 var buildTable = tableHeader + tableBody+ "</tbody></table>";
			 $("#"+divId).append(buildTable);
		},
		error : function(e) {
			console.log('challenge call failure : ' + e);
		}
	});
}
