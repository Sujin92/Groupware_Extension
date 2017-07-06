package com.moaware.login.service;

import com.moaware.member.model.MemberDto;

public interface LoginService {
	MemberDto login(String id, String pass);
}
