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
				<h2 align="left">�� ������Ʈ �̷�</h2>
			</header>
		<form name="listForm" method="post" style="margin: 7px">
			<table width="70%" cellpadding="5" cellspacing="3" border="1">
				<tr align="center">
					<td class="bg_board_title_02" height="2" colspan="5" style="overflow: hidden; padding: 0px"></td>
				</tr>

				<tr class="bg_board_title" align="center" height="30">
					<td align="center" colspan="2"><b>������Ʈ ��ȣ</b></td>
					<td align="center" colspan="3" ><b>������Ʈ �̸�</b></td>
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
					<!-- �� ���� -->
				</tr>
		<%
			}
		}
	} else {
%>
				<tr align="center">
					<td align="center" class="text_gray" colspan="5"><br>
					�Խñ��� �������� �ʽ��ϴ�.<br><br>
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
	alert("�������� URL�����Դϴ�.");
	document.location.href = "<%=root%>";
</script>
<%
}
%>