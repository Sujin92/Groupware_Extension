<%@page import="com.moaware.commute.model.CommuteDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>

<%@ include file="/common/member_header.jsp"%>

<%
	String root1 = request.getContextPath();
	MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
	List<CommuteDto> list = (List<CommuteDto>) request.getAttribute("gotoList");
%>

<link href='<%=root1%>/css/fullcalendar.css' rel='stylesheet' />
<link href='<%=root1%>/css/fullcalendar.print.css' rel='stylesheet'
	media='print' />
		<!-- Project CSS -->
	<link href="<%=root%>/dist/css/project.css" rel="stylesheet">
<script src='<%=root1%>/js/lib/moment.min.js' charset="UTF-8"></script>
<script src='<%=root1%>/js/lib/jquery.min.js' charset="UTF-8"></script>
<script src='<%=root1%>/js/lib/jquery-ui.min.js' charset="UTF-8"></script>
<script src='<%=root1%>/js/fullcalendar.js' charset="UTF-8"></script>

<script>


var httpRequest;
function getXMLHttpRequest() {
	if (window.ActiveXObject) { // Internet Explorer라면
		try {
			return new ActiveXObject("Msxml2.XMLHTTP"); // 7이상
		} catch (e1) {
			try {
				return new ActiveXObject("Microsoft.XMLHTTP"); // 7이하
			} catch (e2) {
				alert("지원하지않는 브라우저입니다.");
				return null;
			}

		}
	} else if (window.XMLHttpRequest) { // chrome, safari, firefox등등
		return new XMLHttpRequest();
	} else { // HttpRequest를 지원하지 않는 브라우저
		alert("지원하지않는 브라우저입니다.");
		return null;
	}
}
function getTime() {
	httpRequest = getXMLHttpRequest();
	httpRequest.onreadystatechange = starttime;
	httpRequest.open("POST", "<%=root1%>/commute/time.jsp", true); // get, url, 동기화할건지 비동기화 할건지 비동기화하면 true
	httpRequest.send(null); // 인자값으로 파라미터 가져갈 수 있음
} // callback함수 이름, get/post, url만 바꾸면 됨 

function starttime() { // callback 함수 >> 상태가 계속 바뀔 때마다 호출된다
	if (httpRequest.readyState == 4) { // 데이터 다 넘어온 상태 
		if (httpRequest.status == 200) {
			var time = httpRequest.responseText; // responseXml;
			document.getElementById("ctime").innerHTML = time;
			window.setTimeout("getTime()", 1000); // 1초 후에 getTime()을 호출해라
		} else {
			alert("문제발생 : " + httpRequest.status);
		}
	} else { // 데이터 넘어오기 전 상태 
		//document.getElementById("ctime").innerHTML = "로딩중..";
	}
}

