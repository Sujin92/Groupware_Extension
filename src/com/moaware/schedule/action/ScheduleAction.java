package com.moaware.schedule.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.moaware.action.Action;
import com.moaware.schedule.model.ScheduleDto;
import com.moaware.schedule.service.ScheduleServiceImpl;
import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane.ScalableIconUIResource;

public class ScheduleAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ScheduleDto scheduleDto= new ScheduleDto();
		scheduleDto.setId(request.getParameter("id"));
		scheduleDto.setDaytDate(request.getParameter("daytDate"));
		scheduleDto.setTitle(request.getParameter("title"));
		scheduleDto.setContent(request.getParameter("content"));
		scheduleDto.setFreedayselector(request.getParameter("freedayselector"));
	
	int test=ScheduleServiceImpl.getScheduleService().scheduleDto(scheduleDto);
		if(test==1){
		return "/calendarindex.jsp";
		}
		else
			return "/index.jsp";
	}
}