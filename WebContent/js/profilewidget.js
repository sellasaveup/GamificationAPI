function getProfile(divId, customerID) {

	var buildUrl = 'http://localhost:8080/GamificationAPI/sella/api/GET_PROFILE?custId='
	buildUrl = buildUrl + customerID;
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			console.log('profile call success: ' + data);
			var profileHtml = '<h4><label id="profileName">'
					+ data.Result.customerName
					+ '</label></h4>'
					+ '<img src="./img/profile/'
					+ data.Result.customerAvatar
					+ '" class="img-circle width="100" height="80"><br>';

			$("#" + divId).append(profileHtml);

		},
		error : function(e) {
			console.log('profile call failure : ' + e);
		}
	});
}