package com.moaware.admin.member.dao;

import java.util.List;

import com.moaware.admin.member.model.*;
import com.moaware.member.model.MemberDetailDto;

public interface MemberRegisterDao {
	int idCheck(String sid);
	List<DeptDto> deptSearch(String deptName);
	List<PositionDto> positionSearch(String positionName);
	int register(MemberDetailDto memberDetailDto);
}
