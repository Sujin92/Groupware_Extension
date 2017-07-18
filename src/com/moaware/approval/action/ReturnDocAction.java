package com.moaware.approval.action;

import com.moaware.action.Action;
import com.moaware.approval.model.ApprovalDto;
import com.moaware.approval.service.ApprovalServiceImpl;
import com.moaware.approval.util.PageNavigation;
import com.moaware.member.model.MemberDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ReturnDocAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		String state = "�ݷ�";
		
		List<ApprovalDto> list = ApprovalServiceImpl.getApprovalServiceImpl().docList(memberDto.getEmp_num(), state, pg);
		request.setAttribute("returnDoc", list);
		
		PageNavigation pageNavigation = ApprovalServiceImpl.getApprovalServiceImpl().makePageNavigation(pg, state, memberDto.getEmp_num());
		pageNavigation.setRoot(request.getContextPath());
		pageNavigation.setNavigator();
		request.setAttribute("navigator", pageNavigation);
		
		return "/approval/returnDoc.jsp";
	}

}
