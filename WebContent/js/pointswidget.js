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
				document.getElementById(divId).innerHTML = data.Points;
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
			var tableHeader =  '<h4 class="element">Achieved Challenges...</h4><table class="table"><thead><tr class="danger"> <th>Challenges</th><th>Points</th> <th>Date</th></tr></thead><tbody>';
			 $.each( challengeList, function( index, obj ) {
				 
				 challengesHtml =  tableBody + '<tr class="success">'+
						 '<td>' + challengeList[index].story + '</td>'+
						 '<td>' + challengeList[index].points  + '</td>' +
						 '<td>' + challengeList[index].receivedDate +'</td>'+ '</tr>';
						 
				 tableBody = challengesHtml;
				 
			 });
			 var buildTable = tableHeader + tableBody+ "</tbody></table>";
			 $("#"+divId).append(buildTable);
		},
		error : function(e) {
			console.log('points call failure : ' + e);
		}
	});
}
