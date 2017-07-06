package com.moaware.mypage.dao;

import java.util.List;

import com.moaware.project.model.ProjectDto;

public interface MyPageProjectDao {
	List<ProjectDto> listProject(String id);
}
