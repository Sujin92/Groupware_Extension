package com.moaware.schedule.model;

import java.util.Date;

public class ScheduleDto {
	private String id;
	private String daytDate;

	public String getDaytDate() {
		return daytDate;
	}

	public void setDaytDate(String daytDate) {
		this.daytDate = daytDate;
	}

	private String title;
	private String content;
	private String freedayselector;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setFreedayselector(String string) {
		this.freedayselector = string;
	}

}
