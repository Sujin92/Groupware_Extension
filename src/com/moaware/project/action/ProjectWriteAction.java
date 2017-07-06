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

public class ProjectWriteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProjectDto projectDto = new ProjectDto();
		projectDto.setProject_progress(request.getParameter("progress"));
		int progress = Integer.parseInt(request.getParameter("progress"));
		System.out.println("asdasdasdasd"+progress);
		
		if(progress==1){
		projectDto.setProject_content(request.getParameter("area1"));
		}
		else if(progress==2){
			projectDto.setProject_content(request.getParameter("area2"));
		}
		else if(progress==3){
			projectDto.setProject_content(request.getParameter("area3"));
		}
		else if(progress==4){
			projectDto.setProject_content(request.getParameter("area4"));
		}
		
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
