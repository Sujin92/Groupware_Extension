package com.moaware.mypage.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.moaware.action.Action;
import com.moaware.member.model.MemberDetailDto;
import com.moaware.member.model.MemberDto;
import com.moaware.mypage.service.MyPageServiceImpl;

public class MyPageModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDetailDto memberDetailDto = new MemberDetailDto();
		memberDetailDto.setEmp_num(request.getParameter("emp_num"));
		memberDetailDto.setPass(request.getParameter("pass"));
		memberDetailDto.setName(request.getParameter("name"));
		memberDetailDto.setGender(request.getParameter("gender"));
		memberDetailDto.setEmail1(request.getParameter("email1"));
		memberDetailDto.setEmail2(request.getParameter("email2"));
		memberDetailDto.setTel1(request.getParameter("tel1"));
		memberDetailDto.setTel2(request.getParameter("tel2"));
		memberDetailDto.setTel3(request.getParameter("tel3"));
		memberDetailDto.setZip1(request.getParameter("zip1"));
		memberDetailDto.setZip2(request.getParameter("zip2"));
		memberDetailDto.setAddr1(request.getParameter("addr1"));
		memberDetailDto.setAddr2(request.getParameter("addr2"));
		memberDetailDto.setBirth1(request.getParameter("birth_yyyy"));
		memberDetailDto.setBirth2(request.getParameter("birth_mm"));
		memberDetailDto.setBirth3(request.getParameter("birth_dd"));
		memberDetailDto.setMarriage(request.getParameter("marriage"));

		int cnt = MyPageServiceImpl.getMyPageServiceImpl().memberInfoModify(memberDetailDto);
		if (cnt != 0) {
			request.setAttribute("modifyInfo", memberDetailDto);
		}
		
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");

		MemberDetailDto DetailDto = MyPageServiceImpl.getMyPageServiceImpl().getMemberInfo(memberDto.getId());
		request.setAttribute("mypage", DetailDto);
		
		return "/mypage/mypage.jsp";
	}

}
