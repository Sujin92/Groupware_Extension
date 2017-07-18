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
					각 회사에 맞는 홈화면을 만들어 드립니다.<br><br>
					<br><br><br><br><br><br><br><br><br><br> 
					서울시 구로구 디지털로 34길 43 코오롱 싸이언스밸리1차 4층<br>
					TEL:02-869-8301, FAX:02-869-6052<br>
					Smart Platform(Java) 기반 융합 컨텐츠 개발자 과정(22기) 1조 MOAWARE<br>
					Copyright 2017 KITRI-Java:22기,ALL RIGHTS RESERVED<br>
					<font color="#46B692">권성준, 엄호진, 정성욱, 정현우, 황예인, 황혜정</font> <br>
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
alert("부적절한 URL 접근입니다.");
document.location.href="<%=root%>";
<%
}%>