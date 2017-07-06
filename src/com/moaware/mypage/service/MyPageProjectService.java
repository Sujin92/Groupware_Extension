package com.moaware.mypage.service;

import java.util.List;

import com.moaware.project.model.ProjectDto;

public interface MyPageProjectService {
	List<ProjectDto> listProject(String dept_num);
}
