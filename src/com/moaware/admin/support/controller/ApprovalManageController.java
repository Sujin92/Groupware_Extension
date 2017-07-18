package com.moaware.admin.support.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.factory.ApprovalManageFactory;
import com.moaware.util.NumberCheck;
import com.moaware.util.PageMove;

@WebServlet("/support")
public class ApprovalManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		int pg = NumberCheck.nullToOne(request.getParameter("pg"));
		String emp_num = request.getParameter("emp_num");
		String queryString = "?pg=" + pg + "&emp_num=" + emp_num;
		String path = "/index.jsp";
		
		if ("memberList".equals(act)) {
			path = ApprovalManageFactory.getMemberListAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if ("docList".equals(act)) {
			path = ApprovalManageFactory.getDocListAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if ("scheduleList".equals(act)) {
			path = ApprovalManageFactory.getScheduleListAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if ("scheduleAdd".equals(act)) {
			path = ApprovalManageFactory.getScheduleAddAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if ("scheduleModify".equals(act)) {
			path = ApprovalManageFactory.getScheduleModifyAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if ("scheduleDelete".equals(act)) {
			path = ApprovalManageFactory.getScheduleDeleteAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}
}
