package com.moaware.admin.cominfo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.action.Action;
import com.moaware.admin.cominfo.service.CominfoServiceImpl;
import com.moaware.admin.member.model.DeptDto;
import com.moaware.util.Encoding;

public class DeptModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptName = Encoding.isoToEuc(request.getParameter("dept_name"));
		int deptNum = Integer.parseInt(request.getParameter("dept_num"));
		
		DeptDto deptDto = new DeptDto();
		deptDto.setDept_num(deptNum);
		deptDto.setDept_name(deptName);
		CominfoServiceImpl.getCominfoService().deptModify(deptDto);
		
		List<DeptDto> list = CominfoServiceImpl.getCominfoService().deptList();
		request.setAttribute("deptList", list);
		
		return "/comInfo?act=deptList";
	}

}
