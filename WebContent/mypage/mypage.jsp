<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="com.moaware.member.model.MemberDetailDto"%>
<%@ include file="/common/member_header.jsp"%>
<%
root = request.getContextPath();
MemberDetailDto memberDetailDto = (MemberDetailDto) request.getAttribute("mypage");
if(memberDetailDto != null) {
%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
function mvmodify(){
	document.location.href = "<%= root %>/mypageController?act=mvmodify";
}

</script>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12" align="center">
			<header>
				<h2 align="left">마이페이지</h2>
			</header>
		<form id="joinform" name="joinform" method="post" action="" style="margin: 0px">
			<input type="hidden" name="act" value="register">
		<table width="900" height="700" cellspacing="4" cellpadding="5">
<!--	<tr>
			<td >사원번호</td>
			<td ><input type="text" name="emp_num" id="emp_num" value="" size="12"></td>
		</tr>
-->
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
				<td>비밀번호</td>
				<td><%=memberDetailDto.getPass() %></td>
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
			
<!--
			<tr>
				<td >우편번호</td>
				<td >
					<input type="text" name="zip1" id="zip1" value="" size="5" maxlength="3" readonly="readonly"> -
					<input type="text" name="zip2" id="zip2" value="" size="5" maxlength="3" readonly="readonly">
					<input type="button" value="우편번호검색" onclick="javascript:openzip();">
				</td>
			</tr>
		
			<tr>
				<td >주소</td>
				<td >
					<input type="text" name="addr1" id="addr1" value="" size="100" readonly="readonly"></td>
			</tr>

			<tr>
				<td >상세주소</td>
				<td >
					<input type="text" name="addr2" size="100">
				</td>
			</tr>
-->
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정" onclick="javascript:mvmodify();">
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