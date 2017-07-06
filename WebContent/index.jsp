<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	String root = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Login</title>
<link href="<%=root %>/dist/css/index.css" rel="stylesheet">
<script type="text/javascript">
function logincheck(){
	if(document.getElementById("id").value  == "") {
		alert("아이디 입력!");
		return;	
	} else if(document.getElementById("pass").value == "") {
		alert("비밀번호 입력!"); 
	return;
	} else {
		document.loginform.action = "<%=root%>/login";
		document.loginform.submit();
	}
}
</script>
</head>	
<body>
</head>
<body>
<form class="signUp" id="loginform" name="loginform" method="post" action="">
   <h1 class="signUpTitle">MOAWARE Login</h1>
   <input type ="hidden" name ="act" value="mvlogin">
   <input name="id" id="id" type="text" class="signUpInput" placeholder="Type your username" autofocus required>
   <input name="pass" id="pass" type="password" class="signUpInput" placeholder="Choose a password" required>
   <input type="submit" value="Sign me up!" class="signUpButton" onclick="javascript:logincheck();">
</form>
</body>
</html>
