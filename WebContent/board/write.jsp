<%@page import="com.moaware.board.model.BoardDto"%>
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
List<BoardDto> list = (List<BoardDto>) request.getAttribute("articleList");
	if(memberDto!=null){
%>

<script type="text/javascript">
var root = "<%=root%>"
var bcode="<%=bcode%>"
var pg="<%=pg%>"
var key="<%=key%>"
var word="<%=word%>"

function writeArticle(){
	if(document.writeForm.subject.value == ""){
		alert("������ �Է��ϼ���");
		return;
	}else if(document.writeForm.content.value == ""){
		alert("������ �Է��ϼ���");
		return;
	}else{
		document.writeForm.action = "<%=root%>/board";
		document.writeForm.submit();
	}
}
</script>
  <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.css" rel="stylesheet">
  <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.js"></script>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12"> 
			<h1 class="page-header"></h1>

<div class="container1" style="margin:30px;padding:20px">
<table class="table table-bordered">
    <thead>
        <h2>�۾���</h2>
    </thead>
  
  <script>
    $(document).ready(function() {
        $('#content').summernote();
    });
  </script>
  <form id="writeForm" name="writeForm" method="post" >
<input type="hidden" name="act" value="write">
<input type="hidden" name="bcode" value="<%=bcode %>">	
<input type="hidden" name="pg" value="1">
<input type="hidden" name="key" value="">
<input type="hidden" name="word" value="">
    <tbody>
            <tr>
                <th width="80">����: </th>
                <td><input type="text" placeholder="������ �Է��ϼ���. " name="subject" class="form-control"/></td>
            </tr>
            <tr>
                <th width="80">����: </th>
                <td><textarea id="content" cols="10" rows="15" placeholder="������ �Է��ϼ���. " name="content" class="form-control"></textarea></td>
            </tr>
            <tr>
                <th width="80">÷������: </th>
                <td><input type="text" placeholder="������ �����ϼ���. " name="filename" class="form-control"/></td>
            </tr>

            <tr>
                <td colspan="2">
                <button type="button" class="btn btn-default" onclick="javascript:history.back();">�� ��� ����</button>
                    <button type="button" class="btn btn-danger" onclick="javascript:writeArticle();">���</button>
                    
                </td>
            </tr>
    </tbody>
</table>
</div>
</div>
</div>
</div>

</form>
<%
}
%>
</body>
</html>