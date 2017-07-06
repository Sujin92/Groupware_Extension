package com.moaware.admin.member.service;

import java.util.List;

import com.moaware.admin.member.dao.MemberRegisterDaoImpl;
import com.moaware.admin.member.model.*;
import com.moaware.member.model.MemberDetailDto;

public class MemberRegisterServiceImpl implements MemberRegisterService {
	
	private static MemberRegisterService memberRegisterService;

	static {
		memberRegisterService = new MemberRegisterServiceImpl();
	}

	private MemberRegisterServiceImpl() {}

	public static MemberRegisterService getMemberRegisterService() {
		return memberRegisterService;
	}

	@Override
	public int idCheck(String sid) {
		return MemberRegisterDaoImpl.getReboardDao().idCheck(sid);
	}
	
	@Override
	public List<DeptDto> deptSearch(String deptName) {
		return MemberRegisterDaoImpl.getReboardDao().deptSearch(deptName);
	}
	
	@Override
	public List<PositionDto> positionSearch(String positionName) {
		return MemberRegisterDaoImpl.getReboardDao().positionSearch(positionName);
	}

	@Override
	public int register(MemberDetailDto memberDetailDto) {
		return MemberRegisterDaoImpl.getReboardDao().register(memberDetailDto);
	}

}
