package com.moaware.board.dao;

import java.util.List;
import java.util.Map;

import com.moaware.board.model.BoardDto;

public interface GroupBoardDao {

	List<BoardDto> listArticle(Map<String, String> map);
	int writeArticle(BoardDto boardDto);
	BoardDto getArticle(int seq);
	int modifyArticle(BoardDto boardDto);
	int deleteArticle(int seq);
	
}
