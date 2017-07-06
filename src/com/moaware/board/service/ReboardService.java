package com.moaware.board.service;

import java.util.List;

import com.moaware.board.model.ReboardDto;

public interface ReboardService {

	int writeArticle(ReboardDto reboardDto); //ȸ�������̶� �ٸ��� ����.
	ReboardDto getArticle(int seq, int bcode); // �� �ϳ� ������ 
	List<ReboardDto> listArticle(int bcode, int pg, String key, String word); // ����Ʈ
	int replyArticle(ReboardDto reboardDto); // ���
	
	int modifyArticle(ReboardDto reboardDto); // ����
	int deleteArticle(int seq); // �����
	
}
