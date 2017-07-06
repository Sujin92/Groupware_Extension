package com.moaware.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.factory.ReboardActionFactory;
import com.moaware.util.BoardConstance;
import com.moaware.util.Encoding;
import com.moaware.util.NumberCheck;
import com.moaware.util.PageMove;

@WebServlet("/reboard")
public class ReboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		int bcode = NumberCheck.nullToZero(request.getParameter("bcode"));
		int pg = NumberCheck.nullToOne(request.getParameter("pg"));
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = request.getParameter("word");
		if (request.getMethod().equals("GET")) {
			word = Encoding.isoToEuc(word);
		} 
		String queryString = "?bcode=" + bcode + "&pg=" + pg + "&key=" + key + "&word=" + Encoding.urlFormat(word);
		System.out.println("RC >>>> "+ queryString); 
		String path = "/index.jsp";
		
		if("mvwrite".equals(act)) {
			path ="/reboard/write.jsp" + queryString;
			PageMove.redirect(path, request, response);
		} else if("write".equals(act)) {
			path = ReboardActionFactory.getReboardWriteAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if("view".equals(act)) {
			path = ReboardActionFactory.getReboardViewAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if("list".equals(act)) {
			path = ReboardActionFactory.getReboardListAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if("mvreply".equals(act)) {
			path = ReboardActionFactory.getReboardMoveReplyAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if("reply".equals(act)) {
			path = ReboardActionFactory.getReboardReplyAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if("mvmodify".equals(act)) {
			path = ReboardActionFactory.getReboardMoveModifyAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if("modify".equals(act)) {
			path = ReboardActionFactory.getReboardModifyAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if("delete".equals(act)) {
			path = ReboardActionFactory.getReboardDeleteAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else {
			path = "/index.jsp";
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(BoardConstance.DEFAULT_CHAR_SET);
		doGet(request, response);
	}

}
