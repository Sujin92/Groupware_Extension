package com.moaware.admin.cominfo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.action.Action;
import com.moaware.admin.cominfo.service.CominfoServiceImpl;
import com.moaware.admin.member.model.DeptDto;

public class DeptGetInfoModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq = request.getParameter("seq");
		DeptDto deptDto = CominfoServiceImpl.getCominfoService().getDeptInfo(seq);
		request.setAttribute("getDeptDto", deptDto);
		
		List<DeptDto> list = CominfoServiceImpl.getCominfoService().deptList();
		request.setAttribute("deptList", list);
		System.out.println(deptDto.getDept_name());
		System.out.println(deptDto.getDept_num());
		
		return "getDeptDto";
	}

}
