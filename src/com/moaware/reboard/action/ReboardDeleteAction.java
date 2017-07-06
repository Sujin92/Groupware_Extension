package com.moaware.reboard.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moaware.action.Action;
import com.moaware.board.model.ReboardDto;
import com.moaware.board.service.CommonServiceImpl;
import com.moaware.board.service.ReboardServiceImpl;
import com.moaware.member.model.MemberDto;
import com.moaware.util.BoardConstance;
import com.moaware.util.Encoding;
import com.moaware.util.NumberCheck;
import com.moaware.util.PageNavigation;

public class ReboardDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(); // session ����
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
		String path = "/index.jsp"; //������ login.jsp���� �����Ƿ� index
		
		if (memberDto != null) { // �α����� �ߴٸ�
//			int seq = CommonServiceImpl.getCommonService().getNextSeq(); // �� ��ȣ ��� db����
			int seq = NumberCheck.nullToZero(request.getParameter("seq"));
			int cnt = ReboardServiceImpl.getReboardService().deleteArticle(seq);
			
			int bcode = NumberCheck.nullToZero(request.getParameter("bcode"));
			int pg = NumberCheck.nullToOne(request.getParameter("pg"));
			String key = Encoding.nullToBlank(request.getParameter("key"));
			String word = Encoding.isoToEuc(request.getParameter("word"));
			
			
			List<ReboardDto> list = ReboardServiceImpl.getReboardService().listArticle(bcode, pg, key, word);
			request.setAttribute("articleList", list);
			
			//����¡ó��
			PageNavigation pageNavigation = CommonServiceImpl.getCommonService().makePageNavigation(bcode, pg, key, word, BoardConstance.LIST_SIZE);
			pageNavigation.setRoot(request.getContextPath());
			pageNavigation.setNavigator();
			request.setAttribute("navigator", pageNavigation);
			
			if (cnt != 0) {
				path = "/reboard/list.jsp";
			} else
				path = "/reboard/view.jsp";
		} 
		return path;
	}
}
