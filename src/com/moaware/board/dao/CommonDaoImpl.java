package com.moaware.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.moaware.util.db.DBClose;
import com.moaware.util.db.DBConnection;

public class CommonDaoImpl implements CommonDao {

	private static CommonDao commonDao;
	
	static {
		commonDao = new CommonDaoImpl();
	}
	
	private CommonDaoImpl() {}
	
	public static CommonDao getCommonDao() {
		return commonDao;
	}

	
	@Override
	public int getNextSeq(int bcode) {
		int seq = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = null;
			if(bcode==0){
				sql = "select board_num_seq.nextval from dual";
				}
			else if(bcode==1){
				sql = "select board_num1_seq.nextval from dual";
				}
			else if(bcode==2){
				sql = "select board_num2_seq.nextval from dual";
				}
			else if(bcode==3){
				sql = "select board_num3_seq.nextval from dual";
				}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			seq = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return seq;
	}

	@Override
	public void updateHit(int seq, int bcode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			String sql = null;
			if(bcode==0){
				sql = "update noticeboard set hit = hit + 1 where seq = ?";
				System.out.println("0");
				}
			else if(bcode==1){
				sql = "update board set hit = hit + 1 where seq = ?";
				System.out.println("1");
				}
			else if(bcode==2){
				sql = "update departboard set hit = hit + 1 where seq = ?";
				}
			else if(bcode==3){
				sql = "update faqboard set hit = hit + 1 where seq = ?";
				}
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			int cnt=pstmt.executeUpdate();
			System.out.println(cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}

	}

	@Override
	public int newArticleCount(int bcode) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			if(bcode==0){
				sql.append("select count(seq) \n");
				sql.append("from noticeboard \n");
				sql.append("where to_char(logtime, 'yymmdd') = to_char(sysdate, 'yymmdd')");
				}
			else if(bcode==1){
				sql.append("select count(seq) \n");
				sql.append("from board \n");
				sql.append("where to_char(logtime, 'yymmdd') = to_char(sysdate, 'yymmdd')");
				}
			else if(bcode==2){
				sql.append("select count(seq) \n");
				sql.append("from departboard \n");
				sql.append("where to_char(logtime, 'yymmdd') = to_char(sysdate, 'yymmdd')");
				}
			else if(bcode==3){
				sql.append("select count(seq) \n");
				sql.append("from faqboard \n");
				sql.append("where to_char(logtime, 'yymmdd') = to_char(sysdate, 'yymmdd')");
				}
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return count;
	}

	@Override
	public int totalArticleCount(Map<String, String> map) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			if(Integer.parseInt(map.get("bcode"))==0){
				sql.append("select count(seq) \n");
				sql.append("from noticeboard \n");
				}
			else if(Integer.parseInt(map.get("bcode"))==1){
				sql.append("select count(seq) \n");
				sql.append("from board \n");
				}
			else if(Integer.parseInt(map.get("bcode"))==2){
				sql.append("select count(seq) \n");
				sql.append("from departboard \n");
				}
			else if(Integer.parseInt(map.get("bcode"))==3){
				sql.append("select count(seq) \n");
				sql.append("from faqboard \n");
				}
			String key = map.get("key");
			String word = map.get("word");
			if(!key.isEmpty() && !word.isEmpty()) {
//				제목 >> like, 
//				글쓴이, 글번호 >> =
				if(key.equals("subject"))
					sql.append("		where subject like '%'||?||'%' \n");
				else
					sql.append("		where " + key + " = ? \n");
			}
			pstmt = conn.prepareStatement(sql.toString());
			if(!key.isEmpty() && !word.isEmpty())
				pstmt.setString(1, word);
			rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return count;
	}
}

