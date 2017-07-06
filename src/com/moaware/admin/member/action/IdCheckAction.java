package com.moaware.admin.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.action.Action;
import com.moaware.admin.member.service.MemberRegisterServiceImpl;

public class IdCheckAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		int cnt = MemberRegisterServiceImpl.getMemberRegisterService().idCheck(sid);
		request.setAttribute("cnt", cnt + "");
		request.setAttribute("sid", sid);
		return "/member_register/member_register_id_check.jsp?sid=" + sid + "&cnt=" + cnt;
	}

}
