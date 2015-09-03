function drawgoallinechart(divId){
	$.ajax({
		type : "GET",
		url :  commonUrl + 'GET_GOAL_TREND',
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {	
			var chartData = data.Response[0];				
			var lineChartData = {
					labels : chartData.xAxis,
					datasets : [
						{
							label: "Goal Trend Dataset",
							fillColor : "rgba(151,187,205,0.2)",
							strokeColor : "rgba(151,187,205,1)",
							pointColor : "rgba(151,187,205,1)",
							pointStrokeColor : "#fff",
							pointHighlightFill : "#fff",
							pointHighlightStroke : "rgba(151,187,205,1)",
							data : chartData.yAxis
						}
					]
				}
				var ctxT = document.getElementById(divId).getContext("2d");
				window.myLine = new Chart(ctxT).Line(lineChartData, {
					 maintainAspectRatio: false, responsive: true
				});
		},
		error : function(e) {
			console.log('line chart call failure : ' + e);
		}
	});
}
