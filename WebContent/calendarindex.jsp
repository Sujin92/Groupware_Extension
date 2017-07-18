<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="utf-8"
	import="com.moaware.schedule.model.ScheduleDto, java.util.List"%>
<%@ include file="/common/member_header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />



<%
	String root1 = request.getContextPath();
	MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
	List<ScheduleDto> list = (List<ScheduleDto>) request.getAttribute("slist");
%>


<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- Project CSS -->
<link href="<%=root%>/dist/css/project.css" rel="stylesheet">
<link href='<%=root1%>/css/fullcalendar.css' rel='stylesheet' />
<link href='<%=root1%>/css/fullcalendar.print.css' rel='stylesheet'
	media='print' />
<script src='<%=root1%>/js/lib/moment.min.js' charset="utf-8"></script>
<script src='<%=root1%>/js/lib/jquery.min.js' charset="utf-8"></script>
<script src='<%=root1%>/js/lib/jquery-ui.min.js' charset="utf-8"></script>
<script src='<%=root1%>/js/fullcalendar.js' charset="utf-8"></script>

<script>
	function freedateselector(fdsValue) {
		document.fddate.action = "<%=root%>/ScheduleController";
		document.fddate.fds.value = fdsValue;
		document.fddate.submit();
		
	}
	

	function deletef() {
		
		document.delupp.action = "<%=root%>/ScheduleController";
		document.delupp.act.value  = 'deletee';
		document.delupp.submit();
	}
	
	function updatef(){
		
		document.delupp.action = "<%=root%>/ScheduleController";
		document.delupp.act.value = 'updatee';
		document.delupp.submit();
	}
	
</script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous">
</script>

<script>
var eventData;

	$(document).ready(function() {
		
		var eventData;
		var HOstart;
		var HOend;
		
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
				HOstart = start;
				HOend = end;
				$("#fullCalModalToInsert").modal({"show" : true});

				  $("#fullCalModalToInsert #startDate").val(start);
				 $("#fullCalModalToInsert #endDate").val(end);
			},
			
			
			editable : true,
			eventLimit : true, // allow "more" link when too many events
		
			
			eventClick : function(event, element) {
				if (title) {
					$("#fullCalModal").modal({"show" : true});
					$("#fullCalModal #modalTitle").text(event.title);
					$("#fullCalModal #contenttext").text(event.content);
					$("#fullCalModal #startDate").text(event.start);
					$("#fullCalModal #endDate").text(event.end);
					$("#delupp #title").val(event.title);
					$("#delupp #content").val(event.content);
					$("#delupp #startDate").val(event.start);
					$("#delupp #endDate").val(event.end);
					
					
				//	$("#delete").on('click', function() {
				///		console.log(123);
				//		$('#calendar').fullCalendar('removeEvents',event._id);
				//		$("#fullCalModal").modal('hide');
				//	});
				
				}
		
				
			},
			
			events: [
			<%int size = list.size();
			if (size != 0) {
				for (int i = 0; i < size; i++) {
					ScheduleDto scheduleDto = list.get(i);
					if (scheduleDto.getFreedayselector().equals("1")) {%>
				{
					title : '<%=scheduleDto.getTitle()%>',
		        	start : '<%=scheduleDto.getStartDate()%>',
		        	end : '<%=scheduleDto.getEndDate()%>',
		        	content : '<%=scheduleDto.getContent()%>',
		        	color : "#FF0000"
		        
		        
		        	},
		        	
		      
		     	//	color : "#3a87ad"// my event data				
		        	<%} else {%>
					{
						title : '<%=scheduleDto.getTitle()%>',
			        	start : '<%=scheduleDto.getStartDate()%>',
			        	end : '<%=scheduleDto.getEndDate()%>',
			        	content : '<%=scheduleDto.getContent()%>',
			        	color : "#3a87ad"
			        
			        
			        	},
					
<%}
				}
			}%>				
			],
		});


	$("#insertEvent").on('click', function() {
		var eventData1 = {
			start : HOstart,
			end : HOend,
			title : $("#fullCalModalToInsert #title").val(),
			content : $("#fullCalModalToInsert #content").val(),
		
		};
		$('#calendar').fullCalendar('renderEvent', eventData1, true);
		$("#fullCalModalToInsert").modal('hide');
		$("#fullCalModalToInsert #title").val("");
		$("#fullCalModalToInsert #content").val("");
		$('#calendar').fullCalendar('unselect');
		   
	});

});
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
	background-color: white;
}
</style>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<header class="headers">
				<h3> 일정관리 </h3>
			</header class="headers">
			<br>
			<div id='calendar'></div>
			<form name="delupp" id="delupp" method="post" action="">
				<input type="hidden" name="act" value="">
				
				 <input type="hidden" name="id" value="<%=member.getEmp_num()%>">
				<input type="hidden" name="title" id ="title" value="">
				<input type="hidden" name="content" id="content" value="">
				<input type="hidden" name="startDate" id="startDate" value="">
				<input type="hidden" name="endDate" id="endDate" value="">
				
				 
				<div id="fullCalModal" class="modal fade">

					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">

								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">x</span> <span class="sr-only">close</span>
								</button>

								<h4 id="startDate" class="modal-title"></h4>
								&nbsp&nbsp
								

								<h4 id="endDate" class="modal-title"></h4><br>
							
								<br>
								<h4 id="modalTitle" class="modal-title">
								
									제목 :  <br>
								</h4>
							</div>
							<div id="modalBody" class="modal-body">
								<h3>내용 :</h3><textarea id="contenttext" name="contenttext" cols="70"></textarea>
							</div>
							<div class="modal-footer">
								<button class="btn btn-primary" id="delete" name="delete" onclick="javascript:deletef();">Delete</button>
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								<button class="btn btn-primary" id="update" name="update" onclick="javascript:updatef();">Update</button>
							</div>
						</div>
					</div>

				</div>
			</form>

			<form name="fddate" id="fddate" method="post" action="">
				<input type="hidden" name="act" value="freedate"> <input
					type="hidden" name="id" value="<%=member.getEmp_num()%>">
					<input type="hidden" name="fds" value="">
				<div id="fullCalModalToInsert" class="modal fade">

					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">

								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">x</span> <span class="sr-only">close</span>
								</button>
								<h4 id="modalTitle" class="modal-title">
									시작날짜 : &nbsp&nbsp<input type="text" name="startDate"
										id="startDate" style="text-align: center;">
								</h4>
								<h4 id="modalTitle" class="modal-title">
									끝 날짜 : &nbsp&nbsp<input type="text" name="endDate" id="endDate"
										style="text-align: center;">
								</h4>


							</div>
							<div id="modalBody" class="modal-body">
								<h3>
									제목 : <br> <input type="text" size="42" name="title"
										id="title">
								</h3>
								<h3>내용 :</h3>
								<textarea id="content" name="content" cols="70"></textarea>
							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>

								<button class="btn btn-primary" type="button"
									id="insertfreedate" onclick="javascript:freedateselector(1);">freedate</button>
								<button class="btn btn-primary" type="button" id="insertEvent"
									onclick="javascript:freedateselector(0);">Insert</button>
							</div>

						</div>
					</div>

				</div>
			</form>
		</div>
	</div>
</div>



</body>
</html>