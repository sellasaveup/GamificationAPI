<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<head>
<title>My Goals</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="./css/bootstrap.min.css">
<script src="./js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="./js/jquery.blockUI.js" type="text/javascript"></script>
<script src="./js/bootstrap.min.js" type="text/javascript"></script>
<script src="./js/session.js"></script>
<title>challenges</title>
<script type="text/javascript">

 
	$(document).ready(function() {
		
	});

	function funcOnChange(selectedGoal) {
		localStorage.setItem("sessionGoalCode", selectedGoal);
		$("#myGoalFormId").submit();
	}
</script>

</head>
<style>
.tool {
	width: 70px;
	height: 16px;
	overflow: hidden;
	position: absolute;
	left: 50%;
	margin-left: -35px;
	background-color: #c6e5f6;
	background: #CABA75;
	color: black;
	font-size: 11px;
}

</style>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
<form action="MasterTemplate.jsp" method="post" id="myGoalFormId">
	<div class="container">
		<div class="row well">
			<div class="col-sm-12">
				<center>
					<h2>Select a Goal</h2>
				</center>
			</div>
		</div>
		<div class="row well">
			<div class="col-sm-4">
				<label class="radio-inline"><input type="radio"
					id="hype" name="goalType" value="HYPE_GOAL" onchange="funcOnChange(this.value)">Hype</label>
			</div>
			<div class="col-sm-4">
				<label class="radio-inline"><input type="radio"
					id="townHallMeet" value="INTRANET_GOAL" name="goalType" onchange="funcOnChange(this.value)">Intranet</label>
			</div>
			<div class="col-sm-4">
				<label class="radio-inline"><input type="radio"
					id="pdu" value="PDU_GOAL" name="goalType" onchange="funcOnChange(this.value)">PDU</label>
			</div>
		</div>
		<br>
		<hr>
	</div>
	</form>
	<script>
	$(document).ready(function() {
		 $('#myGoalFormId').click(function() { 
		        $.blockUI({ 
		            message: $('div.growlUI'), 
		            fadeIn: 700, 
		            fadeOut: 700, 
		            timeout: 2000, 
		            showOverlay: false, 
		            centerY: false, 
		            css: { 
		                width: '350px', 
		                top: '10px', 
		                left: '', 
		                right: '10px', 
		                border: 'none', 
		                padding: '5px', 
		                backgroundColor: '#000', 
		                '-webkit-border-radius': '10px', 
		                '-moz-border-radius': '10px', 
		                opacity: .6, 
		                color: '#fff' 
		            } 
		        }); 
		    }); 
	});
	</script>
</body>
</html>
