<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.moaware.project.model.ProjectDto, java.util.List"%>

<%@ include file="/common/member_header.jsp" %>


<!-- Project CSS -->
<link href="<%=root%>/dist/css/project.css" rel="stylesheet">


<script type="text/javascript">

var idx = 1; // 생성될 객체 idx
var img_L = 0;
var img_T = 0;
var targetObj;
var httpRequest;

function add_div1() {
	
//	$("#btn_cr1").on("click", function() {
//	var param = $("#writeForm1").serialize();
//	alert(param);
//	 $.ajax({   
//	   type: "POST"  
//	  ,data: param
//      ,dataType: "xml"
//	  ,success:registerResult
//	  ,error:function(data){
//	    alert("error");
//	  }
//	});
//});
	 
	var div = document.createElement('DIV'); // DIV 객체 생성
	div.style.margin = "6px";
	div.style.padding = "20px";
	div.setAttribute('card', 'div'+idx); // id 지정
	div.innerHTML = document.getElementById("area1").value;
	document.getElementById('inbox1').appendChild(div).style.backgroundColor = "white";
	idx++;

	 document.writeForm1.action ="<%=root%>/project";
	 document.writeForm1.submit();

}

function add_div2() {
	
	var div = document.createElement('DIV');
	div.style.margin = "6px";
	div.style.padding = "20px";
	div.setAttribute('card', 'div' + idx); // id 지정
	div.innerHTML = document.getElementById("area2").value;
	document.getElementById('inbox2').appendChild(div).style.backgroundColor = "white";
	idx++;

	 document.writeForm2.action ="<%=root%>/project";
	 document.writeForm2.submit();
}
function add_div3() {
	 
	var div = document.createElement('DIV'); // DIV 객체 생성
	div.style.margin = "6px";
	div.style.padding = "20px";
	div.setAttribute('card', 'div' + idx); 
	div.innerHTML = document.getElementById("area3").value;
	document.getElementById('inbox3').appendChild(div).style.backgroundColor = "white";
	idx++;
	
	 document.writeForm3.action ="<%=root%>/project";
	 document.writeForm3.submit();

}
function add_div4() {

	 
	var div = document.createElement('DIV'); // DIV 객체 생성
	div.style.margin = "6px";
	div.style.padding = "20px";
	div.setAttribute('card', 'div' + idx);
	div.innerHTML = document.getElementById("area4").value;
	document.getElementById('inbox4').appendChild(div).style.backgroundColor = "white";
	idx++;
	
	
	 document.writeForm4.action ="<%=root%>/project";
	 document.writeForm4.submit();
	 
}

function press(f) {
	if (f.keyCode == 13) {
		// forname.submit()
		var box = document.getElementById('card');
		box.style.backgroundColor = black;
	}
}

function modal(a) {
	document.getElementById("modal-a").textContent = document.getElementById(a).textContent;
	document.getElementById("contentnum").value = a;
	$('#myModal').modal("show");
}


function modifyArticle(m){

	  var contentnum = document.getElementById("contentnum").value;
	  var cardcontent = document.getElementById("modal-a").value;
	  document.location.href = "<%=root%>/project?act=modify&seq="+ contentnum+"&content="+cardcontent;
	  $('#myModal').modal('hide');	u8i77                                                                                                                                            
}

function deleteArticle(){
	
	  var contentnum = document.getElementById("contentnum").value;
	  document.location.href = "<%=root%>/project?act=delete&seq="+ contentnum;
	  $('#myModal').modal('hide');	
	
}

function initproject(){
	
	 document.initprojects.action ="<%=root%>/project";
	 document.initprojects.submit();
}

</script>

<% 
List<ProjectDto> list = (List<ProjectDto>)request.getAttribute("cardlist");
%>


<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<header class="headers">
				<h3> 프로젝트 관리 </h3>
			</header class="headers">

			<div class="container1">
			
			
<%
int size = list.size();
				for(int i =0; i<size; i++){
					ProjectDto projectDto = list.get(i);
%>

<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <p><h2>Modify & Delete</h2></p>
        </div>
        <div class="modal-body">
        <input type="hidden" id="contentnum" value="">
         <textarea rows="5" cols="70" id="modal-a" name="modal-a" type="text" class="textfield"></textarea>
        </div>
        <div id="modaldiv" class="modal-footer">
        <button id="modi" type="button" class="btn btn-default" data-dismiss="modal" onclick="JavaScript:modifyArticle();">수정</button>
        <button id="dele" type="button" class="btn btn-default" data-dismiss="modal" onclick="JavaScript:deleteArticle();">삭제</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">종료</button>
        </div>
      </div>
      
    </div>
  </div>
<%		
	
} 
%>	


				<div class="box" overflow-y="auto">
					<div id="inbox1">
						<strong><b2>Todo</b2></strong>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						</div>
					<div id="card1">
