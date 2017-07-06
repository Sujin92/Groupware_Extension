package com.moaware.org.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.moaware.action.Action;
import com.moaware.org.model.OrgDto;
import com.moaware.org.service.OrgInfoServiceImpl;

public class OrgInfoAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<OrgDto> list = OrgInfoServiceImpl.getOrgInfoService().orgInfoList();
		request.setAttribute("adressinfo", list);
		return "/member_address/member_address.jsp";

	}

}
