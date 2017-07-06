package com.moaware.login.dao;

import java.util.Map;

import com.moaware.member.model.MemberDto;

public interface LoginDao {

	MemberDto login(String id, String pass); 
}
