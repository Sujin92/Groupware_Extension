package com.moaware.admin.member.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.moaware.admin.member.model.*;
import com.moaware.member.model.MemberDetailDto;
import com.moaware.util.db.DBClose;
import com.moaware.util.db.DBConnection;

public class MemberRegisterDaoImpl implements MemberRegisterDao {

	private static MemberRegisterDao memberRegisterDao;

	static {
		memberRegisterDao = new MemberRegisterDaoImpl();
	}

	private MemberRegisterDaoImpl() {
	}

	public static MemberRegisterDao getReboardDao() {
		return memberRegisterDao;
	}

	@Override
	public int idCheck(String sid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 1;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select count(id) \n");
			sql.append("from member_info \n");
			sql.append("where id=?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public List<DeptDto> deptSearch(String deptName) {
		List<DeptDto> list = new ArrayList<DeptDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select dept_num, dept_name \n");
			sql.append("from dept_info \n");
			sql.append("where dept_name like '%'||?||'%'");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, deptName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DeptDto deptDto = new DeptDto();
				deptDto.setDept_num(rs.getInt("dept_num"));
				deptDto.setDept_name(rs.getString("dept_name"));

				list.add(deptDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<PositionDto> positionSearch(String positionName) {
		List<PositionDto> list = new ArrayList<PositionDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select position_num, position_name \n");
			sql.append("from position_info \n");
			sql.append("where position_name like '%'||?||'%'");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, positionName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PositionDto positionDto = new PositionDto();
				positionDto.setPosition_num(rs.getInt("position_num"));
				positionDto.setPosition_name(rs.getString("position_name"));

				list.add(positionDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int register(MemberDetailDto memberDetailDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert all \n");
	         sql.append("into member_info(emp_num, dept_num, position_num, id, pass, name, gender, email1, email2, tel1, tel2, tel3) \n");
	         sql.append("values(emp_num_seq.nextval, (select dept_num from dept_info where dept_name=?), (select position_num from position_info where position_name=?), ?, ?, ?, ?, ?, ?, ?, ?, ?) \n");
	         sql.append("into member_detail_info(emp_num, zip1, zip2, addr1, addr2, birth1, birth2, birth3, marriage, hire_date1, hire_date2, hire_date3) \n");
	         sql.append("values(emp_num_seq.currval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) \n");
	         sql.append("select * from dual");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setString(++idx, memberDetailDto.getDept_name());
			pstmt.setString(++idx, memberDetailDto.getPosition_name());
			pstmt.setString(++idx, memberDetailDto.getId());
			pstmt.setString(++idx, memberDetailDto.getPass());
			pstmt.setString(++idx, memberDetailDto.getName());
			pstmt.setString(++idx, memberDetailDto.getGender());
			pstmt.setString(++idx, memberDetailDto.getEmail1());
			pstmt.setString(++idx, memberDetailDto.getEmail2());
			pstmt.setString(++idx, memberDetailDto.getTel1());
			pstmt.setString(++idx, memberDetailDto.getTel2());
			pstmt.setString(++idx, memberDetailDto.getTel3());
			pstmt.setString(++idx, memberDetailDto.getZip1());
			pstmt.setString(++idx, memberDetailDto.getZip2());
			pstmt.setString(++idx, memberDetailDto.getAddr1());
			pstmt.setString(++idx, memberDetailDto.getAddr2());
			pstmt.setString(++idx, memberDetailDto.getBirth1());
			pstmt.setString(++idx, memberDetailDto.getBirth2());
			pstmt.setString(++idx, memberDetailDto.getBirth3());
			pstmt.setString(++idx, memberDetailDto.getMarriage());
			pstmt.setString(++idx, memberDetailDto.getHire_date1());
			pstmt.setString(++idx, memberDetailDto.getHire_date2());
			pstmt.setString(++idx, memberDetailDto.getHire_date3());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}
}
