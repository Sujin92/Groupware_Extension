package com.moaware.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.moaware.board.dao.CommonDaoImpl;
import com.moaware.board.dao.ReboardDaoImpl;
import com.moaware.board.model.ReboardDto;
import com.moaware.util.BoardConstance;

public class ReboardServiceImpl implements ReboardService {

	private static ReboardService reboardService;

	static {
		reboardService = new ReboardServiceImpl();
	}

	private ReboardServiceImpl() {
	};

	public static ReboardService getReboardService() {
		return reboardService;
	}

	@Override
	public int writeArticle(ReboardDto reboardDto) {
		return ReboardDaoImpl.getReboardDao().writeArticle(reboardDto);
	}

	@Override
	public ReboardDto getArticle(int seq, int bcode) {
		CommonDaoImpl.getCommonDao().updateHit(seq, bcode);
		return ReboardDaoImpl.getReboardDao().getArticle(seq);
	}

	@Override
	public List<ReboardDto> listArticle(int bcode, int pg, String key, String word) {
		int end = pg * BoardConstance.LIST_SIZE;
		int start = end - BoardConstance.LIST_SIZE; 
		Map<String, String> map = new HashMap<String, String>();
		map.put("bcode", bcode + "");
		map.put("key", key);
		map.put("word", word);
		map.put("start", start +""); // 페이지 첫번호와 마지막번호를 계산하기 위해서 start와 end 만듦
		map.put("end", end +"");
		return ReboardDaoImpl.getReboardDao().listArticle(map);
	}
	
	@Override
	public int replyArticle(ReboardDto reboardDto) {
		return ReboardDaoImpl.getReboardDao().replyArticle(reboardDto);
	}

	@Override
	public int modifyArticle(ReboardDto reboardDto) {
		return ReboardDaoImpl.getReboardDao().modifyArticle(reboardDto);
	}

	@Override
	public int deleteArticle(int seq) {
		return ReboardDaoImpl.getReboardDao().deleteArticle(seq);
	}

}
