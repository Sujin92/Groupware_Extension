<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" import="java.util.Map, java.util.List, com.moaware.approval.model.ApprovalDto"%>
<%@ include file="/common/member_header.jsp"%>
<%
    MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
    Map map = (Map) request.getAttribute("doc1");
    List<ApprovalDto> list1 = (List<ApprovalDto>) request.getAttribute("doc2");
    List<ApprovalDto> list2 = (List<ApprovalDto>) request.getAttribute("doc3");
    if(list1 != null && list2 != null) {
%>
<link href="<%=root%>/dist/css/project.css" rel="stylesheet">
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
           		<header class="headers">
				<h3> 전자결재 </h3>
			</header class="headers">
			<br>
            <%--<div id="payment-list" style="position: relative; float: left;">--%>
            <%@include file="list.jsp"%>
			
            <div class="col-lg-3">
                <div>결재할 문서함</div>
                <table class="table table-bordered">
                    <tr>
                        <th>미결재</th>
                        <td><%=map.get(5) %>건</td>
                    </tr>
                    <tr>
                        <th>결재</th>
                        <td><%=map.get(6) %>건</td>
                    </tr>
                </table>
            </div>
            <div class="col-lg-3">
                <div>개인 문서함</div>
                <table class="table table-bordered">
                    <tr>
                        <th>대기문서</th>
                        <td><%=map.get(1)%>건</td>
                        <th>반려문서</th>
                        <td><%=map.get(3)%>건</td>
                    </tr>
                    <tr>
                        <th>결재완료</th>
                        <td><%=map.get(2)%>건</td>
                        <th>상신문서</th>
                        <td><%=map.get(4)%>건</td>
                    </tr>
                </table>
            </div>
            <div class="col-lg-6">
                <div>결재할 문서함 > 미결재 문서</div>
                <table class="table table-bordered">
                    <tr>
                        <th>문서번호</th>
                        <th>기안일자</th>
                        <th>문서명</th>
                        <th>기안자</th>
                    </tr>
                    <%
                        int count1 = list1.size();
                        if(count1 != 0) {
                            for(int i=0; i < count1; i++) {
                                ApprovalDto approvalDto = list1.get(i);
                                if(i > 4)
                                    break;
                    %>
                    <tr>
                        <td><%=approvalDto.getDoc_num() %></td>
                        <td><%=approvalDto.getDraft_date() %></td>
                        <td><%=approvalDto.getDoc_subject() %></td>
                        <td><%=approvalDto.getEmp_num() %></td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr align="center">
                        <td align="center" class="text_gray" colspan="5"><br>
                            미결재 문서가 존재하지 않습니다.<br><br>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>
            <div class="col-lg-6">
                <div>개인 문서함 > 상신문서</div>
                <table class="table table-bordered">
                    <tr>
                        <th>문서번호</th>
                        <th>기안일자</th>
                        <th>문서명</th>
                        <th>상태</th>
                    </tr>
                    <%
                        int count2 = list2.size();
                        if(count2 != 0) {
                            for(int i=0; i < count2; i++) {
                                ApprovalDto approvalDto = list2.get(i);
                                if(i > 4)
                                    break;
                    %>
                    <tr>
                        <td><%=approvalDto.getDoc_num() %></td>
                        <td><%=approvalDto.getDraft_date() %></td>
                        <td><%=approvalDto.getDoc_subject() %></td>
                        <td><%=approvalDto.getDoc_state() %></td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr align="center">
                        <td align="center" class="text_gray" colspan="5"><br>
                            상신 문서가 존재하지 않습니다.<br><br>
                        </td>
                    </tr>
                    <%
                        }
                    %>
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
<%
} else {
%>
<script>
    alert("부적절한 URL접근입니다.");
    document.location.href = "<%=root%>";
</script>
<%
    }
%>