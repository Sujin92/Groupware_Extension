package com.moaware.board.service;

import com.moaware.util.PageNavigation;

public interface CommonService {
	int getNextSeq(int bcode);
	PageNavigation makePageNavigation(int bcode, int pg, String key, String word, int listSize);
}
