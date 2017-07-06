package com.moaware.groupboard.action;

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
import com.moaware.board.service.GroupBoardServiceImpl;
import com.moaware.member.model.MemberDto;
import com.moaware.util.BoardConstance;
import com.moaware.util.Encoding;
import com.moaware.util.NumberCheck;
import com.moaware.util.PageNavigation;

public class GroupBoardListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bcode = NumberCheck.nullToZero(request.getParameter("bcode"));
		int pg = NumberCheck.nullToOne(request.getParameter("pg"));
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = Encoding.isoToEuc(request.getParameter("word"));
		HttpSession session = request.getSession();//session 积己
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");//session俊辑 MemberDto get
		
		
		List<BoardDto> list = GroupBoardServiceImpl.getGroupboardService().listArticle(bcode, pg, key, word, memberDto.getDept_num());
		request.setAttribute("articleList", list);
		
		//其捞隆贸府
		PageNavigation pageNavigation = CommonServiceImpl.getCommonService().makePageNavigation(bcode, pg, key, word, BoardConstance.LIST_SIZE);
		pageNavigation.setRoot(request.getContextPath());
		pageNavigation.setNavigator();
		request.setAttribute("navigator", pageNavigation);
		
		return "groupboard/list.jsp";
	}

}
