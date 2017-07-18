package com.moaware.admin.support.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.action.Action;
import com.moaware.admin.cominfo.util.PageNavigation;
import com.moaware.admin.support.model.ScheduleDto;
import com.moaware.admin.support.service.ApprovalManageServiceImpl;
import com.moaware.util.NumberCheck;

public class ScheduleDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int check = Integer.parseInt(request.getParameter("check"));
		int pg = NumberCheck.nullToOne(request.getParameter("pg"));
		String emp_num = "1";
		
		ApprovalManageServiceImpl.getApprovalManageService().scheduleDelete(check);
		
		List<ScheduleDto> list = ApprovalManageServiceImpl.getApprovalManageService().scheduleList(pg, emp_num);
		request.setAttribute("scheduleList", list);
		
		//∆‰¿Ã¬° √≥∏Æ
		PageNavigation pageNavigation = ApprovalManageServiceImpl.getApprovalManageService().scheduleMakePageNavigation(pg, emp_num);
		pageNavigation.setRoot(request.getContextPath());
		pageNavigation.setNavigator();
		request.setAttribute("navigator", pageNavigation);
		
		return "/support?act=scheduleList&pg=1&emp_num=1";
	}

}
