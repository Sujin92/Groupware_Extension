package com.moaware.board.service;

import java.util.HashMap;
import java.util.Map;

import com.moaware.board.dao.CommonDaoImpl;
import com.moaware.util.BoardConstance;
import com.moaware.util.PageNavigation;

public class CommonServiceImpl implements CommonService {
		
		private static CommonService CommonService;
		
		static {
			CommonService = new CommonServiceImpl();
		}
		
		private CommonServiceImpl() {}
		
		public static CommonService getCommonService() {
			return CommonService;
		}

		@Override
		public int getNextSeq(int bcode) {
			return CommonDaoImpl.getCommonDao().getNextSeq(bcode);
		}

		@Override
		public PageNavigation makePageNavigation(int bcode, int pg, String key, String word, int listSize) {
			PageNavigation pageNavigation = new PageNavigation();
			int newArticleCount = CommonDaoImpl.getCommonDao().newArticleCount(bcode);
			pageNavigation.setNewArticleCount(newArticleCount);
			Map<String, String> map = new HashMap<String, String>();
			map.put("bcode", bcode + "");
			map.put("key", key);
			map.put("word", word);
			int totalArticleCount = CommonDaoImpl.getCommonDao().totalArticleCount(map);
			pageNavigation.setTotalArticleCount(totalArticleCount);
			int totalPageCount = (totalArticleCount - 1) / listSize + 1;
			pageNavigation.setTotalPageCount(totalPageCount);
			pageNavigation.setNowFirst(pg <= BoardConstance.PAGE_SIZE);
			pageNavigation.setNowEnd((totalPageCount - 1) / BoardConstance.PAGE_SIZE * BoardConstance.PAGE_SIZE < pg);
			pageNavigation.setPageNo(pg);		
			return pageNavigation;
		}
}
