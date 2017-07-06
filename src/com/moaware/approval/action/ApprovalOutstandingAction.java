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

/**
 * Created by gwasan on 2017. 7. 3..
 */
public class ApprovalOutstandingAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
        List<ApprovalDto> list = ApprovalServiceImpl.getApprovalServiceImpl().confirmList(0, memberDto.getEmp_num());
        request.setAttribute("list", list);

        return "/approval/confirm.jsp";
    }
}
