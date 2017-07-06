package com.moaware.org.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.moaware.org.model.KeywordDto;
import com.moaware.org.model.OrgDto;
import com.moaware.util.db.DBClose;
import com.moaware.util.db.DBConnection;

public class OrgSelectDaoImpl implements OrgSelectDao{

	private static OrgSelectDao orgSelectDao;

	static {
		orgSelectDao = new OrgSelectDaoImpl();
	}

	private OrgSelectDaoImpl() {}

	public static OrgSelectDao getOrgSelectDao() {
		return orgSelectDao;
	}
	
	@Override
	public List<KeywordDto> orgSelectList(String keyword) {
		List<KeywordDto> list = new ArrayList<KeywordDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {


			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();

			sql.append("select mi.*,  \n");
			sql.append("	pi.position_name, di.dept_name,  \n");
			sql.append("	md.birth1, md.birth2, md.birth3, md.hire_date1, md.hire_date2, md.hire_date3 \n");
			sql.append("from member_info mi, member_detail_info md,  \n");
			sql.append("	position_info pi, dept_info di \n");
			sql.append("where mi.emp_num = md.emp_num  \n");
			sql.append("	and mi.position_num = pi.position_num  \n");
			sql.append("	and mi.dept_num = di.dept_num \n");
			sql.append("	and mi.emp_num = ? \n");
			sql.append("order by mi.dept_num \n");
			   
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, keyword);
			   
			rs = pstmt.executeQuery();
			while(rs.next()){ 
				KeywordDto keywordDto = new KeywordDto();
				keywordDto.setEmp_num(rs.getString("emp_num"));
				keywordDto.setDept_num(rs.getInt("dept_num"));
				keywordDto.setPosition_num(rs.getString("position_num"));
				keywordDto.setPosition_name(rs.getString("position_name"));
				keywordDto.setId(rs.getString("id"));
				keywordDto.setPass(rs.getString("pass"));
				keywordDto.setName(rs.getString("name"));
				keywordDto.setGender(rs.getString("gender"));
				keywordDto.setEmail1(rs.getString("email1"));
				keywordDto.setEmail2(rs.getString("email2"));
				keywordDto.setTel1(rs.getString("tel1"));
				keywordDto.setTel2(rs.getString("tel2"));
				keywordDto.setTel3(rs.getString("tel3"));
				keywordDto.setPicture(rs.getString("picture"));
				
				keywordDto.setDept_name(rs.getString("dept_name"));
				keywordDto.setHire_date1(rs.getString("hire_date1"));
				keywordDto.setHire_date2(rs.getString("hire_date2"));
				keywordDto.setHire_date3(rs.getString("hire_date3"));
				keywordDto.setBirth1(rs.getString("birth1"));
				keywordDto.setBirth2(rs.getString("birth2"));
				keywordDto.setBirth3(rs.getString("birth3"));
				

				list.add(keywordDto);
			}
				
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

}
