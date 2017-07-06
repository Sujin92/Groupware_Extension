package com.moaware.factory;

import com.moaware.action.Action;
import com.moaware.board.action.BoardDeleteAction;
import com.moaware.board.action.BoardListAction;
import com.moaware.board.action.BoardModifyAction;
import com.moaware.board.action.BoardMoveModifyAction;
import com.moaware.board.action.BoardViewAction;
import com.moaware.board.action.BoardWriteAction;

public class BoardActionFactory  {
	
	private static Action boardListAction;
	private static Action boardWriteAction;
	private static Action boardViewAction;
	private static Action boardModifyAction;
	private static Action boardDeleteAction;
	private static Action boardMoveModifyAction;
	
	static{
		boardListAction = new BoardListAction();
		boardWriteAction = new BoardWriteAction();
		boardViewAction = new BoardViewAction();
		boardModifyAction = new BoardModifyAction();
		boardDeleteAction = new BoardDeleteAction();
		boardMoveModifyAction = new BoardMoveModifyAction();
	}

	public static Action getBoardModifyAction() {
		return boardModifyAction;
	}

	public static Action getBoardDeleteAction() {
		return boardDeleteAction;
	}

	public static Action getBoardMoveModifyAction() {
		return boardMoveModifyAction;
	}

	public static Action getBoardViewAction() {
		return boardViewAction;
	}

	public static Action getBoardWriteAction() {
		return boardWriteAction;
	}

	public static Action getBoardListAction() {
		return boardListAction;
	}
}
