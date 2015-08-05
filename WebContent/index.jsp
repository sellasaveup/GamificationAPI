<!DOCTYPE>
<html>
<head>
<title>Admin Operation Page</title>
<!-- Include one of jTable styles. -->
<link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() { 
		
		$('#RewardTableContainer').jtable({
			title : 'Reward List',
			actions : {
				listAction : 'RewardController?action=list',
				createAction:'RewardController?action=create',
		          updateAction: 'RewardController?action=update',
		          deleteAction: 'RewardController?action=delete'
			},
			fields : {
				rewardId : {
					title : 'Reward Id',
					width : '10%',
					key : true,
					list : true,
					create : false
				},
				rewardDesc : {
					title : 'Reward',
					width : '40%',
					edit : true
				},
				rewardPoint : {
					title : 'Point',
					width : '10%',
					edit : true
				},
				rewardCode : {
					title : 'Reward Code',
					width : '40%',
					edit : true
				},
				
				imageUrl : {
					title : 'Image URL',
					width : '40%',
					edit : true
				}
			}
		});
		
		 
		$('#ChallengeTableContainer').jtable({
			title : 'Challenge List',
			actions : {
				listAction : 'ChallengeController?action=list',
				createAction:'ChallengeController?action=create',
		          updateAction: 'ChallengeController?action=update',
		          deleteAction: 'ChallengeController?action=delete'
			},
			fields : {
				id : {
					title : 'Id',
					width : '10%',
					key : true,
					list : true,
					create : false
				},
				description : {
					title : 'Description',
					width : '40%',
					edit : true
				},
				userAction : {
					title : 'Action Code',
					width : '10%',
					edit : true
				},
				point : {
					title : 'Point',
					width : '40%',
					edit : true
				},
				
				subjectType : {
					title : 'Subject Type',
					width : '40%',
					edit : true
				},
				imageUrl : {
					title : 'Image URL',
					width : '40%',
					edit : true
				},
				occurrence : {
					title : 'Occurrence',
					width : '40%',
					edit : true
				},
				expiryDate : {
					title : 'Expiry Date',
					width : '40%',
					edit : true,
					type: 'date',
                    displayFormat: 'yy-mm-dd'
				},
				goal : {
					title : 'Goal',
					width : '40%',
					edit : true
				}
				
			}
		});
		
		$('#CustomerTableContainer').jtable({
			title : 'Customer List',
			actions : {
				listAction : 'CustomerMasterController?action=list',
				createAction:'CustomerMasterController?action=create',
		          updateAction: 'CustomerMasterController?action=update',
		          deleteAction: 'CustomerMasterController?action=delete'
			},
			fields : {
				custId : {
					title : 'Customer Id',
					width : '10%',
					key : true,
					list : true,
					create : false
				},
				customerName : {
					title : 'Customer Name',
					width : '40%',
					edit : true
				},
				customerAvatar : {
					title : 'Customer Image URL',
					width : '10%',
					edit : true
				},
				points : {
					title : 'Earned Points',
					width : '40%',
					edit : true
				},
				
				subjectType : {
					title : 'Subject Type',
					width : '40%',
					edit : true
				}
			}
		});

		$('#BadgeTableContainer').jtable({
			title : 'Badge List',
			actions : {
				listAction : 'BadgeMasterController?action=list',
				createAction:function () {
                	return $.Deferred(function($dfd) {
                   		var formData = new FormData(document.forms[0]);
                    	$.ajax({
                        	url: 'BadgeMasterController?action=create',
                        	type: 'POST',
                        	data: formData,
                        	processData: false,
                        	contentType: false,
                        	dataType: 'json',
                        	success: function(data) {
                            	$dfd.resolve(data);
                        	}
                    	});
                	});
            	},
		        updateAction:function () {
                	return $.Deferred(function($dfd) {
                   		var formData = new FormData(document.forms[0]);
                    	$.ajax({
                        	url: 'BadgeMasterController?action=update',
                        	type: 'POST',
                        	data: formData,
                        	processData: false,
                        	contentType: false,
                        	dataType: 'json',
                        	success: function(data) {
                            	$dfd.resolve(data);
                        	}
                    	});
                	});
            	}, 
		        deleteAction: 'BadgeMasterController?action=delete'
			},
			fields : {
				badgeId : {
					title : 'Badge Id',
					width : '10%',
					key : true,
					list : true,
					create : false
				},
				badgeName : {
					title : 'Badge Name',
					width : '40%',
					edit : true
				},
				badgeCode : {
					title : 'Badge Code',
					width : '10%',
					edit : true
				},
				imageUrl : {
					title : 'Image URL',
					width : '40%',
					edit : true,
					input: function (data) {
						return '<input type="file" name="imageUrl" id="imageUrl" />';
					},
				},
				subjectType : {
					title : 'Subject Type',
					width : '40%',
					edit : true
				},
				goal : {
					title : 'Goal',
					width : '40%',
					edit : true
				}
			}
		});
		
		$('#RewardTableContainer').jtable('load');
		$('#ChallengeTableContainer').jtable('load');
		$('#CustomerTableContainer').jtable('load');
		$('#BadgeTableContainer').jtable('load');
	});
</script>

</head>
<body>
	<div
		style="width: 80%; margin-right: 10%; margin-left: 10%; text-align: center;">
		<h4>Reward List</h4>
		<div id="RewardTableContainer"></div>
	</div>
	<br>

	<div
		style="width: 80%; margin-right: 10%; margin-left: 10%; text-align: center;">
		<h4>Challenge List</h4>
		<div id="ChallengeTableContainer"></div>
	</div>

	<div
		style="width: 80%; margin-right: 10%; margin-left: 10%; text-align: center;">
		<h4>Customer List</h4>
		<div id="CustomerTableContainer"></div>
	</div>

	<div
		style="width: 80%; margin-right: 10%; margin-left: 10%; text-align: center;">
		<h4>Badge List</h4>
		<div id="BadgeTableContainer"></div>
	</div>
</body>
</html>