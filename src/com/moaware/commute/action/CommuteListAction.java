package com.moaware.commute.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moaware.action.Action;
import com.moaware.commute.model.CommuteDto;
import com.moaware.commute.service.CommuteServiceImpl;
import com.moaware.member.model.MemberDto;


public class CommuteListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();//session 생성
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");//session에서 MemberDto get
		
		 List<CommuteDto> list = CommuteServiceImpl.getCommuteServiceImpl().listArticle(memberDto.getEmp_num());
		 request.setAttribute("gotoList", list);
		
		return "/commute/calendartest.jsp";
	}

}
