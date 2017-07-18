<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="java.util.Map, java.util.List, com.moaware.admin.support.model.ScheduleDto, com.moaware.admin.cominfo.util.PageNavigation"%>
<%@ include file="/common/admin_header.jsp"%>
<%
	root = request.getContextPath();
	List<ScheduleDto> list = (List<ScheduleDto>) request.getAttribute("scheduleList");
	if (list != null) {
		PageNavigation navigator = (PageNavigation) request.getAttribute("navigator");
%>
<style>
html{
   width: 100%;
   height: 100%;
}
.container {
   width: 100%;
   height: 100%;
}
.outer {
   display: table;
   width: 100%;
   height: 100%;
}
.inner {
   display: table-cell;
   vertical-align: middle;
}
.centered {
   position: relative;
   display: inline-block;
   width: 60%;
   padding: 1em;
}
</style>
<!-- Project CSS -->
<link href="<%=root%>/dist/css/project.css" rel="stylesheet">
<script>
function listArticle(mpg) {
	document.scheduleForm.act.value = "scheduleList";
	document.scheduleForm.pg.value = mpg;
	
	document.scheduleForm.action = "<%=root%>/support";
	document.scheduleForm.submit();
}

function firstArticle() {
	document.scheduleForm.act.value = "scheduleList";
	document.scheduleForm.pg.value = "1";
	
	document.scheduleForm.action = "<%=root%>/support";
	document.scheduleForm.submit();
}

function scheduleAdd() {
	if(document.getElementById("sch_subject").value == "") {
		alert("제목 입력!");
		return;
	} else if(document.getElementById("sch_content").value == "") {
		alert("내용 입력!");
		return;
	} else if(document.getElementById("sch_start").value == "") {
		alert("시작일 입력!");
		return;
	} else if(document.getElementById("sch_end").value == "") {
		alert("종료일 입력!");
		return;
	} else {
		document.scheduleForm.act.value = "scheduleAdd";
		document.scheduleForm.pg.value = "1";
		document.scheduleForm.action = "<%=root%>/support";
		document.scheduleForm.submit();
	}
}

function getScheduleInfo(seq, startdate, enddate, subject, content) {
	document.getElementById("sch_seq").value = seq;
	document.getElementById("sch_start").value = startdate;
	document.getElementById("sch_end").value = enddate;
	document.getElementById("sch_subject").value = subject;
	document.getElementById("sch_content").value = content;
}

function scheduleModify() {
	var seq = document.getElementById("sch_seq").value;
	var start = document.getElementById("sch_start").value;
	var end = document.getElementById("sch_end").value;
	var subject = document.getElementById("sch_subject").value;
	var content = document.getElementById("sch_content").value;
	document.scheduleForm.action = "<%=root%>/support?act=scheduleModify&sch_seq=" + seq + "&sch_start=" + start + "&sch_end=" + end + "&sch_subject=" + subject + "&sch_content=" + content;
	document.scheduleForm.submit();
}

function scheduleDelete() {
	document.listForm.action = "<%=root%>/support";
	document.listForm.submit();
}
</script>
<div id="page-wrapper">
			<header class="headers">
				<h3> 일정관리 </h3>
			</header class="headers">
			<br>
	<div class="container">
		<div class="outer" style="height: auto; min-height: 100px; overflow: auto;" align="center">
			<div class="inner">
				<div class="centered">
				</div>
				<form name="listForm" method="post" action="">
				<table class="table table-bordered">
					<tr align="center">
						<th></th>
						<th>번호</th>
						<th>제목</th>
						<th>내용</th>
						<th>시작일</th>
						<th>종료일</th>
					</tr>
					<%
						int len = list.size();
							if (len != 0) {
								for (int i = 0; i < len; i++) {
									ScheduleDto scheduleDto = list.get(i);
					%>
					<tr align="center">
						<input type="hidden" name="act" value="scheduleDelete">
						<input type="hidden" name="pg" value="1">
						<input type="hidden" name="schedule_num" value="<%=scheduleDto.getSchedule_seq()%>">
						<td><input type="radio" id="check" name="check" value="<%=scheduleDto.getSchedule_seq()%>" 
                   			onclick="javascript:getScheduleInfo('<%=scheduleDto.getSchedule_seq()%>', '<%=scheduleDto.getSchedule_startdate()%>', '<%=scheduleDto.getSchedule_enddate()%>', '<%=scheduleDto.getSchedule_subject()%>', '<%=scheduleDto.getSchedule_content()%>');"></td>
						<td id="schedule_seq<%=scheduleDto.getSchedule_seq()%>"><%=scheduleDto.getSchedule_seq()%></td>
						<td id="schedule_subject<%=scheduleDto.getSchedule_seq()%>"><%=scheduleDto.getSchedule_subject()%></td>
						<td id="schedule_content<%=scheduleDto.getSchedule_seq()%>"><%=scheduleDto.getSchedule_content()%></td>
						<td id="schedule_startdate<%=scheduleDto.getSchedule_seq()%>"><%=scheduleDto.getSchedule_startdate()%></td>
						<td id="schedule_enddate<%=scheduleDto.getSchedule_seq()%>"><%=scheduleDto.getSchedule_enddate()%></td>
					</tr>
					<%
						}
							} else {
					%>
					<tr align="center">
						<td align="center" class="text_gray" colspan="12"><br>
							일정이 존재하지 않습니다.<br> <br></td>
					</tr>
					<%
						}
					%>
				</table>
				
				<!-- 하단 페이징 -->
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
					<tr>
						<td colspan="3" height="5"></td>
					</tr>
					<tr valign="top">
						<td width="100%" align="center">
							<!--PAGE--><%=navigator.getNavigator()%></td>
					</tr>
				</table>
				<br>
				</form>
				<!-- 하단 페이징 -->
				
				<form name="scheduleForm" method="post" style="margin: 30px">
					<input type="hidden" name="act" value="">
					<input type="hidden" name="pg" value="">
					<div align="center" style="padding: 10px;" id="scheduleDiv">
					<table>
                    <tr>
                    	<td align="center">번호</td>
						<td align="center">
                    		<input type="text" id="sch_seq" name="sch_seq" size="3" value="" disabled="disabled">
                    	</td>
						<td align="center">시작일</td>
						<td align="center">
                    		<input type="text" id="sch_start" name="sch_start" size="8" value="">
                    	</td>
						<td align="center">종료일</td>
						<td align="center">
                    		<input type="text" id="sch_end" name="sch_end" size="8" value="">
                    	</td>
					</tr>
					<tr>
						<td align="center">제목</td>
						<td align="center">
                    		<input type="text" id="sch_subject" name="sch_subject" size="20" value="">
                    	</td>
						<td align="center">내용</td>
						<td align="center">
                    		<input type="text" id="sch_content" name="sch_content" size="30" value="">
                    	</td>
                    </tr>
					</table>
            		</div>
            		<div align="center" style="padding: 10px;">
						<tr align="center">
                			<td colspan="3">
								<input type="button" class="btn btn-default" value="등록" onclick="javascript:scheduleAdd();">&nbsp;&nbsp;
								<input type="button" class="btn btn-default" value="수정" onclick="javascript:scheduleModify();">&nbsp;&nbsp;
								<input type="button" class="btn btn-default" value="삭제" onclick="javascript:scheduleDelete();">&nbsp;&nbsp;
                   			</td>
						</tr>
					</div>
				</form>
			</div>
			<!-- /.col-lg-12 -->
		</div>
	</div>
	<!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->


</body>
</html>
<%
	} else {
%>
<script>
	alert("부적절한 URL접근입니다.");
	document.location.href = "<%=root%>";
</script>
<%
	}
%>
