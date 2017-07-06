package com.moaware.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.moaware.member.model.MemberDetailDto;
import com.moaware.project.model.ProjectDto;
import com.moaware.util.db.DBClose;
import com.moaware.util.db.DBConnection;

public class MyPageDaoImpl implements MyPageDao {
	
private static MyPageDao myPageDao;
	
	static {
		myPageDao = new MyPageDaoImpl();
	}
	
	private MyPageDaoImpl() {}

	public static MyPageDao getMyPageDao() {
		return myPageDao;
	}

	@Override
	public MemberDetailDto getMemberInfo(String id) {
		MemberDetailDto memberDetailDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select m.emp_num, dept_name, position_name, id, pass, name, gender, email1, email2, tel1, tel2, tel3, picture, \n");
			sql.append("zip1, zip2, addr1, addr2, birth1, birth2, birth3, marriage, hire_date1, hire_date2, hire_date3 \n");
			sql.append("from member_info m, member_detail_info d, dept_info i, position_info p \n");
			sql.append("where m.emp_num = d.emp_num and m.dept_num = i.dept_num and m.position_num = p.position_num and id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDetailDto = new MemberDetailDto();
				memberDetailDto.setEmp_num(rs.getString("emp_num"));
				memberDetailDto.setDept_name(rs.getString("dept_name"));
				memberDetailDto.setPosition_name(rs.getString("position_name"));
				memberDetailDto.setId(rs.getString("id"));
				memberDetailDto.setPass(rs.getString("pass"));
				memberDetailDto.setName(rs.getString("name"));
				memberDetailDto.setGender(rs.getString("gender"));
				memberDetailDto.setZip1(rs.getString("zip1"));
				memberDetailDto.setZip2(rs.getString("zip2"));
				memberDetailDto.setAddr1(rs.getString("addr1"));
				memberDetailDto.setAddr2(rs.getString("addr2"));
				memberDetailDto.setEmail1(rs.getString("email1"));
				memberDetailDto.setEmail2(rs.getString("email2"));
				memberDetailDto.setTel1(rs.getString("tel1"));
				memberDetailDto.setTel2(rs.getString("tel2"));
				memberDetailDto.setTel3(rs.getString("tel3"));
				memberDetailDto.setPicture(rs.getString("picture"));
				memberDetailDto.setBirth1(rs.getString("birth1"));
				memberDetailDto.setBirth2(rs.getString("birth2"));
				memberDetailDto.setBirth3(rs.getString("birth3"));
				memberDetailDto.setMarriage(rs.getString("marriage"));
				memberDetailDto.setHire_date1(rs.getString("hire_date1"));
				memberDetailDto.setHire_date2(rs.getString("hire_date2"));
				memberDetailDto.setHire_date3(rs.getString("hire_date3"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return memberDetailDto;
	}

	@Override
	public int memberInfoModify(MemberDetailDto memberDetailDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false); //자동커밋방지
			
			StringBuffer member_info_sql = new StringBuffer();
			member_info_sql.append("update member_info set \n");
			member_info_sql.append("pass = ?, name = ?, gender = ?, email1 = ?, email2 = ?,tel1 = ?, tel2 = ?, tel3 = ? \n");
			member_info_sql.append("where emp_num = ? \n");
			pstmt = conn.prepareStatement(member_info_sql.toString());
			int idx = 0;
			pstmt.setString(++idx, memberDetailDto.getPass());
			pstmt.setString(++idx, memberDetailDto.getName());
			pstmt.setString(++idx, memberDetailDto.getGender());
			pstmt.setString(++idx, memberDetailDto.getEmail1());
			pstmt.setString(++idx, memberDetailDto.getEmail2());
			pstmt.setString(++idx, memberDetailDto.getTel1());
			pstmt.setString(++idx, memberDetailDto.getTel2());
			pstmt.setString(++idx, memberDetailDto.getTel3());
			pstmt.setString(++idx, memberDetailDto.getEmp_num());
			
			cnt = pstmt.executeUpdate();
			pstmt.close();
			
			StringBuffer member_detail_info_sql = new StringBuffer();
			member_detail_info_sql.append("update member_detail_info set \n");
			member_detail_info_sql.append("zip1 = ?, zip2 = ?, addr1 = ?, addr2 = ?, birth1 = ?, birth2 = ?, birth3 = ?, marriage = ?");
			member_detail_info_sql.append("where emp_num = ? \n");
			pstmt = conn.prepareStatement(member_detail_info_sql.toString());
			idx = 0;
			pstmt.setString(++idx, memberDetailDto.getZip1());
			pstmt.setString(++idx, memberDetailDto.getZip2());
			pstmt.setString(++idx, memberDetailDto.getAddr1());
			pstmt.setString(++idx, memberDetailDto.getAddr2());
			pstmt.setString(++idx, memberDetailDto.getBirth1());
			pstmt.setString(++idx, memberDetailDto.getBirth2());
			pstmt.setString(++idx, memberDetailDto.getBirth3());
			pstmt.setString(++idx, memberDetailDto.getMarriage());
			pstmt.setString(++idx, memberDetailDto.getEmp_num());
			cnt = pstmt.executeUpdate();
			
			conn.commit();
			cnt = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}
}
