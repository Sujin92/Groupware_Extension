<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"
	import="java.util.*, com.moaware.admin.cominfo.model.CominfoDto, com.moaware.member.model.MemberDetailDto, com.moaware.admin.cominfo.util.PageNavigation"%>
<%@ include file="/common/admin_header.jsp"%>
<%
	int pg = Integer.parseInt(request.getParameter("pg"));
	List<CominfoDto> list = (List<CominfoDto>) request.getAttribute("retireList");
	if (list != null) {
		PageNavigation navigator = (PageNavigation) request.getAttribute("retireNavigator");
%>
<style>
html{
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
<script>
var pg = "<%=pg%>";

function holdList() {
	document.location.href="<%=root%>/comInfo?act=holdList&pg=1";
	// �������~ ���̽��? retirelist�� ������? �� �̰� �����غ��� �ǳ���? 
}

function listArticle(mpg) { //mpg : movepage	//������ �ִ� ������
	document.commonForm.act.value = "retireList";
	document.commonForm.pg.value = mpg;
	
	document.commonForm.action = "<%=root%>/comInfo";
	document.commonForm.submit();
}

function firstArticle() { //�� ù��° ������
	document.commonForm.act.value = "retireList";
	document.commonForm.pg.value = "1";
	
	document.commonForm.action = "<%=root%>/comInfo";
	document.commonForm.submit();
}
</script>

<!-- Project CSS -->
<link href="<%=root%>/dist/css/project.css" rel="stylesheet">
<form name="commonForm" method="get" action="">
	<input type="hidden" name="act" value="">
	<input type="hidden" name="pg" value="">
	<input type="hidden" name="seq" value="">
</form>
<div id="page-wrapper">
			<header class="headers">
				<h3> ������� </h3>
			</header class="headers">
			<br>
	<div class="container">
		<div class="outer" style="height: auto; min-height: 100px; overflow: auto;" align="center">
			<div class="inner">
				<div align="right" class="hold">
					<input type="button" value="������" onclick="javascript:holdList();">
				</div>
				<div class="centered">
				</div>
			<div class="contaner2">
				<div class="table" align="center">
					<form name="listForm" method="post" style="margin: 0px" >
						<table class="table table-bordered">
							<tr class="bg_board_title" align="center" height="30">
								<td align="center"><b>�����ȣ</b></td>
								<td align="center"><b>�μ���</b></td>
								<td align="center"><b>���޸�</b></td>
								<td align="center"><b>���̵�</b></td>
								<td align="center"><b>��й�ȣ</b></td>
								<td align="center"><b>�̸�</b></td>
								<td align="center"><b>����</b></td>
								<td align="center"><b>�ּ�</b></td>
								<td align="center"><b>�̸���</b></td>
								<td align="center"><b>�޴���</b></td>
								<td align="center"><b>�������</b></td>
								<td align="center"><b>��ȥ����</b></td>
								<td align="center"><b>�Ի���</b></td>
								<td align="center"><b>�����</b></td>
							</tr>

							<tr align="center">
								<td class="bg_board_title_02" height="1" colspan="14" style="overflow: hidden; padding: 0px"></td>
							</tr>
							<%
								int len = list.size();
									if (len != 0) {
										for (int i = 0; i < len; i++) {
											CominfoDto cominfoDto = list.get(i);
							%>
							<tr align="center">
								<td align="center"><%=cominfoDto.getEmp_num()%></td>
								<td align="center"><%=cominfoDto.getDept_name()%></td>
								<td align="center"><%=cominfoDto.getPosition_name()%></td>
								<td align="center"><%=cominfoDto.getId()%></td>
								<td align="center"><%=cominfoDto.getPass()%></td>
								<td align="center"><%=cominfoDto.getName()%></td>
								<td align="center"><%=cominfoDto.getGender()%></td>
								<td align="center" id="addr<%=cominfoDto.getEmp_num()%>"><%=cominfoDto.getAddr1()%>&nbsp;<%=cominfoDto.getAddr2() %></td>
								<td align="center"><%=cominfoDto.getEmail1() + "@" + cominfoDto.getEmail2()%></td>
								<td align="center"><%=cominfoDto.getTel1() + "-" + cominfoDto.getTel2() + "-" + cominfoDto.getTel3()%></td>
								<td align="center"><%=cominfoDto.getBirth1() + "/" + cominfoDto.getBirth2() + "/" + cominfoDto.getBirth3()%></td>
								<td align="center"><%=cominfoDto.getMarriage()%></td>
								<td align="center"><%=cominfoDto.getHire_date1() + "/" + cominfoDto.getHire_date2() + "/" + cominfoDto.getHire_date3()%></td>
								<td align="center"><%=cominfoDto.getOut_date1() + "/" + cominfoDto.getOut_date2() + "/" + cominfoDto.getOut_date3()%></td>
							</tr>
							<%
										}
									} else {
							%>
							<tr align="center">
								<td align="center" class="text_gray" colspan="14"><br>
									����� ����� �������� �ʽ��ϴ�.<br><br></td>
							</tr>
							<%
								}
							%>
						</table>
					</form>
					<!-- �ϴ� ����¡ -->
					<table width="100%" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td colspan="3" height="5"></td>
						</tr>
						<tr valign="top">
							<td width="100%" align="center"><!--PAGE--><%= navigator.getNavigator() %></td>
						</tr>
					</table><br>
					<!-- �ϴ� ����¡ -->
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.col-lg-12 -->
</div>
<!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->
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