<%@page import="com.moaware.member.model.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/common/admin_header.jsp"%>
<%
MemberDto memberDto = (MemberDto)session.getAttribute("loginInfo"); 
if(memberDto != null) {
%>
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

function join(){
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
		document.joinform.action = "<%=root%>/memberRegister";
		document.joinform.submit();
	}
}

var httpRequest;
var view;
var flag = false;

function getXMLHttpRequest() {
	if(window.ActiveXObject) {
		try {
			return new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e1) {
			try {
				return new ActiveXObject("Microsoft.XMLHTTP");	
			} catch (e2) {
				alert("�������� �ʴ� �������Դϴ�.");
				return null;
			}
		}
	} else if(window.XMLHttpRequest) {
		return new XMLHttpRequest;
	} else {
		alert("�������� �ʴ� �������Դϴ�.");
		return null;
	}
}

function sendRequest(url, param, callback, method) {
	httpRequest = getXMLHttpRequest();
	
	var httpMethod = method ? method : "GET"; //java�� ��� : method != null ? method : "GET";
	if(httpMethod != "GET" && httpMethod != "POST") { //����ڰ� GET�̳� POST�� �ƴ� ���� �Է��Ͽ��� ���
		httpMethod = "GET"; //default�� GET
	}
	
	var httpParam = (param == null || param == "") ? null : param;
	
	var httpUrl = url;
	if(httpMethod == "GET" && httpParam != null) {
		httpUrl = httpUrl + "?" + httpParam; //get����� ?�ڿ� ����
	}
	
	httpRequest.onreadystatechange=callback;
	httpRequest.open(httpMethod, httpUrl, true); //httpUrl�� ��û�� ����
	httpRequest.send(httpMethod == "POST" ? httpParam : null); //post����� send���� ����
}

function idcheck(){
	view = document.getElementById("idresult");
	var idval = document.getElementById("id").value;
	//alert(idval.length);
	if(idval.length < 5 || idval.length > 16) {
		view.innerHTML = "<font color = orange>���̵�� 5�� �̻� 16�� �����Դϴ�.</font>";
	} else {
		var param = "act=idsearch&id=" + encodeURI(idval);
		sendRequest("<%=root%>/memberRegister", param, idresult, "GET");
	}
}

function idresult() {
	if(httpRequest.readyState == 4) {
		if(httpRequest.status == 200) {
			var txt = httpRequest.responseText;
			view.innerHTML = txt;
		} else {
			alert("�����߻� : " + httpRequest.status);
		}
	}
}

function opendept(){
	window.open("<%= root %>/memberRegister?act=mvdept","dept","top=200, left=300, width=400, height=300, menubar=no, status=no, toolbar=no, location=no, scrollbars=yes");
}

function openposition(){
	window.open("<%= root %>/memberRegister?act=mvposition","position","top=200, left=300, width=400, height=300, menubar=no, status=no, toolbar=no, location=no, scrollbars=yes");
}
</script>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12" align="center">
			<header>
				<h2 align="left">������</h2>
			</header>
		<form id="joinform" name="joinform" method="post" action="">
			<input type="hidden" name="act" value="register">
		<table width="900" height="700" cellspacing="4" cellpadding="5">
<!--	<tr>
			<td >�����ȣ</td>
			<td ><input type="text" name="emp_num" id="emp_num" value="" size="12"></td>
		</tr>