window.onload=function() {
	getTime();
}

	$(document).ready(function() {

		$('#calendar').fullCalendar({
			header : {
				left : 'prev,next today',
				center : 'title',
				right : 'month,agendaWeek,agendaDay'
			},
			defaultDate : new Date().getTime(),
			navLinks : true, // can click day/week names to navigate views
			selectable : true,
			selectHelper : true,
			select : function(start, end) {

				var title = prompt('Event Title:');
				var content = prompt('Event Content');
				var eventData;
				if (title) {
					eventData = {
						title: title,
						start: start,
						end: end
					};
					$('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
				}
			$('#calendar').fullCalendar('unselect');
			},
			editable : true,
			eventLimit : true,

			events: [
		<%int size = list.size();

			if (size != 0) {
				for (int i = 0; i < size; i++) {
					CommuteDto commuteDto = list.get(i);
					if (Integer.parseInt(commuteDto.getCommute_division()) == 0) {
						if (commuteDto.getCheck_out() != null) {%>
			            {
			               	 title : ' 퇴근 ',
			                 start : '<%=commuteDto.getCommute_date()%>',
			                 content : '<%=commuteDto.getCommute_date()%>',
			                 color : "#FF6347"    
			                 
			            },	
			          <%} else {%>
		            {
		               	 title : ' 지각 ',
		                 start : '<%=commuteDto.getCommute_date()%>',
		                 content : '<%=commuteDto.getCommute_date()%>',
		                 color : "#b0e0e6"   
		                 
		            },
		<%}
					} else if (Integer.parseInt(commuteDto.getCommute_division()) == 1) {
						if (commuteDto.getCheck_out() != null) {%>
					 {
						 title : ' 퇴근 ',
		                 start : '<%=commuteDto.getCommute_date()%>',
		                 content : '<%=commuteDto.getCommute_date()%>',
		                 color : "#FF6347" 
			                 
			            },
			            <%} else {%>
			            {
			            	title : ' 출근 ',
			                 start : '<%=commuteDto.getCommute_date()%>',
			                 content : '<%=commuteDto.getCommute_date()%>',
			                 color : "#06db78"    
			                 
			            },
				<%}
					}
				}
			}%>            
		         ]
		});

	});
	
	function goto_work(){
		
		var d = new Date();
		var year = d.getFullYear();
		var month = ('0'+(d.getMonth()+1)).slice(-2);
		var day = d.getDate();
		var hour = d.getHours();
		var min =  d.getMinutes();
		var sec =  d.getSeconds();
            
		alert(year+"년"+month+"월"+day+"일"+hour+"시"+min+"분"+sec+"초");	
		document.location.href = "<%=root%>/commute?act=goto&year="+ year+"&month="+month+"&day="+day+"&hour="+hour+"&min="+min+"&sec="+sec+"&emp_num="+<%=memberDto.getEmp_num()%>;
		document.getElementById("gotowork_input").value = hour+":"+min+":"+sec+" Welcome to "+"<%=memberDto.getName()%>";
		var btn = document.getElementById('workbtn');
		btn.disabled = 'disabled';
	}
	
	function leave_work(){
		
		var d = new Date();
		var year = d.getFullYear();
		var month = ('0'+(d.getMonth()+1)).slice(-2);
		var day = d.getDate();
		var hour = d.getHours();
		var min =  d.getMinutes();
		var sec =  d.getSeconds();
            
		alert(year+"년"+month+"월"+day+"일"+hour+"시"+min+"분"+sec+"초");	
		document.location.href = "<%=root%>/commute?act=leave&year="+ year+"&month="+month+"&day="+day+"&hour="+hour+"&min="+min+"&sec="+sec+"&emp_num="+<%=memberDto.getEmp_num()%>;
		document.getElementById("leave_input").value = hour+":"+min+":"+sec+" Good Bye  "+"<%=memberDto.getName()%>";
		var btn = document.getElementById('leavebtn');
		btn.disabled = 'disabled';
	}
	
</script>
<style>
body {
	padding: 0;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 0 auto;
}
</style>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<header class="headers">
				<h3> 근태관리 </h3>
			</header class="headers">

			<div>
				<table class="table table-striped">
					<tr >
						<td colspan="2"><div id = "ctime"></div></td>
					</tr>
					<tr>
						<td>
							<button id="workbtn" type="button" class="btn btn-info"
								onclick="javascript:goto_work();">출근</button> 
								<input type="text" id="gotowork_input" placeholder="what time -"
							size="30">
							<button id="leavebtn" type="button" class="btn btn-info"
								onclick="javascript:leave_work();">퇴근</button> 
								<input type="text" id="leave_input" placeholder="what time -" size="30">
						</td>
					</tr>
				</table>

				<br>
			</div>

			<br>


			<div id='calendar'></div>


			<!-- Modal -->
			<div class="modal fade" id="fullCalModal2" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">×</button>
							<h4 class="modal-title">Modal Header</h4>
						</div>
						<div class="modal-body">
							<p>Some text in the modal.</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>

				</div>
			</div>


		</div>
	</div>
</div>

</body>
</html>
