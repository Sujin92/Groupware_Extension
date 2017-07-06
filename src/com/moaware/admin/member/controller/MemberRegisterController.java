package com.moaware.admin.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.admin.member.action.IdCheckAction;
import com.moaware.factory.MemberRegisterFactory;
import com.moaware.factory.MyPageFactory;
import com.moaware.util.PageMove;

@WebServlet("/memberRegister")
public class MemberRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		
		String path = "/index.jsp";
		
		if("mvregister".equals(act)) {
			path = "/member_register/member_register.jsp";
			PageMove.redirect(path, request, response);
		} else if("idsearch".equals(act)) {
			path = MemberRegisterFactory.getIdCheckAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else if("register".equals(act)) {
			path = MemberRegisterFactory.getMemberRegisterAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else if("mvdept".equals(act)) {
			path = "/member_register/dept_check.jsp";
			PageMove.redirect(path, request, response);
		} else if("mvposition".equals(act)) {
			path = "/member_register/position_check.jsp";
			PageMove.redirect(path, request, response);
		} else if("deptsearch".equals(act)) {
			path = MemberRegisterFactory.getDeptCheckAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else if("positionsearch".equals(act)) {
			path = MemberRegisterFactory.getPositionCheckAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else if("mvzip".equals(act)) {
			path = MemberRegisterFactory.getPositionCheckAction().execute(request, response);
			PageMove.forward(path, request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
