package com.moaware.project.action;

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
import com.moaware.member.model.MemberDto;
import com.moaware.project.model.ProjectDto;
import com.moaware.project.service.ProjectServiceImpl;
import com.moaware.util.BoardConstance;
import com.moaware.util.Encoding;
import com.moaware.util.NumberCheck;
import com.moaware.util.PageNavigation;

public class ProjectDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
		String path = "/index.jsp"; 
		
		if (memberDto != null) { 
			int seq = NumberCheck.nullToZero(request.getParameter("seq"));
			int cnt = ProjectServiceImpl.getProjectService().deleteCard(seq);
			
			
			if(cnt != 0) {
				path = "/project?act=cardList";
			} else {
				path = "/index.jsp";
			}
		}
		return path;
	}

}
