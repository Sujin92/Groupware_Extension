package com.moaware.org.service;

import java.util.List;

import com.moaware.org.model.KeywordDto;
import com.moaware.org.model.OrgDto;

public interface OrgSelectService {

	List<KeywordDto> orgSelectList(String keyword);

}
