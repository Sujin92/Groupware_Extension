package com.moaware.admin.member.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.action.Action;
import com.moaware.admin.member.model.PositionDto;
import com.moaware.admin.member.service.MemberRegisterServiceImpl;
import com.moaware.util.Encoding;

public class PositionCheckAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String positionName = Encoding.isoToEuc(request.getParameter("position_name"));
		List<PositionDto> list = MemberRegisterServiceImpl.getMemberRegisterService().positionSearch(positionName);
		
		request.setAttribute("position_name", positionName);
		request.setAttribute("positionList", list);
		return "/member_register/position_check.jsp";
	}

}
