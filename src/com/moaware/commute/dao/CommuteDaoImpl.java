package com.moaware.commute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.moaware.board.model.ReboardDto;
import com.moaware.commute.model.CommuteDto;
import com.moaware.util.db.DBClose;
import com.moaware.util.db.DBConnection;

public class CommuteDaoImpl implements CommuteDao {

	
private static CommuteDao commuteDaoImpl;
	
	static{
		commuteDaoImpl = new CommuteDaoImpl();
	}
	
	private CommuteDaoImpl(){}
	

	public static CommuteDao getCommuteDaoImpl() {
		return commuteDaoImpl;
	}


	@Override
	public int gotowork(CommuteDto commuteDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			String str = commuteDto.getCheck_in();
			StringTokenizer st = new StringTokenizer(str, ":");
			if(Integer.parseInt(st.nextToken())>9){
			sql.append("insert \n");
			sql.append("	into commute (EMP_NUM,COMMUTE_SEQ,COMMUTE_DATE, CHECKIN, CHECKOUT, COMMUTE_DIVISION ) \n");
			sql.append("	values(?, commute_num_seq.nextval,?, ?, ?, '0') \n");
			}
			else{
			sql.append("insert \n");
			sql.append("	into commute (EMP_NUM,COMMUTE_SEQ,COMMUTE_DATE, CHECKIN, CHECKOUT, COMMUTE_DIVISION ) \n");
			sql.append("	values(?, commute_num_seq.nextval,?, ?, ?, '1') \n");
			}
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setString(++idx, commuteDto.getEmp_num());
			pstmt.setString(++idx, commuteDto.getCommute_date());
			pstmt.setString(++idx, commuteDto.getCheck_in());
			pstmt.setString(++idx, commuteDto.getCheck_out());
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			return 0;
		}
		finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}


	@Override
	public List<CommuteDto> listArticle(String emp) {
		List<CommuteDto> list = new ArrayList<CommuteDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
	         StringBuffer sql = new StringBuffer();
	         sql.append("select EMP_NUM, COMMUTE_DATE, CHECKIN, CHECKOUT, COMMUTE_DIVISION \n");
	         sql.append("from commute \n");
	         sql.append("where emp_num = ?");
	        
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,emp);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CommuteDto commuteDto = new CommuteDto();
				commuteDto.setEmp_num(rs.getString("EMP_NUM"));
				commuteDto.setCheck_in(rs.getString("CHECKIN"));
				commuteDto.setCheck_out(rs.getString("CHECKOUT"));
				commuteDto.setCommute_date(rs.getString("COMMUTE_DATE"));
				commuteDto.setCommute_division(rs.getString("COMMUTE_DIVISION"));

				list.add(commuteDto);
			};
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}


	@Override
	public int leavework(CommuteDto commuteDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update commute \n");
			sql.append("set checkout = ? \n");
			sql.append("where commute_date = ?");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setString(++idx, commuteDto.getCheck_out());
			pstmt.setString(++idx, commuteDto.getCommute_date());
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e){
			return 0;
		} finally{
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

}
