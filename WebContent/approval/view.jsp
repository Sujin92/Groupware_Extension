<%@ page import="com.moaware.approval.model.ApprovalDto" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<%
    ApprovalDto approvalDto = (ApprovalDto) request.getAttribute("view");

%>
<%@ include file="/common/member_header.jsp" %>
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
                            <td>사원 <%=approvalDto.getEmp_name()%>
                            </td>
                            <th>부서</th>
                            <td colspan="3">아직 안함
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