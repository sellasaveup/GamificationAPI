function drawbadgetrackerchart(divId){
	$.ajax({
		type : "GET",
		url :  commonUrl + 'GET_BADGE_TRACKER_CHART',
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {	
			console.log(data);
			var chartData = {
					labels : data.Response.xAxis,
					datasets : [
						{
							label: "Goal Trend Dataset",
							fillColor : "rgba(151,187,205,0.2)",
							strokeColor : "rgba(151,187,205,1)",
							pointColor : "rgba(151,187,205,1)",
							pointStrokeColor : "#fff",
							pointHighlightFill : "#fff",
							pointHighlightStroke : "rgba(151,187,205,1)",
							data : data.Response.yAxis
						}
					]
				}
				var ctxT = document.getElementById(divId).getContext("2d");
				new Chart(ctxT).Line(chartData, {
					 maintainAspectRatio: false, responsive: true
				});
		},
		error : function(e) {
			console.log('badge tracker chart call failure : ' + e);
		}
	});
}