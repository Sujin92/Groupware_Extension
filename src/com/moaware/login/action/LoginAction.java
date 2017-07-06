package com.moaware.login.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moaware.action.Action;
import com.moaware.member.model.MemberDto;
import com.moaware.login.service.LoginServiceImpl;

public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberDto memberDto = LoginServiceImpl.getLoginService().login(id, pass);
		
		if (memberDto != null) {
			session.setAttribute("loginInfo", memberDto);
			if(memberDto.getId().equals("admin")){
				return "/common/admin_index.jsp";
			}else
			return "/home/home.jsp";
		} else {
			return "/login/loginfail.jsp";
		}
	}

}
