package com.moaware.factory;

import com.moaware.action.Action;
import com.moaware.org.action.*;
import com.moaware.org.service.OrgSelectServiceImpl;

public class OrgFactory {
	
	//
	
	private static Action orgSelectAction;
	private static Action orgInfoAction;
	private static Action orgChartAction;
	private static Action orgSelectDeptAction;
	

	static {

		orgSelectAction = new OrgSelectAction();
		orgInfoAction = new OrgInfoAction();
		orgChartAction = new OrgChartAction();
		orgSelectDeptAction = new OrgSelectDeptAction();
		

	}

	public static Action getOrgSelectAction() {
		return orgSelectAction;
	}

	public static Action getOrgInfoAction() {
		return orgInfoAction;
	}

	public static Action getOrgChartAction() {
		return orgChartAction;
	}

	public static Action getOrgSelectDeptAction() {
		return orgSelectDeptAction;
	}

}
