<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<div class="col-lg-2" style="height: 100vh">
    <ol>
        <li><a href="approval.jsp">전자결재 메인</a></li>
        <li><a href="order_paper.jsp">결재문서 작성</a></li>
        <li>결재할 문서함
            <ol>
                <li><a href="<%=root%>/appcontrol?act=outstanding">미결재 문서</a></li>
                <li><a href="confirm.jsp">결재완료 문서</a></li>
            </ol>
        </li>
        <li>개인문서함
            <ol>
                <li><a href="<%=root%>/appcontrol?act=ready">대기문서</a></li>
                <li><a href="individual.jsp">임시저장</a></li>
                <li><a href="individual.jsp">반려문서</a></li>
                <li><a href="individual.jsp">결재완료</a></li>
                <li><a href="individual.jsp">상신취소</a></li>
            </ol>
        </li>
    </ol>
</div>