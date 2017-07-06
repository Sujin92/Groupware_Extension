package com.moaware.admin.cominfo.service;

import java.util.*;

import com.moaware.admin.cominfo.dao.CominfoDao;
import com.moaware.admin.cominfo.dao.CominfoDaoImpl;
import com.moaware.admin.cominfo.model.CominfoDto;
import com.moaware.admin.cominfo.util.PageNavigation;
import com.moaware.admin.member.model.DeptDto;
import com.moaware.util.Constance;

public class CominfoServiceImpl implements CominfoService {
	private static CominfoService cominfoService;
	
	static {
		cominfoService = new CominfoServiceImpl();
	}
	
	private CominfoServiceImpl() {}

	public static CominfoService getCominfoService() {
		return cominfoService;
	}

	@Override
	public List<CominfoDto> holdList(int pg) {
		int end = pg * Constance.LIST_SIZE;
		int start = end - Constance.LIST_SIZE;
		Map<String, String> map = new HashMap<String, String>();
		map.put("start", start + "");
		map.put("end", end + "");
		return CominfoDaoImpl.getCominfoDao().holdList(map);
	}

	@Override
	public List<CominfoDto> retireList(int pg) {
		int end = pg * Constance.LIST_SIZE;
		int start = end - Constance.LIST_SIZE;
		Map<String, String> map = new HashMap<String, String>();
		map.put("start", start + "");
		map.put("end", end + "");
		return CominfoDaoImpl.getCominfoDao().retireList(map);
	}
	
	@Override
	public CominfoDto getArticle(int seq) {
		return CominfoDaoImpl.getCominfoDao().getArticle(seq);
	}

	@Override
	public PageNavigation makePageNavigation(int pg, String param) {
		PageNavigation pageNavigation = new PageNavigation();
		int totalArticleCount = CominfoDaoImpl.getCominfoDao().totalArticleCount(param); //전체 게시물 수
		pageNavigation.setTotalArticleCount(totalArticleCount);
		int totalPageCount = (totalArticleCount - 1) / Constance.LIST_SIZE + 1; //전체 페이지 수
		pageNavigation.setTotalPageCount(totalPageCount);
		
		pageNavigation.setNowFirst(pg <= Constance.PAGE_SIZE);
		pageNavigation.setNowEnd((totalPageCount - 1) / Constance.PAGE_SIZE * Constance.PAGE_SIZE < pg);
		pageNavigation.setPageNo(pg);
		return pageNavigation;
	}

	@Override
	public int modify(CominfoDto cominfoDto) {
		return CominfoDaoImpl.getCominfoDao().modify(cominfoDto);
	}

	@Override
	public List<DeptDto> deptList() {
		return CominfoDaoImpl.getCominfoDao().deptList();
	}

	@Override
	public void deptRegister(String deptName) {
		CominfoDaoImpl.getCominfoDao().deptRegister(deptName);
	}

	@Override
	public void deptDelete(int check) {
		CominfoDaoImpl.getCominfoDao().deptDelete(check);
	}

	@Override
	public DeptDto getDeptInfo(String seq) {
		return CominfoDaoImpl.getCominfoDao().getDeptInfo(seq);
	}

}
