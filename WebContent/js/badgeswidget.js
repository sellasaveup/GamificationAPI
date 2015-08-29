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
				
				badgesHtml =  badgesHtml + '<div class="col-sm-2"><div class="flip-container vertical"><div class="flipper">' +
				'<div class="back" style="background:white;">'+
				'<div class="back_text">' + badgesList[index].name+ '<br>' + badgesList[index].story+ '</div>'+
				'</div>'+
				'<div class="front" style="background:white">'+
				'<img src="./img/badges/'+ badgesList[index].image + '" class="img-thumbnail" width="100" height="80">' +
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
				'<div class="back_text">' + badgesList[index].name+ '<br>' + badgesList[index].story+ '</div>'+
				'</div>'+
				'<div class="front" style="background:white">'+
				'<center><img src="./img/badges/'+ badgesList[index].image + '" class="img-thumbnail" width="100" height="80"><center>' + 
				'</div></div>' + '</div></div>';
				
				
			 });
			
			 $("#"+divId).append(badgesHtml);
		},
		error : function(e) {
			console.log('badges call failure : ' + e);
		}
	});
}

