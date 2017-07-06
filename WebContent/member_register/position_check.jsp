<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.List, com.moaware.admin.member.model.PositionDto"%>
<%
String root = request.getContextPath();

String positionName = (String) request.getAttribute("position_name");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= root %>/css/style.css" type="text/css">
<script type="text/javascript">
function positioncheck(){
	if(document.getElementById("position_name").value == "") {
		alert("�˻� ���� �Է�!");
		return;
	} else {
		document.positionform.action = "<%=root%>/memberRegister";
		document.positionform.submit();
	}
}

function selectposition(position_name){
	opener.document.getElementById("position_name").value = position_name;
	
	self.close();
}
</script>
</head>
<body>
<center>
<form name="positionform" method="get" action="">
<input type="hidden" name="act" value="positionsearch">
<h3>�μ��˻�</h3>
<table width="350">
<tr>
	<td class="td3">�˻��� ������ �Է��ϼ���<br>(��: ����, ���)</td>
</tr>
<tr>
	<td class="td4">
	<input type="text" name="position_name" id="position_name" onkeypress="javascript:if(event.keyCode == 13){ positioncheck(); }">
	<input type="button" value="�˻�" id="btnsearch" onclick="javascript:positioncheck();">
	</td>
</tr>
<%
if(positionName == null) {
%>
<tr>
	<td class="td4">
	���޸��� ��Ȯ�� �Է��ϼ���.
	</td>
</tr>
<%
} else {
	List<PositionDto> list = (List<PositionDto>) request.getAttribute("positionList");
	int size = list.size();
	if(size != 0) {
		for(int i=0;  i < size; i++) {
			PositionDto positionDto = list.get(i);
%>
<tr>
	<td class="td4">
	<a href="javascript:selectposition('<%=positionDto.getPosition_name() %>');"><%=positionDto.getPosition_num() %>&nbsp;<%=positionDto.getPosition_name() %></a>
	</td>
</tr>
<%
		}
	} else {
%>
<tr>
	<td class="td4">
	<b><%= positionName %></b>�� ���� �˻� ����� �����ϴ�.<br>
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
