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

public class ScheduleAddAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pg = NumberCheck.nullToOne(request.getParameter("pg"));
		String param = "null";
		String emp_num = "1";
		
		ScheduleDto scheduleDto = new ScheduleDto();
		scheduleDto.setEmp_num(emp_num);
		scheduleDto.setSchedule_subject(request.getParameter("sch_subject"));
		scheduleDto.setSchedule_content(request.getParameter("sch_content"));
		scheduleDto.setSchedule_startdate(request.getParameter("sch_start"));
		scheduleDto.setSchedule_enddate(request.getParameter("sch_end"));
		ApprovalManageServiceImpl.getApprovalManageService().scheduleAdd(scheduleDto);
		
		//臂 格废
		List<ScheduleDto> list = ApprovalManageServiceImpl.getApprovalManageService().scheduleList(pg, emp_num);
		request.setAttribute("scheduleList", list);
		
		//其捞隆 贸府
		PageNavigation pageNavigation = ApprovalManageServiceImpl.getApprovalManageService().scheduleMakePageNavigation(pg, emp_num);
		pageNavigation.setRoot(request.getContextPath());
		pageNavigation.setNavigator();
		request.setAttribute("navigator", pageNavigation);
		
		return "/support?act=scheduleList&pg=1&emp_num=1";
	}

}
