function getPoints(divId, customerID, requestType) {

	var buildUrl = 'http://localhost:8080/GamificationAPI/sella/api/GET_POINT?custId='
	buildUrl = buildUrl + customerID + '&requestType=' + requestType;
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			console.log('points call success: ' + data);
			if (data.custId && data.point) {
				document.getElementById(divId).innerHTML = data.point;
			}
		},
		error : function(e) {
			console.log('points call failure : ' + e);
		}
	});
}