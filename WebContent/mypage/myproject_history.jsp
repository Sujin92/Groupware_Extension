<%@page import="com.moaware.project.model.ProjectDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.moaware.project.model.ProjectDto, java.util.List, com.moaware.member.model.MemberDto"%>
<%@ include file="/common/member_header.jsp"%>
<%
root = request.getContextPath();
List<ProjectDto> list = (List<ProjectDto>) request.getAttribute("projectList");
if(list != null) {
%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12" align="center">
			<header>
				<h2 align="left">내 프로젝트 이력</h2>
			</header>
		<form name="listForm" method="post" style="margin: 7px">
			<table width="70%" cellpadding="5" cellspacing="3" border="1">
				<tr align="center">
					<td class="bg_board_title_02" height="2" colspan="5" style="overflow: hidden; padding: 0px"></td>
				</tr>

				<tr class="bg_board_title" align="center" height="30">
					<td align="center" colspan="2"><b>프로젝트 번호</b></td>
					<td align="center" colspan="3" ><b>프로젝트 이름</b></td>
				</tr>
				
				<tr align="center">
					<td class="bg_board_title_02" height="1" colspan="5" style="overflow: hidden; padding: 0px"></td>
				</tr>
	<%
	int len = list.size();
	if(len != 0) {
		for(int i=0; i<len; i++) {
			ProjectDto projectDto = list.get(i);
	%>
				<tr align="center">
					<td align="center" colspan="2"><%=projectDto.getProject_num()%></td>
					<td align="center" colspan="3"><%=projectDto.getProject_name()%></td>
				</tr>
				
		<%
			if(i < len -1) {
		%>
				<tr align="center">
					<td bgcolor="#ededed" height="1" colspan="5" style="overflow: hidden; padding: 0px"></td>
					<!-- 선 한줄 -->
				</tr>
		<%
			}
		}
	} else {
%>
				<tr align="center">
					<td align="center" class="text_gray" colspan="5"><br>
					게시글이 존재하지 않습니다.<br><br>
					</td>
				</tr>
	<%
	}
	%>
				<tr align="center">
					<td class="bg_board_title_02" height="1" colspan="5" style="overflow: hidden; padding: 0px"></td>
				</tr>
			</table>
		</form>
		</div>
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