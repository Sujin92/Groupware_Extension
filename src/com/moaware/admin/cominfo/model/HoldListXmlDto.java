package com.moaware.admin.cominfo.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "holdlist")
public class HoldListXmlDto {
	private boolean status;
	private List<CominfoDto> list;
	
	public boolean isStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<CominfoDto> getList() {
		return list;
	}

	@XmlElement(name = "hold")
	public void setList(List<CominfoDto> list) {
		this.list = list;
	}
}
