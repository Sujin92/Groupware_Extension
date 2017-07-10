package com.moaware.commute.service;

import java.util.List;

import com.moaware.commute.dao.CommuteDaoImpl;
import com.moaware.commute.model.CommuteDto;

public class CommuteServiceImpl implements CommuteService {

	private static CommuteService commuteServiceImpl;

	static {
		commuteServiceImpl = new CommuteServiceImpl();
	}

	private CommuteServiceImpl() {
	}

	public static CommuteService getCommuteServiceImpl() {
		return commuteServiceImpl;
	}

	@Override
	public int gotowork(CommuteDto commuteDto) {
		return CommuteDaoImpl.getCommuteDaoImpl().gotowork(commuteDto);
	}

	@Override
	public List<CommuteDto> listArticle(String emp) {
		return CommuteDaoImpl.getCommuteDaoImpl().listArticle(emp);
	}

	@Override
	public int leavework(CommuteDto commuteDto) {
		return CommuteDaoImpl.getCommuteDaoImpl().leavework(commuteDto);
	}

}
