<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="java.sql.SQLException,com.moaware.util.db.DBClose,com.moaware.util.db.DBConnection"%>
<%@page import="java.sql.ResultSet,java.sql.PreparedStatement,java.sql.Connection,java.util.ArrayList,com.moaware.org.model.OrgDto"%>
<%@page import="java.util.List,com.moaware.org.dao.*,com.moaware.util.NumberCheck,com.moaware.org.model.KeywordDto"%>
<%@include file="/common/member_header.jsp"%>
<%@include file="/member_address/member_address_attribute.jsp"%>
<%
	List<OrgDto> list = (List<OrgDto>) request.getAttribute("adressinfo");
	List<KeywordDto> list2 = (List<KeywordDto>) request.getAttribute("selectinfo");
	String selected = (String) request.getAttribute("selected");
%>
<script type="text/javascript">

function getkeyword(emp_num,dept_num,position_num,name){
	document.testform2.act.value = "findkeyword1";
	document.testform2.emp_num.value = emp_num;
	document.testform2.dept_num.value = dept_num; 
	document.testform2.position_num.value = position_num; 
	document.testform2.name.value = name; 
	document.testform2.action= "<%=root%>/findkeyword";
	document.testform2.submit();
}
function selectedt(keydept) {
    var x = document.getElementById(keydept);
    x.checked = true;
}

</script>


<style>
#treev label,
#treev label::before
{
    background: url("<%=root%>/icon/icon.png") no-repeat;
}

#blankempty div{
 	text-indent: 20px;
}
</style>

<link href="//fonts.googleapis.com/css?family=Open+Sans:400,300|Oswald:400,300:latin" rel="stylesheet" />
<link href="<%=root%>/css/member_treeview.css" rel="stylesheet" />

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">주소록</h1>
			
			<div style="float: left; left: 10px; top: 10px; width: 25%; border: 1px solid gray; position: relative">
			<h4>부서</h4>
				<div id="treev">
							<form name="testform2" method="post" action="">
								<input type="hidden" name="act" value="findkeyword1">
								<input type="hidden" id="emp_num" name="emp_num" value="">
								<input type="hidden" id="dept_num" name="dept_num" value="">
								<input type="hidden" id="position_num" name="position_num" value="">
								<input type="hidden" id="name" name="name" value="">
							</form>
					<ul >
						<%
						
						if(list != null){
						
						int dept_num = 0;
						int len = list.size();
							for(int i=0; i<len; i++) {
								OrgDto orgDto = list.get(i);
								if(dept_num != orgDto.getDept_num()) {
									dept_num = orgDto.getDept_num();
						%>
						<li><input type="checkbox" name="checkb" id="keydept<%=i%>"	<% if(selected != null){ 
						if(selected.equals(orgDto.getDept_num()+"")){
							%>
							checked="checked"
							<%
							}
						} 
						%>               
						>
						 
						<label for="depfolder"><%=orgDto.getDept_name() %></label>
						<%
								}
						%>	
							<ul>
								<li>
								<a href="#" onClick="getkeyword('<%=orgDto.getEmp_num()%>','<%=orgDto.getDept_name() %>','<%=orgDto.getPosition_num()%>','<%= orgDto.getName() %>'); return false;" id="deptname<%=i%>" style="text-indent: 20px;" >  
								<%=orgDto.getPosition_name()%>&nbsp;&nbsp;<%= orgDto.getName() %> </a>
								</li>
							</ul>
						<%
							}
						%>
						</li>
						<%
						}
						%>
					
					
					</ul>
				</div>
			</div>
	
			<%
		if(list2 != null){
			
			int size = list2.size();
			if(size !=0) {
				for(KeywordDto od : list2){
%>
			<form id="testform" name="testform" method="post" action="#">

				<div class="blankempty" id="addressinfo" style=" float:right;">
		
				<!-- 
					<div class="blankpic" >
					<img src="<%=root %>/img/<%=od.getPicture() %>" >
					</div>
				 -->
				 
					<div class="blankpack">
						<div class="blankleft">직급</div>
						<div class="blankright"><%=od.getPosition_name() %></div>
					</div>
					
					<div class="blankpack">
						<div class="blankleft">ID</div>
						<div class="blankright"><%=od.getId() %></div>
					</div>
	
					<div class="blankpack">
						<div class="blankleft">이름</div>
						<div class="blankright"><%=od.getName() %></div>
					</div>
	
					<div class="blankpack">
						<div class="blankleft">성별</div>
						<div class="blankright"><%=od.getGender() %></div>
					</div>
	
					<div class="blankpack">
						<div class="blankleft">생년월일</div>
						<div class="blankright"><%=od.getBirth1() %>년 <%=od.getBirth2() %>월 <%=od.getBirth3() %>일</div>
					</div>
	
					<div class="blankpack">
						<div class="blankleft">입사일</div>
						<div class="blankright"><%=od.getHire_date1() %>년 <%=od.getHire_date2() %>월 <%=od.getHire_date3() %>일</div>
					</div>
	
					<div class="blankpack">
						<div class="blankleft">연락처</div>
						<div class="blankright"><%=od.getTel1() %>-<%=od.getTel2() %>-<%=od.getTel3() %></div>
					</div>
	
					<div class="blankpack">
						<div class="blankleft">소속</div>
						<div class="blankright"><%=od.getDept_name() %></div>
					</div>
	
				</div>
			</form>
		<%
				}
			}
		} else {
			
		%>
		<div class="blankempty" id="addressinfo" style=" float:right;">
				
				<!-- 
					<div class="blankpic">
					<img src="">
					</div>
				 -->
	
					<div class="blankpack">
						<div class="blankleft">직급</div>
						<div class="blankright"></div>
					</div>
					
					<div class="blankpack">
						<div class="blankleft">ID</div>
						<div class="blankright"></div>
					</div>
	
					<div class="blankpack">
						<div class="blankleft">이름</div>
						<div class="blankright"></div>
					</div>
	
					<div class="blankpack">
						<div class="blankleft">성별</div>
						<div class="blankright"></div>
					</div>
	
					<div class="blankpack">
						<div class="blankleft">생년월일</div>
						<div class="blankright"></div>
					</div>
	
					<div class="blankpack">
						<div class="blankleft">입사일</div>
						<div class="blankright"></div>
					</div>
	
					<div class="blankpack">
						<div class="blankleft">연락처</div>
						<div class="blankright"></div>
					</div>
	
					<div class="blankpack">
						<div class="blankleft">소속</div>
						<div class="blankright"></div>
					</div>
	
				</div>
		
		
		<%
		}
		%>
			
		</div>
	</div>
</div>
			
			
			
			
			
			
			
			
			