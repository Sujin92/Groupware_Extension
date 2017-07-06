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
		//글 목록
		List<CominfoDto> list = CominfoServiceImpl.getCominfoService().holdList(pg);
		request.setAttribute("holdList", list);
		
		//페이징 처리
		PageNavigation pageNavigation = CominfoServiceImpl.getCominfoService().makePageNavigation(pg, param);
		pageNavigation.setRoot(request.getContextPath()); // "/boardmvc"
		pageNavigation.setNavigator(); //root가 설정된 다음 Navigator를 만들어야 원하는 정보들을 얻을 수 있음
		request.setAttribute("navigator", pageNavigation);
		
		return "/commanage/holdlist.jsp";
	}

}
