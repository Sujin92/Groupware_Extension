package com.moaware.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.factory.OrgFactory;
import com.moaware.util.PageMove;

@WebServlet("/org")
public class OrgController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getParameter("act");

		response.setContentType("text/html;charset=euc-kr");
		String path = "/index.jsp";
		if ("address".equals(act)) {
			path = OrgFactory.getOrgInfoAction().execute(request, response);
			PageMove.forward(path, request, response);

		} else if ("chart".equals(act)) {
			path = OrgFactory.getOrgChartAction().execute(request, response);
			PageMove.forward(path, request, response);
		} 
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
