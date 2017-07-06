<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="com.moaware.member.model.MemberDto"%>
<%@ include file="/common/member_header.jsp" %>
<% 
	MemberDto memberDto = (MemberDto)session.getAttribute("loginInfo"); 
	if(memberDto!=null){
%>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12"> 
					<h1 class="page-header"></h1>
					<!-- <script src="/kitri_project/home/testapi.js"></script> -->
					<div style="float:right">
						<iframe src="/kitri_project/home/scrape2.html" width="330px;" height="310px;" scrolling="no" style="float:right;margin-right:30px"></iframe>
						<iframe src="/kitri_project/home/scrape.html" width="450px;" height="220px;" scrolling="no" style="float:right;"></iframe>
						</div>
				</div>
				<!-- /.col-lg-12 -->
			</div>
		</div>
		<!-- /#page-wrapper -->
		
	</div>
	<!-- /#wrapper -->
</body>
</html>
<%}else{
%><script>
alert("부적절한 URL 접근입니다.");
document.location.href="<%=root%>";
<%
}%>