
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">


    <link rel="stylesheet" href="http://getbootstrap.com/dist/css/bootstrap.min.css" />
    <link href="./css/loginprofile.css" rel="stylesheet">
    

   
    

    <style>
    
    .lineheight {
        line-height: 3em;
    }
   
    .initialism {
        font-weight: bold;
        letter-spacing: 1px;
        font-size: 12px;
    }
    p::before { 
  content: "Gamification";
  color: black;
}
body {background: #336699;}
.headstyle { background: #F2F2F2; font: normal small-caps normal 75px/1.4 Georgia; color: #086A87;}
.signstyle {  font: normal small-caps normal 25px/1.4 Georgia; color: white;}
.registerstyle {  font: normal 25px/1.4 Georgia; color: white; align:left;}


.userstyle {  font: normal small-caps normal 25px/1.4 Arial; color: black;}
.submitstyle {  font-family: "Times New Roman", Georgia, Serif; font: 22px/1.4 Arial; color: white;}
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
</head>
<body>
<div class="wrapper">
<div class="container" >
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	
			<div class="navbar-header">
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a class="navbar-brand" href="#">Welcome to Gami world<span class="icon-wink"></span></a>
				</ul>
			</div>
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				
			</div>
			
        
			<p class="headstyle"> Framework<img src="img/logo/logo.gif" width="250"></p>
	</div>
	<div  >
			

			<form id="myForm"  action="MasterTemplate.jsp" method="post" >
				<div class="form-group" >
				<div class="row">
						<div class="col-sm-12 border"><center><h3 class="signstyle">Sign In</h3></center></div>
					</div>
					<br>
					
					
			
					<div class="row">
						<div class="col-sm-12">
							<input type="text" placeholder="UserCode">
						</div>
					</div><br>
					<div class="row">
						<div class="col-sm-12">
							<button type="submit"><span>Submit</span></button>
						</div>
					</div>
					<br>
					
					
					<br>
				</div>
					<div>
<div>
<section class="col-md-10 col-md-offset-1">


        <span class="lineheight">
            
            <a class="initialism registerform_open" href="#registerform" style="color:white;font-size: 15px;">Register in GF</a>
            
        </span>

     
    </section>
    </div>
   

</div>

			</form>
			
		</div>
		
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
		<li></li>
	</ul>
	   
	
	</div>
    

<!-- Fade & scale -->

<div id="registerform" class="well">
    <h4 style="color:black">Register in GF</h4>
    <pre class="prettyprint">
    <table>
    <tr>
    <td>Enter GBSCode</td>
     <td><input type="text" name = "userCode" id ="userCode" ><br><br></td>
     
    </tr>
    
    <tr>
    <td>Who am I ? <br></td>
     <td><select>
  <option value="ss">--Select User type--</option>
  <option value="employee">Employee</option>
  <option value="customer">Customer</option>
  <option value="trainee">Trainee</option>
  <option value="branchUser">Branch user</option>
</select><br><br></td>
    </tr>
    <tr>
    <td>Nick Name  </td>
     <td><input type="text" name = "nickName" id ="nickName" ><br><br></td>
    </tr>
    <tr>
    <td>Avatar</td>
     <td><button type="submit" class="btn btn-primary start">
                    <i class="glyphicon glyphicon-upload"></i>
                    <span>Start upload</span>
                </button><br><br></td>
    </tr>
    <tr>
    <td>Status Message  </td>
     <td><input type="text" name = "statusMsg" id ="statusMsg" ><br></td>
    </tr>


</table>
</pre>

    <button class="registerform_close slide_open btn btn-default">Check IN</button>
    <button class="registerform_close btn btn-default">Close</button>
</div>

<script>
$(document).ready(function () {

    $('#registerform').popup({
        pagecontainer: '.container',
        transition: 'all 0.3s'
    });

});
</script>


 <script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>

    <script src="./js/jquery.popupoverlay.js"></script>
    <script src="./js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
