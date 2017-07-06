package com.moaware.schedule.dao;

import java.sql.Connection;

import com.moaware.project.dao.ProjectDao;
import com.moaware.project.dao.ProjectDaoImpl;
import com.moaware.schedule.model.ScheduleDto;

public class ScheduleDaoImpl implements ScheduleDao{
private static ScheduleDao scheduleDao;
	
	static{
		scheduleDao = new ScheduleDaoImpl();
	}
	
	private ScheduleDaoImpl(){};


	public static ScheduleDao getScheduleDao() {
		return scheduleDao;
	}


	@Override
	public int scheduleDto(ScheduleDto scheduleDto) {
		int test=0;
		
		return test;
	}


}
