<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<%@ include file="/common/member_header.jsp" %>
<%
    MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
    String doc_seq = (String) request.getAttribute("writePaper");
%>
<script type="text/javascript" src="/moa/js/myajax.js"></script>
<!-- Project CSS -->
<link href="<%=root%>/dist/css/project.css" rel="stylesheet">
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.js"></script>
<script>
    window.onload = function () {
        var date = new Date();
        document.getElementById("year").value = date.getFullYear();
        document.getElementById("month").value = date.getMonth() + 1;
        document.getElementById("day").value = date.getDate();
    }

    function save() {

        if (document.getElementById("year").value == "") {
            alert("년도를 입력해주세요");
            return;
        } else if (document.getElementById("month").value == "") {
            alert("월을 입력해주세요");
            return;
        } else if (document.getElementById("day").value == "") {
            alert("일을 입력해주세요");
            return;
        } else if (document.getElementById("receiveDept").value == "") {
            alert("수신부서를 지정해주세요");
            return;
        } else if (document.getElementById("subject").value == "") {
            alert("제목을 작성해주세요");
            return;
        } else if (document.getElementById("content").value == "") {
            alert("내용을 입력해주세요");
            return;
        } else {
//            oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
            document.paperForm.action = "<%=root%>/appcontrol";
            document.paperForm.submit();
        }
    }

    var modal;
    var span;
    var position;
    function doModal(p) {
        position = p;
        modal = document.getElementById("myModal");
        span = document.getElementsByClassName("close")[0];
        modal.style.display = "block";
        sendRequest("<%=root%>/appcontrol", "act=getmember", displayModal, "GET");
    }

    function displayModal() {
        if (httpRequest.readyState == 4) {
            if (httpRequest.status == 200) {
                var tmp = httpRequest.responseText;
                var txt = JSON.parse(tmp);
                var i;
                var x = "";
                var dept = "";
//                var test = "2";
                for (i in txt.info) {
                    if (txt.info[i].dept_num !== dept) {
                        dept = txt.info[i].dept_num;
                        if (i != 0)
                            x += "</ul>";
                        x += "<ul style=\"list-style-type: none\"><b>" + txt.info[i].dept_num + "</b>";

                    }
//                <a href=\"writeModal('" + txt.info[i].emp_num + "')\"</a>
//                    x += "<li id='" + txt.info[i].emp_num + "'>" + txt.info[i].position_num + " " + txt.info[i].name + "</li>";

                    x += "<li onclick='getMember(" + JSON.stringify(txt.info[i]) + ")' id='" + txt.info[i].emp_num + "'>" + txt.info[i].position_num + " " + txt.info[i].name + "</li>";
                }
                x += "</ul>";
                document.getElementById("getmember").innerHTML = x;
//                for (i in txt.info) {
//                    document.getElementById("14").addEventListener("click", getMember(txt.info[i]), false);
//                    $('#txt.info[i].emp_num').click(getMember(txt.info[i]));
//                    console.log("txt.info [i] :  " + txt.info[i].emp_num);
//                }
            } else {
                alert("문제발생 : " + httpRequest.status);
            }
        }
    }

    function getMember(m) {
        var p = position;
//        var txt = JSON.parse(m);
        var confirm = "confirm" + p;
        var sel = "sel" + p;
        var ch = "ch" + p;
        document.getElementById("confirm_line" + p).value = m.emp_num;
        document.getElementById(confirm).innerHTML = m.position_num + " " + m.name;
        document.getElementById(sel).style.display = "none";
        document.getElementById(ch).style.display = "block";
        closeModal();
    }

    function closeModal() {
        modal.style.display = "none";
    }

    function closeModalDept() {
        modal2.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        } else if (event.target == modal2) {
            modal2.style.display = "none";
        }
    }

    var modal2;
    var span2;
    function doModalDept() {
        modal2 = document.getElementById("myModalDept");
        span2 = document.getElementsByClassName("close")[0];
        modal2.style.display = "block";
        sendRequest("<%=root%>/appcontrol", "act=getdept", displayModalDept, "GET");
    }

    function displayModalDept() {
        if (httpRequest.readyState == 4) {
            if (httpRequest.status == 200) {
                var tmp = httpRequest.responseText;
                var txt = JSON.parse(tmp);
                var i;
                var x = "";
                x+= "<select id=\"selDept\">";
                for (i in txt.info) {
//                    x += "<input type='checkbox' name='dept'>" + txt.info[i].dept_name + "&nbsp;";
                    x += "<option value=\"" + txt.info[i].dept_name + "\">" + txt.info[i].dept_name + "</option>";
                }
                x += "</select>";
                document.getElementById("getdept").innerHTML = x;
            } else {
                alert("문제발생 : " + httpRequest.status);
            }
        }
    }

    function getDept() {
        document.getElementById("receiveDept").value = document.getElementById("selDept").value;
        closeModalDept();
    }

    $(document).ready(function () {
        $('#content').summernote({
            height: 700,
            minHeight: null,
            maxHeight: null,
            focus: true
        });
    });

