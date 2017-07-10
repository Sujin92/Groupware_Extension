package com.moaware.factory;

import com.moaware.action.Action;
import com.moaware.commute.action.CommuteGotoAction;
import com.moaware.commute.action.CommuteLeaveAction;
import com.moaware.commute.action.CommuteListAction;

public class CommuteFactory {
	private static Action commuteGotoAction;
	private static Action commuteListAction;
	private static Action commuteLeaveAction;

	static {
		commuteGotoAction = new CommuteGotoAction();
		commuteListAction = new CommuteListAction();
		commuteLeaveAction = new CommuteLeaveAction();

	}

	public static Action getCommuteLeaveAction() {
		return commuteLeaveAction;
	}

	public static Action getCommuteListAction() {
		return commuteListAction;
	}

	public static Action getCommuteGotoAction() {
		return commuteGotoAction;
	}

}
