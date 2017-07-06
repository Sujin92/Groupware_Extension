package com.moaware.board.dao;

import java.util.List;
import java.util.Map;

import com.moaware.board.model.ReboardDto;

public interface ReboardDao {

	int writeArticle(ReboardDto reboardDto);
	ReboardDto getArticle(int seq); // �� �ϳ� ������ 
	List<ReboardDto> listArticle(Map<String, String> map); // ����Ʈ => ���ڰ��� �������ε� Dto�� ���� ���� �� Map���� ����
	int replyArticle(ReboardDto reboardDto); // ���
	
	int modifyArticle(ReboardDto reboardDto); // ����
	int deleteArticle(int seq); // �����
	
}
