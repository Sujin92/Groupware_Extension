package com.moaware.schedule.service;

import java.util.List;

import com.moaware.schedule.dao.ScheduleDaoImpl;
import com.moaware.schedule.model.ScheduleDto;

public class ScheduleServiceImpl implements ScheduleService{
private static ScheduleService scheduleService;
	
	static{
		scheduleService = new ScheduleServiceImpl();
	}
	
	private ScheduleServiceImpl(){};
	

	public static ScheduleService getScheduleService() {
		return scheduleService;
	}

	@Override
	public int scheduleDto(ScheduleDto scheduleDto) {
		// TODO Auto-generated method stub
		return ScheduleDaoImpl.getScheduleDao().scheduleDto(scheduleDto);
	}

}
