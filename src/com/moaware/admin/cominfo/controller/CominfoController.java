package com.moaware.admin.cominfo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.factory.CominfoFactory;
import com.moaware.util.NumberCheck;
import com.moaware.util.PageMove;

@WebServlet("/comInfo")
public class CominfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		int pg = NumberCheck.nullToOne(request.getParameter("pg"));
		String queryString = "?pg=" + pg;

		String path = "/index.jsp";
		if ("holdList".equals(act)) {
			path = CominfoFactory.getHoldListAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if ("retireList".equals(act)) {
			path = CominfoFactory.getRetireListAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if ("mvmodify".equals(act)) {
			path = CominfoFactory.getHoldMoveModifyAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if ("modify".equals(act)) {
			path = CominfoFactory.getHoldModifyAction().execute(request, response);
			path += "&pg=" +pg;
			PageMove.redirect(path, request, response);
		} else if ("deptList".equals(act)) {
			path = CominfoFactory.getDeptListAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else if ("deptRegister".equals(act)) {
			path = CominfoFactory.getDeptRegisterAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else if ("getDeptInfo".equals(act)) {
			path = CominfoFactory.getDeptGetInfoModifyAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else if ("deptModify".equals(act)) {
			path = CominfoFactory.getDeptModifyAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else if ("deptDelete".equals(act)) {
			path = CominfoFactory.getDeptDeleteAction().execute(request, response);
			PageMove.forward(path, request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}
}
