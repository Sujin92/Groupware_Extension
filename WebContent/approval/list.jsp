<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<div class="col-lg-2" style="height: 100vh">
    <ol>
        <li><a href="approval.jsp">���ڰ��� ����</a></li>
        <li><a href="order_paper.jsp">���繮�� �ۼ�</a></li>
        <li>������ ������
            <ol>
                <li><a href="<%=root%>/appcontrol?act=outstanding">�̰��� ����</a></li>
                <li><a href="confirm.jsp">����Ϸ� ����</a></li>
            </ol>
        </li>
        <li>���ι�����
            <ol>
                <li><a href="<%=root%>/appcontrol?act=ready">��⹮��</a></li>
                <li><a href="individual.jsp">�ӽ�����</a></li>
                <li><a href="individual.jsp">�ݷ�����</a></li>
                <li><a href="individual.jsp">����Ϸ�</a></li>
                <li><a href="individual.jsp">������</a></li>
            </ol>
        </li>
    </ol>
</div>