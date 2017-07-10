package com.moaware.approval.controller;

import com.moaware.approval.service.ApprovalServiceImpl;
import com.moaware.factory.ApprovalFactory;
import com.moaware.util.PageMove;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gwasan on 2017. 6. 20..
 */
@WebServlet("/appcontrol")
public class ApprovalController extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("act");

        String path = "/index.jsp";
        if ("write".equals(act)) {
            path = ApprovalFactory.getApprovalWriteAction().execute(request, response);
            PageMove.redirect(path, request, response);
        } else if ("getmember".equals(act)) {
            ApprovalServiceImpl.getApprovalServiceImpl().getMember(response);
        } else if ("getdept".equals(act)) {
            ApprovalServiceImpl.getApprovalServiceImpl().getDept(response);
        } else if ("outstanding".equals(act)) {
            path = ApprovalFactory.getApprovalOutstandingAction().execute(request, response);
            PageMove.forward(path, request, response);
        } else if ("view".equals(act)) {
            path = ApprovalFactory.getApprovalViewAction().execute(request, response);
            PageMove.forward(path, request, response);
        } else if ("confirm".equals(act)) {
            path = ApprovalFactory.getApprovalViewAction().execute(request, response);
            PageMove.forward(path, request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("EUC-KR");
        doGet(request, response);
    }

}
