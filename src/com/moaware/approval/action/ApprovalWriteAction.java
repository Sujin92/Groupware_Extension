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

/**
 * Created by gwasan on 2017. 6. 24..
 */
public class ApprovalWriteAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");

        String path = "/index.jsp";
        if (memberDto != null) {
            ApprovalDto approvalDto = new ApprovalDto();
//            approvalDto.setDoc_num("48");
            approvalDto.setEmp_num(memberDto.getEmp_num());
            approvalDto.setDoc_type_num("33");
            approvalDto.setDoc_name("order paper");
            approvalDto.setDoc_state("ing");
            approvalDto.setDoc_subject(request.getParameter("subject"));
            approvalDto.setDoc_content(request.getParameter("content"));
            approvalDto.setDraft_date(request.getParameter("year") + "." + request.getParameter("month") + "." + request.getParameter("day"));
            approvalDto.setReceive_dept(request.getParameter("receiveDept"));
            approvalDto.setConfirm_line_1(request.getParameter("confirm_line1"));
            approvalDto.setConfirm_line_2(request.getParameter("confirm_line2"));
            approvalDto.setConfirm_line_3(request.getParameter("confirm_line3"));

            int cnt = ApprovalServiceImpl.getApprovalServiceImpl().writePaper(approvalDto);
            if (cnt != 0) {
                request.setAttribute("app", approvalDto);
                path = "/approval/approval.jsp";
            } else {
                path = "/approval/writeFail.jsp";
            }
        }

        return path;
    }
}
