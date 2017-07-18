package com.moaware.approval.action;

import com.moaware.action.Action;
import com.moaware.approval.model.ApprovalDto;
import com.moaware.approval.service.ApprovalServiceImpl;
import com.moaware.member.model.MemberDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ApprovalMainAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
		
		Map<Integer, Integer> map = ApprovalServiceImpl.getApprovalServiceImpl().approvalDoc(memberDto.getEmp_num());
		request.setAttribute("doc1", map);
		
		List<ApprovalDto> list1 = ApprovalServiceImpl.getApprovalServiceImpl().approvalList1(memberDto.getEmp_num());
		request.setAttribute("doc2", list1);
		
		List<ApprovalDto> list2 = ApprovalServiceImpl.getApprovalServiceImpl().approvalList2(memberDto.getEmp_num());
		request.setAttribute("doc3", list2);
		
		return "/approval/approval.jsp";
	}

}
