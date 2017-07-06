package com.moaware.admin.member.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.action.Action;
import com.moaware.admin.member.model.DeptDto;
import com.moaware.admin.member.service.MemberRegisterServiceImpl;
import com.moaware.util.Encoding;

public class DeptCheckAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptName = Encoding.isoToEuc(request.getParameter("dept_name"));
		List<DeptDto> list = MemberRegisterServiceImpl.getMemberRegisterService().deptSearch(deptName);
		
		request.setAttribute("dept_name", deptName);
		request.setAttribute("deptList", list);
		return "/member_register/dept_check.jsp";
	}

}
