function drawlinechart(divId, userCode, goalCode){
	var buildUrl =  commonUrl + 'GET_MY_POINTS_LINE_CHART?userCode=';
	buildUrl = buildUrl + userCode + '&goalCode=' + goalCode;		
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {			
			var chartData = data.Response;				
			var Jan = chartData.yAxis[0];
			var Feb = chartData.yAxis[1];
			var Mar = chartData.yAxis[2];
			var Apr = chartData.yAxis[3];
			var May = chartData.yAxis[4];
			var Jun = chartData.yAxis[5];
			var Jul =  chartData.yAxis[6];
			var Aug = chartData.yAxis[7];
			var Sep = chartData.yAxis[8];
			var Oct = chartData.yAxis[9];
			var Nov = chartData.yAxis[10];
			var Dec = chartData.yAxis[11];
			var lineChartData1 = {
					labels : ["January","February","March","April","May","June","July","August","September","October","November","December"],
					datasets : [
						{
							label: "My First dataset",
							fillColor : "rgba(151,187,205,0.2)",
							strokeColor : "rgba(151,187,205,1)",
							pointColor : "rgba(151,187,205,1)",
							pointStrokeColor : "#fff",
							pointHighlightFill : "#fff",
							pointHighlightStroke : "rgba(151,187,205,1)",
							data : [Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec]
						}
					]

				}

				var ctxT = document.getElementById(divId).getContext("2d");
				window.myLine = new Chart(ctxT).Line(lineChartData1, {
					 maintainAspectRatio: false, responsive: true
				});
		},
		error : function(e) {
			console.log('line chart call failure : ' + e);
		}
	});

		 
}
