package com.moaware.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.factory.BoardActionFactory;
import com.moaware.util.BoardConstance;
import com.moaware.util.Encoding;
import com.moaware.util.NumberCheck;
import com.moaware.util.PageMove;


@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		
		String path = "/index.jsp";
		
		int bcode = NumberCheck.nullToZero(request.getParameter("bcode"));
		int pg = NumberCheck.nullToOne(request.getParameter("pg"));
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = request.getParameter("word");
		if(request.getMethod().equals("GET"))
			word = Encoding.isoToEuc(word);
		
		String queryString = "?bcode=" + bcode + "&pg=" + pg + "&key=" + key + "&word=" + Encoding.urlFormat(word);
		
		
		if("list".equals(act)){
			path = BoardActionFactory.getBoardListAction().execute(request, response);
			PageMove.forward(path, request, response);
		}else if("mvwrite".equals(act)) {
			path = "/board/write.jsp" + queryString;
			PageMove.redirect(path, request, response);
		}else if("write".equals(act)){
			path = BoardActionFactory.getBoardWriteAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		}else if("view".equals(act)) {
			path = BoardActionFactory.getBoardViewAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		}else if("mvmodify".equals(act)) {
			path = BoardActionFactory.getBoardMoveModifyAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if("modify".equals(act)) {
			path = BoardActionFactory.getBoardModifyAction().execute(request, response);
			path += queryString;
			PageMove.forward(path, request, response);
		} else if("delete".equals(act)) {
			path = BoardActionFactory.getBoardDeleteAction().execute(request, response);
			path += queryString;
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
