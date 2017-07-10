package com.moaware.commute.dao;

import java.util.List;

import com.moaware.commute.model.CommuteDto;

public interface CommuteDao {
	List <CommuteDto> listArticle(String emp);
	int gotowork(CommuteDto commuteDto);
	int leavework(CommuteDto commuteDto);

}
