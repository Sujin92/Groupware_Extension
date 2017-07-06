package com.moaware.board.dao;

import java.util.List;
import java.util.Map;

import com.moaware.board.model.ReboardDto;

public interface ReboardDao {

	int writeArticle(ReboardDto reboardDto);
	ReboardDto getArticle(int seq); // 글 하나 얻어오기 
	List<ReboardDto> listArticle(Map<String, String> map); // 리스트 => 인자값이 여러개인데 Dto로 따로 없을 때 Map으로 보냄
	int replyArticle(ReboardDto reboardDto); // 답글
	
	int modifyArticle(ReboardDto reboardDto); // 수정
	int deleteArticle(int seq); // 지우기
	
}
