package com.moaware.project.service;

import java.util.List;

import com.moaware.member.model.MemberDto;
import com.moaware.project.dao.ProjectDaoImpl;
import com.moaware.project.model.ProjectDto;

public class ProjectServiceImpl implements ProjectService {
	
	private static ProjectService projectService;
	
	static{
		projectService = new ProjectServiceImpl();
	}
	
	private ProjectServiceImpl(){};
	

	public static ProjectService getProjectService() {
		return projectService;
	}


	@Override
	public List<ProjectDto> boardList(String dept) {
		return ProjectDaoImpl.getProjectDao().boardList(dept);
	}


	@Override
	public int createCard(ProjectDto projectDto) {
		return ProjectDaoImpl.getProjectDao().createCard(projectDto);
		
	}


	@Override
	public int modifyCard(ProjectDto projectDto) {
		return ProjectDaoImpl.getProjectDao().modifyCard(projectDto);
	}


	@Override
	public int deleteCard(int seq) {
		return ProjectDaoImpl.getProjectDao().deleteCard(seq);
	}


	@Override
	public List<MemberDto> membersearch(String dept) {
		return ProjectDaoImpl.getProjectDao().membersearch(dept);
	}

}
