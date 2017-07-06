<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<%@ include file="/common/member_header.jsp" %>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">전자결재문서</h1>
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
                                    <option value="see">전체보기</option>
                                    <option value="paper">결재문서양식</option>
                                    <option value="subject">제목</option>
                                    <option value="name">기안자</option>
                                    <option value="date">기안일자</option>
                                </select>
                            </div>
                        </td>
                        <td>
                            <div id="search_Category" style="display: none;">
                                <select name="Category">
                                    <option value selected>전체</option>
                                    <option value="1">기안서</option>
                                    <option value="2">품의서</option>
                                    <option value="3">휴가신청서</option>
                                    <option value="4">지출결의서</option>

                                </select>
                            </div>
                        </td>
                        <td>
                            <div id="search_Text1" style="display: none;">
                                <input type="search" size="40">
                                <input type="button" value="검색">
                            </div>
                        </td>
                        <td>
                            <div id="search_Text2" style="display: none;">
                                <input type="search">
                                <input type="button" value="검색">
                            </div>
                        </td>
                    </tr>
                </table>
                <table class="table table-bordered">

                    <thead>
                    <tr>
                        <th>NO</th>
                        <th>문서번호</th>
                        <th>기안일자</th>
                        <th>문서종류</th>
                        <th>문서명</th>
                        <th>상태</th>
                        <th>의견</th>
                        <th>수정/삭제</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>22</td>
                        <td>2017.11.11</td>
                        <td>프로젝트 기안서</td>
                        <td>모아프로젝트 수정서</td>
                        <td>미결재</td>
                        <td>다시 작성하세요</td>
                        <td>
                            <input type="button" name="" id="" value="수정"> /
                            <input type="button" name="" id="" value="삭제">
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