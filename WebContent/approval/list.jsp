<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<div class="col-lg-2" style="height: 100vh">
    <ol>
        <li><a href="<%=root%>/appcontrol?act=approval">전자결재 메인</a></li>
        <li><a href="<%=root%>/appcontrol?act=writePaper">결재문서 작성</a></li>
        <li>결재할 문서함
            <ol>
                <li><a href="<%=root%>/appcontrol?act=outstanding">미결재 문서</a></li>
                <li><a href="<%=root%>/appcontrol?act=complete">결재완료 문서</a></li>
            </ol>
        </li>
        <li>개인문서함
            <ol>
                <li><a href="<%=root%>/appcontrol?act=readyDoc&pg=1">대기문서</a></li>
                <li><a href="<%=root%>/appcontrol?act=returnDoc&pg=1">반려문서</a></li>
                <li><a href="<%=root%>/appcontrol?act=finishDoc&pg=1">결재완료</a></li>
                <li><a href="<%=root%>/appcontrol?act=wholeDoc&pg=1">상신문서</a></li>
            </ol>
        </li>
    </ol>
</div>