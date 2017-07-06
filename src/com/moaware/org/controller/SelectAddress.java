package com.moaware.org.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.factory.OrgFactory;
import com.moaware.util.PageMove;

@WebServlet("/selectdept")
public class SelectAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		
		String path = "/index.jsp";
		if ("selectdept1".equals(act)) {
			path = OrgFactory.getOrgSelectDeptAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else if("".equals(act)) {
			
		}
	}
	}

