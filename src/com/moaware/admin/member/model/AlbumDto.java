package com.moaware.admin.member.model;

import com.moaware.admin.cominfo.model.CominfoDto;

public class AlbumDto extends CominfoDto { // ���� �Խ���
	private String orignPicture; // ���� ����
	private String savePicture; // ���� ����
	private String saveFolder; // ���� ����
	private int type; // ���� Ÿ��(����, ����)

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
