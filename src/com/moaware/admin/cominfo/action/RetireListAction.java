package com.moaware.admin.cominfo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.action.Action;
import com.moaware.admin.cominfo.dao.CominfoDaoImpl;
import com.moaware.admin.cominfo.model.CominfoDto;
import com.moaware.admin.cominfo.service.CominfoServiceImpl;
import com.moaware.admin.cominfo.util.PageNavigation;

public class RetireListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pg = Integer.parseInt(request.getParameter("pg"));
		String param = "not null";
		
		//�� ���
		List<CominfoDto> list = CominfoServiceImpl.getCominfoService().retireList(pg);
		request.setAttribute("retireList", list);
		
		//����¡ ó��
		PageNavigation pageNavigation = CominfoServiceImpl.getCominfoService().makePageNavigation(pg, param);
		pageNavigation.setRoot(request.getContextPath()); // "/boardmvc"
		pageNavigation.setNavigator(); //root�� ������ ���� Navigator�� ������ ���ϴ� �������� ���� �� ����
		request.setAttribute("retireNavigator", pageNavigation);
				
		return "/commanage/retirelist.jsp";
	}


}