-->
			<tr>
				<td >�μ��̸�<font color="red">*</font></td>
				<td>
					<input type="text" name="dept_name" id="dept_name" value="" size="12" readonly="readonly">
					<input type="button" value="�μ��˻�" onclick="javascript:opendept();">
				</td>
			</tr>

			<tr>
				<td >�����̸�<font color="red">*</font></td>
				<td >
					<input type="text" name="position_name" id="position_name" value="" size="12" readonly="readonly">
					<input type="button" value="���ް˻�" onclick="javascript:openposition();">
				</td>
			</tr>

			<tr>
				<td >���̵�(ID)<font color="red">*</font></td>
				<td >
					<input type="text" name="id" id="id" value="" size="12" onkeyup="javascript:idcheck();">
				<div id="idresult"></div>
				</td>
			</tr>

			<tr>
				<td >��й�ȣ�Է�<font color="red">*</font></td>
				<td >
					<input type="password" name="pass" id="pass" size="12" maxlength="12">
					&nbsp;&nbsp;<font color="#3cb371">6~12</font>�ڸ��� ����(��ҹ��� ����)�̳� ����</td>
			</tr>

			<tr>
				<td >��й�ȣȮ��<font color="red">*</font></td>
				<td >
					<input type="password" name="passcheck" id="passcheck" size="12" maxlength="12">
					&nbsp;&nbsp;��й�ȣ�� �ѹ� �� �Է��ϼ���</td>
			</tr>
			
			<tr>
				<td >�̸�<font color="red">*</font></td>
				<td >
					<input type="text" name="name" id="name" value="" size="12"></td>
			</tr>

			<tr>
				<td >����</td>
				<td >
					<input type="radio" name="gender" value="��" checked="checked">���� 
					&nbsp; <input type="radio" name="gender" value="��">����</td>
			</tr>
			
			<tr>
				<td >�����ȣ<font color="red">*</font></td>
				<td ><input type="text" name="zip1" id="zip1" value="" size="5" maxlength="3" readonly="readonly"> -
					<input type="text" name="zip2" id="zip2" value="" size="5" maxlength="3" readonly="readonly">
					<input type="button" value="�����ȣ�˻�" onclick="javascript:openzip();"></td>
			</tr>
			
			<tr>
				<td >�ּ�<font color="red">*</font></td>
				<td ><input type="text" name="addr1" id="addr1" value="" size="50" readonly="readonly"></td>
			</tr>

			<tr>
				<td >���ּ�<font color="red">*</font></td>
				<td ><input type="text" name="addr2" id="addr2" size="50"></td>
			</tr>

			<tr>
				<td >�ַ� ���� �̸���</td>
				<td >
					<input type="text" name="email1" value="" size="12"> @ 
					<!--<input type="text" name="direct" value="" size=12>-->
						<select name="email2">
							<!--<option value="naver.com">�����Է�</option>-->
							<option value="naver.com">naver.com</option>
							<option value="hanmail.net">hanmail.net</option>
						</select>
				</td>
			</tr>

			<tr>
				<td >����ó<font color="red">*</font></td>
				<td >
					<select name="tel1">
						<option value="">----</option>
						<option value="010">010</option>
						<option value="010">011</option>
						<option value="010">016</option>
						<option value="010">017</option>
						<option value="010">018</option>
					</select> - 
					<input type="text" name="tel2" value="" size="4" maxlength="4"> - 
					<input type="text" name="tel3" value="" size="4" maxlength="4"><br>
				</td>
			</tr>
			
			<tr>
				<td >�������</td>
				<td >
					<select name="birth_yyyy">
						<option value="">----</option>
						<%
						for(int i=1940; i<2018; i++ ) {
						%>
						<option value="<%=i%>"><%=i%></option>
						<%
						}
						%>
					</select>��
					<select name="birth_mm">
						<option value="">----</option>
						<%
						for(int i=1; i<13; i++ ) {
							if(i < 10) {
						%>
						<option value="<%="0"+i%>">0<%=i%></option>
						<%
							} else {
						%>
						<option value="<%=i%>"><%=i%></option>
						<%
							}
						}
						%>
					</select>��
					<select name="birth_dd">
						<option value="">----</option>
						<%
						for(int i=1; i<31; i++ ) {
							if(i < 10) {
						%>
							<option value="<%="0"+i%>">0<%=i%></option>
						<%
							} else {
						%>
							<option value="<%=i%>"><%=i%></option>
						<%
							}
						}
						%>
					</select>��
				</td>
			</tr>
			
			<tr>
				<td >��ȥ����</td> 
				<td >
					<input type="radio" name="marriage" value="��ȥ" checked="checked">��ȥ 
					&nbsp; <input type="radio" name="marriage" value="��ȥ">��ȥ
				</td>
			</tr>
			
			<tr>
				<td >�Ի���</td>
				<td >
					<select name="hire_yyyy">
						<option value="">----</option>
						<%
						for(int i=1940; i<2018; i++ ) {
						%>
						<option value="<%=i%>"><%=i%></option>
						<%
						}
						%>
					</select>��
					<select name="hire_mm">
						<option value="">----</option>
						<%
						for(int i=1; i<13; i++ ) {
							if(i < 10) {
						%>
						<option value="<%="0"+i%>">0<%=i%></option>
						<%
							} else {
						%>
						<option value="<%=i%>"><%=i%></option>
						<%
							}
						}
						%>
					</select>��
					<select name="hire_dd">
						<option value="">----</option>
						<%
						for(int i=1; i<31; i++ ) {
							if(i < 10) {
						%>
							<option value="<%="0"+i%>">0<%=i%></option>
						<%
							} else {
						%>
							<option value="<%=i%>"><%=i%></option>
						<%
							}
						}
						%>
					</select>��
				</td>
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
				<td colspan="2" align="center">
					<input type="button" value="���" onclick="javascript:join();">
					&nbsp;&nbsp; <input type="reset" value="���">
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