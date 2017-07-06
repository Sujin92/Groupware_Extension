package com.moaware.board.service;

import java.util.List;

import com.moaware.board.model.BoardDto;

public interface GroupBoardService {

	List <BoardDto> listArticle(int bcode, int pg, String key, String word, String dept);
	int writeArticle(BoardDto boardDto);
	BoardDto getArticle(int seq, int bcode);
	int modifyArticle(BoardDto boardDto);
	int deleteArticle(int seq);
	
}
