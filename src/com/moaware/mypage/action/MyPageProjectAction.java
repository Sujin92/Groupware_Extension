package com.moaware.mypage.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.moaware.action.Action;
import com.moaware.member.model.MemberDto;
import com.moaware.mypage.service.MyPageProjectServiceImpl;
import com.moaware.project.model.ProjectDto;

public class MyPageProjectAction implements Action {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
		
		//±Û ¸ñ·Ï
		List<ProjectDto> list = MyPageProjectServiceImpl.getProjectService().listProject(memberDto.getId());
		request.setAttribute("projectList", list);
		
		return "/mypage/myproject_history.jsp";
	}
}
