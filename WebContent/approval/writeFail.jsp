<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String root = request.getContextPath();
%>
<script>
    alert("오류가 발생하여 글 입력이 되지 않았습니다.");
    location.href="<%=root%>/approval/approval.jsp";
</script>
