package com.moaware.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.moaware.board.dao.BoardDaoImpl;
import com.moaware.board.dao.CommonDaoImpl;
import com.moaware.board.model.BoardDto;
import com.moaware.util.BoardConstance;

public class BoardServiceImpl implements BoardService {

	private static BoardService boardService;
	
	static{
		boardService = new BoardServiceImpl();
	}
	
	private BoardServiceImpl(){}
	
	public static BoardService getBoardService() {
		return boardService;
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
		return BoardDaoImpl.getBoardDaoImpl().listArticle(map);
	}

	@Override
	public int writeArticle(BoardDto boardDto) {
		return BoardDaoImpl.getBoardDaoImpl().writeArticle(boardDto);
	}

	@Override
	public BoardDto getArticle(int seq, int bcode) {
		CommonDaoImpl.getCommonDao().updateHit(seq, bcode);
		return BoardDaoImpl.getBoardDaoImpl().getArticle(seq);
	}

	@Override
	public int modifyArticle(BoardDto boardDto) {
		return BoardDaoImpl.getBoardDaoImpl().modifyArticle(boardDto);
	}

	@Override
	public int deleteArticle(int seq) {
		return BoardDaoImpl.getBoardDaoImpl().deleteArticle(seq);
	}
	
	
}
