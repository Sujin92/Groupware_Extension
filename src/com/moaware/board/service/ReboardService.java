package com.moaware.board.service;

import java.util.List;

import com.moaware.board.model.ReboardDto;

public interface ReboardService {

	int writeArticle(ReboardDto reboardDto); //회원가입이랑 다를거 없음.
	ReboardDto getArticle(int seq, int bcode); // 글 하나 얻어오기 
	List<ReboardDto> listArticle(int bcode, int pg, String key, String word); // 리스트
	int replyArticle(ReboardDto reboardDto); // 답글
	
	int modifyArticle(ReboardDto reboardDto); // 수정
	int deleteArticle(int seq); // 지우기
	
}
