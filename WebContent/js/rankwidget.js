function getRank(divId, customerID, requestType) {

	var buildUrl = 'http://localhost:8080/GamificationAPI/sella/api/GET_RANK?custId='
	buildUrl = buildUrl + customerID + '&requestType=' + requestType;
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			console.log('rank call success: ' + data);
			if (data.custId && data.rank) {
				document.getElementById(divId).innerHTML = data.rank;
			}
		},
		error : function(e) {
			console.log('rank call failure : ' + e);
		}
	});
}