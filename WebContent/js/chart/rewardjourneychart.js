function drawrewardjourneychart(divId, goalCode){
	$.ajax({
		type : "GET",
		url :  commonUrl + 'GET_REWARD_JOURNEY_CHART?goalCode=' + goalCode,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {	
			console.log(data);
			var chartData =  [
					          {
			                	  value: data.Response.yAxis[0],
			                	  color:"#F7464A",
			                	  highlight: "#FF5A5E",
			                	  label: data.Response.xAxis[0]
			                  },
			                  {
			                	  value: data.Response.yAxis[1],
			                	  color: "#949FB1",
			                	  highlight: "#A8B3C5",
			                	  label: data.Response.xAxis[1]
			                  },
			                  {
			                	  value: data.Response.yAxis[2],
			                	  color: "#46BFBD",
			                      highlight: "#5AD3D1",
			                	  label: data.Response.xAxis[2]
			                  },
			                  {
			                	  value: data.Response.yAxis[3],
			                	  color:"#F7464A",
			                	  highlight: "#FF5A5E",
			                	  label: data.Response.xAxis[3]
			                  },
			                  {
			                	  value: data.Response.yAxis[4],
			                	  color: "#46BFBD",
			                	  highlight: "#5AD3D1",
			                	  label: data.Response.xAxis[4]
			                  },
			                  {
			                	  value: data.Response.yAxis[5],
			                	  color: "#FDB45C",
			                	  highlight: "#FFC870",
			                	  label: data.Response.xAxis[5]
			                  },
			                  {
			                	  value: data.Response.yAxis[6],
			                	  color: "#FDB45C",
			                	  highlight: "#FFC870",
			                	  label: data.Response.xAxis[6]
			                  },
			                  {
			                	  value: data.Response.yAxis[7],
			                	  color: "#46BFBD",
			                      highlight: "#5AD3D1",
			                	  label: data.Response.xAxis[7]
			                  },
			                  {
			                	  value: data.Response.yAxis[8],
			                	  color: "#FDB45C",
			                	  highlight: "#FFC870",
			                	  label: data.Response.xAxis[8]
			                  },{
			                	  value: data.Response.yAxis[9],
			                	  color:"#F7464A",
			                	  highlight: "#FF5A5E",
			                	  label: data.Response.xAxis[9]
			                  },
			                  {
			                	  value: data.Response.yAxis[10],
			                	  color: "#FDB45C",
			                	  highlight: "#FFC870",
			                	  label: data.Response.xAxis[10]
			                  },
			                  {
			                	  value: data.Response.yAxis[11],
			                	  color: "#FDB45C",
			                	  highlight: "#FFC870",
			                	  label: data.Response.xAxis[11]
			                  }
					];
				var ctxT = document.getElementById(divId).getContext("2d");
				new Chart(ctxT).PolarArea(chartData, {
					animateScale : true
				});
		},
		error : function(e) {
			console.log('reward journey chart call failure : ' + e);
		}
	});
}