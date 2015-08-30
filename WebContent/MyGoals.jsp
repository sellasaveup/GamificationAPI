<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<head>
<title>My Goals</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="./js/jquery.min.js"></script>
<script src="./js/jquery.popupoverlay.js"></script>

<link rel="stylesheet" href="./css/bootstrap.min.css">
<script src="./js/session.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/goalwidget.js" type="text/javascript"></script>
<style>
body {
	  background: #663366;
	  position: absolute;
	  top: 100%;
	  left: 0;
	  width: 100%;
	  height: 100%;
	  overflow: hidden;
}
</style>
<script type="text/javascript">
var commonUrl = getSessionUrl();
	
	$(document).ready(function() {
		
		var userCode = getSessionUserCode();
		getAllGoalList('goalTemplate', userCode, commonUrl);
		
		$('#registerform').popup({
			type: 'overlay',
			autoopen: true,
			background: true,
			backgroundactive: true,
			opacity: '0.1',
			horizontal: 'center',
			vertical: 'middle',
			blur: false,
			keepfocus: true,
			scrolllock: false
		});
		
		$("#ButtonSubmit").click(function() {
			
			if($('input:radio:checked').length > 0){
				var selectedGoalCode = $('.list input[type="radio"]:checked:first').val();
				localStorage.setItem("sessionGoalCode", selectedGoalCode);
				window.location.replace("MasterTemplate.jsp");
			}else{
			    alert("Please Select a Goal");
			    window.location.replace("MyGoals.jsp");
			}
		});

		$("#BackSubmit").click(function() {
			window.location.replace("Login.jsp");
		});

	});
</script>
</head>
<body>
	<div id="registerform" class="well">
		<h4 style="color: black">Select a Goal</h4>
		<div class="list">
			<div id="goalTemplate"></div>
			<table>
				<tr>
					<td colspan=2><input id="ButtonSubmit" type="button"
						class="registerform_close btn btn-default" Value="Submit">
						<input id="BackSubmit" type="button"
						class="registerform_close btn btn-default" Value="Back"></td>
				</tr>
			</table>
		</div>
	</div>
	<style>
	
#registerform {
	-webkit-transform: scale(0.8);
	-moz-transform: scale(0.8);
	-ms-transform: scale(0.8);
	transform: scale(0.8);
}

.popup_visible #registerform {
	-webkit-transform: scale(1);
	-moz-transform: scale(1);
	-ms-transform: scale(1);
	transform: scale(1);
}
</style>
</body>
</html>