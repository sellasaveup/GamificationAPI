function drawchallengechart(divId,userCode, goalCode){
	$.ajax({
		type : "GET",
		url :  commonUrl + 'GET_CHALLENGE_TREND_CHART?userCode=' + userCode + '&goalCode=' + goalCode,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {	
			var chartData = {
					labels : data.Response.xAxis,
					datasets : [
						{
							label: "Challenge Trend Dataset",
							fillColor: "rgba(151,187,205,0.5)",
				            strokeColor: "rgba(151,187,205,0.8)",
				            highlightFill: "rgba(151,187,205,0.75)",
				            highlightStroke: "rgba(151,187,205,1)",
							data : data.Response.yAxis
						}
					]
				}
				var ctxT = document.getElementById(divId).getContext("2d");
				new Chart(ctxT).Bar(chartData, {
					 maintainAspectRatio: false, responsive: true
				});
		},
		error : function(e) {
			console.log('line chart call failure : ' + e);
		}
	});
}