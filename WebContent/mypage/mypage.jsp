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
				<h2 align="left">����������</h2>
			</header>
		<form id="joinform" name="joinform" method="post" action="" style="margin: 0px">
			<input type="hidden" name="act" value="register">
		<table width="900" height="700" cellspacing="4" cellpadding="5">
<!--	<tr>
			<td >�����ȣ</td>
			<td ><input type="text" name="emp_num" id="emp_num" value="" size="12"></td>
		</tr>
-->
			<tr>
				<td>�μ���</td>
				<td><%=memberDetailDto.getDept_name() %></td>
			</tr>

			<tr>
				<td>���޸�</td>
				<td><%=memberDetailDto.getPosition_name() %></td>
			</tr>

			<tr>
				<td>���̵�(ID)</td>
				<td><%=memberDetailDto.getId() %></td>
			</tr>

			<tr>
				<td>��й�ȣ</td>
				<td><%=memberDetailDto.getPass() %></td>
			</tr>
			
			<tr>
				<td>�̸�</td>
				<td><%=memberDetailDto.getName() %></td>
			</tr>

			<tr>
				<td>����</td>
				<td><%=memberDetailDto.getGender() %></td>
			</tr>
			
			<tr>
				<td>�����ȣ</td>
				<td><%=memberDetailDto.getZip1() %>-<%=memberDetailDto.getZip2() %></td>
			</tr>
			
			<tr>
				<td>�ּ�</td>
				<td><%=memberDetailDto.getAddr1() %> <%=memberDetailDto.getAddr2() %></td>
			</tr>

			<tr>
				<td>�ַ� ���� �̸���</td>
				<td><%=memberDetailDto.getEmail1() %>@<%=memberDetailDto.getEmail2() %></td>
			</tr>

			<tr>
				<td>����ó</td>
				<td><%=memberDetailDto.getTel1() %>-<%=memberDetailDto.getTel2() %>-<%=memberDetailDto.getTel3() %></td>
			</tr>
			
			<tr>
				<td>�������</td>
				<td><%=memberDetailDto.getBirth1() %>/<%=memberDetailDto.getBirth2() %>/<%=memberDetailDto.getBirth3() %></td>
			</tr>
			
			<tr>
				<td>��ȥ����</td> 
				<td><%=memberDetailDto.getMarriage() %></td>
			</tr>
			
			<tr>
				<td>�Ի���</td>
				<td><%=memberDetailDto.getHire_date1() %>/<%=memberDetailDto.getHire_date2() %>/<%=memberDetailDto.getHire_date3() %></td>
			</tr>
			
<!--
			<tr>
				<td >�����ȣ</td>
				<td >
					<input type="text" name="zip1" id="zip1" value="" size="5" maxlength="3" readonly="readonly"> -
					<input type="text" name="zip2" id="zip2" value="" size="5" maxlength="3" readonly="readonly">
					<input type="button" value="�����ȣ�˻�" onclick="javascript:openzip();">
				</td>
			</tr>
		
			<tr>
				<td >�ּ�</td>
				<td >
					<input type="text" name="addr1" id="addr1" value="" size="100" readonly="readonly"></td>
			</tr>

			<tr>
				<td >���ּ�</td>
				<td >
					<input type="text" name="addr2" size="100">
				</td>
			</tr>
-->
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="����" onclick="javascript:mvmodify();">
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
	alert("�������� URL�����Դϴ�.");
	document.location.href = "<%=root%>";
</script>
<%
}
%>