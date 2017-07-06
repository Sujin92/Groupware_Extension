package com.moaware.factory;

import com.moaware.action.Action;
import com.moaware.admin.cominfo.action.*;

public class CominfoFactory {
	private static Action holdListAction;
	private static Action retireListAction;
	private static Action holdMoveModifyAction;
	private static Action holdModifyAction;
	private static Action deptListAction;
	private static Action deptRegisterAction;
	private static Action deptModifyAction;
	private static Action deptDeleteAction;
	private static Action deptGetInfoModifyAction;

	static {
		holdListAction = new HoldListAction();
		retireListAction = new RetireListAction();
		holdMoveModifyAction = new HoldMoveModifyAction();
		holdModifyAction = new HoldModifyAction();
		deptListAction = new DeptListAction();
		deptRegisterAction = new DetpRegisterAction();
		deptModifyAction = new DeptModifyAction();
		deptDeleteAction = new DetpDeleteAction();
		deptGetInfoModifyAction = new DeptGetInfoModifyAction();
	}

	public static Action getHoldListAction() {
		return holdListAction;
	}

	public static Action getRetireListAction() {
		return retireListAction;
	}

	public static Action getHoldMoveModifyAction() {
		return holdMoveModifyAction;
	}

	public static Action getHoldModifyAction() {
		return holdModifyAction;
	}

	public static Action getDeptListAction() {
		return deptListAction;
	}

	public static Action getDeptRegisterAction() {
		return deptRegisterAction;
	}

	public static Action getDeptModifyAction() {
		return deptModifyAction;
	}

	public static Action getDeptDeleteAction() {
		return deptDeleteAction;
	}

	public static Action getDeptGetInfoModifyAction() {
		return deptGetInfoModifyAction;
	}
	
}
