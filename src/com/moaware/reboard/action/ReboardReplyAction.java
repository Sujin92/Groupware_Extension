package com.moaware.reboard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moaware.action.Action;
import com.moaware.board.model.ReboardDto;
import com.moaware.board.service.CommonServiceImpl;
import com.moaware.board.service.ReboardServiceImpl;
import com.moaware.member.model.MemberDto;
import com.moaware.util.Encoding;
import com.moaware.util.NumberCheck;

public class ReboardReplyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(); // session ����
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
		String path = "/index.jsp"; //������ login.jsp���� �����Ƿ� index
		
		int bcode = NumberCheck.nullToZero(request.getParameter("bcode"));
		int pg = NumberCheck.nullToOne(request.getParameter("pg"));
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = Encoding.isoToEuc(request.getParameter("word"));
		
		if (memberDto != null) { // �α����� �ߴٸ�
			int seq = CommonServiceImpl.getCommonService().getNextSeq(bcode); // �� ��ȣ ��� db����
			
			ReboardDto reboardDto = new ReboardDto();
			reboardDto.setSeq(seq); // �۹�ȣ ������ ������ �ۼ��� �� Ȯ���� ������ ��, �ۼ��� ���� ������ �� ��ȣ�� �ʿ���
			reboardDto.setEmp_num(memberDto.getEmp_num()); // session
			reboardDto.setName(memberDto.getName()); // session
			reboardDto.setSubject(request.getParameter("subject")); // parameter
			reboardDto.setContent(request.getParameter("content")); // parameter
			reboardDto.setBcode(NumberCheck.nullToZero(request.getParameter("bcode"))); // parameter
//			reboardDto.setRef(Integer.parseInt(request.getParameter("ref"))); // ����϶��� ������ ref�� �Ȱ��� �ؾ���
//			reboardDto.setLev(Integer.parseInt(request.getParameter("lev")));
//			reboardDto.setStep(Integer.parseInt(request.getParameter("step"))); 
			reboardDto.setPseq(Integer.parseInt(request.getParameter("pseq"))); // ������ �۹�ȣ�� �� ����������
			// ref, lev, step, pseq nullToZero �Ǵ� one�� ���ϴ� ������ ��״� ���� �߸� �������� ������ ���°� �±⶧���� ����ȯ�� ��
			
			int cnt = ReboardServiceImpl.getReboardService().replyArticle(reboardDto);
			if (cnt != 0) {
				// bcode, pg, key, word�� queryString���� �ѱ��, �������� request�� session�� �޾Ƽ� �ѱ���
				request.setAttribute("seq", seq +""); // ����ȯ�ϱ� �������ϱ�...
				path = "reboard/writeOk.jsp"; // �ּҴ� �빮�� �ҹ��� ������, �۹�ȣ ���������� ( �ۼ��� �� Ȯ�� ), bcode, pg, key, word
				
			} else
				path = "reboard/writeFail.jsp";
		} 
		return path;
	}

}
