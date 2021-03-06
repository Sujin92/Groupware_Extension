package com.moaware.reboard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moaware.action.Action;
import com.moaware.board.model.ReboardDto;
import com.moaware.board.service.ReboardServiceImpl;
import com.moaware.member.model.MemberDto;
import com.moaware.util.NumberCheck;

public class ReboardModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(); // session 생성
		MemberDto memberDto = (MemberDto) session.getAttribute("loginInfo");
		String path = "/index.jsp"; //원래는 login.jsp지만 없으므로 index
		
		if (memberDto != null) { // 로그인을 했다면
			int seq = NumberCheck.nullToZero(request.getParameter("seq"));
			
			ReboardDto reboardDto = new ReboardDto();
			reboardDto.setSeq(seq); // 글번호 얻어오는 이유는 작성한 글 확인을 눌렀을 때, 작성한 글을 보려면 글 번호가 필요함
			reboardDto.setEmp_num(memberDto.getEmp_num()); // session
			reboardDto.setName(memberDto.getName()); // session
			reboardDto.setSubject(request.getParameter("subject")); // parameter
			reboardDto.setContent(request.getParameter("content")); // parameter
			reboardDto.setBcode(NumberCheck.nullToZero(request.getParameter("bcode"))); // parameter

			int cnt = ReboardServiceImpl.getReboardService().modifyArticle(reboardDto);
			if (cnt != 0) {
				// bcode, pg, key, word는 queryString으로 넘기고, 나머지는 request나 session에 받아서 넘기자
				request.setAttribute("seq", seq +""); // 형변환하기 귀찮으니까...
				path = "reboard/modifyOk.jsp"; // 주소는 대문자 소문자 구분함, 글번호 가져가야함 ( 작성한 글 확인 ), bcode, pg, key, word
				
			} else
				path = "reboard/modifyFail.jsp";
		}
		return path;
	}

}
