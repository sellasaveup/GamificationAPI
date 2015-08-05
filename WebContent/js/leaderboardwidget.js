function getLeaderboard(divId, customerID, requestType) {

	var buildUrl = 'http://localhost:8080/GamificationAPI/sella/api/GET_LEADERBOARD?custId='
	buildUrl = buildUrl + customerID  + '&requestType=' + requestType;
	
/*
 * "Result": [
    {
      "custId": 2,
      "customerName": "Sujatha",
      "customerAvatar": "",
      "points": 200,
      "subjectType": "EMP"
    },
    {
      "custId": 1,
      "customerName": "Boobathi",
      "customerAvatar": "profilepic.jpg",
      "points": 100,
      "subjectType": "EMP"
    }
  ]
  
  */
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			var leaderBoardList = data.Result;
			var leaderBoardHtml = '';

			 
			 $.each( leaderBoardList, function( index, obj ) {
				 
				 leaderBoardHtml =  '<div class="row"><tr>';

				 if(customerID == leaderBoardList[index].custId) {
					  leaderBoardHtml= leaderBoardHtml + '<div class="col-sm-8 points"><td><img src="./img/profile/'+leaderBoardList[index].customerAvatar+ '" class="img-rounded width="100" height="80">'+ "&nbsp;&nbsp;&nbsp;" +leaderBoardList[index].customerName+ '</td></div>';
					  leaderBoardHtml = leaderBoardHtml +  '<div class="col-sm-4 points"><td>'+leaderBoardList[index].points+ '</td></div>';
				 } else {
					 leaderBoardHtml = leaderBoardHtml + '<div class="col-sm-8"><td><img src="./img/profile/'+leaderBoardList[index].customerAvatar+ '" class="img-rounded width="100" height="80">' +"&nbsp;&nbsp;&nbsp;" +leaderBoardList[index].customerName +'</td></div>';
					 leaderBoardHtml = leaderBoardHtml +  '<div class="col-sm-4"><td>'+leaderBoardList[index].points+ '</td></div>';
				 }
				
				 '</tr></div><br/>';
						 
				 $("#"+divId).append(leaderBoardHtml);
				 
			 });
			 
		},
		error : function(e) {
			console.log('leaderboard call failure : ' + e);
		}
	});
}