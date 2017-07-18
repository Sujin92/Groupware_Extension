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

function modify(){
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
					<h3>마이페이지</h3>
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
			<td >사원번호</td>
			<td ><input type="text" name="emp_num" id="emp_num" value="" size="12"></td>
		</tr>
-->
							<tr>
								<td>부서명<font color="red">*</font></td>
								<td><input type="text" name="dept_name" id="dept_name"
									value="<%=memberDetailDto.getDept_name()%>" size="12"
									disabled="disabled"></td>
							</tr>

							<tr>
								<td>직급명<font color="red">*</font></td>
								<td><input type="text" name="position_name"
									id="position_name"
									value="<%=memberDetailDto.getPosition_name()%>" size="12"
									disabled="disabled"></td>
							</tr>

							<tr>
								<td>아이디(ID)<font color="red">*</font></td>
								<td><input type="text" name="id" id="id"
									value="<%=memberDetailDto.getId()%>" size="12"
									disabled="disabled"></td>
							</tr>

							<tr>
								<td>비밀번호입력<font color="red">*</font></td>
								<td><input type="password" name="pass" id="pass" size="12"
									maxlength="12"> &nbsp;&nbsp;<font color="#3cb371">6~12</font>자리의
									영문(대소문자 구별)이나 숫자</td>
							</tr>

							<tr>
								<td>비밀번호확인<font color="red">*</font></td>
								<td><input type="password" name="passcheck" id="passcheck"
									size="12" maxlength="12"> &nbsp;&nbsp;비밀번호를 한번 더 입력하세요</td>
							</tr>

							<tr>
								<td>이름<font color="red">*</font></td>
								<td><input type="text" name="name" id="name"
									value="<%=memberDetailDto.getName()%>" size="12"></td>
							</tr>

							<tr>
								<td>성별</td>
								<td><input type="radio" name="gender" value="남자"
									<%if ("남자".equals(memberDetailDto.getGender()))
					out.print("checked");%>>남자
									&nbsp; <input type="radio" name="gender" value="여자"
									<%if ("여자".equals(memberDetailDto.getGender()))
					out.print("checked");%>>여자</td>
							</tr>

							<tr>
								<td>우편번호<font color="red">*</font></td>
								<td><input type="text" name="zip1" id="zip1"
									value="<%=memberDetailDto.getZip1()%>" size="5" maxlength="3"
									readonly="readonly"> - <input type="text" name="zip2"
									id="zip2" value="<%=memberDetailDto.getZip2()%>" size="5"
									maxlength="3" readonly="readonly"> <input type="button"
									value="우편번호검색" onclick="javascript:openzip();"></td>
							</tr>

							<tr>
								<td>주소<font color="red">*</font></td>
								<td><input type="text" name="addr1" id="addr1"
									value="<%=memberDetailDto.getAddr1()%>" size="50"
									readonly="readonly"></td>
							</tr>

							<tr>
								<td>상세주소<font color="red">*</font></td>
								<td><input type="text" name="addr2" id="addr2"
									value="<%=memberDetailDto.getAddr2()%>" size="50"></td>
							</tr>

							<tr>
								<td>주로 쓰는 이메일</td>
								<td><input type="text" name="email1"
									value="<%=memberDetailDto.getEmail1()%>" size="12"> @
									<!--<input type="text" name="direct" value="" size=12>--> <select
									name="email2">
										<!--<option value="naver.com">직접입력</option>-->
										<option value="naver.com"
											<%="naver.com".equals(memberDetailDto.getEmail2()) ? " selected" : ""%>>naver.com</option>
										<option value="hanmail.net"
											<%="hanmail.net".equals(memberDetailDto.getEmail2()) ? " selected" : ""%>>hanmail.net</option>
								</select></td>
							</tr>

							<tr>
								<td>연락처<font color="red">*</font></td>
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
								<td>생년월일</td>
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
								</select>년 <select name="birth_mm">
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
								</select>월 <select name="birth_dd">
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
								</select>일</td>
							</tr>

							<tr>
								<td>결혼여부</td>
								<td><input type="radio" name="marriage" value="미혼"
									<%if ("미혼".equals(memberDetailDto.getMarriage()))
					out.print("checked");%>>미혼
									&nbsp; <input type="radio" name="marriage" value="기혼"
									<%if ("기혼".equals(memberDetailDto.getMarriage()))
					out.print("checked");%>>기혼
								</td>
							</tr>

							<tr>
								<td>입사일</td>
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
								</select>년 <select name="hire_mm" disabled="disabled">
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
								</select>월 <select name="hire_dd" disabled="disabled">
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
								</select>일</td>

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
								<td colspan="2" align="center"><input type="button"
									class="btn btn-default" value="수정"
									onclick="javascript:modify();"> &nbsp;&nbsp; <input
									type="reset" class="btn btn-default" value="취소"
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
	alert("부적절한 URL접근입니다.");
	document.location.href = "<%=root%>
	";
</script>
<%
	}
%>