package com.moaware.project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.action.Action;
import com.moaware.project.model.ProjectDto;
import com.moaware.project.service.ProjectServiceImpl;

public class ProjectInitAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		ProjectDto projectDto = new ProjectDto();
		projectDto.setProject_progress(request.getParameter("progress"));
		projectDto.setProject_content("Ω√¿€");
		projectDto.setProject_name(request.getParameter("project_name"));
		projectDto.setProject_num(request.getParameter("project_num"));
		projectDto.setDept_num(request.getParameter("dept_num"));
		projectDto.setEmp_num(request.getParameter("emp_num"));

		
		int cnt = ProjectServiceImpl.getProjectService().createCard(projectDto);
		
//		HttpSession session = request.getSession();
//		MemberDto memberDto = (MemberDto)session.getAttribute("loginInfo");
//		List<ProjectDto> list = ProjectServiceImpl.getProjectService().boardList(memberDto.getDept_num());
//		request.setAttribute("cardlist", list);
		
		return "/project?act=cardList";
	
	}

}
