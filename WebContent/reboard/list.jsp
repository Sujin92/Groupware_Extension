<%@page import="com.moaware.board.model.ReboardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" 
import="com.moaware.util.*, com.moaware.member.model.MemberDto"%>
<%@ include file="/common/member_header.jsp" %>
<% 

int bcode = NumberCheck.nullToZero(request.getParameter("bcode"));
int pg = NumberCheck.nullToOne(request.getParameter("pg"));
String key = Encoding.nullToBlank(request.getParameter("key"));
String word = Encoding.isoToEuc(request.getParameter("word"));

MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo"); 
List<ReboardDto> list = (List<ReboardDto>) request.getAttribute("articleList");
	if(memberDto!=null){
		PageNavigation navigator = (PageNavigation) request.getAttribute("navigator");
		
%>

<!-- Project CSS -->
<link href="<%=root%>/dist/css/project.css" rel="stylesheet">
<script type="text/javascript">
var root = "<%=root%>"
var bcode="<%=bcode%>"
var pg="<%=pg%>"
var key="<%=key%>"
var word="<%=word%>"

	function searchArticle() {
	if(document.searchForm.word.value == "") {
		alert("검색어입력!!!!");
		return;
	} else {
		document.searchForm.action = "<%=root%>/reboard";
		document.searchForm.submit();
	}
}

	function moveWrite() {
	document.commonForm.act.value = "mvwrite";
	document.commonForm.bcode.value = bcode;
	document.commonForm.pg.value = "1";
	document.commonForm.key.value = "";
	document.commonForm.word.value = "";
	
	document.commonForm.action = root + "/reboard";
	document.commonForm.submit();
}

function viewArticle(seq) {
	document.commonForm.act.value = "view";
	document.commonForm.bcode.value = bcode;
	document.commonForm.pg.value = pg;
	document.commonForm.key.value = key;
	document.commonForm.word.value = word;
	document.commonForm.seq.value = seq;
	
	document.commonForm.action = root + "/reboard";
	document.commonForm.submit();
}

function firstArticle() {
	document.commonForm.act.value = "list";
	document.commonForm.bcode.value = bcode;
	document.commonForm.pg.value = "1";
	document.commonForm.key.value = "";
	document.commonForm.word.value = "";
	
	document.commonForm.action = root +  "/reboard";
	document.commonForm.submit();
}

function listArticle(mpg) {
	document.commonForm.act.value = "list";
	document.commonForm.bcode.value = bcode;
	document.commonForm.pg.value = mpg;
	document.commonForm.key.value = key;
	document.commonForm.word.value = word;
	
	document.commonForm.action = root +  "/reboard";
	document.commonForm.submit();
}

</script>

		<div id="page-wrapper" >
			<div class="row">
				<div class="col-lg-12" > 
			<header class="headers">
				<h3> 게시판 </h3>
			</header class="headers">
<div style="margin:10px;padding:20px">
 <font style="font-size: 20pt">Q&A</font> | 묻고 답하기 게시판입니다.<br><br>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>글번호 </th>
        <th>제목</th>
        <th>글쓴이 </th>
        <th>조회 </th>
		<th>날짜</th>
      </tr>
    </thead>
    <tbody>
    <%
int size = list.size();
if(size != 0 && list !=null) {
	for(ReboardDto boardDto : list) {
%>
      <tr>
        <td><%=boardDto.getSeq() %></td>
        <td><img src="<%=root %>/img/blank.gif" width="<%=boardDto.getLev() * 10 %>" height="1"><a href="javascript:viewArticle('<%=boardDto.getSeq() %>');">
        <%=boardDto.getSubject() %></a></td>
        <td><%=boardDto.getName() %></td>
        <td><%=boardDto.getHit() %></td>
        <td><%=boardDto.getLogtime() %></td>
      </tr>
<%
	}
} else {
%>
	<tr>
		<td align="center" class="text_gray" colspan="10">
		<br>
		게시글이 존재하지 않습니다.
		<br>
		</td>
	</tr>
	<tr>
		<td bgcolor="#ededed" height="1" colspan="11"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
<%	
}
%>
    </tbody>
  </table>
  <div align="center"><%=navigator.getNavigator() %></div>
  <span><a href="javascript:moveWrite();"><button class="btn btn-primary btn-lg" type="submit" >글쓰기</button></a></span>
  <div align="right"><b><%=navigator.getPageNo()%></b> / <%=navigator.getTotalPageCount() %></div>
  <br>
	

	<form name="searchForm" method="get" action="" onsubmit="return false;" style="margin: 0px">
	<input type="hidden" name="act" value="list">
	<input type="hidden" name="bcode" value="<%=bcode%>">
	<input type="hidden" name="pg" value="1">
	<table>
	<tr >
		<td width="50%"></td>
		<td nowrap>
		<select name="key" class="inp">
			<option value="subject">글제목
			<option value="name">글쓴이
			<option value="seq">글번호
		</select> <span id="sear1"> 
		<input type="text" name="word" size="22" class="inp" style="margin-top: -19px;"
		onkeypress="javascript:if(event.keyCode == 13) {searchArticle();}"> </span> <span id="sear2" style="display: none;"> 
		<select name="head" class="inp">
			<option value="말머리선택">말머리선택
		</select> </span> 
		<button class="btn btn-info" type="submit" onclick="javascript:searchArticle();" >검색</button> 
		</td>
	</tr>
	</table>
	</form>
</div>

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
<%}else{
%><script>
alert("부적절한 URL 접근입니다.");
document.location.href="<%=root%>";
<%
}%>