package com.moaware.admin.support.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.action.Action;
import com.moaware.admin.cominfo.util.PageNavigation;
import com.moaware.admin.support.service.ApprovalManageServiceImpl;
import com.moaware.approval.model.ApprovalDto;

public class DocListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pg = Integer.parseInt(request.getParameter("pg"));
		String emp_num = request.getParameter("emp_num");
		
		//�� ���
		List<ApprovalDto> list = ApprovalManageServiceImpl.getApprovalManageService().docList(pg, emp_num);
		request.setAttribute("docList", list);
		
		//����¡ ó��
		PageNavigation pageNavigation = ApprovalManageServiceImpl.getApprovalManageService().docMakePageNavigation(pg, emp_num);
		pageNavigation.setRoot(request.getContextPath());
		pageNavigation.setNavigator();
		request.setAttribute("navigator", pageNavigation);
		
		return "/business_support/docList.jsp";
	}

}
