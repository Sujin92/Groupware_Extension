package com.moaware.reboard.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moaware.action.Action;
import com.moaware.board.model.ReboardDto;
import com.moaware.board.service.CommonServiceImpl;
import com.moaware.board.service.ReboardServiceImpl;
import com.moaware.util.BoardConstance;
import com.moaware.util.Encoding;
import com.moaware.util.NumberCheck;
import com.moaware.util.PageNavigation;

public class ReboardListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bcode = NumberCheck.nullToZero(request.getParameter("bcode")); // ��ũ�� �������� ��, 0 = ��� �Խ����� ��� �۸������
		int pg = NumberCheck.nullToOne(request.getParameter("pg")); // �������� 0��° �������� ���⶧���� 1�� �ʱ�ȭ
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = Encoding.isoToEuc(request.getParameter("word")); // ���� �˻��� �갡 �ϴ°Ŵϱ� �굵 �ѱ�ó��
		// �� ���
		List<ReboardDto> list = ReboardServiceImpl.getReboardService().listArticle(bcode, pg, key, word);
		request.setAttribute("articleList", list);
		
		// ����¡ó��
		PageNavigation pageNavigation = CommonServiceImpl.getCommonService().makePageNavigation(bcode, pg, key, word, BoardConstance.LIST_SIZE);
		pageNavigation.setRoot(request.getContextPath());
		pageNavigation.setNavigator();
		request.setAttribute("navigator", pageNavigation);
		return "/reboard/list.jsp";
	}

}
