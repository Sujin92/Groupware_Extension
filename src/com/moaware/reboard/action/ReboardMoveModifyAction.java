package com.moaware.reboard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.action.Action;
import com.moaware.board.model.ReboardDto;
import com.moaware.board.service.ReboardServiceImpl;
import com.moaware.util.Encoding;
import com.moaware.util.NumberCheck;

public class ReboardMoveModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int seq = NumberCheck.nullToZero(request.getParameter("seq"));
		int bcode = NumberCheck.nullToZero(request.getParameter("bcode"));
		int pg = NumberCheck.nullToOne(request.getParameter("pg"));
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = Encoding.isoToEuc(request.getParameter("word"));
		if (seq != 0) { // 글번호가 0이 아닐때만 특정 글을 보여줌 
			ReboardDto reboardDto = ReboardServiceImpl.getReboardService().getArticle(seq, bcode);

			request.setAttribute("article", reboardDto);
		}
		return "reboard/modify.jsp";
	}

}
