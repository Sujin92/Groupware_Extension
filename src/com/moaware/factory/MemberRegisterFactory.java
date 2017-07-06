package com.moaware.factory;

import com.moaware.action.Action;
import com.moaware.admin.member.action.*;

public class MemberRegisterFactory {
	private static Action IdCheckAction;
	private static Action memberRegisterAction;
	private static Action deptCheckAction;
	private static Action positionCheckAction;

	static {
		IdCheckAction = new IdCheckAction();
		memberRegisterAction = new MemberRegisterAction();
		deptCheckAction = new DeptCheckAction();
		positionCheckAction = new PositionCheckAction();
	}

	public static Action getIdCheckAction() {
		return IdCheckAction;
	}

	public static Action getMemberRegisterAction() {
		return memberRegisterAction;
	}

	public static Action getDeptCheckAction() {
		return deptCheckAction;
	}

	public static Action getPositionCheckAction() {
		return positionCheckAction;
	}
}
