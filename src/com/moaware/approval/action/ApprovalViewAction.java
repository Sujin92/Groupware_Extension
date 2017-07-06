package com.moaware.approval.action;

import com.moaware.action.Action;
import com.moaware.approval.model.ApprovalDto;
import com.moaware.approval.service.ApprovalServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gwasan on 2017. 7. 6..
 */
public class ApprovalViewAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int seq = Integer.parseInt(request.getParameter("seq"));
        if (seq != 0) {
            ApprovalDto approvalDto = ApprovalServiceImpl.getApprovalServiceImpl().viewPaper(seq);
            request.setAttribute("view", approvalDto);
        }
        return "/approval/view.jsp";
    }
}
