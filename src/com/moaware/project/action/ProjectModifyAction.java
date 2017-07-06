package com.moaware.project.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moaware.action.Action;
import com.moaware.board.model.ReboardDto;
import com.moaware.board.service.BoardServiceImpl;
import com.moaware.member.model.MemberDto;
import com.moaware.project.model.ProjectDto;
import com.moaware.project.service.ProjectServiceImpl;
import com.moaware.util.Encoding;
import com.moaware.util.NumberCheck;
import com.sun.org.apache.bcel.internal.generic.ISTORE;

public class ProjectModifyAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();//session 생성
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");//session에서 MemberDto get
		
		String path = "/index.jsp";
		if(memberDto != null) {//로그인 했다면.
			int seq = NumberCheck.nullToZero(request.getParameter("seq"));
			String content = Encoding.isoToEuc(request.getParameter("content"));
			System.out.println(seq);
			System.out.println(content);
			ProjectDto projectDto = new ProjectDto();

			projectDto.setContent_num(Integer.toString(seq));
			projectDto.setProject_content(content);
			projectDto.setDept_num(memberDto.getName());
			projectDto.setEmp_num(memberDto.getEmp_num());
			
			int cnt = ProjectServiceImpl.getProjectService().modifyCard(projectDto);
			
			if(cnt != 0) {
				path = "/project?act=cardList";
			} else {
				path = "/index.jsp";
			}
		}
		
		return path;
	}

}
