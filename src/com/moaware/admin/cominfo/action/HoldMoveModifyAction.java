package com.moaware.admin.cominfo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.moaware.action.Action;
import com.moaware.admin.cominfo.model.CominfoDto;
import com.moaware.admin.cominfo.service.CominfoServiceImpl;
import com.moaware.util.NumberCheck;

public class HoldMoveModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int seq = NumberCheck.nullToZero(request.getParameter("seq"));
		
		if(seq != 0){
			CominfoDto cominfoDto = CominfoServiceImpl.getCominfoService().getArticle(seq);
			
			request.setAttribute("article", cominfoDto);
			request.setAttribute("seq", seq + "");
		}
		
		return "/commanage/hold_modify.jsp";
	}

}