</script>
<style>
    /* The Modal (background) */
    .modal {
        display: none; /* Hidden by default */
        position: fixed; /* Stay in place */
        z-index: 1; /* Sit on top */
        padding-top: 100px; /* Location of the box */
        left: 250px;
        top: 0;
        width: 100%; /* Full width */
        /*height: 100%; !* Full height *!*/
        overflow: auto; /* Enable scroll if needed */
        /*background-color: rgb(255, 255, 255); !* Fallback color *!*/
        /*background-color: rgba(255, 105, 75, 0.4); !* Black w/ opacity *!*/
    }

    /* Modal Content */
    .modal-content {
        background-color: #fefefe;
        margin: auto;
        padding: 10px;
        border: 1px solid #888;
        width: 700px;
    }

    /* The Close Button */
    .close {
        color: #aaaaaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
    }

    .close:hover,
    .close:focus {
        color: #000;
        text-decoration: none;
        cursor: pointer;
    }
</style>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
        	<header class="headers">
				<h3> 전자결재 </h3>
			</header class="headers">
			<br>
            <%--<div id="payment-list" style="position: relative; float: left;">--%>
            <%@include file="list.jsp" %>

            <div class="col-lg-9">

                <div id="myModal" class="modal col-lg-4">

                    <!-- Modal content -->
                    <div class="modal-content" align="center">
                        <span class="close" onclick="closeModal();">&times;</span>
                        <div id="getmember"></div>
                    </div>

                </div>

                <div id="myModalDept" class="modal col-lg-4">

                    <!-- Modal content -->
                    <div class="modal-content" align="center">
                        <span class="close" onclick="closeModal();">&times;</span>
                        <div id="getdept"></div>
                        <div align="center">
                            <input type="button" value="확인" onclick="getDept()">
                            <input type="button" value="취소" onclick="closeModalDept()">
                        </div>
                    </div>

                </div>

                <div align="center" style="font-size: 30px">기안서</div>
                <form name="paperForm" method="post" action="">
                    <input type="hidden" id="confirm_line1" name="confirm_line1" value="">
                    <input type="hidden" id="confirm_line2" name="confirm_line2" value="">
                    <input type="hidden" id="confirm_line3" name="confirm_line3" value="">
                    <input type="hidden" name="act" value="write">
                    <table class="table table-bordered">
                        <tr>
                            <th>문서번호</th>
                            <td><%=doc_seq%></td>
                            <th rowspan="2">결재</th>
                            <td id="confirm" rowspan="2">
                                <div id="confirm1"></div>
                                <input type="button" value="선택" id="sel1" onclick="doModal(1);" style="display: block">
                                <input type="button" value="변경" id="ch1" onclick="doModal(1);" style="display: none">

                            </td>
                            <td rowspan="2">
                                <div id="confirm2"></div>
                                <input type="button" value="선택" id="sel2" onclick="doModal(2);" style="display: block">
                                <input type="button" value="변경" id="ch2" onclick="doModal(2);" style="display: none">
                            </td>
                            <td rowspan="2">
                                <div id="confirm3"></div>
                                <input type="button" value="선택" id="sel3" onclick="doModal(3);" style="display: block">
                                <input type="button" value="변경" id="ch3" onclick="doModal(3);" style="display: none">
                            </td>
                        </tr>
                        <tr>
                            <th>문서종류</th>
                            <td>기안서</td>

                        </tr>
                        <tr>
                            <th>기안일</th>
                            <td>
                                <input type="text" id="year" name="year">년
                                <input type="text" id="month" name="month">월
                                <input type="text" id="day" name="day">일
                            </td>
                            <th>수신부서</th>
                            <td colspan="3">
                                <input type="text" id="receiveDept" name="receiveDept">
                                <input type="button" name="selectDept" id="selectDept" onclick="doModalDept();"
                                       value="수신부서지정">
                                <%--<input type="button" name="viewDept" id="viewDept" value="수신부서보기">--%>
                            </td>
                        </tr>
                        <tr>
                            <th>기안자</th>
                            <td>사원 <%=memberDto.getName()%>
                            </td>
                            <th>부서</th>
                            <td colspan="3"><%=memberDto.getDept_num()%>
                            </td>
                        </tr>
                        <tr>
                            <th>제목</th>
                            <td colspan="5">
                                <input type="text" size="100%" id="subject" name="subject">
                            </td>
                        </tr>
                        <%-- Naver SmartEditor --%>
                        <tr>
                            <td colspan="6">
                            <textarea name="content" id="content" cols="" rows="30" style="width: 100%;">
                            </textarea>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="6" align="center">
                                <input type="button" value="저장" onclick="javascript:save();">
                                <input type="reset" value="취소">
                            </td>
                        </tr>
                    </table>
                </form>
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