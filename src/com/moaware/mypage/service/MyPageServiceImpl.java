package com.moaware.mypage.service;

import com.moaware.member.model.MemberDetailDto;
import com.moaware.mypage.dao.MyPageDaoImpl;

public class MyPageServiceImpl implements MyPageService{
	
	private static MyPageService myPageServiceImpl;
	
	static {
		myPageServiceImpl = new MyPageServiceImpl();
	}
	
	private MyPageServiceImpl(){}
	
	public static MyPageService getMyPageServiceImpl() {
		return myPageServiceImpl;
	}
	
	@Override
	public MemberDetailDto getMemberInfo(String id) {
		return MyPageDaoImpl.getMyPageDao().getMemberInfo(id);
	}

	@Override
	public int memberInfoModify(MemberDetailDto memberDetailDto) {
		return MyPageDaoImpl.getMyPageDao().memberInfoModify(memberDetailDto);
	}
	
	
	
}
