<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<div class="col-lg-2" style="height: 100vh">
    <ol>
        <li><a href="<%=root%>/appcontrol?act=approval">���ڰ��� ����</a></li>
        <li><a href="<%=root%>/appcontrol?act=writePaper">���繮�� �ۼ�</a></li>
        <li>������ ������
            <ol>
                <li><a href="<%=root%>/appcontrol?act=outstanding">�̰��� ����</a></li>
                <li><a href="<%=root%>/appcontrol?act=complete">����Ϸ� ����</a></li>
            </ol>
        </li>
        <li>���ι�����
            <ol>
                <li><a href="<%=root%>/appcontrol?act=readyDoc&pg=1">��⹮��</a></li>
                <li><a href="<%=root%>/appcontrol?act=returnDoc&pg=1">�ݷ�����</a></li>
                <li><a href="<%=root%>/appcontrol?act=finishDoc&pg=1">����Ϸ�</a></li>
                <li><a href="<%=root%>/appcontrol?act=wholeDoc&pg=1">��Ź���</a></li>
            </ol>
        </li>
    </ol>
</div>