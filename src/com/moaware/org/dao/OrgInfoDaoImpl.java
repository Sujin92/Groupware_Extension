package com.moaware.org.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.moaware.org.model.OrgDto;
import com.moaware.util.db.DBClose;
import com.moaware.util.db.DBConnection;

public class OrgInfoDaoImpl implements OrgInfoDao{

	private static OrgInfoDao orgDao;

	static {
		orgDao = new OrgInfoDaoImpl();
	}

	private OrgInfoDaoImpl() {

	}

	public static OrgInfoDao getOrgInfoDao() {
		return orgDao;
	}

	public List<OrgDto> orgInfoList() {
		List<OrgDto> list = new ArrayList<OrgDto>();
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
			sql.append("order by mi.dept_num \n");
			   
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrgDto orgListDto = new OrgDto();
				orgListDto.setEmp_num(rs.getString("emp_num"));
				orgListDto.setDept_num(rs.getInt("dept_num"));
				orgListDto.setPosition_num(rs.getString("position_num"));
				orgListDto.setPosition_name(rs.getString("position_name"));
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
				orgListDto.setHire_date1(rs.getString("hire_date1"));
				orgListDto.setHire_date2(rs.getString("hire_date2"));
				orgListDto.setHire_date3(rs.getString("hire_date3"));
				orgListDto.setBirth1(rs.getString("birth1"));
				orgListDto.setBirth2(rs.getString("birth2"));
				orgListDto.setBirth3(rs.getString("birth3"));
				

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
