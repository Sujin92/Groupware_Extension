<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<%@ include file="/common/member_header.jsp" %>
<%
    MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">���ڰ��繮��</h1>
            <%--<div id="payment-list" style="position: relative; float: left;">--%>
            <%@include file="list.jsp"%>

            <div class="col-lg-3">
                <div>������ ������</div>
                <table class="table table-bordered">
                <tr>
                    <th>�̰���</th>
                    <td>0��</td>
                </tr>
                <tr>
                    <th>����</th>
                    <td>0��</td>
                </tr>
            </table>
            </div>
            <div class="col-lg-3">
                <div>���� ������</div>
                <table class="table table-bordered">
                    <tr>
                        <th>��Ź���</th>
                        <td>0��</td>
                        <th>�ݷ�����</th>
                        <td>0��</td>
                    </tr>
                    <tr>
                        <th>������</th>
                        <td>0��</td>
                        <th>����Ϸ�</th>
                        <td>0��</td>
                    </tr>
                </table>
            </div>
            <div class="col-lg-8">
                <div>������ ������ > �̰��� ����</div>
                <table class="table table-bordered">
                    <tr>
                        <th>������ȣ</th>
                        <th>�������</th>
                        <th>������</th>
                        <th>�����</th>
                        <th>���ǰ���</th>
                        <th>����</th>
                        <th>����������</th>
                        <th>�ǰ�</th>
                    </tr>
                    <tr>
                        <td>22</td>
                        <td>2020.02.30</td>
                        <td>��� ��ȼ�</td>
                        <td>������</td>
                        <td>�̰���</td>
                        <td>������</td>
                        <td>�ں���</td>
                        <td>..</td>
                    </tr>
                </table>
            </div>
            <div class="col-lg-8">
                <div>���� ������ > ��Ź���</div>
                <table class="table table-bordered">
                    <tr>
                        <th>������ȣ</th>
                        <th>�������</th>
                        <th>������</th>
                        <th>����</th>
                        <th>�ǰ�</th>
                    </tr>
                    <tr>
                        <td>22</td>
                        <td>2020.02.30</td>
                        <td>��� ��ȼ�</td>
                        <td>������</td>
                        <td>�̰���</td>
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