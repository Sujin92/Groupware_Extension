package com.moaware.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moaware.factory.LoginFactory;
import com.moaware.login.action.LoginAction;
import com.moaware.util.PageMove;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String act = request.getParameter("act");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		String path = "/index.jsp";
		if("mvlogin".equals(act)){
			path = LoginFactory.getLoginAction().execute(request, response);
			PageMove.forward(path, request, response);
		}else if("logout".equals(act)){
			HttpSession session = request.getSession();
			session.invalidate();
			path = "/index.jsp";
			PageMove.redirect(path, request, response);
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
