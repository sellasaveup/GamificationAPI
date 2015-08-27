function getBadges(divId, customerID) {

	var buildUrl = 'http://localhost:8080/GamificationAPI/sella/api/GET_BADGE?custId='
		buildUrl = buildUrl + customerID;

	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			
			var badgesHtml = '<div class="row">';
			var items = [];
			var badgesList = data.Result;
			
			$.each( badgesList, function( index, obj ) {
				
				
				badgesHtml =  '<div class="col-sm-4"><img src="./img/badges/'+
								badgesList[index].imageUrl + '" class="img-thumbnail" width="100" height="80"></div></div>'
						 
				 $("#"+divId).append(badgesHtml);
				 
			 });

		},
		error : function(e) {
			console.log('badges call failure : ' + e);
		}
	});
}

function getMyBadges(divId, userCode, goalCode, commonUrl) {

	var buildUrl =  commonUrl + 'GET_MY_BADGE?userCode='
		buildUrl = buildUrl + userCode + '&goalCode=' + goalCode;
	
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			var badgesHtml = '<div class="row">';
			var items = [];
			var badgesList = data.Response;
			$.each( badgesList, function( index, obj ) {
				
				badgesHtml =  '<div class="col-sm-2"><div class="flip-container vertical"><div class="flipper">' +
				'<div class="back" style="background:white;">'+
				'<div class="back_text">' + badgesList[index].story+ '</div>'+
				'</div>'+
				'<div class="front" style="background:white">'+
				'<img src="./img/profile/'+ badgesList[index].image + '" class="img-thumbnail" width="100" height="80">' +
				'</div></div>' + '</div></div>';
			 });
			
			 $("#"+divId).append(badgesHtml);
		},
		error : function(e) {
			console.log('badges call failure : ' + e);
		}
	});
}

function getAllMyLockedBadges(divId, userCode, goalCode, commonUrl) {

	var buildUrl =  commonUrl + 'GET_MY_LOCKED_BADGE?userCode='
		buildUrl = buildUrl + userCode + '&goalCode=' + goalCode;
	
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			var badgesHtml = '<div class="row">';
			var items = [];
			var badgesList = data.Response;
			var totalBadges = "";
			$.each( badgesList, function( index, obj ) {
				
				badgesHtml =  badgesHtml + '<div class="col-sm-2"><div class="flip-container vertical"><div class="flipper">' +
				'<div class="back" style="background:white;">'+
				'<div class="back_text">' + badgesList[index].story+ '</div>'+
				'</div>'+
				'<div class="front" style="background:white">'+
				'<center><img src="./img/profile/'+ badgesList[index].image + '" class="img-thumbnail" width="100" height="80"><center>' +
				'</div></div>' + '</div></div>';
				
				totalBadges = badgesHtml;
			 });
			
			 $("#"+divId).append(totalBadges);
		},
		error : function(e) {
			console.log('badges call failure : ' + e);
		}
	});
}

/*function getAllMyBadges(divId, userCode, goalCode, commonUrl) {


	var buildUrl =  commonUrl + 'GET_ALL_MY_BADGES?userCode='
		buildUrl = buildUrl + userCode + '&goalCode=' + goalCode;
	
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			var badgeList = data.Response;
			var badgeHtml = "";
			var tableBody = "";
			var tableHeader =  '<table class="table"><thead><tr class="success"> <th>Level</th><th>Level Story</th><th>Rewards</th> <th>Status Badge</th></tr></thead><tbody>';
			 $.each( badgeList, function( index, obj ) {
				 
				 badgesHtml =  tableBody + '<tr class="danger"><td>'+'<img src="./img/badges/'+ badgeList[index].image + '" class="img-rounded" width="100" height="80">' + '</td>' +
						 '<td>' + badgeList[index].story + '</td>'+
						 '<td>' + badgeList[index].rewardCode  + '</td>' +
						 '<td>'+'<img src="./img/badges/' + badgeList[index].badgeCode + '" class="img-rounded" width="100" height="80">' +'</td>'+ '</tr>';
						 
				 tableBody = badgesHtml;
				 
			 });
			 var buildTable = tableHeader + tableBody+ "</tbody></table>";
			 $("#"+divId).append(buildTable);
		},
		error : function(e) {
			console.log('badge call failure : ' + e);
		}
	});
}*/