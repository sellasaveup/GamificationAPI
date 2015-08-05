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