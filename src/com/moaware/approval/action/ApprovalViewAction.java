package com.moaware.approval.action;

import com.moaware.action.Action;
import com.moaware.approval.dao.ApprovalDaoImpl;
import com.moaware.approval.model.ApprovalDto;
import com.moaware.approval.model.ConfirmDto;
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
            ConfirmDto confirmDto = ApprovalDaoImpl.getApprovalDaoImpl().getConfirmList(approvalDto.getConfirm_line_1(), approvalDto.getConfirm_line_2(), approvalDto.getConfirm_line_3());
            request.setAttribute("confirmList", confirmDto);
        }
        return "/approval/view.jsp";
    }
}
