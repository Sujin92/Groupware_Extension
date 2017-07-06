package com.moaware.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.moaware.member.model.MemberDto;
import com.moaware.util.db.DBClose;
import com.moaware.util.db.DBConnection;

public class LoginDaoImpl implements LoginDao {
	
	private static LoginDao loginDao;
	
	static{
		loginDao = new LoginDaoImpl();
	}
	
	private LoginDaoImpl(){};

	public static LoginDao getLoginDao() {
		return loginDao;
	}

	@Override
	public MemberDto login(String id, String pass) {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select emp_num, dept_num, position_num, id, name from member_info \n");
			sql.append("where id= ? and pass= ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDto =  new MemberDto();
				memberDto.setEmp_num(rs.getString("emp_num"));
				memberDto.setDept_num(rs.getString("dept_num"));
				memberDto.setPosition_num(rs.getString("position_num"));
				memberDto.setId(rs.getString("id"));
				memberDto.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBClose.close(conn, pstmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return memberDto;
	}

}
