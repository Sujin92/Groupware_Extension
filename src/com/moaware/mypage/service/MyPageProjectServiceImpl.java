package com.moaware.mypage.service;

import java.util.List;

import com.moaware.mypage.dao.MyPageProjectDaoImpl;
import com.moaware.project.model.ProjectDto;

public class MyPageProjectServiceImpl implements MyPageProjectService {

	private static MyPageProjectService projectService;

	static {
		projectService = new MyPageProjectServiceImpl();
	}

	private MyPageProjectServiceImpl() {}

	public static MyPageProjectService getProjectService() {
		return projectService;
	}

	@Override
	public List<ProjectDto> listProject(String dept_num) {
		return MyPageProjectDaoImpl.getReboardDao().listProject(dept_num);
	}

}
