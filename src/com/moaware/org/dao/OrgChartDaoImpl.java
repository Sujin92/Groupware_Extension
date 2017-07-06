package com.moaware.org.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.moaware.org.model.OrgDto;
import com.moaware.util.db.DBClose;
import com.moaware.util.db.DBConnection;

public class OrgChartDaoImpl implements OrgChartDao{
	private static OrgChartDao orgChartDao;

	static {
		orgChartDao = new OrgChartDaoImpl();
	}

	private OrgChartDaoImpl() {

	}

	public static OrgChartDao getOrgChartDao() {
		return orgChartDao;
	}

	@Override
	public List<OrgDto> orgChartList() {
		List<OrgDto> list = new ArrayList<OrgDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {


			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();

			sql.append("select mf.*, df.dept_name \n");
			sql.append("from member_info mf, dept_info df \n");
			sql.append("where mf.dept_num = df.dept_num \n");
			sql.append("order by mf.dept_num \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrgDto orgListDto = new OrgDto();
				orgListDto.setEmp_num(rs.getString("emp_num"));
				orgListDto.setDept_num(rs.getInt("dept_num"));
				
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