package com.moaware.mypage.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.moaware.project.model.ProjectDto;
import com.moaware.util.db.DBClose;
import com.moaware.util.db.DBConnection;

public class MyPageProjectDaoImpl implements MyPageProjectDao {
	
	private static MyPageProjectDao projectDao;
	
	static {
		projectDao = new MyPageProjectDaoImpl();
	}
	
	private MyPageProjectDaoImpl() {}

	public static MyPageProjectDao getReboardDao() {
		return projectDao;
	}

	@Override
	public List<ProjectDto> listProject(String id) {
		List<ProjectDto> list = new ArrayList<ProjectDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select distinct project_num, project_name \n");
			sql.append("from project \n");
			sql.append("where dept_num = (select dept_num from member_info where id = ? \n)");
			sql.append("order by project_num");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProjectDto projectDto = new ProjectDto();
				projectDto.setProject_num(rs.getString("project_num"));
				projectDto.setProject_name(rs.getString("project_name"));
			
				list.add(projectDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}
}
