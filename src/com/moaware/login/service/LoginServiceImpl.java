package com.moaware.login.service;

import com.moaware.login.dao.LoginDaoImpl;
import com.moaware.member.model.MemberDto;

public class LoginServiceImpl implements LoginService {
	
	private static LoginService loginService;
	
	static{
		loginService = new LoginServiceImpl();
	}
	
	private LoginServiceImpl(){};

	public static LoginService getLoginService() {
		return loginService;
	}

	@Override
	public MemberDto login(String id, String pass) {
		return LoginDaoImpl.getLoginDao().login(id, pass);
	}

}
