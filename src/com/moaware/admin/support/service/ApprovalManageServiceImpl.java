package com.moaware.admin.support.service;

import java.util.*;

import com.moaware.admin.cominfo.model.CominfoDto;
import com.moaware.admin.cominfo.util.PageNavigation;
import com.moaware.admin.support.dao.ApprovalManageDaoImpl;
import com.moaware.admin.support.model.ScheduleDto;
import com.moaware.approval.model.ApprovalDto;
import com.moaware.util.Constance;

public class ApprovalManageServiceImpl implements ApprovalManageService {
	
	private static ApprovalManageService approvalManageService;
	
	static {
		approvalManageService = new ApprovalManageServiceImpl();
	}
	
	private ApprovalManageServiceImpl() {}

	public static ApprovalManageService getApprovalManageService() {
		return approvalManageService;
	}

	@Override
	public List<CominfoDto> memberList(int pg) {
		int end = pg * Constance.LIST_SIZE;
		int start = end - Constance.LIST_SIZE;
		Map<String, String> map = new HashMap<String, String>();
		map.put("start", start + "");
		map.put("end", end + "");
		return ApprovalManageDaoImpl.getApprovalManageService().memberList(map);
	}
	
	@Override
	public List<ApprovalDto> docList(int pg, String emp_num) {
		int end = pg * Constance.LIST_SIZE;
		int start = end - Constance.LIST_SIZE;
		Map<String, String> map = new HashMap<String, String>();
		map.put("start", start + "");
		map.put("end", end + "");
		return ApprovalManageDaoImpl.getApprovalManageService().docList(emp_num, map);
	}

	@Override
	public List<ScheduleDto> scheduleList(int pg, String emp_num) {
		int end = pg * Constance.LIST_SIZE;
		int start = end - Constance.LIST_SIZE;
		Map<String, String> map = new HashMap<String, String>();
		map.put("start", start + "");
		map.put("end", end + "");
		return ApprovalManageDaoImpl.getApprovalManageService().scheduleList(emp_num, map);
	}

	@Override
	public PageNavigation makePageNavigation(int pg, String param) {
		PageNavigation pageNavigation = new PageNavigation();
		int totalArticleCount = ApprovalManageDaoImpl.getApprovalManageService().totalArticleCount(param);
		pageNavigation.setTotalArticleCount(totalArticleCount);
		int totalPageCount = (totalArticleCount - 1) / Constance.LIST_SIZE + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		
		pageNavigation.setNowFirst(pg <= Constance.PAGE_SIZE);
		pageNavigation.setNowEnd((totalPageCount - 1) / Constance.PAGE_SIZE * Constance.PAGE_SIZE < pg);
		pageNavigation.setPageNo(pg);
		return pageNavigation;
	}

	@Override
	public PageNavigation docMakePageNavigation(int pg, String emp_num) {
		PageNavigation pageNavigation = new PageNavigation();
		int totalArticleCount = ApprovalManageDaoImpl.getApprovalManageService().docTotalArticleCount(emp_num);
		pageNavigation.setTotalArticleCount(totalArticleCount);
		int totalPageCount = (totalArticleCount - 1) / Constance.LIST_SIZE + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		
		pageNavigation.setNowFirst(pg <= Constance.PAGE_SIZE);
		pageNavigation.setNowEnd((totalPageCount - 1) / Constance.PAGE_SIZE * Constance.PAGE_SIZE < pg);
		pageNavigation.setPageNo(pg);
		return pageNavigation;
	}

	@Override
	public PageNavigation scheduleMakePageNavigation(int pg, String emp_num) {
		PageNavigation pageNavigation = new PageNavigation();
		int totalArticleCount = ApprovalManageDaoImpl.getApprovalManageService().scheduleTotalArticleCount(emp_num);
		pageNavigation.setTotalArticleCount(totalArticleCount);
		int totalPageCount = (totalArticleCount - 1) / Constance.LIST_SIZE + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		
		pageNavigation.setNowFirst(pg <= Constance.PAGE_SIZE);
		pageNavigation.setNowEnd((totalPageCount - 1) / Constance.PAGE_SIZE * Constance.PAGE_SIZE < pg);
		pageNavigation.setPageNo(pg);
		return pageNavigation;
	}

	@Override
	public void scheduleAdd(ScheduleDto scheduleDto) {
		ApprovalManageDaoImpl.getApprovalManageService().scheduleAdd(scheduleDto);
	}

	@Override
	public void scheduleModify(ScheduleDto scheduleDto) {
		ApprovalManageDaoImpl.getApprovalManageService().scheduleModify(scheduleDto);
	}

	@Override
	public void scheduleDelete(int check) {
		ApprovalManageDaoImpl.getApprovalManageService().scheduleDelete(check);
	}

}
