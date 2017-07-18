<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="java.util.Map, java.util.List, com.moaware.approval.model.ApprovalDto, com.moaware.admin.cominfo.util.PageNavigation"%>
<%@ include file="/common/admin_header.jsp"%>
<%
	root = request.getContextPath();
	List<ApprovalDto> list = (List<ApprovalDto>) request.getAttribute("docList");
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
<script>
function listArticle(mpg) {
	document.commonForm.act.value = "docList";
	document.commonForm.pg.value = mpg;
	document.commonForm.emp_num.value = document.getElementById("emp_num").value;
	
	document.commonForm.action = "<%=root%>/support";
	document.commonForm.submit();
}

function firstArticle() {
	document.commonForm.act.value = "docList";
	document.commonForm.pg.value = "1";
	document.commonForm.emp_num.value = document.getElementById("emp_num").value;
	
	document.commonForm.action = "<%=root%>/support";
	document.commonForm.submit();
}

function memberList() {
	document.location.href="<%=root%>/support?act=memberList&pg=1";
}
</script>

<!-- Project CSS -->
<link href="<%=root%>/dist/css/project.css" rel="stylesheet">
<form name="commonForm" method="get" action="">
	<input type="hidden" name="act" value=""> <input type="hidden" name="pg" value="">
	<input type="hidden" name="emp_num" value="">
</form>
<div id="page-wrapper">
			<header class="headers">
				<h3> 문서목록 </h3>
			</header class="headers">
			<br>
	<div class="container">
		<div class="outer" style="height: auto; min-height: 100px; overflow: auto;" align="center">
			<div class="inner">
				<div align="right" class="docList">
					<input type="button" value="사원목록" onclick="javascript:memberList();">
				</div>
				<div class="centered">
				</div>
				<table class="table table-bordered">
					<tr align="center">
						<th>번호</th>
						<th>종류</th>
						<th>제목</th>
						<th>기안날짜</th>
						<th>수신부서</th>
						<th>결재선1</th>
						<th>결재선2</th>
						<th>결재선3</th>
						<th>결재선1확인</th>
						<th>결재선2확인</th>
						<th>결재선3확인</th>
						<th>상태</th>
					</tr>
					<%
						int len = list.size();
							if (len != 0) {
								for (int i = 0; i < len; i++) {
									ApprovalDto approvalDto = list.get(i);
					%>
					<tr align="center">
						<input type="hidden" id="emp_num" value="<%=approvalDto.getEmp_num()%>">
						<td id="doc_num<%=approvalDto.getDoc_num()%>"><%=approvalDto.getDoc_num()%></td>
						<td id="doc_name<%=approvalDto.getDoc_num()%>"><%=approvalDto.getDoc_name()%></td>
						<td id="doc_subject<%=approvalDto.getDoc_num()%>"><%=approvalDto.getDoc_subject()%></td>
						<td id="draft_date<%=approvalDto.getDoc_num()%>"><%=approvalDto.getDraft_date()%></td>
						<td id="receive_dept<%=approvalDto.getDoc_num()%>"><%=approvalDto.getReceive_dept()%></td>
						<td id="confirm_line_one<%=approvalDto.getDoc_num()%>"><%=approvalDto.getConfirm_line_1()%></td>
						<td id="confirm_line_two<%=approvalDto.getDoc_num()%>"><%=approvalDto.getConfirm_line_2()%></td>
						<td id="confirm_line_three<%=approvalDto.getDoc_num()%>"><%=approvalDto.getConfirm_line_3()%></td>
						<td id="confirm_line_ok_one<%=approvalDto.getDoc_num()%>"><%=approvalDto.getConfirm_line_ok_1()%></td>
						<td id="confirm_line_ok_two<%=approvalDto.getDoc_num()%>"><%=approvalDto.getConfirm_line_ok_2()%></td>
						<td id="confirm_line_ok_three<%=approvalDto.getDoc_num()%>"><%=approvalDto.getConfirm_line_ok_3()%></td>
						<td id="doc_state<%=approvalDto.getDoc_num()%>"><%=approvalDto.getDoc_state()%></td> 
					</tr>
					<%
						}
							} else {
					%>
					<tr align="center">
						<td align="center" class="text_gray" colspan="12"><br>
							상신문서가 존재하지 않습니다.<br> <br></td>
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
				<!-- 하단 페이징 -->
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
