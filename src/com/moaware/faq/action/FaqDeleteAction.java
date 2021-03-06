package com.moaware.faq.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moaware.action.Action;
import com.moaware.board.model.BoardDto;
import com.moaware.board.service.BoardServiceImpl;
import com.moaware.board.service.CommonServiceImpl;
import com.moaware.board.service.FaqServiceImpl;
import com.moaware.member.model.MemberDto;
import com.moaware.util.BoardConstance;
import com.moaware.util.Encoding;
import com.moaware.util.NumberCheck;
import com.moaware.util.PageNavigation;

public class FaqDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(); // session 생성
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
		String path = "/index.jsp"; 
		
		if (memberDto != null) { // 로그인을 했다면
			int seq = NumberCheck.nullToZero(request.getParameter("seq"));
			int cnt = FaqServiceImpl.getFaqService().deleteArticle(seq);
			
			int bcode = NumberCheck.nullToZero(request.getParameter("bcode"));
			int pg = NumberCheck.nullToOne(request.getParameter("pg"));
			String key = Encoding.nullToBlank(request.getParameter("key"));
			String word = Encoding.isoToEuc(request.getParameter("word"));
			
			List<BoardDto> list = FaqServiceImpl.getFaqService().listArticle(bcode, pg, key, word);
			request.setAttribute("articleList", list);
			
			//페이징처리
			PageNavigation pageNavigation = CommonServiceImpl.getCommonService().makePageNavigation(bcode, pg, key, word, BoardConstance.LIST_SIZE);
			pageNavigation.setRoot(request.getContextPath());
			pageNavigation.setNavigator();
			request.setAttribute("navigator", pageNavigation);
			
			if (cnt != 0) {
				path = "/faq/list.jsp";
			} else
				path = "/faq/view.jsp";
		}
		return path;
	}

}
