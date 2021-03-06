package com.moaware.commute.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.action.Action;

import com.moaware.commute.model.CommuteDto;
import com.moaware.commute.service.CommuteServiceImpl;
import com.moaware.util.Encoding;

public class CommuteGotoAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String year = request.getParameter("year") + "";
		String month = request.getParameter("month") + "";
		String day = request.getParameter("day") + "";
		String hour = request.getParameter("hour") + "";
		String min = request.getParameter("min") + "";
		String sec = request.getParameter("sec") + "";

		String emp_num = Encoding.isoToEuc(request.getParameter("emp_num"));

		String path = "/index.jsp";
		
		CommuteDto commuteDto = new CommuteDto();
		
		commuteDto.setEmp_num(emp_num);
		commuteDto.setCommute_date(year + "-" + month + "-" + day);
		commuteDto.setCheck_in(hour + ":" + min + ":" + sec);
		commuteDto.setCheck_out(null);
		commuteDto.setCommute_division(0 + "");

		int cnt = CommuteServiceImpl.getCommuteServiceImpl().gotowork(commuteDto);
		 
		if(cnt!=0){
		return "/commute?act=list";
		}
		else{
			return "/home/home.jsp";
		}
	}

}
