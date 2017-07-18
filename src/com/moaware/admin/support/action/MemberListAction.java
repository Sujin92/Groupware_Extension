package com.moaware.admin.support.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.action.Action;
import com.moaware.admin.cominfo.model.CominfoDto;
import com.moaware.admin.cominfo.util.PageNavigation;
import com.moaware.admin.support.service.ApprovalManageServiceImpl;

public class MemberListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pg = Integer.parseInt(request.getParameter("pg"));
		String param = "null";
		
		//臂 格废
		List<CominfoDto> list = ApprovalManageServiceImpl.getApprovalManageService().memberList(pg);
		request.setAttribute("memberList", list);
		
		//其捞隆 贸府
		PageNavigation pageNavigation = ApprovalManageServiceImpl.getApprovalManageService().makePageNavigation(pg, param);
		pageNavigation.setRoot(request.getContextPath());
		pageNavigation.setNavigator();
		request.setAttribute("navigator", pageNavigation);
		
		return "/business_support/memberList.jsp";
	}

}
