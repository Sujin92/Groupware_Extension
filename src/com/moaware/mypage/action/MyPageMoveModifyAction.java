package com.moaware.mypage.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.moaware.action.Action;
import com.moaware.member.model.MemberDetailDto;
import com.moaware.member.model.MemberDto;
import com.moaware.mypage.service.MyPageServiceImpl;

public class MyPageMoveModifyAction implements Action {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");

		MemberDetailDto memberDetailDto = MyPageServiceImpl.getMyPageServiceImpl().getMemberInfo(memberDto.getId());
		request.setAttribute("mypage", memberDetailDto);
		
		return "/mypage/mypage_modify.jsp";
	}
	
}
