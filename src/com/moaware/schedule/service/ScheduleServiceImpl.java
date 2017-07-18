package com.moaware.schedule.service;

import java.util.List;

import com.moaware.schedule.dao.ScheduleDaoImpl;
import com.moaware.schedule.model.ScheduleDto;

public class ScheduleServiceImpl implements ScheduleService {
	private static ScheduleService scheduleService;

	static {
		scheduleService = new ScheduleServiceImpl();
	}

	private ScheduleServiceImpl() {
	};

	public static ScheduleService getScheduleService() {
		return scheduleService;
	}

	@Override
	public int scheduleDto(ScheduleDto scheduleDto) {
		return ScheduleDaoImpl.getScheduleDao().scheduleDto(scheduleDto);
	}

	@Override
	public List<ScheduleDto> list(ScheduleDto scheduleDto) {

		return ScheduleDaoImpl.getScheduleDao().list(scheduleDto);
	}

	@Override
	public int scheduleDto1(ScheduleDto scheduleDto) {

		return ScheduleDaoImpl.getScheduleDao().scheduleDto1(scheduleDto);
	}

	@Override
	public int scheduleDto2(ScheduleDto scheduleDto) {
		return ScheduleDaoImpl.getScheduleDao().scheduleDto2(scheduleDto);
	}

}
