package com.moaware.admin.cominfo.dao;

import java.util.List;
import java.util.Map;

import com.moaware.admin.cominfo.model.CominfoDto;
import com.moaware.admin.member.model.DeptDto;

public interface CominfoDao {
	List<CominfoDto> holdList(Map<String, String> map);
	List<CominfoDto> retireList(Map<String, String> map);
	CominfoDto getArticle(int seq);
	
	int modify(CominfoDto cominfoDto);
	
	int totalArticleCount(String param);
	
	List<DeptDto> deptList();
	void deptRegister(String deptName);
	DeptDto getDeptInfo(String seq);
	
	void deptDelete(int check);
}
