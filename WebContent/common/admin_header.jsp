<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
String root = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>MOAWARE</title>
<!-- Bootstrap Core CSS -->
<link href="<%=root%>/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="<%=root%>/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="<%=root%>/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="<%=root%>/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<!-- jQuery -->
<script src="<%=root%>/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<%=root%>/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="<%=root%>/vendor/metisMenu/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="<%=root%>/dist/js/sb-admin-2.js"></script>
</head>
<body>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0; background-color:#46B692;">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar" style="background-color: white"></span> <span
					class="icon-bar" style="background-color: white"></span> <span
					class="icon-bar" style="background-color: white"></span>
			</button>
			<a class="navbar-brand" href="index.html" style="color: white;">MOAWARE</a>
		</div>
		<!-- /.navbar-header -->

		<ul class="nav navbar-top-links navbar-right">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#" style="background-color: #46B692">
					<i class="fa fa-envelope fa-fw" style="color: white"></i> <i
					class="fa fa-caret-down" style="color: white"></i>
			</a>
				<ul class="dropdown-menu dropdown-messages">
					<li><a href="#">
							<div>
								<strong>권성준</strong> <span class="pull-right text-muted">
									<em>Yesterday</em>
								</span>
							</div>
							<div>쪽지가 왔어요</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<strong>엄호진</strong> <span class="pull-right text-muted">
									<em>Today</em>
								</span>
							</div>
							<div>안녕하세요</div>
					</a></li>
					<li class="divider"></li>
					<li><a class="text-center" href="#"> <strong>Read
								All Messages</strong> <i class="fa fa-angle-right"></i>
					</a></li>
				</ul> <!-- /.dropdown-messages --></li>

			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#" style="background-color: #46B692">
					<i class="fa fa-tasks fa-fw" style="color: white"></i> <i
					class="fa fa-caret-down" style="color: white"></i>
			</a>
				<ul class="dropdown-menu dropdown-tasks">
					<li><a href="#">
							<div>
								<p>
									<strong>Task 1</strong> <span class="pull-right text-muted">40%
										Complete</span>
								</p>
								<div class="progress progress-striped active">
									<div class="progress-bar progress-bar-success"
										role="progressbar" aria-valuenow="40" aria-valuemin="0"
										aria-valuemax="100" style="width: 40%">
										<span class="sr-only">40% Complete (success)</span>
									</div>
								</div>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<p>
									<strong>Task 2</strong> <span class="pull-right text-muted">20%
										Complete</span>
								</p>
								<div class="progress progress-striped active">
									<div class="progress-bar progress-bar-info" role="progressbar"
										aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"
										style="width: 20%">
										<span class="sr-only">20% Complete</span>
									</div>
								</div>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<p>
									<strong>Task 3</strong> <span class="pull-right text-muted">60%
										Complete</span>
								</p>
								<div class="progress progress-striped active">
									<div class="progress-bar progress-bar-warning"
										role="progressbar" aria-valuenow="60" aria-valuemin="0"
										aria-valuemax="100" style="width: 60%">
										<span class="sr-only">60% Complete (warning)</span>
									</div>
								</div>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<p>
									<strong>Task 4</strong> <span class="pull-right text-muted">80%
										Complete</span>
								</p>
								<div class="progress progress-striped active">
									<div class="progress-bar progress-bar-danger"
										role="progressbar" aria-valuenow="80" aria-valuemin="0"
										aria-valuemax="100" style="width: 80%">
										<span class="sr-only">80% Complete (danger)</span>
									</div>
								</div>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a class="text-center" href="#"> <strong>See
								All Tasks</strong> <i class="fa fa-angle-right"></i>
					</a></li>
				</ul> <!-- /.dropdown-tasks --></li>

			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#" style="background-color: #46B692">
					<i class="fa fa-bell fa-fw" style="color: white"></i> <i
					class="fa fa-caret-down" style="color: white"></i>
			</a>
				<ul class="dropdown-menu dropdown-alerts">
					<li><a href="#">
							<div>
								<i class="fa fa-comment fa-fw"></i> New Comment <span
									class="pull-right text-muted small">4 minutes ago</span>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<i class="fa fa-twitter fa-fw"></i> 3 New Followers <span
									class="pull-right text-muted small">12 minutes ago</span>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<i class="fa fa-envelope fa-fw"></i> Message Sent <span
									class="pull-right text-muted small">4 minutes ago</span>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<i class="fa fa-tasks fa-fw"></i> New Task <span
									class="pull-right text-muted small">4 minutes ago</span>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<i class="fa fa-upload fa-fw"></i> Server Rebooted <span
									class="pull-right text-muted small">4 minutes ago</span>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a class="text-center" href="#"> <strong>See
								All Alerts</strong> <i class="fa fa-angle-right"></i>
					</a></li>
				</ul> <!-- /.dropdown-alerts --></li>

			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#" style="background-color: #46B692">
					<i class="fa fa-user fa-fw" style="color: white"></i> <i
					class="fa fa-caret-down" style="color: white"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="#"><i class="fa fa-user fa-fw"></i> User
							Profile</a></li>
					<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a></li>
					<li class="divider"></li>
					<li><a href="login.html"> <i class="fa fa-sign-out fa-fw"></i>
							Logout
					</a></li>
				</ul> <!-- /.dropdown-user --></li>
			<!-- /.dropdown -->
		</ul>
		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar" role="navigation">
			<div id="sidebar-search">
				<h3 id="title" style="color: white">Sungjun - Gwon</h3>
				<p style="color: white">@ Web Developer</p>
				<p style="color: white">- kakao develop "A" team</p>
			</div>
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					
					<li><a href="index.html" style="backgrouncolor: #46B692">
							<i class="fa fa-dashboard fa-fw" style="color: #46B692"></i> HOME
					</a></li>
				
					<li><a href="#" style="color: white"> <i
							class="fa fa-sitemap fa-fw" style="color: #46B692"></i> 관리자 메뉴 <span
							class="fa arrow"></span>
					</a>
						<ul class="nav nav-second-level">
							<li><a href="<%=root%>/memberRegister?act=mvregister" style="color: white"> 사원등록</a></li>
							<li><a href="#" style="color: white"> 회사정보관리
							<span class="fa arrow"></span>
							</a>
								<ul class="nav nav-third-level">
									<li><a href="<%=root%>/comInfo?act=deptList">부서관리</a></li>
									<li><a href="<%=root%>/comInfo?act=holdList&pg=1">사원정보관리</a></li>
								</ul> <!-- /.nav-third-level -->
							</li>
							<li><a href="#" style="color: white"> 업무지원
							<span class="fa arrow"></span>
							</a>
								<ul class="nav nav-third-level">
									<li><a href="#">전자결재관리</a></li>
									<li><a href="#">근태관리</a></li>
									<li><a href="#">전자결재</a></li>
								</ul> <!-- /.nav-third-level -->
							</li>
						</ul> <!-- /.nav-second-level -->
					</li>
				
					<li><a href=# style="color: white"> <!-- 글자 앞의 아이콘 --> <i
							class="fa fa-table fa-fw" style="color: #46B692"></i> 마이페이지 <!-- < 화살표 -->
							<span class="fa arrow" style="color: #46B692"></span>
					</a>
						<ul class="nav nav-second-level">
							<li><a href="morris.html" style="color: white">회원정보 </a></li>
						</ul> <!-- /.nav-second-level -->
					</li>

					<li><a href="#" style="color: white"> <!-- 글자 앞의 아이콘 --> <i
							class="fa fa-bar-chart-o fa-fw" style="color: #46B692"></i> 캘린더 <!-- < 화살표 -->
							<span class="fa arrow" style="color: #46B692"></span>
					</a>
						<ul class="nav nav-second-level">
							<li><a href="calendarindex.jsp" style="color: white">일정관리</a></li>
							<li><a href="morris.html" style="color: white">근태관리</a></li>
						</ul> <!-- /.nav-second-level --></li>

					<li><a href="tables.html" style="color: white"> <i
							class="fa fa-table fa-fw" style="color: #46B692"></i> 조직도 & 주소록
					</a></li>

					<li><a href="forms.html" style="color: white"> <i
							class="fa fa-edit fa-fw" style="color: #46B692"></i> 전자결재
					</a></li>

					<li><a href="#" style="color: white"> <i
							class="fa fa-wrench fa-fw" style="color: #46B692"></i> 게시판 <span
							class="fa arrow"></span>
					</a>
						<ul class="nav nav-second-level">
							<li><a href="panels-wells.html" style="color: white">공지사항</a></li>
							<li><a href="notifications.html" style="color: white">Q&A</a></li>
							<li><a href="typography.html" style="color: white">부서별
									게시판</a></li>
							<li><a href="icons.html" style="color: white">FAQ</a></li>
						</ul> <!-- /.nav-second-level --></li>

					<li><a href="#" style="color: white"> <i
							class="fa fa-sitemap fa-fw" style="color: #46B692"></i> 프로젝트 관리 <span
							class="fa arrow"></span>
					</a>
						<ul class="nav nav-second-level">
							<li><a href="#" style="color: white">Todo</a></li>
						</ul> <!-- /.nav-second-level --></li>

					<li><a href="#" style="color: white"> <i
							class="fa fa-files-o fa-fw" style="color: #46B692"></i> 메신저 <span
							class="fa arrow"></span>
					</a>
					</li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side -->
		</nav>