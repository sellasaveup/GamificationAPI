function getAllGoalList(divId, userCode, commonUrl) {

	var buildUrl = commonUrl + 'GET_ALL_MY_GOALS?userCode='
		buildUrl = buildUrl + userCode;
	
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			var goalList = data.Response;
			var goalHtml = '<table><tr>';
			 $.each( goalList, function( index, obj ) {
				 var goalCode = goalList[index].goalCode;
				 goalHtml = goalHtml + '<td><input type="radio" name="goalType" value="' + goalList[index].goalCode + '" >' + goalList[index].name + '</td>';
						 
				 
			 });
			 
			 $("#"+divId).append(goalHtml + '</tr></table>');
		},
		error : function(e) {
			console.log('goals call failure : ' + e);
		}
	});
	
}