package com.moaware.org.service;

import java.util.List;

import com.moaware.org.dao.OrgInfoDaoImpl;
import com.moaware.org.model.OrgDto;



public class OrgInfoServiceImpl implements OrgInfoService {

	private static OrgInfoService orgInfoService;
	
	static {
		orgInfoService = new OrgInfoServiceImpl();
	}
	
	private OrgInfoServiceImpl() {}
	
	public static OrgInfoService getOrgInfoService() {
		return orgInfoService;
	}

	public List<OrgDto> orgInfoList() {
		return OrgInfoDaoImpl.getOrgInfoDao().orgInfoList();
	}



}
