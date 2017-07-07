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
            <%@include file="list.jsp"%>



        </div>
        <!-- /.col-lg-12 -->
    </div>
</div>
<!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->


</body>
</html>