package com.moaware.admin.support.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.action.Action;
import com.moaware.admin.support.model.ScheduleDto;
import com.moaware.admin.support.service.ApprovalManageServiceImpl;

public class ScheduleModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sch_seq = request.getParameter("sch_seq");
		String sch_start = request.getParameter("sch_start");
		String sch_end = request.getParameter("sch_end");
		String sch_subject = request.getParameter("sch_subject");
		String sch_content = request.getParameter("sch_content");
		
		ScheduleDto scheduleDto = new ScheduleDto();
		scheduleDto.setSchedule_seq(sch_seq);
		scheduleDto.setSchedule_startdate(sch_start);
		scheduleDto.setSchedule_enddate(sch_end);
		scheduleDto.setSchedule_subject(sch_subject);
		scheduleDto.setSchedule_content(sch_content);
		
		ApprovalManageServiceImpl.getApprovalManageService().scheduleModify(scheduleDto);
		
		return "/support?act=scheduleList&pg=1&emp_num=1";
	}

}
