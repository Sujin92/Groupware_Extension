package com.moaware.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.factory.ProjectFactory;
import com.moaware.util.PageMove;


@WebServlet("/project") //프로젝트 관리 controller.

public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act = request.getParameter("act");
		String path = "/index.jsp";

		if("cardList".equals(act)){
			path = ProjectFactory.getProjectListAction().execute(request, response);
			PageMove.forward(path, request, response);
		}else if("insertproject".equals(act)){
			path = ProjectFactory.getProjectWriteAction().execute(request, response);
			PageMove.redirect(path, request, response);
		}else if("modify".equals(act)){
			path = ProjectFactory.getProjectModifyAction().execute(request, response);
			PageMove.forward(path, request, response);
		}else if("delete".equals(act)){
			path = ProjectFactory.getProjectDeleteAction().execute(request, response);
			PageMove.forward(path, request, response);
		}else if("initproject".equals(act)){
			path = ProjectFactory.getProjectInitAction().execute(request, response);
			PageMove.forward(path, request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
