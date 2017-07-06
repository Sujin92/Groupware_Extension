package com.moaware.org.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.moaware.action.Action;
import com.moaware.org.model.KeywordDto;
import com.moaware.org.model.OrgDto;
import com.moaware.org.service.OrgInfoServiceImpl;
import com.moaware.org.service.OrgSelectServiceImpl;


public class OrgSelectAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("emp_num");

		List<KeywordDto> list = OrgSelectServiceImpl.getOrgSelectService(keyword).orgSelectList(keyword);
		List<OrgDto> orgList = OrgInfoServiceImpl.getOrgInfoService().orgInfoList();
		request.setAttribute("selectinfo", list);
		request.setAttribute("adressinfo", orgList);
		return "/member_address/member_address.jsp";
	}
}