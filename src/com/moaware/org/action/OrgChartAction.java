package com.moaware.org.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.moaware.action.Action;
import com.moaware.org.model.OrgDto;
import com.moaware.org.service.OrgChartServiceImpl;

public class OrgChartAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<OrgDto> list = OrgChartServiceImpl.getOrgChartService().orgChartList();
		request.setAttribute("chartinfo", list);
		return "/member_address/member_chart.jsp";
	}

}
