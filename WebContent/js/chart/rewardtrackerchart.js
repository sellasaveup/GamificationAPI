function drawrewardtrackerchart(divId){
	$.ajax({
		type : "GET",
		url :  commonUrl + 'GET_REWARD_TRACKER_CHART',
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {	
			console.log(data);
			var chartData = {
					labels : data.Response.xAxis,
					datasets : [
						{
							label: "Reward Trend Dataset",
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
			console.log('reward tracker chart call failure : ' + e);
		}
	});
}