package com.moaware.admin.support.dao;

import java.sql.*;
import java.util.*;

import com.moaware.admin.cominfo.model.CominfoDto;
import com.moaware.admin.support.model.ScheduleDto;
import com.moaware.approval.model.ApprovalDto;
import com.moaware.util.db.DBClose;
import com.moaware.util.db.DBConnection;

public class ApprovalManageDaoImpl implements ApprovalManageDao {

	private static ApprovalManageDao approvalManageDao;

	static {
		approvalManageDao = new ApprovalManageDaoImpl();
	}

	private ApprovalManageDaoImpl() {
	}

	public static ApprovalManageDao getApprovalManageService() {
		return approvalManageDao;
	}

	@Override
	public List<CominfoDto> memberList(Map<String, String> map) {
		List<CominfoDto> list = new ArrayList<CominfoDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select b.* \n");
			sql.append("from(select rownum rn, a.* \n");
			sql.append("	from(select m.emp_num, dept_name, position_name, id, pass, name, gender, email1, email2, tel1, tel2, tel3, \n");
			sql.append("		zip1, zip2, addr1, addr2, birth1, birth2, birth3, marriage, hire_date1, hire_date2, hire_date3, out_date1, out_date2, out_date3 \n");
			sql.append("		from member_info m, member_detail_info d, dept_info i, position_info p \n");
			sql.append("		where m.emp_num = d.emp_num and m.dept_num = i.dept_num and m.position_num = p.position_num and out_date1 is null and id <> 'admin' \n");
			sql.append("		order by hire_date1, hire_date2, hire_date3, name \n");
			sql.append("		) a \n");
			sql.append("	where rownum <= ? \n");
			sql.append("	) b \n");
			sql.append("where b.rn > ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, map.get("end"));
			pstmt.setString(2, map.get("start"));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CominfoDto cominfoDto = new CominfoDto();
				cominfoDto.setEmp_num(rs.getString("emp_num"));
				cominfoDto.setDept_name(rs.getString("dept_name"));
				cominfoDto.setPosition_name(rs.getString("position_name"));
				cominfoDto.setId(rs.getString("id"));
				cominfoDto.setName(rs.getString("name"));
				cominfoDto.setEmail1(rs.getString("email1"));
				cominfoDto.setEmail2(rs.getString("email2"));
				cominfoDto.setTel1(rs.getString("tel1"));
				cominfoDto.setTel2(rs.getString("tel2"));
				cominfoDto.setTel3(rs.getString("tel3"));
				cominfoDto.setHire_date1(rs.getString("hire_date1"));
				cominfoDto.setHire_date2(rs.getString("hire_date2"));
				cominfoDto.setHire_date3(rs.getString("hire_date3"));

				list.add(cominfoDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<ApprovalDto> docList(String emp_num, Map<String, String> map) {
		List<ApprovalDto> list = new ArrayList<ApprovalDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ApprovalDto approvalDto = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select b.* \n");
			sql.append("from(select rownum rn, a.* \n");
			sql.append("	from (select * \n");
			sql.append("		from document_info \n");
			sql.append("		where emp_num = ? \n ");
			sql.append("		order by draft_date desc \n");
			sql.append("		) a \n");
			sql.append("	where rownum <= ? \n");
			sql.append("	) b \n");
			sql.append("where b.rn > ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, emp_num);
			pstmt.setString(2, map.get("end"));
			pstmt.setString(3, map.get("start"));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				approvalDto = new ApprovalDto();
				approvalDto.setDoc_num(rs.getString("doc_num"));
				approvalDto.setEmp_num(rs.getString("emp_num"));
				approvalDto.setDoc_name(rs.getString("doc_name"));
				approvalDto.setDoc_state(rs.getString("doc_state"));
				approvalDto.setDoc_subject(rs.getString("doc_subject"));
				approvalDto.setDoc_content(rs.getString("doc_content"));
				approvalDto.setDraft_date(rs.getString("draft_date"));
				approvalDto.setReceive_dept(rs.getString("receive_dept"));
				approvalDto.setConfirm_line_1(rs.getString("confirm_line_1"));
				approvalDto.setConfirm_line_2(rs.getString("confirm_line_2"));
				approvalDto.setConfirm_line_3(rs.getString("confirm_line_3"));
				approvalDto.setConfirm_line_ok_1(rs.getString("confirm_line_1_ok"));
				approvalDto.setConfirm_line_ok_2(rs.getString("confirm_line_2_ok"));
				approvalDto.setConfirm_line_ok_3(rs.getString("confirm_line_3_ok"));

				list.add(approvalDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<ScheduleDto> scheduleList(String emp_num, Map<String, String> map) {
		List<ScheduleDto> list = new ArrayList<ScheduleDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ScheduleDto scheduleDto = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select b.* \n");
			sql.append("from(select rownum rn, a.* \n");
			sql.append("	from (select emp_num, schedule_seq, schedule_subject, schedule_content, schedule_startdate, schedule_enddate \n");
			sql.append("		from schedule h \n");
			sql.append("		where emp_num = ? \n ");
			sql.append("		order by schedule_seq desc \n");
			sql.append("		) a \n");
			sql.append("	where rownum <= ? \n");
			sql.append("	) b \n");
			sql.append("where b.rn > ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, emp_num);
			pstmt.setString(2, map.get("end"));
			pstmt.setString(3, map.get("start"));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				scheduleDto = new ScheduleDto();
				scheduleDto.setEmp_num(rs.getString("emp_num"));
				scheduleDto.setSchedule_seq(rs.getString("schedule_seq"));
				scheduleDto.setSchedule_subject(rs.getString("schedule_subject"));
				scheduleDto.setSchedule_content(rs.getString("schedule_content"));
				scheduleDto.setSchedule_startdate(rs.getString("schedule_startdate"));
				scheduleDto.setSchedule_enddate(rs.getString("schedule_enddate"));

				list.add(scheduleDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int totalArticleCount(String param) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select count(emp_num) \n");
			sql.append("from member_detail_info \n");
			if (param.equals("null"))
				sql.append("where out_date1 is null \n");
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
	public int docTotalArticleCount(String emp_num) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select count(emp_num) \n");
			sql.append("from document_info \n");
			sql.append("where emp_num = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, emp_num);
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
	public int scheduleTotalArticleCount(String emp_num) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select count(emp_num) \n");
			sql.append("from schedule \n");
			sql.append("where emp_num = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, emp_num);
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
	public void scheduleAdd(ScheduleDto scheduleDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into schedule(emp_num, schedule_seq, schedule_subject, schedule_content, schedule_startdate, schedule_enddate) \n");
			sql.append("values(?, schedule_seq.nextval, ?, ?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setString(++idx, scheduleDto.getEmp_num());
			pstmt.setString(++idx, scheduleDto.getSchedule_subject());
			pstmt.setString(++idx, scheduleDto.getSchedule_content());
			pstmt.setString(++idx, scheduleDto.getSchedule_startdate());
			pstmt.setString(++idx, scheduleDto.getSchedule_enddate());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public void scheduleModify(ScheduleDto scheduleDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update schedule set \n");
			sql.append("schedule_subject = ?, schedule_content = ?, schedule_startdate = ?, schedule_enddate = ? \n");
			sql.append("where schedule_seq = ? \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, scheduleDto.getSchedule_subject());
			pstmt.setString(2, scheduleDto.getSchedule_content());
			pstmt.setString(3, scheduleDto.getSchedule_startdate());
			pstmt.setString(4, scheduleDto.getSchedule_enddate());
			pstmt.setString(5, scheduleDto.getSchedule_seq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}

	@Override
	public void scheduleDelete(int check) {
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete from schedule where schedule_seq = ?");
			psmt = conn.prepareStatement(sql.toString());
			psmt.setInt(1, check);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt);
		}
	}

}
