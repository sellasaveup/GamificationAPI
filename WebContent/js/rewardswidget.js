function getMyRewards(divId, userCode, goalCode, commonUrl) {

	var buildUrl =  commonUrl + 'GET_MY_REWARD?userCode='
		buildUrl = buildUrl + userCode + '&goalCode=' + goalCode;	    
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			var rewardsHtml = '<div class="well"> <div class="row">';
			var items = [];
			var rewardList = data.Response;				
			$.each( rewardList, function( index, obj ) {				
				rewardsHtml =  rewardsHtml + '<div class="col-sm-4">' +
				rewardList[index].name+ '<span class="badge">' + rewardList[index].reedemPoints + '</span> <br>' 
				+ '<a href="redeemURL" class="thumbnail"> <p> ' +
				rewardList[index].story + '</p>' + '<img src="./img/rewards/'+ rewardList[index].image + '" class="img-thumbnail" width="200" height="200"> </a>' +
				'</div>';
				 
			 });			
			rewardsHtml = rewardsHtml + '</div></div>';
			 $("#"+divId).append(rewardsHtml);
		},
		error : function(e) {
			console.log('rewards call failure : ' + e);
		}
	});
}
