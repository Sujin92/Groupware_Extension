package com.moaware.board.model;

public class ReboardDto extends BoardDto{

	private int rseq;
	private int ref; // 그룹 번호
	private int lev; // 들여쓰기 (뎁스라고 생각하면 됨)
	private int step;// 답변 정렬순서
	private int pseq;// 원글 번호 => 
	private int reply;//답변 갯수 - 답변 갯수에 따라서 글을 지울 수 있는지 없는지 판단 ( 답변 갯수 없으면 지워도 상관 무 )

	public int getRseq() {
		return rseq;
	}

	public void setRseq(int rseq) {
		this.rseq = rseq;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getLev() {
		return lev;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getPseq() {
		return pseq;
	}

	public void setPseq(int pseq) {
		this.pseq = pseq;
	}

	public int getReply() {
		return reply;
	}

	public void setReply(int reply) {
		this.reply = reply;
	}
	
}
