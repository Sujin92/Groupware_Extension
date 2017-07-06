package com.moaware.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.moaware.board.dao.BoardDaoImpl;
import com.moaware.board.dao.CommonDaoImpl;
import com.moaware.board.dao.GroupBoardDaoImpl;
import com.moaware.board.model.BoardDto;
import com.moaware.util.BoardConstance;

public class GroupBoardServiceImpl implements GroupBoardService {

	private static GroupBoardService groupboardService;
	
	static{
		groupboardService = new GroupBoardServiceImpl();
	}
	
	private GroupBoardServiceImpl(){}
	
	public static GroupBoardService getGroupboardService() {
		return groupboardService;
	}

	@Override
	public List<BoardDto> listArticle(int bcode, int pg, String key, String word, String dept) {
		int end = pg * BoardConstance.LIST_SIZE;
		int start = end-BoardConstance.LIST_SIZE;
		Map<String, String> map = new HashMap<String, String>();
		map.put("bcode", bcode+"");
		map.put("key", key);
		map.put("word", word);
		map.put("start", start+ "");
		map.put("end", end+"");
		map.put("dept", dept+"");
		return GroupBoardDaoImpl.getGroupboardDaoImpl().listArticle(map);
	}

	@Override
	public int writeArticle(BoardDto boardDto) {
		return GroupBoardDaoImpl.getGroupboardDaoImpl().writeArticle(boardDto);
	}

	@Override
	public BoardDto getArticle(int seq, int bcode) {
		CommonDaoImpl.getCommonDao().updateHit(seq, bcode);
		return GroupBoardDaoImpl.getGroupboardDaoImpl().getArticle(seq);
	}

	@Override
	public int modifyArticle(BoardDto boardDto) {
		return GroupBoardDaoImpl.getGroupboardDaoImpl().modifyArticle(boardDto);
	}

	@Override
	public int deleteArticle(int seq) {
		return GroupBoardDaoImpl.getGroupboardDaoImpl().deleteArticle(seq);
	}
	

}
