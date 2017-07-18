<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="java.util.Map, java.util.List, com.moaware.approval.model.ApprovalDto, com.moaware.approval.util.PageNavigation"%>
<%@ include file="/common/member_header.jsp"%>
<%
	MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
	int pg = Integer.parseInt(request.getParameter("pg"));
	List<ApprovalDto> list = (List<ApprovalDto>) request.getAttribute("finishDoc");
	if (list != null) {
		PageNavigation navigator = (PageNavigation) request.getAttribute("navigator");
%>
<!-- Project CSS -->
<link href="<%=root%>/dist/css/project.css" rel="stylesheet">

<form name="commonForm" method="get" action="">
	<input type="hidden" name="act" value=""> <input type="hidden"
		name="pg" value="">
</form>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
					<header class="headers">
				<h3> 전자결재 </h3>
			</header class="headers">
			<br>
			<%@include file="list.jsp"%>
			<div class="col-lg-8">
				<div>결재완료 문서</div>
				<table class="table table-bordered">
					<tr>
						<th>번호</th>
						<th>문서종류</th>
						<th>상태</th>
						<th>제목</th>
						<th>기안일</th>
						<th>결재선1</th>
						<th>결재선2</th>
						<th>결재선3</th>
					</tr>
					<%
						int count = list.size();
							if (count != 0) {
								for (int i = 0; i < count; i++) {
									ApprovalDto approvalDto = list.get(i);
					%>
					<tr>
						<input type="hidden" id="doc_num<%=approvalDto.getDoc_num()%>" name="doc_num" value="<%=approvalDto.getDoc_num()%>">
						<input type="hidden" id="emp_num<%=approvalDto.getDoc_num()%>" name="emp_num" value="<%=approvalDto.getEmp_num()%>">
						<input type="hidden" id="doc_type_num<%=approvalDto.getDoc_num()%>" name="doc_type_num" value="<%=approvalDto.getDoc_type_num()%>">
						<input type="hidden" id="doc_content<%=approvalDto.getDoc_num()%>" name="doc_content" value="<%=approvalDto.getDoc_content()%>">
						<input type="hidden" id="receive_dept<%=approvalDto.getDoc_num()%>" name="receive_dept" value="<%=approvalDto.getReceive_dept()%>">
						<td>
							<a href="javascript:modal(<%=approvalDto.getDoc_num()%>)" ><%=approvalDto.getDoc_num()%>
						</td>
						<td id="doc_name<%=approvalDto.getDoc_num()%>"><%=approvalDto.getDoc_name()%></td>
						<td id="doc_state<%=approvalDto.getDoc_num()%>"><%=approvalDto.getDoc_state()%></td>
						<td id="doc_subject<%=approvalDto.getDoc_num()%>"><%=approvalDto.getDoc_subject()%></td>
						<td id="draft_date<%=approvalDto.getDoc_num()%>"><%=approvalDto.getDraft_date()%></td>
						<td id="confirm_line_one<%=approvalDto.getDoc_num()%>"><%=approvalDto.getConfirm_line_1()%></td>
						<td id="confirm_line_two<%=approvalDto.getDoc_num()%>"><%=approvalDto.getConfirm_line_2()%></td>
						<td id="confirm_line_three<%=approvalDto.getDoc_num()%>"><%=approvalDto.getConfirm_line_3()%></td>
					</tr>
					<%
						}
							} else {
					%>
					<tr align="center">
						<td align="center" class="text_gray" colspan="8"><br> 결재완료 문서가 존재하지 않습니다.<br> <br></td>
					</tr>
					<%
						}
					%>
				</table>

				<div class="modal fade" id="myModal" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<p align="center" style="font-size: 30px">기안서</p>
							</div>
							<div class="modal-body">
								<form name="paperForm" method="post" action="">
									<input type="hidden" id="confirm_line1" name="confirm_line1" value="">
									<input type="hidden" id="confirm_line2" name="confirm_line2" value="">
									<input type="hidden" id="confirm_line3" name="confirm_line3" value="">
									<table class="table table-bordered">
										<tr>
											<th>문서번호</th>
											<td id="doc_num"></td>
											<th rowspan="2">결재</th>
											<td id="confirm" rowspan="2">
												<div id="confirm1"></div>
											</td>
											<td rowspan="2">
												<div id="confirm2"></div>
											</td>
											<td rowspan="2">
												<div id="confirm3"></div>
											</td>
										</tr>
										<tr>
											<th>문서종류</th>
											<td id="doc_name"></td>

										</tr>
										<tr>
											<th>기안일</th>
											<td id="draft_date"></td>
											<th>수신부서</th>
											<td colspan="3" id="receive_dept">
											</td>
										</tr>
										<tr>
											<th>제목</th>
											<td id="doc_subject"></td>
											<th>부서</th>
											<td colspan="3"><%=memberDto.getDept_num()%></td>
										</tr>
										<tr>
											<td colspan="6" id="doc_content"></td>
										</tr>
									</table>
								</form>
							</div>
						</div>
					</div>
				</div>

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

		</div>
		<!-- /.col-lg-12 -->
	</div>
</div>
<!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->


</body>
<script>
function listArticle(mpg) {
	document.commonForm.act.value = "finishDoc";
	document.commonForm.pg.value = mpg;
	
	document.commonForm.action = "<%=root%>/appcontrol";
	document.commonForm.submit();
}

function firstArticle() {
	document.commonForm.act.value = "finishDoc";
	document.commonForm.pg.value = "1";
	
	document.commonForm.action = "<%=root%>/appcontrol";
	document.commonForm.submit();
}

function modal(doc_num) { //modal창으로 데이터 가져오기
	document.getElementById("doc_num").textContent = document.getElementById("doc_num"+doc_num).value;
	document.getElementById("doc_name").textContent =document.getElementById("doc_name"+doc_num).textContent;
	document.getElementById("confirm1").textContent = document.getElementById("confirm_line_one"+doc_num).textContent;
	document.getElementById("confirm2").textContent = document.getElementById("confirm_line_two"+doc_num).textContent;
	document.getElementById("confirm3").textContent = document.getElementById("confirm_line_three"+doc_num).textContent;
	document.getElementById("draft_date").textContent = document.getElementById("draft_date"+doc_num).textContent;
	document.getElementById("receive_dept").textContent = document.getElementById("receive_dept"+doc_num).value;
	document.getElementById("doc_subject").textContent = document.getElementById("doc_subject"+doc_num).textContent;
	document.getElementById("doc_content").textContent = document.getElementById("doc_content"+doc_num).value;
	$('#myModal').modal("show");
}
</script>
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
