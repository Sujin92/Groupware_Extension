package com.moaware.admin.support.dao;

import java.util.List;
import java.util.Map;

import com.moaware.admin.cominfo.model.CominfoDto;
import com.moaware.admin.support.model.ScheduleDto;
import com.moaware.approval.model.ApprovalDto;

public interface ApprovalManageDao {
	List<CominfoDto> memberList(Map<String, String> map);
	List<ApprovalDto> docList(String emp_num, Map<String, String> map);
	List<ScheduleDto> scheduleList(String emp_num, Map<String, String> map);
	void scheduleAdd(ScheduleDto scheduleDto);
	void scheduleModify(ScheduleDto scheduleDto);
	void scheduleDelete(int check);
	int totalArticleCount(String param);
	int docTotalArticleCount(String emp_num);
	int scheduleTotalArticleCount(String emp_num);
}
