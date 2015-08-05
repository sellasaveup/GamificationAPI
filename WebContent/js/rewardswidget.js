function getRewards(divId, customerID) {

	var buildUrl = 'http://localhost:8080/GamificationAPI/sella/api/GET_REWARD?custId='
	buildUrl = buildUrl + customerID;
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			var rewardsList = data.Result;
			var rewardsHtml = "";
			
			 $.each( rewardsList, function( index, obj ) {
				 
				 rewardsHtml =  '<div class="row">'+
				 					'<div class="col-sm-10">'+ rewardsList[index].rewardDesc + '</div>'+
				 					'<div class="col-sm-2"><button id="redeemsubmit+index" type="button" class="btn btn-primary" onclick=getRedeemClicked($("#custId").val()); >Submit</button></div>'+
				 				'</div>';
						 
				 $("#"+divId).append(rewardsHtml);
			 });
		},
		error : function(e) {
			console.log('rewards call failure : ' + e);
			
		}
	});
}

function redeemPoints(customerID){
	var buildUrl = 'http://localhost:8080/GamificationAPI/sella/api/REDUCE_POINT?custId=';
		buildUrl = buildUrl + customerID + "&point="+ 10;

	$.ajax({
            type: "GET",
            data: "",
            url: buildUrl,
            dataType : "json",
            contentType: "application/json; charset=utf-8",
            crossDomain: true,

            success: function (data) {
            	console.log("success");
            },

            error: function (e) {
                console.log('rewards error ' + e)
            }
         });
   }