package com.moaware.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.moaware.board.dao.CommonDaoImpl;
import com.moaware.board.dao.FaqDaoImpl;
import com.moaware.board.model.BoardDto;
import com.moaware.util.BoardConstance;

public class FaqServiceImpl implements FaqService {

	private static FaqService faqService;
	
	static{
		faqService = new FaqServiceImpl();
	}
	
	private FaqServiceImpl(){}
	
	
	
	public static FaqService getFaqService() {
		return faqService;
	}



	@Override
	public List<BoardDto> listArticle(int bcode, int pg, String key, String word) {
		int end = pg * BoardConstance.LIST_SIZE;
		int start = end-BoardConstance.LIST_SIZE;
		Map<String, String> map = new HashMap<String, String>();
		map.put("bcode", bcode+"");
		map.put("key", key);
		map.put("word", word);
		map.put("start", start+ "");
		map.put("end", end+"");
		return FaqDaoImpl.getFaqDaoImpl().listArticle(map);
	}

	@Override
	public int writeArticle(BoardDto boardDto) {
		return FaqDaoImpl.getFaqDaoImpl().writeArticle(boardDto);
	}

	@Override
	public BoardDto getArticle(int seq, int bcode) {
		CommonDaoImpl.getCommonDao().updateHit(seq, bcode);
		return FaqDaoImpl.getFaqDaoImpl().getArticle(seq);
	}

	@Override
	public int modifyArticle(BoardDto boardDto) {
		return FaqDaoImpl.getFaqDaoImpl().modifyArticle(boardDto);
	}

	@Override
	public int deleteArticle(int seq) {
		return FaqDaoImpl.getFaqDaoImpl().deleteArticle(seq);
	}
	
	

}
