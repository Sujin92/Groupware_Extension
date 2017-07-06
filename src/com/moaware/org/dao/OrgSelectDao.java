package com.moaware.org.dao;

import java.util.List;

import com.moaware.org.model.KeywordDto;
import com.moaware.org.model.OrgDto;

public interface OrgSelectDao {
	List<KeywordDto> orgSelectList(String keyword);
}
