<%@ page import="com.moaware.approval.model.ApprovalDto" %>
<%@ page import="com.moaware.approval.model.ConfirmDto" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<%
    ApprovalDto approvalDto = (ApprovalDto) request.getAttribute("view");
    ConfirmDto confirmDto = (ConfirmDto) request.getAttribute("confirmList");
    MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");

    System.out.println(confirmDto);

    if (approvalDto != null && memberDto != null) {
%>
<%@ include file="/common/member_header.jsp" %>
<script>
    var pos;
    function confirm(p) {
        pos = p;
        sendRequest("<%=root%>/appcontrol", "act=confirm", approval, "GET");
    }

    function approval() {

    }
</script>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">전자결재문서</h1>
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
                            <td><%=approvalDto.getDoc_num()%>
                            <th rowspan="2">결재</th>
                            <td id="confirm" rowspan="2">
                                <div id="confirm1">
                                    <%
                                        if (confirmDto.getConfirm1_name() != null) {
                                    %>
                                    <%=confirmDto.getConfirm1_position()%><%=confirmDto.getConfirm1_name()%>
                                    <%
                                    } else {
                                    %>
                                    없음
                                    <%
                                        }
                                    %>
                                </div>
                                <%
                                    if (memberDto.getEmp_num().equals(approvalDto.getConfirm_line_1())) {
                                %>
                                <input type="button" value="결재" id="sel1" onclick="confirm(1, );"
                                       style="display: block">
                                <input type="button" value="취소" id="ch1" onclick="doModal(1);" style="display: none">
                                <%
                                    }
                                %>
                            </td>
                            <td rowspan="2">
                                <div id="confirm2">
                                    <%
                                        if (confirmDto.getConfirm2_name() != null) {
                                    %>
                                    <%=confirmDto.getConfirm2_position()%><%=confirmDto.getConfirm2_name()%>
                                    <%
                                    } else {
                                    %>
                                    없음
                                    <%
                                        }
                                    %>
                                </div>
                                <%
                                    if (memberDto.getEmp_num().equals(approvalDto.getConfirm_line_2())) {
                                %>
                                <input type="button" value="결재" id="sel2" onclick="doModal(2);" style="display: block">
                                <input type="button" value="취소" id="ch2" onclick="doModal(2);" style="display: none">
                                <%
                                    }
                                %>
                            </td>
                            <td rowspan="2">
                                <div id="confirm3">
                                    <%
                                        if (confirmDto.getConfirm3_name() != null) {
                                    %>
                                    <%=confirmDto.getConfirm3_position()%><%=confirmDto.getConfirm3_name()%>
                                    <%
                                    } else {
                                    %>
                                    없음
                                    <%
                                        }
                                    %>
                                </div>
                                <%
                                    if (memberDto.getEmp_num().equals(approvalDto.getConfirm_line_3())) {
                                %>
                                <input type="button" value="결재" id="sel3" onclick="confirm(3);" style="display: block">
                                <input type="button" value="취소" id="ch3" onclick="doModal(3);" style="display: none">
                                <%
                                    }
                                %>
                            </td>
                        </tr>
                        <tr>
                            <th>문서종류</th>
                            <td>기안서</td>

                        </tr>
                        <tr>
                            <th>기안일</th>
                            <td>
                                <%=approvalDto.getDraft_date()%>
                            </td>
                            <th>수신부서</th>
                            <td colspan="3">
                                <%=approvalDto.getReceive_dept()%>
                                <%--<input type="text" id="receiveDept" name="receiveDept">--%>
                                <%--<input type="button" name="selectDept" id="selectDept" onclick="doModalDept();"--%>
                                <%--value="수신부서지정">--%>
                                <%--<input type="button" name="viewDept" id="viewDept" value="수신부서보기">--%>
                            </td>
                        </tr>
                        <tr>
                            <th>기안자</th>
                            <td>사원 <%=approvalDto.getEmp_name()%>
                            </td>
                            <th>부서</th>
                            <td colspan="3"><%=approvalDto.getDept_name()%>
                            </td>
                        </tr>
                        <tr>
                            <th>제목</th>
                            <td colspan="5">
                                <%=approvalDto.getDoc_subject()%>
                            </td>
                        </tr>
                        <%-- Naver SmartEditor --%>
                        <tr>
                            <td colspan="6">
                                <%=approvalDto.getDoc_content()%>
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
<%
} else {
%>
<script>
    alert("!!");
</script>
<%
    }
%>