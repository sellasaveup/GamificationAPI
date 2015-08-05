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