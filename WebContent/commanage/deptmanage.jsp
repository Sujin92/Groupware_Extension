<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="java.util.List, com.moaware.admin.member.model.DeptDto"%>
<%@ include file="/common/admin_header.jsp"%>
<%
	root = request.getContextPath();
	List<DeptDto> list = (List<DeptDto>) request.getAttribute("deptList");
	if (list != null) {
%>
<script>
function deptRegister() {
	if(document.getElementById("dept_name").value == "") {
		alert("부서이름 입력!");
		return;
	}  else {
		document.getElementById("act1").value = "deptRegister";
		//alert(document.getElementById("act").value);
		document.registerform.submit();
		document.deptform.action = "<%=root%>/comInfo";
		document.deptform.submit();
	}
}

function deptDelete() {
	document.getElementById("act2").value = "deptDelete";
	document.deleteform.submit();
	document.listform.action = "<%=root%>/comInfo";
	document.listform.submit();
}
</script>
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
   text-align: center;
}
.centered {
   position: relative;
   display: inline-block;
   width: 60%;
   padding: 1em;
}
</style>

<form name="registerform" method="post" action="">
	<input type="hidden" name="act" value="register">
</form>

<form name="modifyform" method="post" action="">
	<input type="hidden" name="act" value="modify">
</form>

<form name="deleteform" method="post" action="">
	<input type="hidden" name="act" value="delete">
</form>
</form>
<div id="page-wrapper">
	<div class="container">
		<div class="outer" style="padding: 10px; height: auto; min-height: 100px; overflow: auto;" align="center">
			<div class="inner">
				<header>
					<h2 align="left" style="padding: 10px; margin: 10px">부서관리</h2>
				</header>
				<div class="centered">
				<form name="listform" method="post" action="">
				<input type="hidden" id="act2" name="act" value="">
				<table cellpadding="5" cellspacing="3" border="1" align="center" style="margin: 20px" class="table table-bordered">

				<tr class="bg_board_title" align="center">
                	<td align="center" colspan="1"  nowrap width="50"></td>
					<td align="center" colspan="1"  nowrap width="70"><b>번호</b></td>
					<td align="center" colspan="3" nowrap width="200"><b>이름</b></td>
				</tr>
			<%
				int len = list.size();
				if (len != 0) {
					for (int i = 0; i < len; i++) {
						DeptDto deptDto = list.get(i);
			%> 
                <tr align="center">
                	<td align="center" colspan="1"  nowrap width="50">
                    <b><input type="radio" id="check" name="check" value="<%=deptDto.getDept_num()%>" onclick="javascript:getDeptInfo();"></b></td>
                	<td><%=deptDto.getDept_num() %></td>
                    <td><%=deptDto.getDept_name() %></td>
                </tr>
                <%
					if (i < len - 1) {
				%>
                <tr align="center">
					<td class="bg_board_title_02" height="1" colspan="5"
						style="overflow: hidden; padding: 0px"></td>
				</tr>
				<%
					}
				}
			} else {
				%>

				<tr align="center">
					<td align="center" class="text_gray" colspan="5"><br> 부서가
						존재하지 않습니다.<br> <br></td>
				</tr>
		<%
			}
		%>
			</table>
			</form>
		</div>
	</div>
	</div>
	<div class="outer">
		<form name="deptform" method="post" style="margin: 30px">
			<input type="hidden" id="act1" name="act" value="">
			<div align="center" style="padding: 10px;" id="deptDiv">
				<tr>
					<td align="center">부서번호</td>
					<td align="center">
                    <input type="text" id="dept_num" name="dept_num" size="10" disabled="disabled"></td>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<td align="center" >부서명</td>
					<td align="center" >
                    <input type="text" id="dept_name" name="dept_name"
						size="15"></td>
				</tr>
            </div>
            <div align="center" style="padding: 10px;">
				<tr align="center">
                <td colspan="5">
					<input type="button" class="btn btn-default" value="등록" onclick="javascript:deptRegister();">&nbsp;&nbsp;
					<input type="button" class="btn btn-default" value="수정">&nbsp;&nbsp;
					<input type="button" class="btn btn-default" value="삭제" onclick="javascript:deptDelete();">&nbsp;&nbsp;
                   </td>
				</tr>
			</div>
		</form>
	</div>
	<!-- /.col-lg-12 -->
</div>
</div>
</div>
</div>
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