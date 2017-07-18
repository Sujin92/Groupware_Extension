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
				<h3> ���ڰ��� </h3>
			</header class="headers">
			<br>
            <%--<div id="payment-list" style="position: relative; float: left;">--%>
            <%@include file="list.jsp"%>
			
            <div class="col-lg-3">
                <div>������ ������</div>
                <table class="table table-bordered">
                    <tr>
                        <th>�̰���</th>
                        <td><%=map.get(5) %>��</td>
                    </tr>
                    <tr>
                        <th>����</th>
                        <td><%=map.get(6) %>��</td>
                    </tr>
                </table>
            </div>
            <div class="col-lg-3">
                <div>���� ������</div>
                <table class="table table-bordered">
                    <tr>
                        <th>��⹮��</th>
                        <td><%=map.get(1)%>��</td>
                        <th>�ݷ�����</th>
                        <td><%=map.get(3)%>��</td>
                    </tr>
                    <tr>
                        <th>����Ϸ�</th>
                        <td><%=map.get(2)%>��</td>
                        <th>��Ź���</th>
                        <td><%=map.get(4)%>��</td>
                    </tr>
                </table>
            </div>
            <div class="col-lg-6">
                <div>������ ������ > �̰��� ����</div>
                <table class="table table-bordered">
                    <tr>
                        <th>������ȣ</th>
                        <th>�������</th>
                        <th>������</th>
                        <th>�����</th>
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
                            �̰��� ������ �������� �ʽ��ϴ�.<br><br>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>
            <div class="col-lg-6">
                <div>���� ������ > ��Ź���</div>
                <table class="table table-bordered">
                    <tr>
                        <th>������ȣ</th>
                        <th>�������</th>
                        <th>������</th>
                        <th>����</th>
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
                            ��� ������ �������� �ʽ��ϴ�.<br><br>
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
    alert("�������� URL�����Դϴ�.");
    document.location.href = "<%=root%>";
</script>
<%
    }
%>