package com.moaware.admin.cominfo.dao;

import java.sql.*;
import java.util.*;

import com.moaware.admin.cominfo.model.CominfoDto;
import com.moaware.admin.member.model.DeptDto;
import com.moaware.util.db.DBClose;
import com.moaware.util.db.DBConnection;

public class CominfoDaoImpl implements CominfoDao {
	private static CominfoDao cominfoDao;
	
	static {
		cominfoDao = new CominfoDaoImpl();
	}
	
	private CominfoDaoImpl() {}

	public static CominfoDao getCominfoDao() {
		return cominfoDao;
	}

	@Override
	public List<CominfoDto> holdList(Map<String, String> map) {
		List<CominfoDto> list = new ArrayList<CominfoDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select b.* \n");
			sql.append("from(select rownum rn, a.* \n");
			sql.append("	from (select m.emp_num, dept_name, position_name, id, pass, name, gender, email1, email2, tel1, tel2, tel3, \n");
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
			while(rs.next()) {
				CominfoDto cominfoDto = new CominfoDto();
				cominfoDto.setEmp_num(rs.getString("emp_num"));
				cominfoDto.setDept_name(rs.getString("dept_name"));
				cominfoDto.setPosition_name(rs.getString("position_name"));
				cominfoDto.setId(rs.getString("id"));
				cominfoDto.setPass(rs.getString("pass"));
				cominfoDto.setName(rs.getString("name"));
				cominfoDto.setGender(rs.getString("gender"));
				cominfoDto.setZip1(rs.getString("zip1"));
				cominfoDto.setZip2(rs.getString("zip2"));
				cominfoDto.setAddr1(rs.getString("addr1"));
				cominfoDto.setAddr2(rs.getString("addr2"));
				cominfoDto.setEmail1(rs.getString("email1"));
				cominfoDto.setEmail2(rs.getString("email2"));
				cominfoDto.setTel1(rs.getString("tel1"));
				cominfoDto.setTel2(rs.getString("tel2"));
				cominfoDto.setTel3(rs.getString("tel3"));
				cominfoDto.setBirth1(rs.getString("birth1"));
				cominfoDto.setBirth2(rs.getString("birth2"));
				cominfoDto.setBirth3(rs.getString("birth3"));
				cominfoDto.setMarriage(rs.getString("marriage"));
				cominfoDto.setHire_date1(rs.getString("hire_date1"));
				cominfoDto.setHire_date2(rs.getString("hire_date2"));
				cominfoDto.setHire_date3(rs.getString("hire_date3"));
				cominfoDto.setOut_date1(rs.getString("out_date1"));
				cominfoDto.setOut_date2(rs.getString("out_date2"));
				cominfoDto.setOut_date3(rs.getString("out_date3"));
			
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
	public List<CominfoDto> retireList(Map<String, String> map) {
		List<CominfoDto> list = new ArrayList<CominfoDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select b.*");
			sql.append("from(select rownum rn, a.*");
			sql.append("	from (select m.emp_num, dept_name, position_name, id, pass, name, gender, email1, email2, tel1, tel2, tel3, \n");
			sql.append("		zip1, zip2, addr1, addr2, birth1, birth2, birth3, marriage, hire_date1, hire_date2, hire_date3, out_date1, out_date2, out_date3 \n");
			sql.append("		from member_info m, member_detail_info d, dept_info i, position_info p \n");
			sql.append("		where m.emp_num = d.emp_num and m.dept_num = i.dept_num and m.position_num = p.position_num and out_date1 is not null \n");
			sql.append("		order by m.emp_num desc \n");
			sql.append("		) a \n");
			sql.append("	where rownum <= ? \n");
			sql.append("	) b \n");
			sql.append("where b.rn > ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, map.get("end"));
			pstmt.setString(2, map.get("start"));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CominfoDto cominfoDto = new CominfoDto();
				cominfoDto.setEmp_num(rs.getString("emp_num"));
				cominfoDto.setDept_name(rs.getString("dept_name"));
				cominfoDto.setPosition_name(rs.getString("position_name"));
				cominfoDto.setId(rs.getString("id"));
				cominfoDto.setPass(rs.getString("pass"));
				cominfoDto.setName(rs.getString("name"));
				cominfoDto.setGender(rs.getString("gender"));
				cominfoDto.setZip1(rs.getString("zip1"));
				cominfoDto.setZip2(rs.getString("zip2"));
				cominfoDto.setAddr1(rs.getString("addr1"));
				cominfoDto.setAddr2(rs.getString("addr2"));
				cominfoDto.setEmail1(rs.getString("email1"));
				cominfoDto.setEmail2(rs.getString("email2"));
				cominfoDto.setTel1(rs.getString("tel1"));
				cominfoDto.setTel2(rs.getString("tel2"));
				cominfoDto.setTel3(rs.getString("tel3"));
				cominfoDto.setBirth1(rs.getString("birth1"));
				cominfoDto.setBirth2(rs.getString("birth2"));
				cominfoDto.setBirth3(rs.getString("birth3"));
				cominfoDto.setMarriage(rs.getString("marriage"));
				cominfoDto.setHire_date1(rs.getString("hire_date1"));
				cominfoDto.setHire_date2(rs.getString("hire_date2"));
				cominfoDto.setHire_date3(rs.getString("hire_date3"));
				cominfoDto.setOut_date1(rs.getString("out_date1"));
				cominfoDto.setOut_date2(rs.getString("out_date2"));
				cominfoDto.setOut_date3(rs.getString("out_date3"));
			
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
	public CominfoDto getArticle(int seq) {
		CominfoDto cominfoDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select m.emp_num, dept_num, position_num, id, pass, name, gender, email1, email2, tel1, tel2, tel3, birth1, birth2, birth3, marriage, hire_date1, hire_date2, hire_date3, out_date1, out_date2, out_date3 \n");
			sql.append("from member_info m, member_detail_info d \n");
			sql.append("where m.emp_num = d.emp_num and emp_num = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cominfoDto = new CominfoDto();
				cominfoDto.setEmp_num(rs.getString("emp_num"));
				cominfoDto.setDept_num(rs.getString("dept_num"));
				cominfoDto.setPosition_num(rs.getString("position_num"));
				cominfoDto.setId(rs.getString("id"));
				cominfoDto.setPass(rs.getString("pass"));
				cominfoDto.setName(rs.getString("name"));
				cominfoDto.setGender(rs.getString("gender"));
				cominfoDto.setEmail1(rs.getString("email1"));
				cominfoDto.setEmail2(rs.getString("email2"));
				cominfoDto.setTel1(rs.getString("tel1"));
				cominfoDto.setTel2(rs.getString("tel2"));
				cominfoDto.setTel3(rs.getString("tel3"));
				cominfoDto.setBirth1(rs.getString("birth1"));
				cominfoDto.setBirth2(rs.getString("birth2"));
				cominfoDto.setBirth3(rs.getString("birth3"));
				cominfoDto.setMarriage(rs.getString("marriage"));
				cominfoDto.setHire_date1(rs.getString("hire_date1"));
				cominfoDto.setHire_date2(rs.getString("hire_date2"));
				cominfoDto.setHire_date3(rs.getString("hire_date3"));
				cominfoDto.setOut_date1(rs.getString("out_date1"));
				cominfoDto.setOut_date2(rs.getString("out_date2"));
				cominfoDto.setOut_date3(rs.getString("out_date3"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return cominfoDto;
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
			if(param.equals("null"))
				sql.append("where out_date1 is null \n");
			else
				sql.append("where out_date1 is not null \n");				
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
	public int modify(CominfoDto cominfoDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false); //자동커밋방지
			
			StringBuffer member_info_sql = new StringBuffer();
			member_info_sql.append("update member_info set \n");
			member_info_sql.append("dept_num = (select dept_num from dept_info where dept_name =  ?), position_num = (select position_num from position_info where position_name = ?), \n");
			member_info_sql.append("id = ?, pass = ?, name = ?, gender = ?, email1 = ?, email2 = ?,tel1 = ?, tel2 = ?, tel3 = ? \n");
			member_info_sql.append("where emp_num = ? \n");
			pstmt = conn.prepareStatement(member_info_sql.toString());
			int idx = 0;
			pstmt.setString(++idx, cominfoDto.getDept_name());
			pstmt.setString(++idx, cominfoDto.getPosition_name());
			pstmt.setString(++idx, cominfoDto.getId());
			pstmt.setString(++idx, cominfoDto.getPass());
			pstmt.setString(++idx, cominfoDto.getName());
			pstmt.setString(++idx, cominfoDto.getGender());
			pstmt.setString(++idx, cominfoDto.getEmail1());
			pstmt.setString(++idx, cominfoDto.getEmail2());
			pstmt.setString(++idx, cominfoDto.getTel1());
			pstmt.setString(++idx, cominfoDto.getTel2());
			pstmt.setString(++idx, cominfoDto.getTel3());
			pstmt.setString(++idx, cominfoDto.getEmp_num());
			cnt = pstmt.executeUpdate();
			pstmt.close();
			
			StringBuffer member_detail_info_sql = new StringBuffer();
			member_detail_info_sql.append("update member_detail_info set \n");
			member_detail_info_sql.append("zip1 = ?, zip2 = ?, addr1 = ?, addr2 = ?, birth1 = ?, birth2 = ?, birth3 = ?, marriage = ?, \n");
			member_detail_info_sql.append("hire_date1 = ?, hire_date2 = ?, hire_date3 = ? \n");
			if(cominfoDto.getOut_date1() != null && cominfoDto.getOut_date2() != null && cominfoDto.getOut_date3() != null)
				member_detail_info_sql.append(", out_date1 = ?, out_date2 = ?, out_date3 = ? \n");
			member_detail_info_sql.append("where emp_num = ? \n");
			pstmt = conn.prepareStatement(member_detail_info_sql.toString());
			idx = 0;
			pstmt.setString(++idx, cominfoDto.getZip1());
			pstmt.setString(++idx, cominfoDto.getZip2());
			pstmt.setString(++idx, cominfoDto.getAddr1());
			pstmt.setString(++idx, cominfoDto.getAddr2());
			pstmt.setString(++idx, cominfoDto.getBirth1());
			pstmt.setString(++idx, cominfoDto.getBirth2());
			pstmt.setString(++idx, cominfoDto.getBirth3());
			pstmt.setString(++idx, cominfoDto.getMarriage());
			pstmt.setString(++idx, cominfoDto.getHire_date1());
			pstmt.setString(++idx, cominfoDto.getHire_date2());
			pstmt.setString(++idx, cominfoDto.getHire_date3());
			if(cominfoDto.getOut_date1() != null && cominfoDto.getOut_date2() != null && cominfoDto.getOut_date3() != null) {
				pstmt.setString(++idx, cominfoDto.getOut_date1());
				pstmt.setString(++idx, cominfoDto.getOut_date2());
				pstmt.setString(++idx, cominfoDto.getOut_date3());
			}
			pstmt.setString(++idx, cominfoDto.getEmp_num());
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

	@Override
	public List<DeptDto> deptList() {
		List<DeptDto> list = new ArrayList<DeptDto>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select dept_num, dept_name from dept_info order by dept_num");
			psmt = conn.prepareStatement(sql.toString());
			rs = psmt.executeQuery();
			while(rs.next()) {
				DeptDto deptDto = new DeptDto();
				deptDto.setDept_num(rs.getInt("dept_num"));
				deptDto.setDept_name(rs.getString("dept_name"));
				
				list.add(deptDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		return list;
	}

	@Override
	public void deptRegister(String deptName) {
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into dept_info values(dept_num_seq.nextval, ?)");
			psmt = conn.prepareStatement(sql.toString());
			psmt.setString(1, deptName);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt);
		}
	}

	@Override
	public void deptDelete(int check) {
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete from dept_info where dept_num = ? and (select count(*) from member_info where dept_num = ?) = 0");
			psmt = conn.prepareStatement(sql.toString());
			psmt.setInt(1, check);
			psmt.setInt(2, check);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt);
		}
	}

	@Override
	public DeptDto getDeptInfo(String seq) {
		DeptDto deptDto = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select dept_num, dept_name from dept_info where dept_num=?");
			psmt = conn.prepareStatement(sql.toString());
			psmt.setString(1, seq);
			rs = psmt.executeQuery();
			if(rs.next()){
				deptDto = new DeptDto();
				deptDto.setDept_num(rs.getInt("dept_num"));
				deptDto.setDept_name(rs.getString("dept_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		return deptDto;
	}

	@Override
	public void deptModify(DeptDto deptDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update dept_info set \n");
			sql.append("dept_name = ? \n");
			sql.append("where dept_num = ? \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, deptDto.getDept_name());
			pstmt.setInt(2, deptDto.getDept_num());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}
	
}
