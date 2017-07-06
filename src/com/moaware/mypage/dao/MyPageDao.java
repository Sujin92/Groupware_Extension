package com.moaware.mypage.dao;

import com.moaware.member.model.MemberDetailDto;

public interface MyPageDao {
	
	MemberDetailDto getMemberInfo(String id);
	int memberInfoModify(MemberDetailDto memberDetailDto);
}
