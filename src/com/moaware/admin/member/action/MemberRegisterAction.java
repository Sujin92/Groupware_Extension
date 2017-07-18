package com.moaware.admin.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.member.model.MemberDetailDto;
import com.moaware.action.Action;
import com.moaware.admin.member.service.MemberRegisterServiceImpl;

public class MemberRegisterAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDetailDto memberDetailDto = new MemberDetailDto();
		memberDetailDto.setDept_name(request.getParameter("dept_name"));
		memberDetailDto.setPosition_name(request.getParameter("position_name"));
		memberDetailDto.setId(request.getParameter("id"));
		memberDetailDto.setPass(request.getParameter("pass"));
		memberDetailDto.setName(request.getParameter("name"));
		memberDetailDto.setGender(request.getParameter("gender"));
		memberDetailDto.setEmail1(request.getParameter("email1"));
		memberDetailDto.setEmail2(request.getParameter("email2"));
		memberDetailDto.setTel1(request.getParameter("tel1"));
		memberDetailDto.setTel2(request.getParameter("tel2"));
		memberDetailDto.setTel3(request.getParameter("tel3"));
		memberDetailDto.setPicture(request.getParameter("picture"));
		memberDetailDto.setZip1(request.getParameter("zip1"));
		memberDetailDto.setZip2(request.getParameter("zip2"));
		memberDetailDto.setAddr1(request.getParameter("addr1"));
		memberDetailDto.setAddr2(request.getParameter("addr2"));
		memberDetailDto.setBirth1(request.getParameter("birth_yyyy"));
		memberDetailDto.setBirth2(request.getParameter("birth_mm"));
		memberDetailDto.setBirth3(request.getParameter("birth_dd"));
		memberDetailDto.setMarriage(request.getParameter("marriage"));
		memberDetailDto.setHire_date1(request.getParameter("hire_yyyy"));
		memberDetailDto.setHire_date2(request.getParameter("hire_mm"));
		memberDetailDto.setHire_date3(request.getParameter("hire_dd"));
		memberDetailDto.setOut_date1(request.getParameter("out_yyyy"));
		memberDetailDto.setOut_date2(request.getParameter("out_mm"));
		memberDetailDto.setOut_date3(request.getParameter("out_dd"));
		
		MemberRegisterServiceImpl.getMemberRegisterService().register(memberDetailDto);

		return "/member_register/member_register.jsp";
	}

}
