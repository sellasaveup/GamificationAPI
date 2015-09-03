function getPoints(divId, customerID, requestType, commonUrl) {

	var buildUrl = commonUrl+'GET_POINT?custId=';
	buildUrl = buildUrl + customerID + '&requestType=' + requestType;
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			console.log('points call success: ' + data);
			if (data.custId && data.point) {
				document.getElementById(divId).innerHTML = data.point;
			}
		},
		error : function(e) {
			console.log('points call failure : ' + e);
		}
	});
}


function getMyAllTimePoints(divId, userCode, goalCode, commonUrl) {

	var buildUrl = commonUrl+'GET_ALL_POINTS?userCode=';
		buildUrl = buildUrl + userCode + '&goalCode=' + goalCode;
	
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			console.log('points call success: ' + data.Points);
				document.getElementById(divId).innerHTML = data.Points;
		},
		error : function(e) {
			console.log('points call failure : ' + e);
		}
	});
	
}

function getMyCurrentMonthPoints(divId, userCode, goalCode, commonUrl) {

	var buildUrl = commonUrl+'GET_MONTH_POINTS?userCode=';
		buildUrl = buildUrl + userCode + '&goalCode=' + goalCode;
	
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			console.log('points call success: ' + data);
			if(data.Points != undefined) {
				document.getElementById(divId).innerHTML = data.Points;
			} else {
				document.getElementById(divId).innerHTML = "You have to earn Points"
			}
		},
		error : function(e) {
			console.log('points call failure : ' + e);
		}
	});
}

function getMyChallengesList(divId, userCode, goalCode, commonUrl) {

	var buildUrl = commonUrl+'GET_ALL_MY_POINTS_DETAIL?userCode=';
	buildUrl = buildUrl + userCode + '&goalCode=' + goalCode;
	
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			var challengeList = data.Response;
			var challengeHtml = "";
			var tableBody = "";
			var tableHeader =  '<table class="table table-striped"><thead><tr> <th>My Actions</th><th>Earned Points</th> <th>Date</th></tr></thead><tbody>';
			 $.each( challengeList, function( index, obj ) {
				 
				 
				 var myDate = new Date(challengeList[index].receivedDate);
				 var formattedDate = myDate.getMonth() + 1 + "-" + myDate.getDate() + "-" + myDate.getFullYear();
				 
				 
				 challengesHtml =  tableBody + '<tr>'+
						 '<td>' + challengeList[index].story + '</td>'+
						 '<td>' + challengeList[index].points  + '</td>' +
						 '<td>' + formattedDate +'</td>'+ '</tr>';
						 
				 tableBody = challengesHtml;
				 
			 });
			 var buildTable = tableHeader + tableBody+ "</tbody></table>";
			 $("#"+divId).append(buildTable);
		},
		error : function(e) {
			console.log('getMyChallengesList call failure : ' + e);
		}
	});
}
