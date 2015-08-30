<!DOCTYPE>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<html>
<head>
<title>Admin</title>
<!-- Include one of jTable styles. -->
<link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() { 
		
		$('#GoalTableContainer').jtable({
			title : 'Goal ',
			openChildAsAccordion: true,
			actions : {
				listAction : 'RetrieveGoal',
				createAction:function () {
                	return $.Deferred(function($dfd) {
                   		var formData = new FormData(document.forms[0]);
                    	$.ajax({
                        	url: 'CreateGoal',
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
            	deleteAction: 'DeleteGoal',
            	updateAction:function () {
                	return $.Deferred(function($dfd) {
                   		var formData = new FormData(document.forms[0]);
                    	$.ajax({
                        	url: 'UpdateGoal',
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
			},
			fields : {
                goalId : {
					title : 'Goal Id',
					width : '10%',
					key : true,
					list : true,
					create : false
				},
				goalCode : {
					title : 'Goal Code',
					width : '10%',
					edit : true
				},
				userType : {
					title: 'U-channel',
                    width: '10%',
                    edit: true,
                    options : 'RetrieveUserChannel?channel=channel',
                    display: function (data) {
                        return data.record.userType;
                    }
				},
				name : {
					title : 'Name',
					width : '20%',
					edit : true
				},
				story : {
					title : 'Stroy',
					width : '40%',
					edit : true
				},
				expiryDate : {
					title : 'Exp Date',
					width : '10%',
					edit : true,
					type : 'date',
					displayFormat : 'yy-mm-dd',
					display: function (data) {
                        return data.record.expiryDate;
                    }
				},
				image : {
					title : 'Image',
					width : '20%',
					edit : true,
					input: function (data) {
						return '<input type="file" name="image" id="image" />';
					}
				},
				status : {
					title: 'Status',
                    width: '10%',
                    type: 'checkbox',
                    values: { 'false': 'Passive', 'true': 'Active' },
                    defaultValue: 'true',
                    display: function (data) {
                        return data.record.status;
                    }
				},
				date : {
					title : 'Date',
					width : '10%',
					edit : true,
					type : 'date',
					displayFormat : 'yy-mm-dd',
					display: function (data) {
                        return data.record.date;
                    }
				},
				
				Challenges: {
                    title: 'C',
                    width: '5%',
                    sorting: false,
                    edit: false,
                    create: false,
                    display: function (goalData) {
                        //Create an image that will be used to open child table
                        var $img = $('<img src="./img/list.png" title="Edit Challenges" />');
                        //Open child table when user clicks the image
                        $img.click(function () {
                            $('#GoalTableContainer').jtable('openChildTable',
                                    $img.closest('tr'),
                                    {
                                        title: goalData.record.goalCode + ' - Challenges',
                                        actions: {
                                        	listAction: 'RetrieveChallenge?goalCode=' + goalData.record.goalCode,
                                        	createAction:function () {
                                            	return $.Deferred(function($dfd) {
                                               		var formData = new FormData(document.forms[0]);
                                                	$.ajax({
                                                    	url: 'CreateChallenge',
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
                                                    	url: 'UpdateChallenge',
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
                                        	deleteAction: 'DeleteChallenge'
                                        },
                                        fields: {
                                            goalCode: {
                                                type: 'hidden',
                                                defaultValue: goalData.record.goalCode
                                            },
                                            challengeId: {
                                                key: true,
                                                width : '5%',
                            					key : true,
                            					list : true,
                            					create : false
                                            },
                                            actionCode: {
                                                title: 'Action Code',
                                                width: '10%',
                                                edit: true
                                            },
                                            story : {
                            					title : 'Stroy',
                            					width : '40%',
                            					edit : true
                            				},
                            				expiryDate : {
                            					title : 'Exp Date',
                            					width : '10%',
                            					edit : true,
                            					type : 'date',
                            					displayFormat : 'yy-mm-dd',
                            					display: function (data) {
                                                    return data.record.expiryDate;
                                                }
                            				},
                            				image : {
                            					title : 'Image',
                            					width : '20%',
                            					edit : true,
                            					input: function (data) {
                            						return '<input type="file" name="image" id="image" />';
                            					}
                            				},
                            				points : {
                            					title : 'Points',
                            					width : '10%',
                            					edit : true
                            				},
                            				occurrence : {
                            					title : 'Occurrence',
                            					width : '10%',
                            					edit : true
                            				},
                            				badgeCode: {
                                            	title: 'Badge',
                                                width: '20%',
                                                edit: true,
                                                options : 'RetrieveBadge?badge=badge',
                                                display: function (data) {
                                                    return data.record.badgeCode;
                                                }
                                            },
                                            rewardCode: {
                                            	title: 'Reward',
                                                width: '20%',
                                                edit: true,
                                                options : 'RetrieveReward?reward=reward',
                                                display: function (data) {
                                                    return data.record.reward;
                                                }
                                            },
                                            date : {
                            					title : 'Date',
                            					width : '20%',
                            					edit : true,
                            					type : 'date',
                            					displayFormat : 'yy-mm-dd',
                            					display: function (data) {
                                                    return data.record.date;
                                                }
                            				}
                                        },
                                        
                                    }, function (data) { //opened handler
                                        data.childTable.jtable('load');
                                    });
                        });
                        //Return image to show on the person row
                        return $img;
                    }
                },
				
                Levels: {
                    title: 'L',
                    width: '5%',
                    sorting: false,
                    edit: false,
                    create: false,
                    display: function (goalData) {
                        //Create an image that will be used to open child table
                        var $img = $('<img src="./img/list.png" title="Edit Challenges" />');
                        //Open child table when user clicks the image
                        $img.click(function () {
                            $('#GoalTableContainer').jtable('openChildTable',
                                    $img.closest('tr'),
                                    {
                                        title: goalData.record.goalCode + ' - Levels',
                                        actions: {
                                        	listAction: 'RetrieveLevel?goalCode=' + goalData.record.goalCode,
                                        	createAction:function () {
                                            	return $.Deferred(function($dfd) {
                                               		var formData = new FormData(document.forms[0]);
                                                	$.ajax({
                                                    	url: 'CreateLevel',
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
                                                    	url: 'UpdateLevel',
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
                                        	deleteAction: 'DeleteLevel'
                                        },
                                        fields: {
                                            goalCode: {
                                                type: 'hidden',
                                                defaultValue: goalData.record.goalCode
                                            },
                                            levelId: {
                                            	width : '10%',
                            					key : true,
                            					list : true,
                            					create : false
                                            },
                                            levelCode: {
                                                title: 'Level Code',
                                                width: '30%',
                                                edit: true
                                            },
                                            story : {
                            					title : 'Stroy',
                            					width : '40%',
                            					edit : true
                            				},
                            				image : {
                            					title : 'Image',
                            					width : '20%',
                            					edit : true,
                            					input: function (data) {
                            						return '<input type="file" name="image" id="image" />';
                            					}
                            				},
                            				name : {
                            					title : 'Name',
                            					width : '20%',
                            					edit : true
                            				},
                            				startPoint : {
                            					title : 'D point',
                            					width : '20%',
                            					edit : true
                            				},
                            				endPoint : {
                            					title : 'Da point',
                            					width : '20%',
                            					edit : true
                            				},
                            				priority : {
                            					title : 'Priority',
                            					width : '20%',
                            					edit : true
                            				},
                                            badgeCode: {
                                            	title: 'Badge Code',
                                                width: '30%',
                                                edit: true,
                                                options : 'RetrieveBadge?badge=badge',
                                                display: function (data) {
                                                    return data.record.badgeCode;
                                                }
                                            },
                                            rewardCode: {
                                            	title: 'Reward',
                                                width: '30%',
                                                edit: true,
                                                options : 'RetrieveReward?reward=reward',
                                                display: function (data) {
                                                    return data.record.reward;
                                                }
                                            },
                                            date : {
                            					title : 'Date',
                            					width : '40%',
                            					edit : true,
                            					type : 'date',
                            					displayFormat : 'yy-mm-dd',
                            					display: function (data) {
                                                    return data.record.date;
                                                }
                            				}
                                        },
                                       
                                    }, function (data) { //opened handler
                                        data.childTable.jtable('load');
                                    });
                        });
                        //Return image to show on the person row
                        return $img;
                    }
                },
                
                Badges: {
                    title: 'B',
                    width: '5%',
                    sorting: false,
                    edit: false,
                    create: false,
                    display: function (goalData) {
                        //Create an image that will be used to open child table
                        var $img = $('<img src="./img/list.png" title="Edit Challenges" />');
                        //Open child table when user clicks the image
                        $img.click(function () {
                            $('#GoalTableContainer').jtable('openChildTable',
                                    $img.closest('tr'),
                                    {
                                        title: goalData.record.goalCode + ' - Badges',
                                        actions: {
                                        	listAction: 'RetrieveBadge?goalCode=' + goalData.record.goalCode,
                                        	createAction:function () {
                                            	return $.Deferred(function($dfd) {
                                               		var formData = new FormData(document.forms[0]);
                                                	$.ajax({
                                                    	url: 'CreateBadge',
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
                                                    	url: 'UpdateBadge',
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
                                        	deleteAction: 'DeleteBadge'
                                        },
                                        fields: {
                                            goalCode: {
                                                type: 'hidden',
                                                defaultValue: goalData.record.goalCode
                                            },
                                            badgeId: {
                                            	width : '10%',
                            					key : true,
                            					list : true,
                            					create : false
                                            },
                                            badgeCode: {
                                                title: 'Badge Code',
                                                width: '30%',
                                                edit: true
                                            },
                                            story : {
                            					title : 'Stroy',
                            					width : '40%',
                            					edit : true
                            				},
                            				image : {
                            					title : 'Image',
                            					width : '20%',
                            					edit : true,
                            					input: function (data) {
                            						return '<input type="file" name="image" id="image" />';
                            					}
                            				},
                            				name : {
                            					title : 'Name',
                            					width : '20%',
                            					edit : true
                            				},
                            				expiryDate : {
                            					title : 'Exp Date',
                            					width : '40%',
                            					edit : true,
                            					type : 'date',
                            					displayFormat : 'yy-mm-dd',
                            					display: function (data) {
                                                    return data.record.expiryDate;
                                                }
                            				},
                            				date : {
                            					title : 'Date',
                            					width : '40%',
                            					edit : true,
                            					type : 'date',
                            					displayFormat : 'yy-mm-dd',
                            					display: function (data) {
                                                    return data.record.date;
                                                }
                            				}
                                        },
                                    }, function (data) { //opened handler
                                        data.childTable.jtable('load');
                                    });
                        });
                        //Return image to show on the person row
                        return $img;
                    }
                },
                
                Rewards: {
                    title: 'R',
                    width: '5%',
                    sorting: false,
                    edit: false,
                    create: false,
                    display: function (goalData) {
                        //Create an image that will be used to open child table
                        var $img = $('<img src="./img/list.png" title="Edit Rewards" />');
                        //Open child table when user clicks the image
                        $img.click(function () {
                            $('#GoalTableContainer').jtable('openChildTable',
                                    $img.closest('tr'),
                                    {
                                        title: goalData.record.goalCode + ' - Rewards',
                                        actions: {
                                        	listAction: 'RetrieveReward?goalCode=' + goalData.record.goalCode,
                                        	createAction:function () {
                                            	return $.Deferred(function($dfd) {
                                               		var formData = new FormData(document.forms[0]);
                                                	$.ajax({
                                                    	url: 'CreateReward',
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
                                                    	url: 'UpdateReward',
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
                                        	deleteAction: 'DeleteReward'
                                        },
                                        fields: {
                                            goalCode: {
                                                type: 'hidden',
                                                defaultValue: goalData.record.goalCode
                                            },
                                            rewardId: {
                                            	width : '10%',
                            					key : true,
                            					list : true,
                            					create : false
                                            },
                                            rewardCode: {
                                                title: 'Reward Code',
                                                width: '30%',
                                                edit: true
                                            },
                                            story : {
                            					title : 'Stroy',
                            					width : '40%',
                            					edit : true
                            				},
                            				image : {
                            					title : 'Image',
                            					width : '20%',
                            					edit : true,
                            					input: function (data) {
                            						return '<input type="file" name="image" id="image" />';
                            					}
                            				},
                            				name : {
                            					title : 'Name',
                            					width : '20%',
                            					edit : true
                            				},
                            				expiryDate : {
                            					title : 'Exp Date',
                            					width : '40%',
                            					edit : true,
                            					type : 'date',
                            					displayFormat : 'yy-mm-dd',
                            					display: function (data) {
                                                    return data.record.expiryDate;
                                                }
                            				},
                            				date : {
                            					title : 'Date',
                            					width : '40%',
                            					edit : true,
                            					type : 'date',
                            					displayFormat : 'yy-mm-dd',
                            					display: function (data) {
                                                    return data.record.date;
                                                }
                            				}
                                        },
                                    }, function (data) { //opened handler
                                        data.childTable.jtable('load');
                                    });
                        });
                        //Return image to show on the person row
                        return $img;
                    }
                }
			}
		});
		
		$('#UserTableContainer').jtable({
			title : 'User',
			openChildAsAccordion: true,
			actions : {
				listAction : 'RetrieveUser',
				createAction:function () {
                	return $.Deferred(function($dfd) {
                   		var formData = new FormData(document.forms[0]);
                    	$.ajax({
                        	url: 'CreateUser',
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
            	deleteAction: 'DeleteUser',
            	updateAction:function () {
                	return $.Deferred(function($dfd) {
                   		var formData = new FormData(document.forms[0]);
                    	$.ajax({
                        	url: 'UpdateUser',
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
			},
			fields : {
                userId : {
					title : 'User Id',
					width : '10%',
					key : true,
					list : true,
					create : false
				},
				userCode : {
					title : 'Goal Code',
					width : '10%',
					edit : true
				},
				name : {
					title : 'Name',
					width : '20%',
					edit : true
				},
				nickName : {
					title : 'Nick Name',
					width : '20%',
					edit : true
				},
				userType : {
					title: 'U-channel',
                    width: '10%',
                    edit: true,
                    options : 'RetrieveUserChannel?channel=channel',
                    display: function (data) {
                        return data.record.userType;
                    }
				},
				image : {
					title : 'Image',
					width : '20%',
					edit : true,
					input: function (data) {
						return '<input type="file" name="image" id="image" />';
					}
				},
				status : {
					title: 'Status',
                    width: '10%',
                    type: 'checkbox',
                    values: { 'false': 'Passive', 'true': 'Active' },
                    defaultValue: 'true',
                    display: function (data) {
                        return data.record.status;
                    }
				},
				date : {
					title : 'Date',
					width : '10%',
					edit : true,
					type : 'date',
					displayFormat : 'yy-mm-dd',
					display: function (data) {
                        return data.record.date;
                    }
				},	
			}
		});
		
		
		$('#GoalTableContainer').jtable('load');
		$('#UserTableContainer').jtable('load');
	});
</script>

</head>
<body>
	<div
		style="width: 80%; margin-right: 10%; margin-left: 10%; text-align: center;">
		<h4>Goal </h4>
		<div id="GoalTableContainer"></div>
	</div>
	<br>
	<br>
	<br>
	<div
		style="width: 80%; margin-right: 10%; margin-left: 10%; text-align: center;">
		<h4>User </h4>
		<div id="UserTableContainer"></div>
	</div>
</body>
</html>