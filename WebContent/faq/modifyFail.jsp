<%@page import="com.moaware.util.Encoding"%>
<%@page import="com.moaware.util.NumberCheck"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	
<%@ include file="/common/member_header.jsp" %>	
<%
int bcode = NumberCheck.nullToZero(request.getParameter("bcode"));
int pg = NumberCheck.nullToOne(request.getParameter("pg"));
String key = Encoding.nullToBlank(request.getParameter("key"));
String word = Encoding.isoToEuc(request.getParameter("word"));

%>
<script type="text/javascript">
var root = "<%=root%>"
var bcode="<%=bcode%>"
var pg="<%=pg%>"
var key="<%=key%>"
var word="<%=word%>"

function listArticle(mpg) {
	document.commonForm.act.value = "list";
	document.commonForm.bcode.value = bcode;
	document.commonForm.pg.value = mpg;
	document.commonForm.key.value = key;
	document.commonForm.word.value = word;
	
	document.commonForm.action = root + "/faq";
	document.commonForm.submit();
}

</script>
<%
String seq = (String) request.getAttribute("seq");
if(seq != null) {
%>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12"> 
			<h1 class="page-header"></h1>
			
<table width="100%" cellpadding="6" cellspacing="2" border="0"
	bgcolor="#ffffff" style="border: #e1e1e1 solid 1px">
	<tr>
		<td class="bg_board_title" width="100%">
		</td>
	</tr>	
	<tr>
		<td height="1" bgcolor="#e1e1e1"
			style="overflow: hidden; padding: 0px;"></td>
	</tr>
	<tr>
		<td class="bg_menu" width="100%" style="padding: 25px" height="35"
			align="center"><b>글 수정에 실패하였습니다. 다시 작성해 주세요.</b><br>
		<br>

		<div align="center">
		<button type="button" class="btn btn-success" onclick="javascript:listArticle('<%=pg%>');">목록보기</button>
		</div>
		</td>
	</tr>
</table>
<br>
<form name="commonForm" method="get" action="">
	<input type="hidden" name="act" value="">
	<input type="hidden" name="bcode" value="">
	<input type="hidden" name="pg" value="">
	<input type="hidden" name="key" value="">
	<input type="hidden" name="word" value="">
	<input type="hidden" name="seq" value="">
</form>
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

