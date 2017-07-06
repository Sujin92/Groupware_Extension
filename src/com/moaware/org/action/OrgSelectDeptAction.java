package com.moaware.org.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.action.Action;
import com.moaware.org.model.OrgDto;
import com.moaware.org.service.OrgInfoServiceImpl;

public class OrgSelectDeptAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String selected = request.getParameter("dept_num");
		
		List<OrgDto> orgList = OrgInfoServiceImpl.getOrgInfoService().orgInfoList();
		request.setAttribute("adressinfo", orgList);
		request.setAttribute("selected", selected);
		return "/member_address/member_address.jsp";
	}

}
