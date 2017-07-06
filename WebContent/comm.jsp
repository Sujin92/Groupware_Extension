<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.moaware.member.model.*"%>
<%@ include file="/common/member_header.jsp"%>
<%
	String root1 = request.getContextPath();
	MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link href='<%=root1%>/css/fullcalendar.css' rel='stylesheet' />
<link href='<%=root1%>/css/fullcalendar.print.css' rel='stylesheet'
	<script src='<%=root1%>/js/lib/moment.min.js' charset="utf-8"></script>
	media='print' />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
	

<script>
	function freedateselector() {
		document.fddate.action = "<%=root%>/ScheduleController";
		document.fddate.submit();
	}
	;
</script>

<script>
	var d;
	$(document).ready(function() {
		$('#datepicker').datepicker({
			inline : true,
			onSelect : function(dateText, inst) {

				var formatdate = $.datepicker.formatDate("yy-mm-dd", new Date(dateText));



				$.ajax({
					type : 'post',
					success : function() {

						$("#dalToInsert #daytDate").val(Date(dateText));

					}
				});
			}
		});
	});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>


<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<form name="fddate" id="fddate" method="post" action="">
				<input type="hidden" name="act" value="freedate"> 
				<input type="hidden" name="id" value="<%=member.getEmp_num()%>"> 
				<input type="hidden" name="fds" value="1">
\
				<center>
				
					<div id='calendar' style="float: right;"></div>

				</center>

			</form>
	</body>
</html>
















