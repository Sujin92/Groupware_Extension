package com.moaware.admin.support.service;

import java.util.List;

import com.moaware.admin.cominfo.model.CominfoDto;
import com.moaware.admin.cominfo.util.PageNavigation;
import com.moaware.admin.support.model.ScheduleDto;
import com.moaware.approval.model.ApprovalDto;

public interface ApprovalManageService {
	List<CominfoDto> memberList(int pg);
	List<ApprovalDto> docList(int pg, String emp_num);
	List<ScheduleDto> scheduleList(int pg, String emp_num);
	void scheduleAdd(ScheduleDto scheduleDto);
	void scheduleModify(ScheduleDto scheduleDto);
	void scheduleDelete(int check);
	PageNavigation makePageNavigation(int pg, String param);
	PageNavigation docMakePageNavigation(int pg, String emp_num);
	PageNavigation scheduleMakePageNavigation(int pg, String emp_num);
}
