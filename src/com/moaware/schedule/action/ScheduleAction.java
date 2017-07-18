package com.moaware.schedule.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.moaware.action.Action;
import com.moaware.member.model.MemberDto;
import com.moaware.schedule.model.ScheduleDto;
import com.moaware.schedule.service.ScheduleServiceImpl;
import com.moaware.util.Encoding;
import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane.ScalableIconUIResource;

public class ScheduleAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto)session.getAttribute("loginInfo");
		System.out.println("그냥액션임");
		ScheduleDto scheduleDto= new ScheduleDto();
		scheduleDto.setId(memberDto.getEmp_num());
		scheduleDto.setStartDate(request.getParameter("startDate"));
		scheduleDto.setEndDate(request.getParameter("endDate"));
		scheduleDto.setTitle(request.getParameter("title"));
		scheduleDto.setContent(request.getParameter("content"));
		scheduleDto.setFreedayselector(request.getParameter("fds"));
		
	
		List<ScheduleDto> list = ScheduleServiceImpl.getScheduleService().list(scheduleDto);
		request.setAttribute("slist", list);
		
	
		return "/calendarindex.jsp";
		
	}	
}