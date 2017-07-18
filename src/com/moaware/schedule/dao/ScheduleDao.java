package com.moaware.schedule.dao;

import java.util.List;

import com.moaware.schedule.model.ScheduleDto;

public interface ScheduleDao {

	int scheduleDto(ScheduleDto scheduleDto);
	List<ScheduleDto> list(ScheduleDto scheduleDto);
	
	int scheduleDto1(ScheduleDto scheduleDto);
	int scheduleDto2(ScheduleDto scheduleDto);
}
