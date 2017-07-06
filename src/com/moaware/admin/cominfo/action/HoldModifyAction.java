package com.moaware.admin.cominfo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.swing.JOptionPane;

import com.moaware.action.Action;
import com.moaware.admin.cominfo.model.CominfoDto;
import com.moaware.admin.cominfo.service.CominfoServiceImpl;
import com.moaware.admin.cominfo.util.PageNavigation;
import com.moaware.util.NumberCheck;

public class HoldModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pg = NumberCheck.nullToOne(request.getParameter("pg"));
		String seq = (String) request.getParameter("modifyseq");
		String param = "null";

		CominfoDto cominfoDto = new CominfoDto();
		cominfoDto.setEmp_num(seq);
		cominfoDto.setDept_name(request.getParameter("dept_name"));
		cominfoDto.setPosition_name(request.getParameter("position_name"));
		cominfoDto.setId(request.getParameter("id"));
		cominfoDto.setPass(request.getParameter("pass"));
		cominfoDto.setName(request.getParameter("name"));
		cominfoDto.setGender(request.getParameter("gender"));
		cominfoDto.setEmail1(request.getParameter("email1"));
		cominfoDto.setEmail2(request.getParameter("email2"));
		cominfoDto.setTel1(request.getParameter("tel1"));
		cominfoDto.setTel2(request.getParameter("tel2"));
		cominfoDto.setTel3(request.getParameter("tel3"));
		cominfoDto.setZip1(request.getParameter("zip1"));
		cominfoDto.setZip2(request.getParameter("zip2"));
		cominfoDto.setAddr1(request.getParameter("addr1"));
		cominfoDto.setAddr2(request.getParameter("addr2"));
		cominfoDto.setBirth1(request.getParameter("birth_yyyy"));
		cominfoDto.setBirth2(request.getParameter("birth_mm"));
		cominfoDto.setBirth3(request.getParameter("birth_dd"));
		cominfoDto.setMarriage(request.getParameter("marriage"));
		cominfoDto.setHire_date1(request.getParameter("hire_yyyy"));
		cominfoDto.setHire_date2(request.getParameter("hire_mm"));
		cominfoDto.setHire_date3(request.getParameter("hire_dd"));
		cominfoDto.setOut_date1(request.getParameter("out_yyyy"));
		cominfoDto.setOut_date2(request.getParameter("out_mm"));
		cominfoDto.setOut_date3(request.getParameter("out_dd"));

		CominfoServiceImpl.getCominfoService().modify(cominfoDto);
		
		return "/comInfo?act=holdList";
	}
}