<%
 size = list.size();
	if (size != 0) {
				for(int i =0; i<size; i++){
					ProjectDto projectDto = list.get(i);
					if(Integer.parseInt(projectDto.getProject_progress()) == 1){
%>
					<div id="<%=projectDto.getContent_num() %>" onclick="javascript:modal(<%=projectDto.getContent_num() %>);" style="background-color:white; height: auto; width: auto; margin:6px; padding:20px; font:bold 굴림체;"  ><%= projectDto.getProject_content() %></div>
			
					
					
						<form id="writeForm1" name="writeForm1" action="" method="post">
							<input type="hidden" id="act" name="act" value="insertproject">
							<input type="hidden" id="progress" name="progress" value="1">
							<input type="hidden" id="project_num" name="project_num" value="<%= projectDto.getProject_num() %>">
							<input type="hidden" id="project_name" name="project_name" value="<%= projectDto.getProject_name() %>">
							<input type="hidden" id="dept_num" name="dept_num" value="<%= projectDto.getDept_num() %>">
							<input type="hidden" id="emp_num" name="emp_num" value="<%= projectDto.getEmp_num() %>">

							<%		}else{ 
							%>
							
							
							<form id="writeForm1" name="writeForm1" action="" method="post">
							<input type="hidden" id="act" name="act" value="insertproject">
							<input type="hidden" id="progress" name="progress" value="1">
							<input type="hidden" id="project_num" name="project_num" value="<%= projectDto.getProject_num() %>">
							<input type="hidden" id="project_name" name="project_name" value="<%= projectDto.getProject_name() %>">
							<input type="hidden" id="dept_num" name="dept_num" value="<%= projectDto.getDept_num() %>">
							<input type="hidden" id="emp_num" name="emp_num" value="<%= projectDto.getEmp_num() %>">
							
							
							<%}
	}
} 
%>	
					
							<textarea rows="5" cols="23" id="area1" name="area1"
								type="text" class="form-control"></textarea>
								<br>	
								<button  type="button" class="btn btn-primary" onclick="javascript:add_div1();">CREATE</button>
						
						</form>
						

					</div>
				</div>

				<div class="box" overflow-y="auto">
					<div id="inbox2">
						<strong><b2>~ing</b2></strong>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						</div>
					<div id="card2">
<%
	if (size != 0) {
				for(int i =0; i<size; i++){
					ProjectDto projectDto = list.get(i);
					if(Integer.parseInt(projectDto.getProject_progress()) == 2){
%>
					<div id="<%=projectDto.getContent_num() %>"  onclick="javascript:modal('<%=projectDto.getContent_num() %>');" style="background-color:white; height: auto; width: auto; margin:6px; padding:20px;" ><%= projectDto.getProject_content() %></div>
				

						<form id="writeForm2" name="writeForm2" action="" method="post">
							<input type="hidden" id="act" name="act" value="insertproject">
							<input type="hidden" id="progress" name="progress" value="2">
							<input type="hidden" id="project_num" name="project_num" value="<%= projectDto.getProject_num() %>">
							<input type="hidden" id="project_name" name="project_name" value="<%= projectDto.getProject_name() %>">
							<input type="hidden" id="dept_num" name="dept_num" value="<%= projectDto.getDept_num() %>">
							<input type="hidden" id="emp_num" name="emp_num" value="<%= projectDto.getEmp_num() %>">
<%		}else{%>
						<form id="writeForm2" name="writeForm2" action="" method="post">
							<input type="hidden" id="act" name="act" value="insertproject">
							<input type="hidden" id="progress" name="progress" value="2">
							<input type="hidden" id="project_num" name="project_num" value="<%= projectDto.getProject_num() %>">
							<input type="hidden" id="project_name" name="project_name" value="<%= projectDto.getProject_name() %>">
							<input type="hidden" id="dept_num" name="dept_num" value="<%= projectDto.getDept_num() %>">
							<input type="hidden" id="emp_num" name="emp_num" value="<%= projectDto.getEmp_num() %>">
<%}
	}
} %>					
							<textarea rows="5" cols="23" id="area2" name="area2"
								type="text" class="form-control"></textarea>
								
								<br>	
					<button  type="button" class="btn btn-primary" onclick="javascript:add_div2();">CREATE</button>
					
						</form>

					</div>
				</div>
				
				
				
				<div class="box" overflow-y="auto">
					<div id="inbox3" ondrop="drop(event)" ondragover="allowDrop(event)">
						<strong><b2>Wait</b2></strong>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							</div>
					<div id="card3" >
