package com.moaware.factory;

import com.moaware.action.Action;

import com.moaware.groupboard.action.GroupBoardDeleteAction;
import com.moaware.groupboard.action.GroupBoardListAction;
import com.moaware.groupboard.action.GroupBoardModifyAction;
import com.moaware.groupboard.action.GroupBoardMoveModifyAction;
import com.moaware.groupboard.action.GroupBoardViewAction;
import com.moaware.groupboard.action.GroupBoardWriteAction;

public class GroupBoardActionFactory {

	private static Action groupBoardListAction;
	private static Action groupBoardWriteAction;
	private static Action groupBoardViewAction;
	private static Action groupBoardModifyAction;
	private static Action groupBoardDeleteAction;
	private static Action groupBoardMoveModifyAction;
	
	static{
		groupBoardListAction = new GroupBoardListAction();
		groupBoardWriteAction = new GroupBoardWriteAction();
		groupBoardViewAction = new GroupBoardViewAction();
		groupBoardModifyAction = new GroupBoardModifyAction();
		groupBoardDeleteAction = new GroupBoardDeleteAction();
		groupBoardMoveModifyAction = new GroupBoardMoveModifyAction();
	}

	public static Action getGroupBoardListAction() {
		return groupBoardListAction;
	}

	public static Action getGroupBoardWriteAction() {
		return groupBoardWriteAction;
	}

	public static Action getGroupBoardViewAction() {
		return groupBoardViewAction;
	}

	public static Action getGroupBoardModifyAction() {
		return groupBoardModifyAction;
	}

	public static Action getGroupBoardDeleteAction() {
		return groupBoardDeleteAction;
	}

	public static Action getGroupBoardMoveModifyAction() {
		return groupBoardMoveModifyAction;
	}
}
