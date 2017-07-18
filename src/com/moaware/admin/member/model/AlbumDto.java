package com.moaware.admin.member.model;

import com.moaware.admin.cominfo.model.CominfoDto;

public class AlbumDto extends CominfoDto { // 사진 게시판
	private String orignPicture; // 원본 사진
	private String savePicture; // 저장 사진
	private String saveFolder; // 저장 폴더
	private int type; // 사진 타입(가로, 세로)

	public String getOrignPicture() {
		return orignPicture;
	}

	public void setOrignPicture(String orignPicture) {
		this.orignPicture = orignPicture;
	}

	public String getSavePicture() {
		return savePicture;
	}

	public void setSavePicture(String savePicture) {
		this.savePicture = savePicture;
	}

	public String getSaveFolder() {
		return saveFolder;
	}

	public void setSaveFolder(String saveFolder) {
		this.saveFolder = saveFolder;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
