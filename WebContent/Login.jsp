
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    
<link rel="stylesheet" href="./css/bootstrap.min.css">

<script src="./js/jquery.min.js" type="text/javascript"></script>

    <script src="./js/jquery.popupoverlay.js"></script>
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
    
body {background: #336699;}
.headstyle { background: #F2F2F2; font: normal small-caps normal 75px/1.4 Georgia; color: #086A87;}
.signstyle {  font: normal small-caps normal 25px/1.4 Georgia; color: white;}
.registerstyle {  font: normal 25px/1.4 Georgia; color: white; align:left;}


.userstyle {  font: normal small-caps normal 25px/1.4 Arial; color: black;}
.submitstyle {  font-family: "Times New Roman", Georgia, Serif; font: 22px/1.4 Arial; color: white;}
    p::before { 
  content: "Gamification";
  color: black;
}
.transUpdate{
  -moz-border-radius:10px;
  -webkit-border-radius:10px;
  border-radius:10px;
  background: #fff; /* fallback for browsers that don't understand rgba */
  border: #solid 10px #000; /* fallback for browsers that don't understand rgba */
  background-color: rgba(255,255,255,0.8)/* slighly transparent white */
  border-color: rgba(0,0,0,0.2) /*Very transparent black*/
}
  .divspace{
   margin-right:30px;
}

        
    .roundedbox{
    border-radius: 25px;
    border: 2px solid yellow;
    width: 380px;
    height: 80px;
}

.textinbox{
    text-align: right;
    margin-top: -10px;
    height: 20px;
    line-height: 20px;
    font-size: 15px;
}

.divbackground{
    background-color: white;
}
    </style>
    
</head>
<body>

<div class="wrapper">

<div class="container">
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	
        
			<p class="headstyle"> Framework<img src="img/logo/logo.gif" width="250"></p>
	</div>
<div>
<form id="myForm"  action="MasterTemplate.jsp" method="post" >
    <div class="row">
    <div class="col-sm-6 pull-left">
			
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

   

</div>
<div>
<section class="col-md-10 col-md-offset-1">


        <span class="lineheight">
            
            <a class="initialism registerform_open" href="#registerform" style="color:white;font-size: 15px;"><b>Register in GF</b></a>
            
        </span>

     
    </section>
    </div>
    </div>&nbsp;&nbsp;
    <div class="col-sm-6 pull-right"><img src="./img/banners/activitylog.png">
    
    <div class="row"></div>

    
   
    

<span><b></b></span></div>
		</div>

			</form>
			
		
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
<div id="registerform" class="well">
    <h4 style="color:black">Register in GF</h4>
   
    <table>
    <tr>
    <td style="color:black">Enter GBSCode&nbsp;</td>
     <td><input type="text" name = "userCode" id ="userCode" ><br><br></td>
     
    </tr>
    
    <tr>
    <td style="color:black">Who am I ? </td>
     <td><select>
  <option value="select" class="selectpicker show-menu-arrow">--Select User type--</option>
  <option value="employee">Employee</option>
  <option value="customer">Customer</option>
  <option value="trainee">Trainee</option>
  <option value="branchUser">Branch user</option>
</select><br><br></td>
    </tr>
    <tr>
    <td style="color:black">Nick Name  </td>
     <td><input type="text" name = "nickName" id ="nickName" ><br><br></td>
    </tr>
    <tr>
    <td style="color:black">Avatar</td>
     <td><button type="submit" class="btn btn-primary start">
                    <i class="glyphicon glyphicon-upload"></i>
                    <span>Upload Avatar</span>
                </button><br><br></td>
    </tr>
    <tr>
    <td style="color:black">Status Message  &nbsp;</td>
     <td><input type="text" name = "statusMsg" id ="statusMsg" ><br><br></td>
    </tr>


</table>


    <button class="registerform_close slide_open btn btn-default">Check IN</button>
    <button class="registerform_close btn btn-default">Close</button>
</div>
 
</div>
<script>
$(document).ready(function () {

    $('#registerform').popup({
        pagecontainer: '.container',
        transition: 'all 0.3s'
    });

});
</script>

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

<!-- Google Prettify syntax highlighting -->


</body>
</html>
