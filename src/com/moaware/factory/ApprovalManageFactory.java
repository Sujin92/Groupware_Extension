package com.moaware.factory;

import com.moaware.action.Action;
import com.moaware.admin.support.action.*;

public class ApprovalManageFactory {
	private static Action memberListAction;
	private static Action docListAction;
	private static Action scheduleListAction;
	private static Action scheduleAddAction;
	private static Action scheduleModifyAction;
	private static Action scheduleDeleteAction;

	static {
		memberListAction = new MemberListAction();
		docListAction = new DocListAction();
		scheduleListAction = new ScheduleListAction();
		scheduleAddAction = new ScheduleAddAction();
		scheduleModifyAction = new ScheduleModifyAction();
		scheduleDeleteAction = new ScheduleDeleteAction();
	}

	public static Action getMemberListAction() {
		return memberListAction;
	}

	public static Action getDocListAction() {
		return docListAction;
	}

	public static Action getScheduleListAction() {
		return scheduleListAction;
	}

	public static Action getScheduleAddAction() {
		return scheduleAddAction;
	}

	public static Action getScheduleModifyAction() {
		return scheduleModifyAction;
	}

	public static Action getScheduleDeleteAction() {
		return scheduleDeleteAction;
	}
	
}
