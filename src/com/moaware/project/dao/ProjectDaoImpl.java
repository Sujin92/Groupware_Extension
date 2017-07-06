package com.moaware.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.moaware.login.dao.LoginDao;
import com.moaware.login.dao.LoginDaoImpl;
import com.moaware.member.model.MemberDto;
import com.moaware.project.model.ProjectDto;
import com.moaware.util.db.DBClose;
import com.moaware.util.db.DBConnection;

public class ProjectDaoImpl implements ProjectDao {
	
	
	private static ProjectDao projectDao;
	
	static{
		projectDao = new ProjectDaoImpl();
	}
	
	private ProjectDaoImpl(){};


	public static ProjectDao getProjectDao() {
		return projectDao;
	}


	@Override
	public List<ProjectDto> boardList(String dept) {
		List<ProjectDto> list = new ArrayList<ProjectDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select content_num, project_content, project_progress, project_num, project_name, dept_num, emp_num \n");
			sql.append("from project \n");
			sql.append("where dept_num = ? \n");
			sql.append("order by content_num desc");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dept);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ProjectDto projectDto = new ProjectDto();
				projectDto.setContent_num(rs.getString("content_num"));
				projectDto.setProject_content(rs.getString("project_content"));
				projectDto.setProject_progress(rs.getString("project_progress"));
				projectDto.setProject_num(rs.getString("project_num"));
				projectDto.setProject_name(rs.getString("project_name"));
				projectDto.setDept_num(rs.getString("dept_num"));
				projectDto.setEmp_num(rs.getString("emp_num"));
				list.add(projectDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}	
		return list;
	}


	@Override
	public int createCard(ProjectDto projectDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into project (content_num, project_content, project_progress, project_num, project_name, dept_num, emp_num)\n");
			sql.append("values(card_num_seq.NEXTVAL, ?, ?, ?, ?, ?, ? )");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, projectDto.getProject_content());
			pstmt.setString(2, projectDto.getProject_progress());
			pstmt.setString(3, projectDto.getProject_num());
			pstmt.setString(4, projectDto.getProject_name());
			pstmt.setString(5, projectDto.getDept_num());
			pstmt.setString(6, projectDto.getEmp_num());
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}


	@Override
	public int modifyCard(ProjectDto projectDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();

			sql.append("update project set project_content = ? \n");
			sql.append("where content_num = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, projectDto.getProject_content());
			pstmt.setString(2, projectDto.getContent_num());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}


	@Override
	public int deleteCard(int seq) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer board_sql = new StringBuffer();
			board_sql.append("delete project where content_num = ?");
			pstmt = conn.prepareStatement(board_sql.toString());
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
			cnt = 1;
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		} finally {
			DBClose.close(conn, pstmt);
		}

		return cnt;
	}


	@Override
	public List<MemberDto> membersearch(String dept) {
		
		List<MemberDto> list = new ArrayList<MemberDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select name \n");
			sql.append("from member_info \n");
			sql.append("where dept_num = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dept);
			rs = pstmt.executeQuery();
			while(rs.next()){
				MemberDto memberDto = new MemberDto();
				memberDto.setName(rs.getString("name"));
				list.add(memberDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBClose.close(conn, pstmt, rs);
		}	
		return list;
	}

}

