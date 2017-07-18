package com.moaware.factory;

import com.moaware.action.Action;
import com.moaware.schedule.action.*;

public class ScheduleActionFactory {

	private static Action scheduleAction;
	private static Action scheduleWriteAction;
	private static Action scheduleDeleteAction;
	private static Action scheduleUpdateAction;

	static {

		scheduleAction = new ScheduleAction();
		scheduleWriteAction = new ScheduleWriteAction();
		scheduleDeleteAction = new ScheduleDeleteAction();
		scheduleUpdateAction = new ScheduleUpdateAction();
	}

	public static Action getScheduleDeleteAction() {
		return scheduleDeleteAction;
	}

	public static Action getScheduleAction() {
		return scheduleAction;
	}

	public static Action getScheduleWriteAction() {
		return scheduleWriteAction;
	}

	public static Action getScheduleUpdateAction() {
		return scheduleUpdateAction;
	}

}
