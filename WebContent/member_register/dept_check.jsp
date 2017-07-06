<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.List, com.moaware.admin.member.model.DeptDto"%>
<%
String root = request.getContextPath();

String deptName = (String) request.getAttribute("dept_name");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= root %>/css/style.css" type="text/css">
<script type="text/javascript">
function deptcheck(){
	if(document.getElementById("dept_name").value == "") {
		alert("�˻� �μ� �Է�!");
		return;
	} else {
		document.deptform.action = "<%=root%>/memberRegister";
		document.deptform.submit();
	}
}

function selectdept(dept_name){
	opener.document.getElementById("dept_name").value = dept_name;
	
	self.close();
}
</script>
</head>
<body>
<center>
<form name="deptform" method="get" action="">
<input type="hidden" name="act" value="deptsearch">
<h3>�μ��˻�</h3>
<table width="350">
<tr>
	<td class="td3">�˻��� �μ��� �Է��ϼ���<br>(��: ���ߺ�, ����)</td>
</tr>
<tr>
	<td class="td4">
	<input type="text" name="dept_name" id="dept_name" onkeypress="javascript:if(event.keyCode == 13){ deptcheck(); }">
	<input type="button" value="�˻�" id="btnsearch" onclick="javascript:deptcheck();">
	</td>
</tr>
<%
if(deptName == null) {
%>
<tr>
	<td class="td4">
	�μ����� ��Ȯ�� �Է��ϼ���.
	</td>
</tr>
<%
} else {
	List<DeptDto> list = (List<DeptDto>) request.getAttribute("deptList");
	int size = list.size();
	if(size != 0) {
		for(int i=0;  i < size; i++) {
			DeptDto deptDto = list.get(i);
%>
<tr>
	<td class="td4">
	<a href="javascript:selectdept('<%=deptDto.getDept_name() %>');"><%=deptDto.getDept_num() %>&nbsp;<%=deptDto.getDept_name() %></a>
	</td>
</tr>
<%
		}
	} else {
%>
<tr>
	<td class="td4">
	<b><%= deptName %></b>�� ���� �˻� ����� �����ϴ�.<br>
	</td>
</tr>
<%
	}
}
%>
</table>
</form>
</center>
</body>
</html>
