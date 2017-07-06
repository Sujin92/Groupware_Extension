package com.moaware.admin.cominfo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.moaware.action.Action;
import com.moaware.admin.cominfo.model.CominfoDto;
import com.moaware.admin.cominfo.service.CominfoServiceImpl;
import com.moaware.admin.cominfo.util.PageNavigation;

public class HoldListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pg = Integer.parseInt(request.getParameter("pg"));
		String param = "null";
		//�� ���
		List<CominfoDto> list = CominfoServiceImpl.getCominfoService().holdList(pg);
		request.setAttribute("holdList", list);
		
		//����¡ ó��
		PageNavigation pageNavigation = CominfoServiceImpl.getCominfoService().makePageNavigation(pg, param);
		pageNavigation.setRoot(request.getContextPath()); // "/boardmvc"
		pageNavigation.setNavigator(); //root�� ������ ���� Navigator�� ������ ���ϴ� �������� ���� �� ����
		request.setAttribute("navigator", pageNavigation);
		
		return "/commanage/holdlist.jsp";
	}

}
