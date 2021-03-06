package com.moaware.schedule.conroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			path = ScheduleActionFactory.getScheduleWriteAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else if ("mydate".equals(act)) {
			System.out.println("珍闘継君猿遭 甚劃");
			path = ScheduleActionFactory.getScheduleAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else if ("slist".equals(act)) {
			System.out.println("眼蟹??");
			path = ScheduleActionFactory.getScheduleWriteAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else if ("deletee".equals(act)) {
			System.out.println("人姶し蟹っしけ格たしけ格たしけ格たけい嬢た");
			path = ScheduleActionFactory.getScheduleDeleteAction().execute(request, response);
			PageMove.forward(path, request, response);
		}else if ("updatee".equals(act)){
			path = ScheduleActionFactory.getScheduleUpdateAction().execute(request, response);
			PageMove.forward(path, request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
