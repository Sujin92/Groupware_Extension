package com.moaware.reboard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moaware.action.Action;
import com.moaware.board.model.ReboardDto;
import com.moaware.board.service.ReboardServiceImpl;
import com.moaware.member.model.MemberDto;
import com.moaware.util.NumberCheck;

public class ReboardModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(); // session ����
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
		String path = "/index.jsp"; //������ login.jsp���� �����Ƿ� index
		
		if (memberDto != null) { // �α����� �ߴٸ�
			int seq = NumberCheck.nullToZero(request.getParameter("seq"));
			
			ReboardDto reboardDto = new ReboardDto();
			reboardDto.setSeq(seq); // �۹�ȣ ������ ������ �ۼ��� �� Ȯ���� ������ ��, �ۼ��� ���� ������ �� ��ȣ�� �ʿ���
			reboardDto.setEmp_num(memberDto.getEmp_num()); // session
			reboardDto.setName(memberDto.getName()); // session
			reboardDto.setSubject(request.getParameter("subject")); // parameter
			reboardDto.setContent(request.getParameter("content")); // parameter
			reboardDto.setBcode(NumberCheck.nullToZero(request.getParameter("bcode"))); // parameter

			int cnt = ReboardServiceImpl.getReboardService().modifyArticle(reboardDto);
			if (cnt != 0) {
				// bcode, pg, key, word�� queryString���� �ѱ��, �������� request�� session�� �޾Ƽ� �ѱ���
				request.setAttribute("seq", seq +""); // ����ȯ�ϱ� �������ϱ�...
				path = "reboard/modifyOk.jsp"; // �ּҴ� �빮�� �ҹ��� ������, �۹�ȣ ���������� ( �ۼ��� �� Ȯ�� ), bcode, pg, key, word
				
			} else
				path = "reboard/modifyFail.jsp";
		}
		return path;
	}

}
