<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR" import="java.sql.SQLException,com. moaware.util.db.*,java.sql.*,java.util.ArrayList"%>
<%@ page import="com.moaware.org.model.OrgDto,java.util.List,com.moaware.org.dao.*"%>
<%
   List<OrgDto> list = (List<OrgDto>) request.getAttribute("chartinfo");
%>
<%@ include file="/common/member_header.jsp"%>
<%@ include file="/member_address/member_address_attribute.jsp"%>
<link rel="stylesheet" href="<%=root%>/css/member_chart.css" />
<link href="<%=root%>/dist/css/project.css" rel="stylesheet">
<!--
ul -> crul
li -> crli

 -->
 <script type="text/javascript">
function getdept(dept_num){
   document.testform2.act.value = "selectdept1";
   document.testform2.dept_num.value = dept_num; 
   document.testform2.action= "<%=root%>/selectdept";
   document.testform2.submit();
}

</script>
 
 
 <div id="page-wrapper" style="overflow-x:hidden; overflow-y:hidden;">
   <div class="row">
   
         <!-- 나누기 -->
         <div class="col-lg-12">
         <!-- <div class="content" id="mchart"> -->
         			<header class="headers">
				<h3> 조직도 </h3>
			</header class="headers">
			<br>

         <div style="margin:auto; text-align:center;">
         
         <div class="content" id="mchart">
            <figure class="org-chart cf" id="mchart">
               <ul id="mchart">
                  <li>
                     <ul class="director" id="mchart" >
                        <li>
                           <!-- <a href="#"><span style="pont-size: 15px">우리 회사</span></a> -->
                           
                           
                           <ul class="departments cf" id="mchart">
                              <li>
                                 <form name="testform2" method="post" action="">
                                    <input type="hidden" name="act" value="findkeyword1">
                                    <input type="hidden" id="dept_num" name="dept_num" value="">
                                    <input type="hidden" id="name" name="name" value="">
                                 </form>
                              </li>
                     
                              <%
                              int dept_num = 0;
                              int len = list.size();
                              int cntcolor=0;
                              for(int i=0; i<len; i++) {
                                 OrgDto orgDto = list.get(i);
                                 if(dept_num != orgDto.getDept_num()) {
                                    dept_num = orgDto.getDept_num();
                              %>
                              <li class="department d<%=cntcolor %>">
                              <a href="<%=root %>/selectdept?act=selectdept1&dept_num=<%=dept_num%>"><span><%=orgDto.getDept_name() %></span></a>
                              <%
                                 cntcolor++;
                                    if(cntcolor > 6){
                                       cntcolor = 0;
                                    }
                                 }
                              %>
                              </li>
                              <%
                                 }
                              %>
                              
                              
                           </ul>
                        </li>
                     </ul>

                  </li>
               </ul>
            </figure>
         </div>
         
         </div>
         
         
   </div>
   </div>
   </div>