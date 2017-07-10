<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.moaware.schedule.model.ScheduleDto, java.util.List"%>
<%@ include file="/common/member_header.jsp"%>
<%
	String root1 = request.getContextPath();
	MemberDto memberDto = (MemberDto)session.getAttribute("loginInfo"); 
%>


<% 
	//List<ScheduleDto> list = (List<SchduleDto>)request.getAttribute("fullCalModal ");
	
%>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  
<link href='<%=root1%>/css/fullcalendar.css' rel='stylesheet' />
<link href='<%=root1%>/css/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='<%=root1%>/js/lib/moment.min.js' charset="utf-8"></script>
<script src='<%=root1%>/js/lib/jquery.min.js' charset="utf-8"></script>
<script src='<%=root1%>/js/lib/jquery-ui.min.js' charset="utf-8"></script>
<script src='<%=root1%>/js/fullcalendar.js' charset="utf-8"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script>

var eventData;
	$(document).ready(function() {
		var eventData;
		var HOstart;
		var HOend;
		 $('#datepicker').datepicker({
		        inline: true,
		        onSelect: function(dateText, inst) {
		            var d = new Date(dateText);
		            $('#calendar').fullCalendar('gotoDate', d);
		            console.log(d);
		        }
		    }); 

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
			},
			
			editable : true,
			eventLimit : true, // allow "more" link when too many events
			eventClick : function(event, element) {
				if (title) {
					$("#fullCalModal").modal({"show" : true});
					$("#fullCalModal #modalTitle").text(event.title);
					$("#fullCalModal #modalBody").text(event.content);
					$("#fullCalModal #startTime").text(HOstart);
					$("#fullCalModal #endTime").text(HOend);
					$("#delete").on('click', function() {
						$('#calendar').fullCalendar('removeEvents',event._id);
						$("#fullCalModal").modal('hide');
					});
				}
			}
			  
		});
		
	/*$(document).on('click', '.fc-day-grid-event', function() {
		console.log(13);
		
		$(this).css('background-color', 'black');
	});
*/
	
$("#insertEvent").on('click', function() {
	eventData = {
		start : HOstart,
		end : HOend,
		title : $("#fullCalModalToInsert #title").val(),
		content : $("#fullCalModalToInsert #content").val()
	};
	$('#calendar').fullCalendar('renderEvent', eventData, true);
	$("#fullCalModalToInsert").modal('hide');
	$("#fullCalModalToInsert #title").val("");
	$("#fullCalModalToInsert #content").val("");
	$('#calendar').fullCalendar('unselect');
});

	});
</script>
<style>
body {
	margin: 40px 10px;
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
</head>
<body>

	<div style="float:right;"><p>Date: <input type="text" id="datepicker"></p></div>
	<div id='calendar' style="float:right;"></div>
	
	
	<div id="fullCalModal" class="modal fade">

	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">x</span> <span class="sr-only">close</span></button>
	              
	                <h4 id="startTime" class="modal-title"></h4>&nbsp&nbsp
	                <h4 id="endTime" class="modal-title"></h4><br>
	                <h4 id="modalTitle" class="modal-title">力格 : <br></h4>
	            </div>
	            <div id="modalBody" class="modal-body"><h3>郴侩 : </h3></div>
	            <div class="modal-footer">
	                <button class="btn btn-primary" id="delete"> Delete </button>
	                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	                <button class="btn btn-primary" id="storage"> Storage </button>
	            </div>
	        </div>
	    </div>
	  
	</div>

	<div id="fullCalModalToInsert" class="modal fade">

		<input type="hidden" id="startDate" />
		<input type="hidden" id="endDate" />
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	            	
	                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">x</span> <span class="sr-only">close</span></button>
	                
	                <h3 id="modalTitle" class="modal-title">力格 : <br><input type="text"  size="42" name="title" id="title"></h3>
	            </div>
	            <div id="modalBody" class="modal-body"><h3>郴侩 : </h3><textarea id="content" cols="70"> </textarea></div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	                <button class="btn btn-primary" id="insertEvent"> Insert </button>
	            </div>
	        </div>
	    </div>
	
	</div>

	
</body>
</html>