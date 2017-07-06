package com.moaware.factory;

import com.moaware.action.Action;
import com.moaware.login.action.LoginAction;

public class LoginFactory {
	private static Action loginAction;
	
	static{
		loginAction = new LoginAction();
	}

	public static Action getLoginAction() {
		return loginAction;
	}

}
