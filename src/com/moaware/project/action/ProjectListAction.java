package com.moaware.project.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moaware.action.Action;
import com.moaware.member.model.MemberDto;
import com.moaware.project.model.ProjectDto;
import com.moaware.project.service.ProjectServiceImpl;

public class ProjectListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto)session.getAttribute("loginInfo");
		List<ProjectDto> list = ProjectServiceImpl.getProjectService().boardList(memberDto.getDept_num());
		request.setAttribute("cardlist", list);
		
		List<MemberDto> list2 = ProjectServiceImpl.getProjectService().membersearch(memberDto.getDept_num());
		request.setAttribute("memberlist", list2);
		
		
		return "/project/project.jsp";

	}

}
