package com.moaware.schedule.conroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.factory.ProjectFactory;
import com.moaware.factory.ScheduleActionFactory;
import com.moaware.util.PageMove;

/**
 * Servlet implementation class ScheduleController
 */
@WebServlet("/ScheduleController")
public class ScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getParameter("act");
		String path = "/index.jsp";

		if ("freedate".equals(act)) {
			System.out.println(request.getParameter("realtime"));
			path = ScheduleActionFactory.getScheduleAction().execute(request, response);
			PageMove.forward(path, request, response);
		}else if("mydate".equals(act)){
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
