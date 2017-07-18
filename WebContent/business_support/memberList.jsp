<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="java.util.Map, java.util.List, com.moaware.approval.model.ApprovalDto, com.moaware.admin.cominfo.util.PageNavigation, com.moaware.admin.cominfo.model.CominfoDto"%>
<%@ include file="/common/admin_header.jsp"%>
<%
	root = request.getContextPath();
	List<CominfoDto> list = (List<CominfoDto>) request.getAttribute("memberList");
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
	document.commonForm.act.value = "memberList";
	document.commonForm.pg.value = mpg;
	
	document.commonForm.action = "<%=root%>/support";
	document.commonForm.submit();
}

function firstArticle() {
	document.commonForm.act.value = "memberList";
	document.commonForm.pg.value = "1";
	
	document.commonForm.action = "<%=root%>/support";
	document.commonForm.submit();
}
</script>
<!-- Project CSS -->
<link href="<%=root%>/dist/css/project.css" rel="stylesheet">
<form name="commonForm" method="get" action="">
	<input type="hidden" name="act" value=""> <input type="hidden" name="pg" value="">
</form>
<div id="page-wrapper">
			<header class="headers">
				<h3> 전자결재 관리 </h3>
			</header class="headers">
			<br>
	<div class="container">
		<div class="outer" style="height: auto; min-height: 100px; overflow: auto;" align="center">
			<div class="inner">

				<div class="centered">
				</div>
				<table class="table table-bordered">
					<tr align="center">
						<th>사원번호</th>
						<th>부서명</th>
						<th>직급명</th>
						<th>아이디</th>
						<th>이름</th>
						<th>이메일</th>
						<th>휴대폰</th>
						<th>입사일</th>
					</tr>
					<%
						int len = list.size();
							if (len != 0) {
								for (int i = 0; i < len; i++) {
									CominfoDto cominfoDto = list.get(i);
					%>
					<tr align="center">
						<td align="center" id="emp_num<%=cominfoDto.getEmp_num()%>"><a href="<%=root %>/support?act=docList&pg=1&emp_num=<%=cominfoDto.getEmp_num()%>"><%=cominfoDto.getEmp_num()%></a></td>
						<td align="center" id="dept_name<%=cominfoDto.getEmp_num()%>"><%=cominfoDto.getDept_name()%></td>
						<td align="center" id="position_name<%=cominfoDto.getEmp_num()%>"><%=cominfoDto.getPosition_name()%></td>
						<td align="center" id="id<%=cominfoDto.getEmp_num()%>"><%=cominfoDto.getId()%></td>
						<td align="center" id="name<%=cominfoDto.getEmp_num()%>"><%=cominfoDto.getName()%></a></td>
						<td align="center" id="email<%=cominfoDto.getEmp_num()%>"><%=cominfoDto.getEmail1() + "@" + cominfoDto.getEmail2()%></td>
						<td align="center" id="tel<%=cominfoDto.getEmp_num()%>"><%=cominfoDto.getTel1() + "-" + cominfoDto.getTel2() + "-" + cominfoDto.getTel3()%></td>
						<td align="center" id="hire_date<%=cominfoDto.getEmp_num()%>"><%=cominfoDto.getHire_date1() + "/" + cominfoDto.getHire_date2() + "/"
								+ cominfoDto.getHire_date3()%></td>
					</tr>
					<%
						}
							} else {
					%>
					<tr align="center">
						<td align="center" class="text_gray" colspan="8"><br>
							재직중인 사원이 존재하지 않습니다.<br> <br></td>
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
