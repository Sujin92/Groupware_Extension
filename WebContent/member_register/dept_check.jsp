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
		alert("검색 부서 입력!");
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
<h3>부서검색</h3>
<table width="350">
<tr>
	<td class="td3">검색할 부서를 입력하세요<br>(예: 개발부, 영업)</td>
</tr>
<tr>
	<td class="td4">
	<input type="text" name="dept_name" id="dept_name" onkeypress="javascript:if(event.keyCode == 13){ deptcheck(); }">
	<input type="button" value="검색" id="btnsearch" onclick="javascript:deptcheck();">
	</td>
</tr>
<%
if(deptName == null) {
%>
<tr>
	<td class="td4">
	부서명을 정확히 입력하세요.
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
	<b><%= deptName %></b>에 대한 검색 결과가 없습니다.<br>
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
