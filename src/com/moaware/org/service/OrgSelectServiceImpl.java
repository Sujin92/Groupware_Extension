package com.moaware.org.service;

import java.util.List;

import com.moaware.org.dao.OrgSelectDaoImpl;
import com.moaware.org.model.KeywordDto;



public class OrgSelectServiceImpl implements OrgSelectService {

	private static OrgSelectService orgSelectService;
	
	static {
		orgSelectService = new OrgSelectServiceImpl();
	}
	
	private OrgSelectServiceImpl() {}
	
	public static OrgSelectService getOrgSelectService(String keyword) {
		return orgSelectService;
	}
	
	@Override
	public List<KeywordDto> orgSelectList(String keyword) {
		return OrgSelectDaoImpl.getOrgSelectDao().orgSelectList(keyword);
	}



}
