package com.moaware.schedule.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.moaware.*;
import com.moaware.schedule.model.ScheduleDto;
import com.moaware.util.db.DBClose;
import com.moaware.util.db.DBConnection;

public class ScheduleDaoImpl implements ScheduleDao{
private static ScheduleDao scheduleDao;
	
	static{
		scheduleDao = new ScheduleDaoImpl();
	}
	
	private ScheduleDaoImpl(){};


	public static ScheduleDao getScheduleDao() {
		return scheduleDao;
	}


	@Override
	public int scheduleDto(ScheduleDto scheduleDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into schedule (emp_num, schedule_seq, schedule_subject, schedule_content, schedule_startdate, schedule_enddate, freeday_selecter) \n");
			sql.append("values(?, schedule_seq.nextval, ?, ?, ?, ?, ?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, scheduleDto.getId());
			pstmt.setString(2, scheduleDto.getTitle());
			pstmt.setString(3, scheduleDto.getContent());
			pstmt.setString(4, scheduleDto.getStartDate());
			pstmt.setString(5, scheduleDto.getEndDate());
			pstmt.setString(6, scheduleDto.getFreedayselector());
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}


	@Override
	public List<ScheduleDto> list(ScheduleDto scheduleDto) {
	
			List<ScheduleDto> list = new ArrayList<ScheduleDto>();
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = DBConnection.getConnection();
				StringBuffer sql = new StringBuffer();
				sql.append("select emp_num, schedule_seq, schedule_subject, schedule_content, schedule_startdate, schedule_enddate, freeday_selecter \n");
				sql.append("from schedule \n");
				sql.append("where emp_num = ?");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, scheduleDto.getId());
				rs = pstmt.executeQuery();
				while(rs.next()){ 
					ScheduleDto scheduledto = new ScheduleDto();
					scheduledto.setId(rs.getString("emp_num"));
					scheduledto.setStartDate(rs.getString("schedule_startdate"));
					scheduledto.setEndDate(rs.getString("schedule_enddate"));
					scheduledto.setTitle(rs.getString("schedule_subject"));
					scheduledto.setContent(rs.getString("schedule_content"));
					scheduledto.setFreedayselector(rs.getString("freeday_selecter"));
					list.add(scheduledto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				DBClose.close(conn, pstmt, rs);
			}	
			return list;
			
		}


	@Override
	public int scheduleDto1(ScheduleDto scheduleDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete from schedule where schedule_subject = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, scheduleDto.getTitle());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}


	@Override
	public int scheduleDto2(ScheduleDto scheduleDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update schedule set schedule_content = ?,schedule_startdate = ?,schedule_enddate = ? where schedule_subject = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, scheduleDto.getContent());
			pstmt.setString(2, scheduleDto.getStartDate());
			pstmt.setString(3, scheduleDto.getEndDate());
			pstmt.setString(4, scheduleDto.getTitle());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

}
