package com.moaware.org.service;

import java.util.List;

import com.moaware.org.dao.OrgChartDaoImpl;
import com.moaware.org.model.OrgDto;



public class OrgChartServiceImpl implements OrgChartService {

	private static OrgChartService orgChartService;
	
	static {
		orgChartService = new OrgChartServiceImpl();
	}
	

	public static OrgChartService getOrgChartService() {
		return orgChartService;
	}


	@Override
	public List<OrgDto> orgChartList() {
		return OrgChartDaoImpl.getOrgChartDao().orgChartList();
	}



}
