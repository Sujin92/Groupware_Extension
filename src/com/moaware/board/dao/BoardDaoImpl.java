package com.moaware.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.moaware.board.model.BoardDto;
import com.moaware.board.service.BoardService;
import com.moaware.board.service.BoardServiceImpl;
import com.moaware.util.db.DBClose;
import com.moaware.util.db.DBConnection;

public class BoardDaoImpl implements BoardDao {

	private static BoardDao boardDaoImpl;
	
	static{
		boardDaoImpl = new BoardDaoImpl();
	}
	
	private BoardDaoImpl(){}
	
	public static BoardDao getBoardDaoImpl() {
		return boardDaoImpl;
	}

	@Override
	public List<BoardDto> listArticle(Map<String, String> map) {
		List<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("	select a.* \n");
			sql.append("	from( \n");
			sql.append("        select RANK() OVER(ORDER BY seq DESC ) rank, \n");
			sql.append("				                seq, emp_num, name , subject, content, hit,\n");
			sql.append("				                case when trunc(logtime, 'dd')=trunc(sysdate, 'dd') \n");
			sql.append("                       then to_char(logtime, 'hh24:mi:ss') \n");
			sql.append("                       else to_char(logtime, 'yy.mm.dd') \n");
			sql.append("               end as logtime \n");
			sql.append("        from noticeboard");
			String key = map.get("key");
			String word = map.get("word");
			if(!key.isEmpty() && !word.isEmpty()){
				//제목 >> like 검색, 글쓴이 - 글번호 >> = (equal) 검색
				if(key.equals("subject"))
					sql.append("		where subject like '%'||?||'%' \n");
			
				else
					sql.append("		where "+ key + " = ? \n");
			}
			sql.append("		)a \n");
			sql.append("	where a.rank > ? and a.rank <= ?");
			pstmt = conn.prepareStatement(sql.toString());
			int idx=0;
			if(!key.isEmpty() && !word.isEmpty())
				pstmt.setString(++idx, word);
			pstmt.setString(++idx, map.get("start"));
			pstmt.setString(++idx, map.get("end"));
			rs = pstmt.executeQuery();
			while(rs.next()){
				BoardDto boardDto = new BoardDto();
				boardDto.setSeq(rs.getInt("seq"));
				boardDto.setEmp_num(rs.getString("emp_num"));
				boardDto.setName(rs.getString("name"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setLogtime(rs.getString("logtime"));
				list.add(boardDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int writeArticle(BoardDto boardDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert \n");
			sql.append("	into noticeboard (seq, emp_num, name, subject, content, hit, logtime) \n");
			sql.append("	values(?, ?, ?, ?, ?, 0, sysdate) \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setInt(++idx, boardDto.getSeq());
			pstmt.setString(++idx, boardDto.getEmp_num());
			pstmt.setString(++idx, boardDto.getName());
			pstmt.setString(++idx, boardDto.getSubject());
			pstmt.setString(++idx, boardDto.getContent());
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public BoardDto getArticle(int seq) {
		BoardDto boardDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select seq, emp_num, name, subject, \n");
			sql.append("		content, hit, logtime \n");
			sql.append("from noticeboard \n");
			sql.append("where seq = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardDto = new BoardDto();
				boardDto.setSeq(rs.getInt("seq"));
				boardDto.setEmp_num(rs.getString("emp_num"));
				boardDto.setName(rs.getString("name"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setLogtime(rs.getString("logtime"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return boardDto;
	}

	@Override
	public int modifyArticle(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();

			sql.append("update noticeboard set subject =?, content =? \n");
			sql.append("where seq = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, boardDto.getSubject());
			pstmt.setString(2, boardDto.getContent());
			pstmt.setInt(3, boardDto.getSeq());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public int deleteArticle(int seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer board_sql = new StringBuffer();
			board_sql.append("delete noticeboard where seq = ?");
			pstmt = conn.prepareStatement(board_sql.toString());
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
			cnt = 1;
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		} finally {
			DBClose.close(conn, pstmt);
		}

		return cnt;
	}

}
