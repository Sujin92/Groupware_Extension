package com.moaware.board.dao;

import java.util.Map;

public interface CommonDao {

	int getNextSeq(int bcode);
	void updateHit(int seq, int bcode);
	int newArticleCount(int bcode);
	int totalArticleCount(Map<String, String> map);
	
}
