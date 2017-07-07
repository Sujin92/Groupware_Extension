<%@ page import="java.util.List" %>
<%@ page import="com.moaware.approval.model.ApprovalDto" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<%@ include file="/common/member_header.jsp" %>
<%
    List<ApprovalDto> list = (List<ApprovalDto>) request.getAttribute("list");
%>
<script>
    function viewPaper(num) {
        document.appForm.act.value = "view";
//        document.appForm.bcode.value = bcode;
//        document.appForm.pg.value = pg;
//        document.appForm.key.value = key;
//        document.appForm.word.value = word;
        document.appForm.seq.value = num;

        document.appForm.action = "<%=root%>/appcontrol";
        document.appForm.submit();
    }
</script>
<form name="appForm" method="post" action="">
    <input type="hidden" name="act" value="">
    <input type="hidden" name="bcode" value="">
    <input type="hidden" name="pg" value="">
    <input type="hidden" name="key" value="">
    <input type="hidden" name="word" value="">
    <input type="hidden" name="seq" value="">
</form>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">전자결재문서</h1>
            <%--<div id="payment-list" style="position: relative; float: left;">--%>
            <%@include file="list.jsp" %>

            <div class="col-lg-9">
                <script>
                    function changeSelect() {
                        var sel = document.getElementById("sel");
                        var val = sel.options[sel.selectedIndex].value;
                        document.getElementById("search_Category").style.display = 'none';
                        document.getElementById("search_Text").style.display = 'none'
                        if (val == "paper") {
                            document.getElementById("search_Category").style.display = 'block';
                            document.getElementById("search_Text").style.display = 'block';
                            document.getElementById("word").size = "40";
                        } else if (val == 'subject' || val == 'name' || val == 'num') {
                            document.getElementById("search_Text").style.display = 'block';
                        }
                    }
                </script>


                <table style="height: 40px;">
                    <tr>
                        <td>
                            <div>
                                <select id="sel" onchange="javascript:changeSelect();">
                                    <option value="see">전체보기</option>
                                    <option value="num">문서번호</option>
                                    <option value="paper">결재문서양식</option>
                                    <option value="subject">제목</option>
                                    <option value="name">기안자</option>
                                    <option value="date">기안일자</option>
                                </select>
                            </div>
                        </td>
                        <td>
                            <div id="search_Category" style="display: none;">
                                <select name="Category">
                                    <option value selected>전체</option>
                                    <option value="1">기안서</option>
                                    <option value="2">품의서</option>
                                    <option value="3">휴가신청서</option>
                                    <option value="4">지출결의서</option>

                                </select>
                            </div>
                        </td>
                        <td>
                            <div id="search_Text" style="display: none;">
                                <input type="search" id="word">
                                <input type="button" value="검색">
                            </div>
                        </td>
                    </tr>
                </table>
                <table class="table table-bordered">

                    <thead>
                    <tr>
                        <th>문서정보</th>
                        <th>기안일자</th>
                        <th>결재일자</th>
                        <th>문서명</th>
                        <th>기안자</th>
                        <th>나의결재</th>
                        <th>상태</th>
                        <th>의견</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        if (!list.isEmpty()) {
                            int size = list.size();
                            for (int i = 0; i < size; i++) {
                                ApprovalDto approvalDto = list.get(i);
                    %>
                    <tr>
                        <td><%=approvalDto.getDoc_num()%></td>
                        <td><%=approvalDto.getDraft_date()%></td>
                        <td>@2017.11.11</td>
                        <td onclick="javascript:viewPaper(<%=approvalDto.getDoc_num()%>)"><%=approvalDto.getDoc_subject()%></td>
                        <td><%=approvalDto.getEmp_name()%></td>
                        <td>미결재</td>
                        <td>미결</td>
                        <td>비고</td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <%
                        }
                    %>
                    </tbody>
                </table>
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