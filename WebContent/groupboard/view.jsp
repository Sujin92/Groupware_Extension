<%@page import="com.moaware.util.Encoding"%>
<%@page import="com.moaware.util.NumberCheck"%>
<%@page import="com.moaware.board.model.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/common/member_header.jsp" %>

<%
int bcode = NumberCheck.nullToZero(request.getParameter("bcode"));
int pg = NumberCheck.nullToOne(request.getParameter("pg"));
String key = Encoding.nullToBlank(request.getParameter("key"));
String word = Encoding.isoToEuc(request.getParameter("word"));
MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
BoardDto boardDto = (BoardDto) request.getAttribute("article");
if(boardDto != null) {
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
	
	document.commonForm.action = root + "/group";
	document.commonForm.submit();
}

function firstArticle() {
	document.commonForm.act.value = "list";
	document.commonForm.bcode.value = bcode;
	document.commonForm.pg.value = "1";
	document.commonForm.key.value = "";
	document.commonForm.word.value = "";
	
	document.commonForm.action = root + "/group";
	document.commonForm.submit();
}
function moveWrite() {
document.commonForm.act.value = "mvwrite";
document.commonForm.bcode.value = bcode;
document.commonForm.pg.value = "1";
document.commonForm.key.value = "";
document.commonForm.word.value = "";

document.commonForm.action = root + "/group";
document.commonForm.submit();
}
function moveModify(seq) {
	document.commonForm.act.value = "mvmodify";	
	document.commonForm.bcode.value = "<%=bcode%>";	
	document.commonForm.pg.value = "1";	
	document.commonForm.key.value = "";	
	document.commonForm.word.value = "";	
	document.commonForm.seq.value = seq;	
	document.commonForm.action = "<%=root%>/group";
	document.commonForm.submit();
}

function deleteArticle(seq) {
	document.commonForm.act.value = "delete";	
	document.commonForm.bcode.value = "<%=bcode%>";	
	document.commonForm.pg.value = "1";	
	document.commonForm.key.value = "";	
	document.commonForm.word.value = "";	
	document.commonForm.seq.value = seq;	
	document.commonForm.action = "<%=root%>/group";
	document.commonForm.submit();
}

</script>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12"> 
			<h1 class="page-header"></h1>
			<div style="margin:30px;padding:20px">
			<form name="commonForm" method="get" action="">
	<input type="hidden" name="act" value="">
	<input type="hidden" name="bcode" value="">
	<input type="hidden" name="pg" value="">
	<input type="hidden" name="key" value="">
	<input type="hidden" name="word" value="">
	<input type="hidden" name="seq" value="">
</form>
<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td>
		<b>부서별 게시판</b> &nbsp;<font style="font-size: 8pt">|</font>&nbsp; 각 부서별 게시판 입니다.<br><br>
		</td>
		<td align="right"></td>
		
	</tr>
	<tr>
		<td colspan="2" height="19"></td>
	</tr>
</table>

<table border="0" cellpadding="5" cellspacing="0" width="100%">
	<tr height="26">
		<td width="100%" style="padding-left: 14px">
		<font>글번호: <%=boardDto.getSeq()%></font>&nbsp; 
		<font>글쓴이 : <%=boardDto.getName() %></font>
		</td>	
		<td style="padding-right: 14px" nowrap class="stext">조회 : <%=boardDto.getHit() %>
		 &nbsp; 날짜 : <%=boardDto.getLogtime() %>
		 <br>
		 <br>
		</td>
	</tr>
</table>

<table class="table table-bordered" >
    <thead>
    </thead>
    <tbody>
        <form action="write_ok.jsp" method="post" encType="multiplart/form-data">
            <tr>
                <th width="120px" bgcolor="#E1E6F6">제목 : </th>
                <td><%=boardDto.getSubject() %></td>
            </tr>
            <tr>
                <th width="120px" bgcolor="#E1E6F6">내용 : </th>
                <td><%=boardDto.getContent() %></td>
            </tr>
            <tr>
                <th width="120px" bgcolor="#E1E6F6">첨부파일 : </th>
                <td ></td>
            </tr>
        </form>
    </tbody>
</table>


<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<form name="bbsForm" id="bbsbbs" method="post"><input
		type="hidden" name="" value="">
	<tr>
		<td valign="bottom" nowrap>
		<button type="button" class="btn btn-primary" onclick="javascript:moveWrite();">글쓰기</button>
<%
if (memberDto.getEmp_num().equals(boardDto.getEmp_num())) {
%>
		<button type="button" class="btn btn-success" onclick="javascript:moveModify('<%=boardDto.getSeq() %>');">글수정</button>
		<button type="button" class="btn btn-info" onclick="javascript:deleteArticle('<%=boardDto.getSeq() %>');">글삭제</button>
<%
}
%>
		</td>
		<td valign="bottom" width="100%" style="padding-left: 4px"></td>
		<td align="right" nowrap valign="bottom">
		<a href="javascript:firstArticle();">최신목록</a><font color="#c5c5c5">|</font>
		<a href="javascript:listArticle('<%=pg%>');">목록</a> 
		</td>
	</tr>
	<tr>
		<td colspan="3" height="5" style="padding: 0px"></td>
	</tr>
</table>


</div>
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
