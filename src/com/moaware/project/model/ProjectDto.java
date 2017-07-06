package com.moaware.project.model;

public class ProjectDto {

	private String content_num; // 프로젝트 카드 번호
	private String project_content; // 프로젝트 카드 내용
	private String project_progress; // 프로젝트 진행사항(구분자)
	private String project_num; // 프로젝트 번호
	private String project_name; // 프로젝트 이름
	private String dept_num; // 부서 번호
	private String emp_num; // 사원 번호

	public String getContent_num() {
		return content_num;
	}

	public void setContent_num(String content_num) {
		this.content_num = content_num;
	}

	public String getProject_content() {
		return project_content;
	}

	public void setProject_content(String project_content) {
		this.project_content = project_content;
	}

	public String getProject_progress() {
		return project_progress;
	}

	public void setProject_progress(String project_progress) {
		this.project_progress = project_progress;
	}

	public String getProject_num() {
		return project_num;
	}

	public void setProject_num(String project_num) {
		this.project_num = project_num;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getDept_num() {
		return dept_num;
	}

	public void setDept_num(String dept_num) {
		this.dept_num = dept_num;
	}

	public String getEmp_num() {
		return emp_num;
	}

	public void setEmp_num(String emp_num) {
		this.emp_num = emp_num;
	}

}
