<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.moaware.member.model.MemberDetailDto"%>
<%@ include file="/common/member_header.jsp"%>
<%
	root = request.getContextPath();
	MemberDetailDto memberDetailDto = (MemberDetailDto) request.getAttribute("mypage");
	if (memberDetailDto != null) {
%>
<style>
html {
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
function openzip() {
    new daum.Postcode({
        oncomplete: function(data) {
            // �������� ������ ���� ���� ��쿣 ����('')���� �����Ƿ�, �̸� �����Ͽ� �б� �Ѵ�.
            var fullAddr = ''; // ���� �ּ� ����
            var extraAddr = ''; // ������ �ּ� ����

            // ����ڰ� ������ �ּ� Ÿ�Կ� ���� �ش� �ּ� ���� �����´�.
            if (data.userSelectedType === 'R') { // ����ڰ� ���θ� �ּҸ� �������� ���
                fullAddr = data.roadAddress;
            } else { // ����ڰ� ���� �ּҸ� �������� ���
                fullAddr = data.jibunAddress;
            }

            // ����ڰ� ������ �ּҰ� ���θ� Ÿ���϶� �����Ѵ�.
            if(data.userSelectedType === 'R'){
                //���������� ���� ��� �߰��Ѵ�.
                if(data.bname !== ''){
                    extraAddr += data.bname;
                }
                // �ǹ����� ���� ��� �߰��Ѵ�.
                if(data.buildingName !== ''){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // �������ּ��� ������ ���� ���ʿ� ��ȣ�� �߰��Ͽ� ���� �ּҸ� �����.
                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
            }
            document.getElementById("zip1").value = data.postcode1;
            document.getElementById("zip2").value = data.postcode2;
            document.getElementById("addr1").value = fullAddr;
            document.getElementById("addr2").focus();
        }
    }).open();
}

function modify(){
	if(document.getElementById("dept_name").value == "") {
		alert("�μ��̸� �Է�!");
		return;
	}  else if(document.getElementById("position_name").value == "") {
		alert("�����̸� �Է�!");
		return;
	}  else if(document.getElementById("id").value == "") {
		alert("���̵� �Է�!");
		return;
	} else if(document.getElementById("pass").value  == "") {
		alert("��й�ȣ �Է�!");
		return;
	} else if(document.getElementById("pass").value != document.getElementById("passcheck").value) {
		alert("��й�ȣ Ȯ��!");
		return;
	} else if(document.getElementById("name").value == "") {
		alert("�̸� �Է�!");
		return;
	} else {
		document.mypagemodify.action = "<%=root%>/mypageController";
		document.mypagemodify.submit();
	}
}

function modifyCancel() {
	document.location.href = "<%=root%>/mypageController?act=mypage";
}
</script>
<div id="page-wrapper">
				<header class="headers">
					<h3>����������</h3>
				</header class="headers">
	<div class="container">
		<div class="outer"
			style="height: auto; min-height: 100px; overflow: auto;"
			align="center">
			<div class="inner">
				<br>
				<div class="centered">
					<form id="mypagemodify" name="mypagemodify" method="post" action="">
						<input type="hidden" id="act" name="act" value="modify"> <input
							type="hidden" name="emp_num"
							value="<%=memberDetailDto.getEmp_num()%>">
						<table class="table table-bordered">
							<!--	<tr>
			<td >�����ȣ</td>
			<td ><input type="text" name="emp_num" id="emp_num" value="" size="12"></td>
		</tr>
-->
							<tr>
								<td>�μ���<font color="red">*</font></td>
								<td><input type="text" name="dept_name" id="dept_name"
									value="<%=memberDetailDto.getDept_name()%>" size="12"
									disabled="disabled"></td>
							</tr>

							<tr>
								<td>���޸�<font color="red">*</font></td>
								<td><input type="text" name="position_name"
									id="position_name"
									value="<%=memberDetailDto.getPosition_name()%>" size="12"
									disabled="disabled"></td>
							</tr>

							<tr>
								<td>���̵�(ID)<font color="red">*</font></td>
								<td><input type="text" name="id" id="id"
									value="<%=memberDetailDto.getId()%>" size="12"
									disabled="disabled"></td>
							</tr>

							<tr>
								<td>��й�ȣ�Է�<font color="red">*</font></td>
								<td><input type="password" name="pass" id="pass" size="12"
									maxlength="12"> &nbsp;&nbsp;<font color="#3cb371">6~12</font>�ڸ���
									����(��ҹ��� ����)�̳� ����</td>
							</tr>

							<tr>
								<td>��й�ȣȮ��<font color="red">*</font></td>
								<td><input type="password" name="passcheck" id="passcheck"
									size="12" maxlength="12"> &nbsp;&nbsp;��й�ȣ�� �ѹ� �� �Է��ϼ���</td>
							</tr>

							<tr>
								<td>�̸�<font color="red">*</font></td>
								<td><input type="text" name="name" id="name"
									value="<%=memberDetailDto.getName()%>" size="12"></td>
							</tr>

							<tr>
								<td>����</td>
								<td><input type="radio" name="gender" value="����"
									<%if ("����".equals(memberDetailDto.getGender()))
					out.print("checked");%>>����
									&nbsp; <input type="radio" name="gender" value="����"
									<%if ("����".equals(memberDetailDto.getGender()))
					out.print("checked");%>>����</td>
							</tr>

							<tr>
								<td>�����ȣ<font color="red">*</font></td>
								<td><input type="text" name="zip1" id="zip1"
									value="<%=memberDetailDto.getZip1()%>" size="5" maxlength="3"
									readonly="readonly"> - <input type="text" name="zip2"
									id="zip2" value="<%=memberDetailDto.getZip2()%>" size="5"
									maxlength="3" readonly="readonly"> <input type="button"
									value="�����ȣ�˻�" onclick="javascript:openzip();"></td>
							</tr>

							<tr>
								<td>�ּ�<font color="red">*</font></td>
								<td><input type="text" name="addr1" id="addr1"
									value="<%=memberDetailDto.getAddr1()%>" size="50"
									readonly="readonly"></td>
							</tr>

							<tr>
								<td>���ּ�<font color="red">*</font></td>
								<td><input type="text" name="addr2" id="addr2"
									value="<%=memberDetailDto.getAddr2()%>" size="50"></td>
							</tr>

							<tr>
								<td>�ַ� ���� �̸���</td>
								<td><input type="text" name="email1"
									value="<%=memberDetailDto.getEmail1()%>" size="12"> @
									<!--<input type="text" name="direct" value="" size=12>--> <select
									name="email2">
										<!--<option value="naver.com">�����Է�</option>-->
										<option value="naver.com"
											<%="naver.com".equals(memberDetailDto.getEmail2()) ? " selected" : ""%>>naver.com</option>
										<option value="hanmail.net"
											<%="hanmail.net".equals(memberDetailDto.getEmail2()) ? " selected" : ""%>>hanmail.net</option>
								</select></td>
							</tr>

							<tr>
								<td>����ó<font color="red">*</font></td>
								<td><select name="tel1">
										<option value="">----</option>
										<option value="010"
											<%="010".equals(memberDetailDto.getTel1()) ? " selected" : ""%>>010</option>
										<option value="011"
											<%="011".equals(memberDetailDto.getTel1()) ? " selected" : ""%>>011</option>
										<option value="016"
											<%="016".equals(memberDetailDto.getTel1()) ? " selected" : ""%>>016</option>
										<option value="017"
											<%="017".equals(memberDetailDto.getTel1()) ? " selected" : ""%>>017</option>
										<option value="018"
											<%="018".equals(memberDetailDto.getTel1()) ? " selected" : ""%>>018</option>
								</select> - <input type="text" name="tel2"
									value="<%=memberDetailDto.getTel2()%>" size="4" maxlength="4">
									- <input type="text" name="tel3"
									value="<%=memberDetailDto.getTel3()%>" size="4" maxlength="4"><br>
								</td>
							</tr>

							<tr>
								<td>�������</td>
								<td><select name="birth_yyyy">
										<option value="">----</option>
										<%
											for (int i = 1940; i < 2018; i++) {
										%>
										<option value="<%=i%>"
											<%if ((i + "").equals(memberDetailDto.getBirth1()))
						out.print("selected");%>><%=i%></option>
										<%
											}
										%>
								</select>�� <select name="birth_mm">
										<option value="">----</option>
										<%
											for (int i = 1; i < 13; i++) {
													if (i < 10) {
										%>
										<option value="<%="0" + i%>"
											<%if (("0" + i).equals(memberDetailDto.getBirth2()))
							out.print("selected");%>>0<%=i%></option>
										<%
											} else {
										%>
										<option value="<%=i%>"
											<%if ((i + "").equals(memberDetailDto.getBirth2()))
							out.print("selected");%>><%=i%></option>
										<%
											}
												}
										%>
								</select>�� <select name="birth_dd">
										<option value="">----</option>
										<%
											for (int i = 1; i < 31; i++) {
													if (i < 10) {
										%>
										<option value="<%="0" + i%>"
											<%if (("0" + i).equals(memberDetailDto.getBirth3()))
							out.print("selected");%>>0<%=i%></option>
										<%
											} else {
										%>
										<option value="<%=i%>"
											<%if ((i + "").equals(memberDetailDto.getBirth3()))
							out.print("selected");%>><%=i%></option>
										<%
											}
												}
										%>
								</select>��</td>
							</tr>

							<tr>
								<td>��ȥ����</td>
								<td><input type="radio" name="marriage" value="��ȥ"
									<%if ("��ȥ".equals(memberDetailDto.getMarriage()))
					out.print("checked");%>>��ȥ
									&nbsp; <input type="radio" name="marriage" value="��ȥ"
									<%if ("��ȥ".equals(memberDetailDto.getMarriage()))
					out.print("checked");%>>��ȥ
								</td>
							</tr>

							<tr>
								<td>�Ի���</td>
								<td><select name="hire_yyyy" disabled="disabled">
										<option value="">----</option>
										<%
											for (int i = 1940; i < 2018; i++) {
										%>
										<option value="<%=i%>"
											<%if ((i + "").equals(memberDetailDto.getHire_date1()))
						out.print("selected");%>><%=i%></option>
										<%
											}
										%>
								</select>�� <select name="hire_mm" disabled="disabled">
										<option value="">----</option>
										<%
											for (int i = 1; i < 13; i++) {
													if (i < 10) {
										%>
										<option value="<%="0" + i%>"
											<%if (("0" + i).equals(memberDetailDto.getHire_date2()))
							out.print("selected");%>>0<%=i%></option>
										<%
											} else {
										%>
										<option value="<%=i%>"
											<%if ((i + "").equals(memberDetailDto.getHire_date2()))
							out.print("selected");%>><%=i%></option>
										<%
											}
												}
										%>
								</select>�� <select name="hire_dd" disabled="disabled">
										<option value="">----</option>
										<%
											for (int i = 1; i < 31; i++) {
													if (i < 10) {
										%>
										<option value="<%="0" + i%>"
											<%if (("0" + i).equals(memberDetailDto.getHire_date3()))
							out.print("selected");%>>0<%=i%></option>
										<%
											} else {
										%>
										<option value="<%=i%>"
											<%if ((i + "").equals(memberDetailDto.getHire_date3()))
							out.print("selected");%>><%=i%></option>
										<%
											}
												}
										%>
								</select>��</td>

							</tr>

							<!--
			<tr>
				<td >�����ȣ<font color="red">*</font></td>
				<td >
					<input type="text" name="zip1" id="zip1" value="" size="5" maxlength="3" readonly="readonly"> -
					<input type="text" name="zip2" id="zip2" value="" size="5" maxlength="3" readonly="readonly">
					<input type="button" value="�����ȣ�˻�" onclick="javascript:openzip();">
				</td>
			</tr>
		
			<tr>
				<td >�ּ�<font color="red">*</font></td>
				<td >
					<input type="text" name="addr1" id="addr1" value="" size="100" readonly="readonly"></td>
			</tr>

			<tr>
				<td >���ּ�<font color="red">*</font></td>
				<td >
					<input type="text" name="addr2" size="100">
				</td>
			</tr>
-->
							<tr>
								<td colspan="2" align="center"><input type="button"
									class="btn btn-default" value="����"
									onclick="javascript:modify();"> &nbsp;&nbsp; <input
									type="reset" class="btn btn-default" value="���"
									onclick="javascript:modifyCancel();"></td>
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
	document.location.href = "<%=root%>
	";
</script>
<%
	}
%>