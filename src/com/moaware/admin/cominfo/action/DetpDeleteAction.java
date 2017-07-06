package com.moaware.admin.cominfo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.action.Action;
import com.moaware.admin.cominfo.service.CominfoServiceImpl;
import com.moaware.admin.member.model.DeptDto;

public class DetpDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int check = Integer.parseInt(request.getParameter("check"));
		
		CominfoServiceImpl.getCominfoService().deptDelete(check);
		
		List<DeptDto> list = CominfoServiceImpl.getCominfoService().deptList();
		request.setAttribute("deptList", list);
		
		return "/comInfo?act=deptList";
	}

}
