package com.moaware.schedule.model;

public class ScheduleDto {
	private String id;
	private String startDate;
	private String endDate;
	private String title;
	private String content;
	private String freedayselector;


	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFreedayselector() {
		return freedayselector;
	}

	public void setFreedayselector(String freedayselector) {
		this.freedayselector = freedayselector;
	}



}
