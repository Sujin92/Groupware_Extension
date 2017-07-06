package com.moaware.admin.cominfo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.action.Action;
import com.moaware.admin.cominfo.service.CominfoServiceImpl;
import com.moaware.admin.member.model.DeptDto;

public class DetpRegisterAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptName = request.getParameter("dept_name");
		CominfoServiceImpl.getCominfoService().deptRegister(deptName);
		
		List<DeptDto> list = CominfoServiceImpl.getCominfoService().deptList();
		request.setAttribute("deptList", list);
		
		return "/comInfo?act=deptList";
	}

}
