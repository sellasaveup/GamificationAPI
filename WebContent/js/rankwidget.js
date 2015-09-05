function getRank(divId, customerID, requestType) {

	var buildUrl = 'http://localhost:8080/GamificationAPI/sella/api/GET_RANK?custId='
	buildUrl = buildUrl + customerID + '&requestType=' + requestType;
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			console.log('rank call success: ' + data);
			if (data.custId && data.rank) {
				document.getElementById(divId).innerHTML = data.rank;
			}
		},
		error : function(e) {
			console.log('rank call failure : ' + e);
		}
	});
}

function getMyCurrentMonthRank(divId, userCode, goalCode, commonUrl) {

	var buildUrl = commonUrl+'GET_MONTH_RANK?userCode=';
		buildUrl = buildUrl + userCode + '&goalCode=' + goalCode;
		
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			console.log('rank call success month: ' + data);
			if(data.Rank != undefined) {
				document.getElementById(divId).innerHTML = data.Rank;
			} else {
				document.getElementById(divId).innerHTML = "0";
			}
		},
		error : function(e) {
			console.log('rank call failure : ' + e);
		}
	});
}


function getMyAllTimeRank(divId, userCode, goalCode, commonUrl) {

	var buildUrl = commonUrl+'GET_ALL_TIME_RANK?userCode=';
		buildUrl = buildUrl + userCode + '&goalCode=' + goalCode;
	
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			console.log('rank call success all time: ' + data.Rank);
				if(data.Rank != undefined) {
					document.getElementById(divId).innerHTML = data.Rank;
				} else {
					document.getElementById(divId).innerHTML = "0"
				}
		},
		error : function(e) {
			console.log('rank call failure : ' + e);
		}
	});
	
}