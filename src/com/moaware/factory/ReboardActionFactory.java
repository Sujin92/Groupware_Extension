package com.moaware.factory;

import com.moaware.action.Action;
import com.moaware.reboard.action.ReboardDeleteAction;
import com.moaware.reboard.action.ReboardListAction;
import com.moaware.reboard.action.ReboardModifyAction;
import com.moaware.reboard.action.ReboardMoveModifyAction;
import com.moaware.reboard.action.ReboardMoveReplyAction;
import com.moaware.reboard.action.ReboardReplyAction;
import com.moaware.reboard.action.ReboardViewAction;
import com.moaware.reboard.action.ReboardWriteAction;

public class ReboardActionFactory {

	private static Action reboardListAction;
	private static Action reboardWriteAction;
	private static Action reboardViewAction;
	private static Action reboardModifyAction;
	private static Action reboardDeleteAction;
	private static Action reboardMoveModifyAction;
	private static Action reboardReplyAction;
	private static Action reboardMoveReplyAction;
	
	static{
		reboardListAction = new ReboardListAction();
		reboardWriteAction = new ReboardWriteAction();
		reboardViewAction = new ReboardViewAction();
		reboardModifyAction = new ReboardModifyAction();
		reboardDeleteAction = new ReboardDeleteAction();
		reboardMoveModifyAction = new ReboardMoveModifyAction();
		reboardMoveReplyAction =  new ReboardMoveReplyAction();
		reboardReplyAction = new ReboardReplyAction();
	}

	public static Action getReboardListAction() {
		return reboardListAction;
	}

	public static Action getReboardWriteAction() {
		return reboardWriteAction;
	}

	public static Action getReboardViewAction() {
		return reboardViewAction;
	}

	public static Action getReboardModifyAction() {
		return reboardModifyAction;
	}

	public static Action getReboardDeleteAction() {
		return reboardDeleteAction;
	}

	public static Action getReboardMoveModifyAction() {
		return reboardMoveModifyAction;
	}

	public static Action getReboardReplyAction() {
		return reboardReplyAction;
	}

	public static Action getReboardMoveReplyAction() {
		return reboardMoveReplyAction;
	}

}

