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
		<link href="./css/breadcrumbs.css" rel="stylesheet">
		
<script>

      function loadHome(){
    	  $("#content").load("AboutGami.jsp");
      }
      
      function loadProfile(){
    	  $("#content").load("MainPage.jsp");
      }
      
      function loadBadgeList(){
    	  $("#content").load("BadgeListing.jsp");
      }
      
      function loadAdminMaster(){
    	  $("#content").load("index.jsp");
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
                <li><a href="#"><i class="glyphicon glyphicon-user"></i></a></li>
                <li><a title="Add Widget" data-toggle="modal" href="#addWidgetModal"><span class="glyphicon glyphicon-plus-sign"></span> Add Widget</a></li>
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
        <div class="col-sm-2">
            <!-- Left column -->
            <a href="#"><strong><i class="glyphicon glyphicon-th"></i> DashBoard</strong></a>

            <hr>

            <ul class="nav nav-stacked">
                <li class="nav-header"> 
                    <ul class="nav nav-stacked collapse in" id="userMenu">
                        <li class="active"> <a href="#" onclick="loadHome();"><i class="glyphicon glyphicon-home"></i> Home</a></li>
                        <li><a href="#" onclick="loadProfile();"><i class="glyphicon glyphicon-user"></i>Profile</a></li>
                        <li><a href="#" onclick="loadBadgeList();"><i class="glyphicon glyphicon-star-empty"></i> My Badges</a></li>
                        <li><a href="#" onclick="loadAdminMaster();"><i class="glyphicon glyphicon-folder-open"></i> Admin Master</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-envelope"></i> Messages <span class="badge badge-info">4</span></a></li>
                        
                    </ul>
                </li>
                
            </ul>

          </div>
        <div class="col-sm-10" id="content">

       
            <div class="btn-group btn-breadcrumb">
            <a href="#" class="btn btn-primary"><i class="glyphicon glyphicon-th"></i></a>
            <a href="#" class="btn btn-primary">Gamification</a>
            <a href="#" class="btn btn-primary">Dashboard</a>
        </div>
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
	<script src="./js/jquery.min.js"></script>
		
	</body>
</html>