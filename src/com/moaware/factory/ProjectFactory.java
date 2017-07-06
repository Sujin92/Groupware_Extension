package com.moaware.factory;

import com.moaware.action.Action;
import com.moaware.project.action.ProjectDeleteAction;
import com.moaware.project.action.ProjectInitAction;
import com.moaware.project.action.ProjectListAction;
import com.moaware.project.action.ProjectModifyAction;
import com.moaware.project.action.ProjectWriteAction;

public class ProjectFactory {
	private static Action projectListAction;
	private static Action projectWriteAction;
	private static Action projectModifyAction;
	private static Action projectDeleteAction;
	private static Action projectInitAction;
	

	static{
		projectListAction = new ProjectListAction();
		projectWriteAction = new ProjectWriteAction();
		projectModifyAction = new ProjectModifyAction();
		projectDeleteAction = new ProjectDeleteAction();
		projectInitAction = new ProjectInitAction();
	}

	public static Action getProjectInitAction() {
		return projectInitAction;
	}

	public static Action getProjectModifyAction() {
		return projectModifyAction;
	}

	public static Action getProjectListAction() {
		return projectListAction;
	}

	public static Action getProjectWriteAction() {
		return projectWriteAction;
	}
	public static Action getProjectDeleteAction() {
		return projectDeleteAction;
	}
}
