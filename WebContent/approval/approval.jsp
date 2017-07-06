<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<%@ include file="/common/member_header.jsp" %>
<%
    MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">전자결재문서</h1>
            <%--<div id="payment-list" style="position: relative; float: left;">--%>
            <%@include file="list.jsp"%>

            <div class="col-lg-3">
                <div>결재할 문서함</div>
                <table class="table table-bordered">
                <tr>
                    <th>미결재</th>
                    <td>0건</td>
                </tr>
                <tr>
                    <th>결재</th>
                    <td>0건</td>
                </tr>
            </table>
            </div>
            <div class="col-lg-3">
                <div>개인 문서함</div>
                <table class="table table-bordered">
                    <tr>
                        <th>상신문서</th>
                        <td>0건</td>
                        <th>반려문서</th>
                        <td>0건</td>
                    </tr>
                    <tr>
                        <th>상신취소</th>
                        <td>0건</td>
                        <th>결재완료</th>
                        <td>0건</td>
                    </tr>
                </table>
            </div>
            <div class="col-lg-8">
                <div>결재할 문서함 > 미결재 문서</div>
                <table class="table table-bordered">
                    <tr>
                        <th>문서번호</th>
                        <th>기안일자</th>
                        <th>문서명</th>
                        <th>기안자</th>
                        <th>나의결재</th>
                        <th>상태</th>
                        <th>다음결재자</th>
                        <th>의견</th>
                    </tr>
                    <tr>
                        <td>22</td>
                        <td>2020.02.30</td>
                        <td>모아 기안서</td>
                        <td>정현우</td>
                        <td>미결재</td>
                        <td>진행중</td>
                        <td>박부장</td>
                        <td>..</td>
                    </tr>
                </table>
            </div>
            <div class="col-lg-8">
                <div>개인 문서함 > 상신문서</div>
                <table class="table table-bordered">
                    <tr>
                        <th>문서번호</th>
                        <th>기안일자</th>
                        <th>문서명</th>
                        <th>상태</th>
                        <th>의견</th>
                    </tr>
                    <tr>
                        <td>22</td>
                        <td>2020.02.30</td>
                        <td>모아 기안서</td>
                        <td>정현우</td>
                        <td>미결재</td>
                    </tr>
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