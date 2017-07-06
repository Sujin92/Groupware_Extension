package com.moaware.groupboard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moaware.action.Action;
import com.moaware.board.model.BoardDto;
import com.moaware.board.service.GroupBoardServiceImpl;
import com.moaware.member.model.MemberDto;
import com.moaware.util.NumberCheck;

public class GroupBoardModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();//session 생성
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");//session에서 MemberDto get
		
		String path = "/index.jsp";
		if(memberDto != null) {//로그인 했다면.
			int seq = NumberCheck.nullToZero(request.getParameter("seq"));
			
			BoardDto boardDto = new BoardDto();
			boardDto.setSeq(seq);
			boardDto.setEmp_num(memberDto.getEmp_num());
			boardDto.setName(memberDto.getName());
			boardDto.setSubject(request.getParameter("subject"));
			boardDto.setContent(request.getParameter("content"));
			boardDto.setBcode(NumberCheck.nullToZero(request.getParameter("bcode")));
			
			int cnt = GroupBoardServiceImpl.getGroupboardService().modifyArticle(boardDto);
			if(cnt != 0) {
				request.setAttribute("seq", seq + "");
				path = "/groupboard/modifyOk.jsp";
			} else {
				path = "/groupboard/modifyFail.jsp";
			}
		}
		
		return path;
	}

}
