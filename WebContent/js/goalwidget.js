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

/*<table>
<tr>
	<td><input type="radio" name="goalType" value="HYPE_GOAL"
		id="radio1">Hype</td>
	<td><input type="radio" value="INTRANET_GOAL"
		name="goalType" id="radio2">Intranet</td>
	<td><input type="radio" value="PDU_GOAL" name="goalType"
		id="radio3">PDU</td>

</tr>
</table>*/
