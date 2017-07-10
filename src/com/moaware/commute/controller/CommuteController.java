package com.moaware.commute.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.commute.action.CommuteGotoAction;
import com.moaware.factory.BoardActionFactory;
import com.moaware.factory.CommuteFactory;
import com.moaware.util.BoardConstance;
import com.moaware.util.Encoding;
import com.moaware.util.NumberCheck;
import com.moaware.util.PageMove;

@WebServlet("/commute")
public class CommuteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String act = request.getParameter("act");
		
		String path = "/index.jsp";
		
		if("goto".equals(act)){
			path = CommuteFactory.getCommuteGotoAction().execute(request, response);
			PageMove.forward(path, request, response);
		}else if("list".equals(act)) {
			path = CommuteFactory.getCommuteListAction().execute(request, response);
			PageMove.forward(path, request, response);
		}else if("leave".equals(act)) {
			path = CommuteFactory.getCommuteLeaveAction().execute(request, response);
			PageMove.forward(path, request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
