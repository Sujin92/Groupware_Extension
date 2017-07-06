package com.moaware.project.service;

import java.util.List;

import com.moaware.member.model.MemberDto;
import com.moaware.project.model.ProjectDto;

public interface ProjectService {

	List<ProjectDto> boardList(String dept);
	
	int createCard(ProjectDto projectDto);
	
	int modifyCard(ProjectDto projectDto);
	int deleteCard(int seq);
	
	List<MemberDto> membersearch(String dept);
}
