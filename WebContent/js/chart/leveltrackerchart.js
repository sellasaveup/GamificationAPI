function drawleveltrackerchart(divId){
	$.ajax({
		type : "GET",
		url :  commonUrl + 'GET_LEVEL_TRACKER_CHART',
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {	
			var chartData = {
					labels : data.Response.xAxis,
					datasets : [
						{
							label: "Level Trend Dataset",
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
			console.log('level tracker chart call failure : ' + e);
		}
	});
}