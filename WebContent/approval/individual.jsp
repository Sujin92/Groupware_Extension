<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<%@ include file="/common/member_header.jsp" %>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">���ڰ��繮��</h1>
            <%--<div id="payment-list" style="position: relative; float: left;">--%>
            <%@include file="list.jsp"%>

            <div class="col-lg-9">
                <script>
                    function changeSelect() {
                        var sel = document.getElementById("sel");
                        var val = sel.options[sel.selectedIndex].value;
                        document.getElementById("search_Category").style.display = 'none';
                        document.getElementById("search_Text1").style.display = 'none';
                        document.getElementById("search_Text2").style.display = 'none';
                        if (val == "paper") {
                            document.getElementById("search_Category").style.display = 'block';
                            document.getElementById("search_Text1").style.display = 'block';
                        } else if (val == 'subject' || val == 'name') {
                            document.getElementById("search_Text2").style.display = 'block';
                        }
                    }
                </script>


                <table style="height: 40px;">
                    <tr>
                        <td>
                            <div>
                                <select id="sel" onchange="javascript:changeSelect();">
                                    <option value="see">��ü����</option>
                                    <option value="paper">���繮�����</option>
                                    <option value="subject">����</option>
                                    <option value="name">�����</option>
                                    <option value="date">�������</option>
                                </select>
                            </div>
                        </td>
                        <td>
                            <div id="search_Category" style="display: none;">
                                <select name="Category">
                                    <option value selected>��ü</option>
                                    <option value="1">��ȼ�</option>
                                    <option value="2">ǰ�Ǽ�</option>
                                    <option value="3">�ް���û��</option>
                                    <option value="4">������Ǽ�</option>

                                </select>
                            </div>
                        </td>
                        <td>
                            <div id="search_Text1" style="display: none;">
                                <input type="search" size="40">
                                <input type="button" value="�˻�">
                            </div>
                        </td>
                        <td>
                            <div id="search_Text2" style="display: none;">
                                <input type="search">
                                <input type="button" value="�˻�">
                            </div>
                        </td>
                    </tr>
                </table>
                <table class="table table-bordered">

                    <thead>
                    <tr>
                        <th>NO</th>
                        <th>������ȣ</th>
                        <th>�������</th>
                        <th>��������</th>
                        <th>������</th>
                        <th>����</th>
                        <th>�ǰ�</th>
                        <th>����/����</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>22</td>
                        <td>2017.11.11</td>
                        <td>������Ʈ ��ȼ�</td>
                        <td>���������Ʈ ������</td>
                        <td>�̰���</td>
                        <td>�ٽ� �ۼ��ϼ���</td>
                        <td>
                            <input type="button" name="" id="" value="����"> /
                            <input type="button" name="" id="" value="����">
                        </td>
                    </tr>
                    </tbody>
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