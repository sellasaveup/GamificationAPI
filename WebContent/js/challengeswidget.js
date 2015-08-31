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
						 '<a href="#">Read More</a></div><div class="col-sm-2 points well well-sm"><center>' +
						 '<h4>' + challengeList[index].point +" points"+'</h4></center></div></div>'
						 
				 $("#"+divId).append(challengesHtml);
				 
			 });
			
		},
		error : function(e) {
			console.log('challenge call failure : ' + e);
		}
	});
}

function getChallengesByGoal(divId, goalCode, commonUrl) {

	var buildUrl = commonUrl+'GETCHALLENGESBYGOAL?goalCode=';
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
				 
				 challengesHtml =  '<div class="paddme"><div class="row"><div class="col-sm-2"><center>'+
						 '<img src="./img/challenges/'+ challengeList[index].image + '" class="img-rounded" width="50" height="50">' +
						 '</center></div><div class="col-sm-8">' + challengeList[index].story + '&nbsp;&nbsp;&nbsp;'+
						 '<a href="#">Read More</a></div><div class="col-sm-2"><center>' +
						 '<h4>' + challengeList[index].points +" points"+'</h4></center></div></div><br/>'
						 
				 $("#"+divId).append(challengesHtml);
				 
			 });
			
		},
		error : function(e) {
			console.log('challenge call failure : ' + e);
		}
	});
}

  

function getLevelByGoal(divId, goalCode, commonUrl) {

	var buildUrl = commonUrl+'GETLEVELBYGOAL?goalCode=';
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
			var tableHeader =  '<center><div class="col-sm-12"><table class="table table-striped table-hover"><thead><tr><th>Level</th><th>Level Story</th><th>Rewards</th> <th>Status Badge</th></tr></thead><tbody>';
			 $.each( challengeList, function( index, obj ) {
				 
				 challengesHtml =  tableBody + '<tr><td>'+'<img src="./img/challenges/'+ challengeList[index].image + '" class="img-rounded" width="100" height="80">' + '</td>' +
						 '<td>' + challengeList[index].story + '</td>'+
						 '<td>' + challengeList[index].rewardCode  + '</td>' +
						 '<td>'+'<img src="./img/challenges/' + challengeList[index].badgeCode + '" class="img-rounded" width="100" height="80">' +'</td>'+ '</tr>';
						 
				 tableBody = challengesHtml;
				 
			 });
			 var buildTable = tableHeader + tableBody+ "</tbody></table></div></center>";
			 $("#"+divId).append(buildTable);
		},
		error : function(e) {
			console.log('challenge call failure : ' + e);
		}
	});
}
