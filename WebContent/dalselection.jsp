<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.moaware.member.model.*"%>
<%@ include file="/common/member_header.jsp"%>
<%
	String root1 = request.getContextPath();
MemberDto memberDto = (MemberDto)session.getAttribute("loginInfo"); 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link href='<%=root1%>/css/fullcalendar.css' rel='stylesheet' />
<link href='<%=root1%>/css/fullcalendar.print.css' rel='stylesheet'
	<script src='<%=root1%>/js/lib/moment.min.js' charset="utf-8"></script>
	media='print' />
<script>
function freedateselector(){


document.fddate.action = "<%=root%>/ScheduleController";
document.fddate.submit();
};

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
		
		<!-- 	<input type="hidden" name="dayDate" value="">
			<input type="hidden" name="title" value="">
			<input type="hidden" name="content" value="">
		 -->
				<center>


					Date:
					<div id="datepicker" style="float: left;"></div>


					<div id="dalToInsert" style="float: left;">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header"
									style="font-size: 20px; text-align: center;">

									<!-- <button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">x</span> <span class="sr-only">close</span>
						</button>
 -->

									<div>
										<h1>
											<center>- 근태 입력 -</center>
										</h1>
									</div>
									<br> <br>
									<h4 id="modalTitle" class="modal-title">
										날짜 : &nbsp&nbsp<input type="text" name="daytDate"
											id="daytDate" style="text-align: center;">
									</h4>

								</div>
								<div id="modalBody" class="modal-body">
									<h3>제목 :</h3>
									<br> <input type="text" size="67" name="title" id="title">
								</div>
								<div id="modalBody" class="modal-body">
									<h3>내용 :</h3>
									<textarea name="content" id="content" cols="70"> </textarea>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
									<button class="btn btn-primary" id="insertEvent" onclick="javascript:freedateselector();">Insert</button>
									<!-- 누르면 고유번호 가 휴가로 강제로 주고 세션 id 값이랑 나머지들이 캘린더로 넘어가야함 -->
								</div>
							</div>
						</div>
					</div>


				</center>

			</form>
			</body>
</html>
















