package com.moaware.org.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.moaware.org.model.KeywordDto;
import com.moaware.util.db.DBClose;
import com.moaware.util.db.DBConnection;

public class KeywordDao {

	public List<KeywordDto> searchKeyword(String keyword) {
		List<KeywordDto> list = new ArrayList<KeywordDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select mf.*, df.dept_name \n");
			sql.append("from member_info mf, dept_info df \n");
			sql.append("where mf.dept_num = df.dept_num \n");
			sql.append("where mf.position_num = ? \n");
			sql.append("order by mf.dept_num \n");
			   
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, keyword);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				KeywordDto orgListDto = new KeywordDto();
				orgListDto.setEmp_num(rs.getString("emp_num"));
				orgListDto.setDept_num(rs.getInt("dept_num"));
				orgListDto.setPosition_num(rs.getString("position_num"));
				orgListDto.setId(rs.getString("id"));
				orgListDto.setPass(rs.getString("pass"));
				orgListDto.setName(rs.getString("name"));
				orgListDto.setGender(rs.getString("gender"));
				orgListDto.setEmail1(rs.getString("email1"));
				orgListDto.setEmail2(rs.getString("email2"));
				orgListDto.setTel1(rs.getString("tel1"));
				orgListDto.setTel2(rs.getString("tel2"));
				orgListDto.setTel3(rs.getString("tel3"));
				orgListDto.setPicture(rs.getString("picture"));
				
				orgListDto.setDept_name(rs.getString("dept_name"));

				list.add(orgListDto);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}
}