<%
	if (size != 0) {
				for(int i =0; i<size; i++){
					ProjectDto projectDto = list.get(i);
					if(Integer.parseInt(projectDto.getProject_progress()) == 3){
%>
					<div id="<%=projectDto.getContent_num() %>"  onclick="javascript:modal('<%=projectDto.getContent_num() %>');" style="background-color:white; height: auto; width: auto; margin:6px; padding:20px;" ><%= projectDto.getProject_content() %></div>
								
								
							<form id= "writeForm3" name="writeForm3" action="" method="post">
							<input type="hidden" id="act" name="act" value="insertproject">
							<input type="hidden" id="progress" name="progress" value="3">
							<input type="hidden" id="project_num" name="project_num" value="<%= projectDto.getProject_num() %>">
							<input type="hidden" id="project_name" name="project_name" value="<%= projectDto.getProject_name() %>">
							<input type="hidden" id="dept_num" name="dept_num" value="<%= projectDto.getDept_num() %>">
							<input type="hidden" id="emp_num" name="emp_num" value="<%= projectDto.getEmp_num() %>">
<%		}else{%>

							<form id= "writeForm3" name="writeForm3" action="" method="post">
							<input type="hidden" id="act" name="act" value="insertproject">
							<input type="hidden" id="progress" name="progress" value="3">
							<input type="hidden" id="project_num" name="project_num" value="<%= projectDto.getProject_num() %>">
							<input type="hidden" id="project_name" name="project_name" value="<%= projectDto.getProject_name() %>">
							<input type="hidden" id="dept_num" name="dept_num" value="<%= projectDto.getDept_num() %>">
							<input type="hidden" id="emp_num" name="emp_num" value="<%= projectDto.getEmp_num() %>">


<%}
	}
} %>					


				
							<textarea rows="5" cols="23" id="area3" name="area3"
								type="text" class="form-control"></textarea>
								<br>	
							<button  type="button" class="btn btn-primary" onclick="javascript:add_div3();">CREATE</button>
								
						</form>

					</div>
				</div>
				
				
				
				<div class="box" overflow-y="auto">
					<div id="inbox4" ondrop="drop(event)" ondragover="allowDrop(event)">
						<strong><b2>Done</b2></strong>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					</div>
					<div id="card4" >
<%
	if (size != 0) {
				for(int i =0; i<size; i++){
					ProjectDto projectDto = list.get(i);
					if(Integer.parseInt(projectDto.getProject_progress()) == 4){
%>
									<div id="<%=projectDto.getContent_num() %>"  onclick="javascript:modal('<%=projectDto.getContent_num() %>');" style="background-color:white; height: auto; width: auto; margin:6px; padding:20px; " ><%= projectDto.getProject_content() %></div>
								
								
							<form id= "writeForm4" name="writeForm4" action="" method="post">
							<input type="hidden" id="act" name="act" value="insertproject">
							<input type="hidden" id="progress" name="progress" value="4">
							<input type="hidden" id="project_num" name="project_num" value="<%= projectDto.getProject_num() %>">
							<input type="hidden" id="project_name" name="project_name" value="<%= projectDto.getProject_name() %>">
							<input type="hidden" id="dept_num" name="dept_num" value="<%= projectDto.getDept_num() %>">
							<input type="hidden" id="emp_num" name="emp_num" value="<%= projectDto.getEmp_num() %>">
				
<%		}
					else{%>
					<form id= "writeForm4" name="writeForm4" action="" method="post">
							<input type="hidden" id="act" name="act" value="insertproject">
							<input type="hidden" id="progress" name="progress" value="4">
							<input type="hidden" id="project_num" name="project_num" value="<%= projectDto.getProject_num() %>">
							<input type="hidden" id="project_name" name="project_name" value="<%= projectDto.getProject_name() %>">
							<input type="hidden" id="dept_num" name="dept_num" value="<%= projectDto.getDept_num() %>">
							<input type="hidden" id="emp_num" name="emp_num" value="<%= projectDto.getEmp_num() %>">
						
						
						
						<%
						
					}
	}
} %>

							<textarea rows="5" cols="23" id="area4" name="area4"
								type="text" class="form-control"></textarea>
								<br>	
							<button  type="button" class="btn btn-primary" onclick="javascript:add_div4();">CREATE</button>
							
						</form>

					</div>
				</div>
				<aside style="position:relative;">
					<Strong>MEMBERS</strong>
					<br>
					<br>
					<ul>
					
<% 
	Random random = new Random();
	int ran = random.nextInt();
	List<MemberDto> list2 = (List<MemberDto>)request.getAttribute("memberlist");
	if(list2!=null){
	int len = list2.size();
	if (len != 0) {
				for(int i =0; i<len; i++){
					MemberDto memberDto = list2.get(i);
%>
		<li><%=memberDto.getName() %></li>
	<form id="initprojects" name="initprojects" action="" method="post">
	<input type="hidden" id="act" name="act" value="initproject">
	<input type="hidden" id="progress" name="progress" value="1">
	<input type="hidden" id="project_num" name="project_num" value="<%=ran %>">
	<input type="hidden" id="project_name" name="project_name" value="사내 프로젝트">
	<input type="hidden" id="dept_num" name="dept_num" value="<%= member.getDept_num() %>">
	<input type="hidden" id="emp_num" name="emp_num" value="<%=member.getEmp_num() %>">
	
			
<%
				}
		}
}
%>
</ul>
<br>
<div style="position:absolute; bottom:0px; align:left;">
! 첫 프로젝트 시 만 [Click] 해주세요.
<button  type="button" class="btn btn-default btn-lg" onclick="javascript:initproject();">New Project</button>
</div>
	</aside>
		</div>

</div>
</div>
<!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->



</body>
</html>
