package com.moaware.factory;

import com.moaware.action.Action;
import com.moaware.mypage.action.*;

public class MyPageFactory {
	private static Action myPageListAction;
	private static Action myPageMoveModifyAction;
	private static Action myPageModifyAction;
	private static Action projectAction;

	static {
		myPageListAction = new MyPageListAction();
		myPageMoveModifyAction = new MyPageMoveModifyAction();
		myPageModifyAction = new MyPageModifyAction();
		projectAction = new MyPageProjectAction();
	}

	public static Action getMyPageListAction() {
		return myPageListAction;
	}

	public static Action getMyPageMoveModifyAction() {
		return myPageMoveModifyAction;
	}

	public static Action getMyPageModifyAction() {
		return myPageModifyAction;
	}

	public static Action getProjectAction() {
		return projectAction;
	}
}
