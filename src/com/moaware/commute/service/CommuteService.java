package com.moaware.commute.service;

import java.util.List;

import com.moaware.commute.model.CommuteDto;

public interface CommuteService {
	List <CommuteDto> listArticle(String emp);
	int gotowork(CommuteDto commuteDto);
	int leavework(CommuteDto commuteDto);
}
