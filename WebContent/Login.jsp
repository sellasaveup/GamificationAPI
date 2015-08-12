<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Login Page</title>

<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/loginprofile.css" rel="stylesheet">
<link rel="stylesheet" href="css/style.css">
    
<style type="text/css">
body {background: #04B486;}
.headstyle { background: #F2F2F2; font: normal small-caps normal 75px/1.4 Georgia; color: #086A87;}
.signstyle {  font: normal small-caps normal 25px/1.4 Georgia; color: #086A87;}
.userstyle {  font: normal small-caps normal 25px/1.4 Arial; color: black;}
.submitstyle {  font-family: "Times New Roman", Georgia, Serif; font: 22px/1.4 Arial; color: white;}
p::before { 
  content: "Gamification";
  color: black;
}
    
</style>
</head>
<body bgcolor="#E6E6FA">
<div class="wrapper">
<div class="container" >
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	
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
					<li class="active"><a href="#home">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
			</div>
        
			<p class="headstyle"> Framework<img src="img/logo/logo.gif" width="250"></p>
	</div>

		<div class="starter-template well"  >
			

			<form id="myForm" class="form-inline" action="MasterTemplate.jsp" method="post" >
				<div class="form-group">
				<div class="row">
						<div class="col-sm-12 border"><center><h3 class="signstyle">Sign In</h3></center></div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-12">
							<input type="text" 
								class="form-control" id="custId" name="custId" placeholder="UserCode">
						</div>
					</div><br>
					<div class="row">
						<div class="col-sm-12">
							<button id="loginsubmit" type="submit" class="btn btn-primary" ><span class="submitstyle">Submit</span></button>
						</div>
					</div>
					<br>
				</div>
					

			</form>
		</div>
		 <div class="navbar navbar-fixed-bottom">Sella Saveup @ Banca sella 2015</div>
	</div>
        <ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul></div>
	<script src="./js/bootstrap.min.js"></script>
	<script src="./js/jquery.min.js" type="text/javascript"></script>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</body>
</html>