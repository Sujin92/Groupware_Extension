package com.moaware.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.moaware.factory.MemberRegisterFactory;
import com.moaware.factory.MyPageFactory;
import com.moaware.util.PageMove;

@WebServlet("/mypageController")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		
		String path = "/index.jsp";
		
		if("projectlist".equals(act)) {
			path = MyPageFactory.getProjectAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else if("mypage".equals(act)) {
			path = MyPageFactory.getMyPageListAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else if("mvmodify".equals(act)) {	
			path = MyPageFactory.getMyPageMoveModifyAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else if("mvzip".equals(act)) {
			path = MemberRegisterFactory.getPositionCheckAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else if("modify".equals(act)) {
			path = MyPageFactory.getMyPageModifyAction().execute(request, response);
			PageMove.forward(path, request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
