<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Notification Admin Page</title>
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="css/starter-template.css" rel="stylesheet">

<script>
	function getSelectedValue() {
		var elementId = document.getElementById("checkPushNotify");

		if ($("#checkPushNotify").is(':checked')) {

		}
	}

	function check() {
		var ddl = document.getElementById("awardType");
		
		var selectedValue = ddl.options[ddl.selectedIndex].value;
		if (selectedValue == "point") {
			var pointsTableHtml = "";
			pointsTableHtml = '<div class="panel panel-blue panel-primary">'
					+ '<div class="panel-heading">Points</div>'
					+ '<div class="panel-body">'
					+ '<form>'
					+ '<div class="form-group">'
					+ '<label for="custId">Customer Id</label>'
					+ '<input type="text" class="form-control" id="custId" placeholder="customer Id">'
					+ '</div>'
					+ '<div class="form-group">'
					+ '<label for="badge">Points</label>'
					+ '<input type="text" class="form-control" id="point" placeholder="point">'
					+ '</div>'
					+ '<div class="form-group">'
					+ '<label for="badge">Action</label>'
					+ '<input type="text" class="form-control" id="action" placeholder="action">'
					+ '</div>'
					+ '<button type="submit" class="btn btn-primary">Submit</button>'
					+ '</form>'
					+ '</div></div>';

					$('#tablePoints').html("");

			$("#tablePoints").append(pointsTableHtml);
			$("#tablePoints").show();
			$("#tableBadge").hide();

		} else if (selectedValue == "badge") {
			var badgeTableHtml = "";
			badgeTableHtml = '<br><div class="panel panel-red panel-primary">'
					+ '<div class="panel-heading">Badges</div>'
					+ '<div class="panel-body">'
					+ '<form>'
					+ '<div class="form-group">'
					+ '<label for="custId">Customer Id</label>'
					+ '<input type="text" class="form-control" id="custId" placeholder="customer Id">'
					+ '</div>'
					+ '<div class="form-group">'
					+ '<label for="badge">Badge</label>'
					+ '<input type="text" class="form-control" id="badge" placeholder="badge">'
					+ '</div>'
					
					+ ' <div class="control-group">'
					+ ' <label class="control-label" for="fileInput">File input</label>'
					+ '<div class="controls">'
					+ ' <input class="form-control input-file" id="fileInput" type="file">'
					+ '</div>'
					+ ' </div>'

					+ '<div class="form-group">'
					+ '<label for="badge">Action</label>'
					+ '<input type="text" class="form-control" id="action" placeholder="action">'
					+ '</div>'
					+ '<button type="submit" class="btn btn-primary">Submit</button>'
					+ '</form>'
					+ '</div></div>';

					$('#tableBadge').html("");
			$("#tableBadge").append(badgeTableHtml);
			$("#tableBadge").show();
			$("#tablePoints").hide();
			
			
		} else if (selectedValue == "") {
			$("#tablePoints").hide();
			$("#tableBadge").hide();
		}
	}
	J
</script>
</head>
<body>
	<form id="notificationForm" action="notification.jsp" method="post">
		<div class="container">

			<div class="row">
				<div class="col-sm-6">
					<label for="checkPush">Do you want to push notifications?</label>
				</div>
				<div class="col-sm-6">
					<input type="checkbox" id="checkPushNotify">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<label class="control-label">Do you want to Award?</label>
				</div>
				<div class="col-sm-3">
					<select class="form-control" name="awardType" id="awardType"
						onchange="check();">
						<option value="">Choose Type</option>
						<option value="point">Points</option>
						<option value="badge">Badge</option>
					</select>
				</div>
				<div class="col-sm-3"></div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-12">
					<center>
						<button type="button" class="btn btn-primary"
							onclick="getSelectedValue()">Submit</button>
					</center>
				</div>
			</div>
			<div id="tablePoints"></div>
			<div id="tableBadge"></div>
		</div>
	</form>


	<script src="./js/bootstrap.min.js"></script>
	<script src="./js/jquery-1.8.2.js" type="text/javascript"></script>
	<script src="./js/application.js" type="text/javascript"></script>
</body>
</html>
