<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="com.moaware.member.model.MemberDto"%>
<%@ include file="/common/member_header.jsp" %>
<script type = "text/css">
#blocking .outboxing {
  width: 60%;
  height: 60%;
  margin: 100px;

}

#blocking .innerboxing {
  display: table-cell;
  vertical-align: middle;
  text-align: center;
}
</script>
<% 
   MemberDto memberDto = (MemberDto)session.getAttribute("loginInfo"); 
   if(memberDto!=null){
%>
      <div id="page-wrapper"  st	yle="overflow-x:hidden; overflow-y:hidden;">
         <div class="row">
            <div class="col-lg-12"> 
               <h1 class="page-header"></h1>
               <!-- <script src="/kitri_project/home/testapi.js"></script> -->
               <div class="col-lg-6">
					<font size="15">MOAWARE</font><br>
					�� ȸ�翡 �´� Ȩȭ���� ����� �帳�ϴ�.<br><br>
					<br><br><br><br><br><br><br><br><br><br> 
					����� ���α� �����з� 34�� 43 �ڿ��� ���̾𽺹븮1�� 4��<br>
					TEL:02-869-8301, FAX:02-869-6052<br>
					Smart Platform(Java) ��� ���� ������ ������ ����(22��) 1�� MOAWARE<br>
					Copyright 2017 KITRI-Java:22��,ALL RIGHTS RESERVED<br>
					<font color="#46B692">�Ǽ���, ��ȣ��, ������, ������, Ȳ����, Ȳ����</font> <br>
               </div>
               <div class="col-lg-6">
                  <%--<iframe src="/kitri_project/home/scrape2.html" width="330px;" height="310px;" scrolling="no" style="float:right;margin-right:30px"></iframe>
                     <iframe src="/kitri_project/home/scrape.html" width="450px;" height="220px;" scrolling="no" style="float:right;"></iframe> --%>
                  
                     <div id="blocking" class="outboxing">
                        <div id="blocking" class="innerboxing">
                           <div style="height:10%"></div>
                           <div style="width:30px;height:30px; float:right;"> </div>
                           <img src="<%=root%>/img/tree2.jpg" style="width:80%; height:70%; float:right;">  
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <!-- /.col-lg-12 -->
         </div>
      </div>
      <!-- /#page-wrapper -->
      
   <!-- /#wrapper -->
</body>
</html>
<%}else{
%><script>
alert("�������� URL �����Դϴ�.");
document.location.href="<%=root%>";
<%
}%>