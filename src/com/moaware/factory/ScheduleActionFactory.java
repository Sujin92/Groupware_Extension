package com.moaware.factory;

import com.moaware.action.Action;
import com.moaware.mypage.action.*;
import com.moaware.schedule.action.ScheduleAction;

public class ScheduleActionFactory {

	private static Action scheduleAction;

	public static Action getScheduleAction() {
		return scheduleAction;
	}

	static {

		scheduleAction = new ScheduleAction();
	}

}
