package com.moaware.admin.cominfo.service;

import java.util.List;

import com.moaware.admin.cominfo.model.CominfoDto;
import com.moaware.admin.cominfo.util.PageNavigation;
import com.moaware.admin.member.model.DeptDto;

public interface CominfoService {
	List<CominfoDto> holdList(int pg);
	List<CominfoDto> retireList(int pg);
	CominfoDto getArticle(int seq);
	
	int modify(CominfoDto cominfoDto);
	
	PageNavigation makePageNavigation(int pg, String param);
	
	List<DeptDto> deptList();
	void deptRegister(String deptName);
	DeptDto getDeptInfo(String seq);
	void deptModify(DeptDto deptDto);
	void deptDelete(int check);
}
