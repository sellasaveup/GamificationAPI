<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Master Template</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		
		<link href="./css/bootstrap.min.css" rel="stylesheet">
		
		<link href="./css/masterpage.css" rel="stylesheet">
		<link href="./css/glphycons.css" rel="stylesheet">
			<script src="./js/jquery.min.js"></script>
		
		
<script>

      function loadMyPoints() {
    	  $("#content").load("MyPoints.jsp");
      }
      
      function loadMyBadges() {
    	  $("#content").load("MyBadges.jsp");
      }
      
      function loadChallenges() {
    	  $("#content").load("Challenges.jsp");
      }
      
      function loadMyRewards() {
    	  $("#content").load("MyRewards.jsp");
      }
      
      function loadAdminMaster() {
    	  $("#content").load("index.jsp");
      }
      
      function loadAwardNotify() {
    	  $("#content").load("notification.jsp");
      }
      
</script>
	</head>
	<body>
<!-- header -->
<div id="top-nav" class="navbar navbar-inverse navbar-static-top">
        <input type="hidden" name="custId" id="custId" value="<%=request.getParameter("custId") %>"   />

    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Gamification Framework</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
             
                <li><a href="#"><i class="glyphicon glyphicon-gift"></i></a></li>
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-globe"></i><span class="count">3</span></a>
                </li>
                <li><a href="#"><i class="glyphicon glyphicon-off"></i> Logout</a></li>
                
            
            </ul>
        </div>
    </div>
    <!-- /container -->
</div>
<!-- /Header -->

<!-- Main -->
<div class="container-fluid">
<div class="row">

</div>
    <div class="row">
        <div class="col-sm-2 profile-sidebar">
        
        
				<div class="profile-userpic">
					<img src="./img/profile/albert-einstein.jpg" class="img-responsive" alt="">
				</div>
				
				<div class="profile-usertitle">
					<div class="profile-usertitle-name">
						Ciao,Federico!
					</div>
					<div class="btn btn-warning"><img src="./img/banners/crown.png" width="12px" height="12px">&nbsp;
						<font><b>Gold</b></font>
					</div>
				</div>
				<br>
				<div class="well">
					<article style="align:center" class = "btn-sm profile-usertitle-job"><img src="./img/banners/coins.png" width="12px" height="12px">Total Points&nbsp;&nbsp;&nbsp;12875&euro;</article>
					
					<article style="align:center" class = "btn-sm profile-usertitle-job"><img src="./img/banners/coins.png" width="12px" height="12px">Redeemed Points&nbsp;&nbsp;&nbsp;12874&euro;</article>
					
					<article style="align:center" class = "btn-sm profile-usertitle-job"><img src="./img/banners/coins.png" width="12px" height="12px">Redeemable Points&nbsp;&nbsp;&nbsp;1&euro;</article>
					
				</div>
      
            <!-- Left column -->

            <hr>

            <ul class="nav nav-stacked">
                <li class="nav-header"> 
                    <ul class="nav nav-stacked collapse in" id="userMenu">
                        <li class="active"> <a href="#" onclick="loadMyPoints();"><i class="glyphicon glyphicon-home"></i> My Points</a></li>
                         <li><a href="#" onclick="loadMyBadges();"><i class="glyphicon glyphicon-star-empty"></i> My Badges</a></li>
                        <li><a href="#" onclick="loadChallenges();"><i class="glyphicon glyphicon-user"></i>Challenges</a></li>
                        <li><a href="#" onclick="loadMyRewards();"><i class="glyphicon glyphicon-user"></i>My Rewards</a></li>
                        <li><a href="#" onclick="loadAdminMaster();"><i class="glyphicon glyphicon-folder-open"></i> Admin Master</a></li>
                        <li><a href="#" onclick="loadAwardNotify();"><i class="glyphicon glyphicon-envelope"></i> Award Notify <span class="badge badge-info">4</span></a></li>
                        
                    </ul>
                </li>
                
            </ul>

          </div>
        <div class="col-sm-10" id="content">

            <hr>

            <div class="row">
                
                <div class="col-md-12">

                </div>

            </div>

        </div>
    </div>
</div>
<!-- /Main -->
<div class="footer navbar-fixed-bottom">
<footer class="text-center">Banca sella, 2015.</footer>
</div>

<div class="modal" id="addWidgetModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title">Add Widget</h4>
            </div>
            <div class="modal-body">
                <p></p>
            </div>
            <div class="modal-footer">
                <a href="#" data-dismiss="modal" class="btn">Close</a>
                <a href="#" class="btn btn-primary">Save changes</a>
            </div>
        </div>
    </div>
</div>
	<!-- script references -->
	<script src="./js/bootstrap.min.js"></script>
		
	</body>
</html>