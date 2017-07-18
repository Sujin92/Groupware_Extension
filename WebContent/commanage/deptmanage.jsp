<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="java.util.List, com.moaware.admin.member.model.DeptDto"%>
<%@ include file="/common/admin_header.jsp"%>
<%
	root = request.getContextPath();
	List<DeptDto> list = (List<DeptDto>) request.getAttribute("deptList");
	if (list != null) {
		DeptDto getDeptDto = (DeptDto) request.getAttribute("getDeptDto");
%>
<script>
function deptRegister() {
	if(document.getElementById("dept_name").value == "") {
		alert("부서이름 입력!");
		return;
	}  else {
		document.getElementById("act2").value = "deptRegister";
		document.deptform.action = "<%=root%>/comInfo";
		document.deptform.submit();
	}
}

function getDeptInfo(deptNum, deptName) {
	document.getElementById("dept_num").value = deptNum;
	document.getElementById("dept_name").value = deptName;
}

function deptModify() {
	//document.getElementById("act2").value = "deptModify";
//	alert(document.getElementById("dept_num").value);
//	alert(document.getElementById("dept_name").value);
	//document.deptform.dept_num.value=document.getElementById("dept_num").value;
	var dept_num = document.getElementById("dept_num").value;
	var dept_name = document.getElementById("dept_name").value;
	document.deptform.action = "<%=root%>/comInfo?act=deptModify&dept_num=" + dept_num + "&dept_name=" + dept_name;
	document.deptform.submit();
}

function deptDelete() {
	document.getElementById("act1").value = "deptDelete";
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

<!-- Project CSS -->
<link href="<%=root%>/dist/css/project.css" rel="stylesheet">
<div id="page-wrapper">
			<header class="headers">
				<h3> 부서관리 </h3>
			</header class="headers">
			<br>
	<div class="container">
		<div class="outer" style="height: auto; min-height: 100px; overflow: auto;" align="center">
			<div class="inner">
				<div class="centered">
				<form name="listform" method="post" action="">
				<input type="hidden" id="act1" name="act" value="">
				<table class="table table-bordered">

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
                    <input type="radio" id="check" name="check" value="<%=deptDto.getDept_num()%>" 
                    onclick="javascript:getDeptInfo('<%=deptDto.getDept_num()%>','<%=deptDto.getDept_name()%>');"></td>
                	<td><%=deptDto.getDept_num() %></td>
                    <td><%=deptDto.getDept_name() %></td>
                </tr>
                <%
					if (i < len - 1) {
				%>
                <tr align="center">
					<td class="bg_board_title_02" height="1" colspan="5" style="overflow: hidden; padding: 0px"></td>
				</tr>
				<%
					}
				}
			} else {
				%>

				<tr align="center">
					<td align="center" class="text_gray" colspan="5"><br> 부서가 존재하지 않습니다.<br> <br></td>
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
			<input type="hidden" id="act2" name="act" value="">
			<div align="center" style="padding: 10px;" id="deptDiv">
			<table>
				<tr>
					<td align="center">부서번호</td>
					<td align="center">
                    	<input type="text" id="dept_num" name="dept_num" size="10" disabled="disabled"  value="">
                    </td>
					<td align="center">부서명</td>
					<td align="center">
                    	<input type="text" id="dept_name" name="dept_name" size="15" value="">
                    </td>
				</tr>
			</table>
            </div>
            <div align="center" style="padding: 10px;">
				<tr align="center">
                <td colspan="5">
					<input type="button" class="btn btn-default" value="등록" onclick="javascript:deptRegister();">&nbsp;&nbsp;
					<input type="button" class="btn btn-default" value="수정" onclick="javascript:deptModify();">&nbsp;&nbsp;
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