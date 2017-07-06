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
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullAddr = ''; // 최종 주소 변수
            var extraAddr = ''; // 조합형 주소 변수

            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                fullAddr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우
                fullAddr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
            if(data.userSelectedType === 'R'){
                //법정동명이 있을 경우 추가한다.
                if(data.bname !== ''){
                    extraAddr += data.bname;
                }
                // 건물명이 있을 경우 추가한다.
                if(data.buildingName !== ''){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
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
		alert("부서이름 입력!");
		return;
	}  else if(document.getElementById("position_name").value == "") {
		alert("직급이름 입력!");
		return;
	}  else if(document.getElementById("id").value == "") {
		alert("아이디 입력!");
		return;
	} else if(document.getElementById("pass").value  == "") {
		alert("비밀번호 입력!");
		return;
	} else if(document.getElementById("pass").value != document.getElementById("passcheck").value) {
		alert("비밀번호 확인!");
		return;
	} else if(document.getElementById("name").value == "") {
		alert("이름 입력!");
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
				alert("지원하지 않는 브라우저입니다.");
				return null;
			}
		}
	} else if(window.XMLHttpRequest) {
		return new XMLHttpRequest;
	} else {
		alert("지원하지 않는 브라우저입니다.");
		return null;
	}
}

function sendRequest(url, param, callback, method) {
	httpRequest = getXMLHttpRequest();
	
	var httpMethod = method ? method : "GET"; //java의 경우 : method != null ? method : "GET";
	if(httpMethod != "GET" && httpMethod != "POST") { //사용자가 GET이나 POST가 아닌 값을 입력하였을 경우
		httpMethod = "GET"; //default는 GET
	}
	
	var httpParam = (param == null || param == "") ? null : param;
	
	var httpUrl = url;
	if(httpMethod == "GET" && httpParam != null) {
		httpUrl = httpUrl + "?" + httpParam; //get방식은 ?뒤에 보냄
	}
	
	httpRequest.onreadystatechange=callback;
	httpRequest.open(httpMethod, httpUrl, true); //httpUrl로 요청을 보냄
	httpRequest.send(httpMethod == "POST" ? httpParam : null); //post방식은 send에서 보냄
}

function idcheck(){
	view = document.getElementById("idresult");
	var idval = document.getElementById("id").value;
	//alert(idval.length);
	if(idval.length < 5 || idval.length > 16) {
		view.innerHTML = "<font color = orange>아이디는 5자 이상 16자 이하입니다.</font>";
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
			alert("문제발생 : " + httpRequest.status);
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
				<h2 align="left">사원등록</h2>
			</header>
		<form id="joinform" name="joinform" method="post" action="">
			<input type="hidden" name="act" value="register">
		<table width="900" height="700" cellspacing="4" cellpadding="5">
<!--	<tr>
			<td >사원번호</td>
			<td ><input type="text" name="emp_num" id="emp_num" value="" size="12"></td>
		</tr>
-->
			<tr>
				<td >부서이름<font color="red">*</font></td>
				<td>
					<input type="text" name="dept_name" id="dept_name" value="" size="12" readonly="readonly">
					<input type="button" value="부서검색" onclick="javascript:opendept();">
				</td>
			</tr>

			<tr>
				<td >직급이름<font color="red">*</font></td>
				<td >
					<input type="text" name="position_name" id="position_name" value="" size="12" readonly="readonly">
					<input type="button" value="직급검색" onclick="javascript:openposition();">
				</td>
			</tr>

			<tr>
				<td >아이디(ID)<font color="red">*</font></td>
				<td >
					<input type="text" name="id" id="id" value="" size="12" onkeyup="javascript:idcheck();">
				<div id="idresult"></div>
				</td>
			</tr>

			<tr>
				<td >비밀번호입력<font color="red">*</font></td>
				<td >
					<input type="password" name="pass" id="pass" size="12" maxlength="12">
					&nbsp;&nbsp;<font color="#3cb371">6~12</font>자리의 영문(대소문자 구별)이나 숫자</td>
			</tr>

			<tr>
				<td >비밀번호확인<font color="red">*</font></td>
				<td >
					<input type="password" name="passcheck" id="passcheck" size="12" maxlength="12">
					&nbsp;&nbsp;비밀번호를 한번 더 입력하세요</td>
			</tr>
			
			<tr>
				<td >이름<font color="red">*</font></td>
				<td >
					<input type="text" name="name" id="name" value="" size="12"></td>
			</tr>

			<tr>
				<td >성별</td>
				<td >
					<input type="radio" name="gender" value="남" checked="checked">남자 
					&nbsp; <input type="radio" name="gender" value="여">여자</td>
			</tr>
			
			<tr>
				<td >우편번호<font color="red">*</font></td>
				<td ><input type="text" name="zip1" id="zip1" value="" size="5" maxlength="3" readonly="readonly"> -
					<input type="text" name="zip2" id="zip2" value="" size="5" maxlength="3" readonly="readonly">
					<input type="button" value="우편번호검색" onclick="javascript:openzip();"></td>
			</tr>
			
			<tr>
				<td >주소<font color="red">*</font></td>
				<td ><input type="text" name="addr1" id="addr1" value="" size="50" readonly="readonly"></td>
			</tr>

			<tr>
				<td >상세주소<font color="red">*</font></td>
				<td ><input type="text" name="addr2" id="addr2" size="50"></td>
			</tr>

			<tr>
				<td >주로 쓰는 이메일</td>
				<td >
					<input type="text" name="email1" value="" size="12"> @ 
					<!--<input type="text" name="direct" value="" size=12>-->
						<select name="email2">
							<!--<option value="naver.com">직접입력</option>-->
							<option value="naver.com">naver.com</option>
							<option value="hanmail.net">hanmail.net</option>
						</select>
				</td>
			</tr>

			<tr>
				<td >연락처<font color="red">*</font></td>
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
				<td >생년월일</td>
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
					</select>년
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
					</select>월
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
					</select>일
				</td>
			</tr>
			
			<tr>
				<td >결혼여부</td> 
				<td >
					<input type="radio" name="marriage" value="미혼" checked="checked">미혼 
					&nbsp; <input type="radio" name="marriage" value="기혼">기혼
				</td>
			</tr>
			
			<tr>
				<td >입사일</td>
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
					</select>년
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
					</select>월
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
					</select>일
				</td>
			</tr>
<!--
			<tr>
				<td >우편번호<font color="red">*</font></td>
				<td >
					<input type="text" name="zip1" id="zip1" value="" size="5" maxlength="3" readonly="readonly"> -
					<input type="text" name="zip2" id="zip2" value="" size="5" maxlength="3" readonly="readonly">
					<input type="button" value="우편번호검색" onclick="javascript:openzip();">
				</td>
			</tr>
		
			<tr>
				<td >주소<font color="red">*</font></td>
				<td >
					<input type="text" name="addr1" id="addr1" value="" size="100" readonly="readonly"></td>
			</tr>

			<tr>
				<td >상세주소<font color="red">*</font></td>
				<td >
					<input type="text" name="addr2" size="100">
				</td>
			</tr>
-->
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="등록" onclick="javascript:join();">
					&nbsp;&nbsp; <input type="reset" value="취소">
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