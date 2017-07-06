package com.moaware.faq.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moaware.action.Action;
import com.moaware.board.model.BoardDto;
import com.moaware.board.service.BoardServiceImpl;
import com.moaware.board.service.CommonServiceImpl;
import com.moaware.board.service.FaqServiceImpl;
import com.moaware.member.model.MemberDto;
import com.moaware.util.Encoding;
import com.moaware.util.NumberCheck;

public class FaqWriteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();//session 생성
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");//session에서 MemberDto get
		
		int bcode = NumberCheck.nullToZero(request.getParameter("bcode"));
		int pg = NumberCheck.nullToOne(request.getParameter("pg"));
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = Encoding.isoToEuc(request.getParameter("word"));
		
		String path = "/index.jsp";
		if(memberDto != null) {//로그인 했다면.
			int seq = CommonServiceImpl.getCommonService().getNextSeq(bcode);//글번호 얻기
			
			BoardDto boardDto = new BoardDto();
			boardDto.setSeq(seq);
			boardDto.setEmp_num(memberDto.getEmp_num());
			boardDto.setName(memberDto.getName());
			boardDto.setSubject(request.getParameter("subject"));
			boardDto.setContent(request.getParameter("content"));
			boardDto.setBcode(NumberCheck.nullToZero(request.getParameter("bcode")));
			
			int cnt = FaqServiceImpl.getFaqService().writeArticle(boardDto);
			if(cnt != 0) {
				request.setAttribute("seq", seq + "");
				path = "/faq/writeOk.jsp";
			} else {
				path = "/faq/writeFail.jsp";
			}
		}
		
		return path;
	}

}
