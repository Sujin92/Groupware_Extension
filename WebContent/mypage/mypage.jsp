<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="com.moaware.member.model.MemberDetailDto"%>
<%@ include file="/common/member_header.jsp"%>
<%
root = request.getContextPath();
MemberDetailDto memberDetailDto = (MemberDetailDto) request.getAttribute("mypage");
if(memberDetailDto != null) {
%>
<style>
html{
   width: 100%;
   height: 100%;
}
.container {
   width: 100%;
   height: 100%;

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
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
function mvmodify(){
	document.location.href = "<%= root %>/mypageController?act=mvmodify";
}

</script>
<div id="page-wrapper">
	<header class="headers">
				<h3>마이페이지</h3>
			</header>
			<br>
	<div class="container">

		<div class="outer" style="height: auto; min-height: 100px; overflow: auto; margin-left:170px; margin-right:170px;" align="center">
			<div class="inner">
				<div class="centered">
		<form id="joinform" name="joinform" method="post" action="">
			<input type="hidden" name="act" value="register">
		<table class="table table-bordered">
			<tr>
				<td>부서명</td>
				<td><%=memberDetailDto.getDept_name() %></td>
			</tr>

			<tr>
				<td>직급명</td>
				<td><%=memberDetailDto.getPosition_name() %></td>
			</tr>

			<tr>
				<td>아이디(ID)</td>
				<td><%=memberDetailDto.getId() %></td>
			</tr>
			
			<tr>
				<td>이름</td>
				<td><%=memberDetailDto.getName() %></td>
			</tr>

			<tr>
				<td>성별</td>
				<td><%=memberDetailDto.getGender() %></td>
			</tr>
			
			<tr>
				<td>우편번호</td>
				<td><%=memberDetailDto.getZip1() %>-<%=memberDetailDto.getZip2() %></td>
			</tr>
			
			<tr>
				<td>주소</td>
				<td><%=memberDetailDto.getAddr1() %> <%=memberDetailDto.getAddr2() %></td>
			</tr>

			<tr>
				<td>주로 쓰는 이메일</td>
				<td><%=memberDetailDto.getEmail1() %>@<%=memberDetailDto.getEmail2() %></td>
			</tr>

			<tr>
				<td>연락처</td>
				<td><%=memberDetailDto.getTel1() %>-<%=memberDetailDto.getTel2() %>-<%=memberDetailDto.getTel3() %></td>
			</tr>
			
			<tr>
				<td>생년월일</td>
				<td><%=memberDetailDto.getBirth1() %>/<%=memberDetailDto.getBirth2() %>/<%=memberDetailDto.getBirth3() %></td>
			</tr>
			
			<tr>
				<td>결혼여부</td> 
				<td><%=memberDetailDto.getMarriage() %></td>
			</tr>
			
			<tr>
				<td>입사일</td>
				<td><%=memberDetailDto.getHire_date1() %>/<%=memberDetailDto.getHire_date2() %>/<%=memberDetailDto.getHire_date3() %></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" class="btn btn-default" value="수정" onclick="javascript:mvmodify();">
				</td>
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
</center>
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