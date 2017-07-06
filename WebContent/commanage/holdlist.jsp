<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="java.util.*, com.moaware.admin.cominfo.model.CominfoDto, com.moaware.member.model.MemberDetailDto, com.moaware.admin.cominfo.util.PageNavigation"
	import="com.moaware.member.model.MemberDto"%>
<%@ include file="/common/admin_header.jsp"%>
<%
	root = request.getContextPath();
	int pg = Integer.parseInt(request.getParameter("pg"));
	List<CominfoDto> list = (List<CominfoDto>) request.getAttribute("holdList");
	if (list != null) {
		PageNavigation navigator = (PageNavigation) request.getAttribute("navigator");
%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
function openzip() {
    new daum.Postcode({
        oncomplete: function(data) {
            // �������� ������ ���� ���� ��쿣 ����('')���� �����Ƿ�, �̸� �����Ͽ� �б� �Ѵ�.
            var fullAddr = ''; // ���� �ּ� ����
            var extraAddr = ''; // ������ �ּ� ����

            // ����ڰ� ������ �ּ� Ÿ�Կ� ���� �ش� �ּ� ���� �����´�.
            if (data.userSelectedType === 'R') { // ����ڰ� ���θ� �ּҸ� �������� ���
                fullAddr = data.roadAddress;
            } else { // ����ڰ� ���� �ּҸ� �������� ���
                fullAddr = data.jibunAddress;
            }

            // ����ڰ� ������ �ּҰ� ���θ� Ÿ���϶� �����Ѵ�.
            if(data.userSelectedType === 'R'){
                //���������� ���� ��� �߰��Ѵ�.
                if(data.bname !== ''){
                    extraAddr += data.bname;
                }
                // �ǹ����� ���� ��� �߰��Ѵ�.
                if(data.buildingName !== ''){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // �������ּ��� ������ ���� ���ʿ� ��ȣ�� �߰��Ͽ� ���� �ּҸ� �����.
                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
            }
            document.getElementById("zip1").value = data.postcode1;
            document.getElementById("zip2").value = data.postcode2;
            document.getElementById("addr1").value = fullAddr;
            document.getElementById("addr2").focus();
        }
    }).open();
}

var pg = "<%=pg%>";

function retireList() {
	document.location.href="<%=root%>/comInfo?act=retireList&pg=1";
}

function listArticle(mpg) { //mpg : movepage	//������ �ִ� ������
	document.commonForm.act.value = "holdList";
	document.commonForm.pg.value = mpg;
	
	document.commonForm.action = "<%=root%>/comInfo";
	document.commonForm.submit();
}

function firstArticle() { //�� ù��° ������
	document.commonForm.act.value = "holdList";
	document.commonForm.pg.value = "1";
	
	document.commonForm.action = "<%=root%>/comInfo";
	document.commonForm.submit();
}

function modal(seq) { //modalâ���� ������ ��������
	var emp_num = $("#seq").val();
	document.getElementById("dept_name").value = document.getElementById("dept_name"+seq).textContent;
	//var checkedValue = $("input[type=stext][name=dept_name]").val();
	//alert(checkedValue);
	document.getElementById("position_name").value = document.getElementById("position_name"+seq).textContent;
	document.getElementById("id").value = document.getElementById("id"+seq).textContent;
	document.getElementById("name").value = document.getElementById("name"+seq).textContent;
	document.getElementById("zip1").value = document.getElementById("zipone"+seq).value;
	document.getElementById("zip2").value = document.getElementById("ziptwo"+seq).value;
	var email = document.getElementById("email"+seq).textContent.split('@');
	document.getElementById("email1").value = email[0];
	$("#email2").val(email[1]).attr("selected", "selected");
	var tel = document.getElementById("tel"+seq).textContent.split('-');
	$("#tel1").val(tel[0]).attr("selected", "selected");
	document.getElementById("tel2").value = tel[1];
	document.getElementById("tel3").value = tel[2];
	//document.getElementById("picture").value = document.getElementById("picture"+seq).value;
	document.getElementById("addr1").value = document.getElementById("addrone"+seq).value;
	document.getElementById("addr2").value = document.getElementById("addrtwo"+seq).value;
	var birth = document.getElementById("birth"+seq).textContent.split('/');
	$("#birth_yyyy").val(birth[0]).attr("selected", "selected");
	$("#birth_mm").val(birth[1]).attr("selected", "selected");
	$("#birth_dd").val(birth[2]).attr("selected", "selected");
	var hire_date = document.getElementById("hire_date"+seq).textContent.split('/');
	$("#hire_yyyy").val(hire_date[0]).attr("selected", "selected");
	$("#hire_mm").val(hire_date[1]).attr("selected", "selected");
	$("#hire_dd").val(hire_date[2]).attr("selected", "selected");
	
	if(document.getElementById("gender"+seq).textContent == "��") {
		$("input:radio[name='gender']:radio[value='����']").prop("checked", true);		
	} else {
		$("input:radio[name='gender']:radio[value='����']").prop("checked", true);	
	}
	if(document.getElementById("marriage"+seq).textContent == "��ȥ") {
		$("input:radio[name='marriage']:radio[value='��ȥ']").prop("checked", true);		
	} else {
		$("input:radio[name='marriage']:radio[value='��ȥ']").prop("checked", true);	
	}
	$('#myModal').modal("show");
}

function modify() {
	document.getElementById("modifyseq").value = $("#seq").val();
	if(document.getElementById("id").value == "") {
		alert("���̵� �Է�!");
		return;
	} else if(document.getElementById("name").value == "") {
		alert("�̸� �Է�!");
		return;
	} else if(document.getElementById("pass").value  == "") {
		alert("��й�ȣ �Է�!");
		return;
	} else if(document.getElementById("pass").value != document.getElementById("passcheck").value) {
		alert("��й�ȣ Ȯ��!");
		return;
	} else {
		document.modifyform.action = "<%=root%>/comInfo";
		document.modifyform.submit();
	}
}

function opendept(){
	window.open("<%= root %>/memberRegister?act=mvdept","dept","top=200, left=300, width=400, height=300, menubar=no, status=no, toolbar=no, location=no, scrollbars=yes");
}

function openposition(){
	window.open("<%= root %>/memberRegister?act=mvposition","position","top=200, left=300, width=400, height=300, menubar=no, status=no, toolbar=no, location=no, scrollbars=yes");
}
</script>
<form name="commonForm" method="get" action="">
	<input type="hidden" name="act" value=""> <input type="hidden"
		name="pg" value="">

</form>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12" align="center">
			<header>
				<h2 align="left">�������</h2>
			</header>
			<div class="container1">
				<div align="right" class="retire">
					<input type="button" value="�����" onclick="javascript:retireList();">
				</div>
			</div>
			<div class="contaner2">
				<div class="modal fade" id="myModal" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<p>Modify & Delete</p>
							</div>
							<div class="modal-body">
								<form name="modifyform" method="post" action="">
									<input type="hidden" name="act" value="modify"> <input
										type="hidden" name="pg" value="<%=pg%>"> <input type="hidden"
										id="modifyseq" name="modifyseq" value="">
									<table width="900" height="700" cellspacing="4" cellpadding="5">
										<tr>
											<td class="td1">�μ���<font color="red">*</font></td>
											<td class="td3"><input type="text" name="dept_name"
												id="dept_name" value="" size="12"> <input
												type="button" value="�μ��˻�" onclick="javascript:opendept();">
											</td>
										</tr>
										<tr>
											<td class="td2">���޸�<font color="red">*</font></td>
											<td class="td4"><input type="text" name="position_name"
												id="position_name" value="" size="12"> <input
												type="button" value="���ް˻�"
												onclick="javascript:openposition();"></td>
										</tr>

										<tr>
											<td class="td1">���̵�(ID)<font color="red">*</font></td>
											<td class="td3"><input type="text" name="id" id="id"
												value="" size="12" onkeyup="javascript:idcheck();">
												<div id="idresult"></div>
										</tr>

										<tr>
											<td class="td2">��й�ȣ�Է�<font color="red">*</font></td>
											<td class="td4"><input type="password" name="pass"
												id="pass" size="12" maxlength="12"> &nbsp;&nbsp;<font
												color="#3cb371">6~12</font>�ڸ��� ����(��ҹ��� ����)�̳� ����</td>
										</tr>

										<tr>
											<td class="td1">��й�ȣȮ��<font color="red">*</font></td>
											<td class="td3"><input type="password" name="passcheck"
												id="passcheck" size="12" maxlength="12">
												&nbsp;&nbsp;��й�ȣ�� �ѹ� �� �Է��ϼ���</td>
										</tr>

										<tr>
											<td class="td2">�̸�<font color="red">*</font></td>
											<td class="td4"><input type="text" name="name" id="name"
												value="" size="12"></td>
										</tr>

										<tr>
											<td class="td1">����</td>
											<td class="td3"><input type="radio" name="gender"
												value="����">���� &nbsp; <input type="radio"
												name="gender" value="����">����</td>
										</tr>

										<tr>
											<td class="td2">�����ȣ<font color="red">*</font></td>
											<td class="td4"><input type="text" name="zip1" id="zip1"
												value="" size="5" maxlength="3" readonly="readonly">
												- <input type="text" name="zip2" id="zip2" value="" size="5"
												maxlength="3" readonly="readonly"> <input
												type="button" value="�����ȣ�˻�" onclick="javascript:openzip();"></td>
										</tr>

										<tr>
											<td class="td1">�ּ�<font color="red">*</font></td>
											<td class="td3"><input type="text" name="addr1"
												id="addr1" value="" size="50" readonly="readonly"></td>
										</tr>

										<tr>
											<td class="td2">���ּ�<font color="red">*</font></td>
											<td class="td4"><input type="text" id="addr2"
												name="addr2" size="50"></td>
										</tr>

										<tr>
											<td class="td2">�ַ� ���� �̸���</td>
											<td class="td4"><input type="text" id="email1"
												name="email1" value="" size="12"> @ <!--<input type="text" name="direct" value="" size=12>-->
												<select name="email2" id="email2">
													<!--<option value="naver.com">�����Է�</option>-->
													<option value="naver.com">naver.com</option>
													<option value="hanmail.net">hanmail.net</option>
											</select></td>
										</tr>

										<tr>
											<td class="td1">����ó<font color="red">*</font></td>
											<td class="td3"><select name="tel1" id="tel1">
													<option value="">----</option>
													<option value="010">010</option>
													<option value="011">011</option>
													<option value="016">016</option>
													<option value="017">017</option>
													<option value="018">018</option>
											</select> - <input type="text" id="tel2" name="tel2" value="" size="4"
												maxlength="4"> - <input type="text" id="tel3"
												name="tel3" value="" size="4" maxlength="4"><br>
											</td>
										</tr>

										<tr>
											<td class="td2">�������</td>
											<td class="td4"><select name="birth_yyyy"
												id="birth_yyyy">
													<option value="">----</option>
													<%
														for (int i = 1940; i < 2018; i++) {
													%>
													<option value="<%=i%>"><%=i%></option>
													<%
														}
													%>
											</select>�� <select name="birth_mm" id="birth_mm">
													<option value="">----</option>
													<%
														for (int i = 1; i < 13; i++) {
																if (i < 10) {
													%>
													<option value="<%="0" + i%>">0<%=i%></option>
													<%
														} else {
													%>
													<option value="<%=i%>"><%=i%></option>
													<%
														}
															}
													%>
											</select>�� <select name="birth_dd" id="birth_dd">
													<option value="">----</option>
													<%
														for (int i = 1; i < 31; i++) {
																if (i < 10) {
													%>
													<option value="<%="0" + i%>">0<%=i%></option>
													<%
														} else {
													%>
													<option value="<%=i%>"><%=i%></option>
													<%
														}
															}
													%>
											</select>��</td>
										</tr>

										<tr>
											<td class="td1">��ȥ����</td>
											<td class="td3"><input type="radio" name="marriage"
												value="��ȥ">��ȥ <input type="radio" name="marriage"
												value="��ȥ">��ȥ</td>
										</tr>

										<tr>
											<td class="td1">�Ի���</td>
											<td class="td3"><select name="hire_yyyy" id="hire_yyyy">
													<option value="">----</option>
													<%
														for (int i = 1940; i < 2018; i++) {
													%>
													<option value="<%=i%>"><%=i%></option>
													<%
														}
													%>
											</select>�� <select name="hire_mm" id="hire_mm">
													<option value="">----</option>
													<%
														for (int i = 1; i < 13; i++) {
																if (i < 10) {
													%>
													<option value="<%="0" + i%>">0<%=i%></option>
													<%
														} else {
													%>
													<option value="<%=i%>"><%=i%></option>
													<%
														}
															}
													%>
											</select>�� <select name="hire_dd" id="hire_dd">
													<option value="">----</option>
													<%
														for (int i = 1; i < 31; i++) {
																if (i < 10) {
													%>
													<option value="<%="0" + i%>">0<%=i%></option>
													<%
														} else {
													%>
													<option value="<%=i%>"><%=i%></option>
													<%
														}
															}
													%>
											</select>��</td>

										</tr>


										<tr>
											<td class="td2">�����</td>
											<td class="td4"><select name="out_yyyy" id="out_yyyy">
													<option value="">----</option>
													<%
														for (int i = 1940; i < 2018; i++) {
													%>
													<option value="<%=i%>"><%=i%></option>
													<%
														}
													%>
											</select>�� <select name="out_mm" id="out_mm">
													<option value="">----</option>
													<%
														for (int i = 1; i < 13; i++) {
																if (i < 10) {
													%>
													<option value="<%="0" + i%>">0<%=i%></option>
													<%
														} else {
													%>
													<option value="<%=i%>"><%=i%></option>
													<%
														}
															}
													%>
											</select>�� <select name="out_dd" id="out_dd">
													<option value="">----</option>
													<%
														for (int i = 1; i < 31; i++) {
																if (i < 10) {
													%>
													<option value="<%="0" + i%>">0<%=i%></option>
													<%
														} else {
													%>
													<option value="<%=i%>"><%=i%></option>
													<%
														}
															}
													%>
											</select>��</td>
										</tr>
										</td>
										</tr>
									</table>
								</form>
							</div>
							<div class="modal-footer" align="center">
								<button type="button" data-dismiss="modal" id="modify_btn" onclick="javascript:modify();">����</button>
								<button type="button" data-dismiss="modal" id="cancel_btn">���</button>
							</div>
						</div>
					</div>
				</div>

				<div class="table" align="center">
					<form name="listForm" method="post" style="margin: 0px">
						<table width="90%" cellpadding="5" cellspacing="0" border="1">
							<tr align="center">
								<td class="bg_board_title_02" height="2" colspan="13"
									style="overflow: hidden; padding: 0px"></td>
							</tr>

							<tr class="bg_board_title" align="center" height="30">
								<td align="center"><b>�����ȣ</b></td>
								<td align="center"><b>�μ���</b></td>
								<td align="center"><b>���޸�</b></td>
								<td align="center"><b>���̵�</b></td>
								<td align="center"><b>��й�ȣ</b></td>
								<td align="center"><b>�̸�</b></td>
								<td align="center"><b>����</b></td>
								<td align="center"><b>�ּ�</b></td>
								<td align="center"><b>�̸���</b></td>
								<td align="center"><b>�޴���</b></td>
								<td align="center"><b>�������</b></td>
								<td align="center"><b>��ȥ����</b></td>
								<td align="center"><b>�Ի���</b></td>
							</tr>

							<tr align="center">
								<td class="bg_board_title_02" height="1" colspan="13"
									style="overflow: hidden; padding: 0px"></td>
							</tr>
							<%
								int len = list.size();
									if (len != 0) {
										for (int i = 0; i < len; i++) {
											CominfoDto cominfoDto = list.get(i);
							%>

							<tr align="center">
								<input type="hidden" id="seq" name="seq"
									value="<%=cominfoDto.getEmp_num()%>">
								<input type="hidden" id="zipone<%=cominfoDto.getEmp_num()%>"
									value="<%=cominfoDto.getZip1()%>">
								<input type="hidden" id="ziptwo<%=cominfoDto.getEmp_num()%>"
									value="<%=cominfoDto.getZip2()%>">
								<input type="hidden" id="picture<%=cominfoDto.getEmp_num()%>"
									value="<%=cominfoDto.getPicture()%>">
								<input type="hidden" id="addrone<%=cominfoDto.getEmp_num()%>"
									value="<%=cominfoDto.getAddr1()%>">
								<input type="hidden" id="addrtwo<%=cominfoDto.getEmp_num()%>"
									value="<%=cominfoDto.getAddr2()%>">
								<td align="center" id="emp_num"><%=cominfoDto.getEmp_num()%></td>
								<td align="center" id="dept_name<%=cominfoDto.getEmp_num()%>"><%=cominfoDto.getDept_name()%></td>
								<td align="center"
									id="position_name<%=cominfoDto.getEmp_num()%>"><%=cominfoDto.getPosition_name()%></td>
								<td align="center" id="id<%=cominfoDto.getEmp_num()%>"><%=cominfoDto.getId()%></td>
								<td align="center" id="pass<%=cominfoDto.getEmp_num()%>"><%=cominfoDto.getPass()%></td>
								<td align="center"><a id="name<%=cominfoDto.getEmp_num()%>"
									href="javascript:modal(<%=cominfoDto.getEmp_num()%>);"><%=cominfoDto.getName()%></a></td>
								<td align="center" id="gender<%=cominfoDto.getEmp_num()%>"><%=cominfoDto.getGender()%></td>
								<td align="center" id="addr<%=cominfoDto.getEmp_num()%>"><%=cominfoDto.getAddr1()%>&nbsp;<%=cominfoDto.getAddr2()%></td>
								<td align="center" id="email<%=cominfoDto.getEmp_num()%>"><%=cominfoDto.getEmail1() + "@" + cominfoDto.getEmail2()%></td>
								<td align="center" id="tel<%=cominfoDto.getEmp_num()%>"><%=cominfoDto.getTel1() + "-" + cominfoDto.getTel2() + "-" + cominfoDto.getTel3()%></td>
								<td align="center" id="birth<%=cominfoDto.getEmp_num()%>"><%=cominfoDto.getBirth1() + "/" + cominfoDto.getBirth2() + "/" + cominfoDto.getBirth3()%></td>
								<td align="center" id="marriage<%=cominfoDto.getEmp_num()%>"><%=cominfoDto.getMarriage()%></td>
								<td align="center" id="hire_date<%=cominfoDto.getEmp_num()%>"><%=cominfoDto.getHire_date1() + "/" + cominfoDto.getHire_date2() + "/"
								+ cominfoDto.getHire_date3()%></td>
							</tr>
							<%
								if (i < len - 1) {
							%>
							<tr align="center">
								<td bgcolor="#ededed" height="1" colspan="13"
									style="overflow: hidden; padding: 0px"></td>
								<!-- �� ���� -->
							</tr>
							<%
								}
										}
									} else {
							%>
							<tr align="center">
								<td align="center" class="text_gray" colspan="13"><br>
									�������� ����� �������� �ʽ��ϴ�.<br> <br></td>
							</tr>
							<%
								}
							%>
							<tr align="center">
								<td class="bg_board_title_02" height="1" colspan="13"
									style="overflow: hidden; padding: 0px"></td>
							</tr>
						</table>
					</form>
					<!-- �ϴ� ����¡ -->
					<table width="100%" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td colspan="3" height="5"></td>
						</tr>
						<tr valign="top">
							<td width="100%" align="center">
								<!--PAGE--><%=navigator.getNavigator()%></td>
						</tr>
					</table>
					<br>
					<!-- �ϴ� ����¡ -->
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.col-lg-12 -->
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