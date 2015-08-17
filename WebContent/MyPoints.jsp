<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<div class="col-md-4 pull-left">
						<div class="row well">

							<ul id="myTab" class="nav nav-tabs">
								<li class="active"><a href="#pointsmonth" data-toggle="tab">
										This Month </a></li>
								<li><a href="#pointswhole" data-toggle="tab">All Time</a></li>
							</ul>
							<div id="myTabContent" class="tab-content">
								<div class="tab-pane fade in active" id="pointsmonth">
									<div class="row">
										<div class="col-sm-6">
											<h2>Points</h2>
										</div>
										<div class="col-sm-6">
											<h1>
												<label id="CurrentMonthPoint"></label>
											</h1>
										</div>
									</div>
								</div>

								<div class="tab-pane fade" id="pointswhole">
									<div class="row">
										<div class="col-sm-6">
											<h2>Points</h2>
										</div>

										<div class="col-sm-6">
											<h1>
												<label id="AllTimePoint"></label>
											</h1>
										</div>
									</div>
								</div>
							</div>
						</div></div>
</div>
</body>
</html>