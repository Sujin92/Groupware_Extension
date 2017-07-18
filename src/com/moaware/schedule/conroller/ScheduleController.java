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
			System.out.println("컨트롤러까진 왓냐");
			path = ScheduleActionFactory.getScheduleAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else if ("slist".equals(act)) {
			System.out.println("담나??");
			path = ScheduleActionFactory.getScheduleWriteAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else if ("deletee".equals(act)) {
			System.out.println("와감ㅇ나ㅓㅇㅁ너ㅏㅇㅁ너ㅏㅇㅁ너ㅏㅁㄴ어ㅏ");
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
