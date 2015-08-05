<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Login Page</title>

<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/loginprofile.css" rel="stylesheet">

</head>
<body>
<div class="container">
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Gamification</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
			</div>
		</div>
	</div>

	
		<div class="starter-template well">
			<h1>Gamification Framework Application</h1>

			<form id="myForm" class="form-inline" action="MainPage.jsp" method="post">
				<div class="form-group">
				<div class="row">
						<div class="col-sm-12"><center><h3>Sign In</h3></center></div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-6">User Id</div>
						<div class="col-sm-6">
							<input type="text"
								class="form-control" id="customerId" name="customerId" placeholder="Id">
						</div>
					</div><br>
					<div class="row">
						<div class="col-sm-12">
							<button id="loginsubmit" type="submit" class="btn btn-primary" >Submit</button>
						</div>
					</div>
				</div>

			</form>

		</div>

	</div>
	<script src="./js/bootstrap.min.js"></script>
	<script src="./js/jquery.min.js" type="text/javascript"></script>
</body>
</html>