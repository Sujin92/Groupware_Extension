package com.moaware.mypage.service;

import com.moaware.member.model.MemberDetailDto;

public interface MyPageService {
	
	MemberDetailDto getMemberInfo(String id);
	int memberInfoModify(MemberDetailDto memberDetailDto);
}
