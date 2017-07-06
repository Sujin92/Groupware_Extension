package com.moaware.approval.dao;

import com.moaware.approval.model.ApprovalDto;
import com.moaware.approval.model.DeptDto;
import com.moaware.member.model.MemberDto;
import com.moaware.util.db.DBClose;
import com.moaware.util.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gwasan on 2017. 6. 20..
 */
public class ApprovalDaoImpl implements ApprovalDao {
    private static ApprovalDao approvalDaoImpl;

    static {
        approvalDaoImpl = new ApprovalDaoImpl();
    }

    private ApprovalDaoImpl(){}

    public static ApprovalDao getApprovalDaoImpl() {
        return approvalDaoImpl;
    }

    @Override
    public int writePaper(ApprovalDto approvalDto) {
        int cnt = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("insert into document_info (doc_num, emp_num, doc_type_num, doc_name, doc_state, doc_subject, doc_content, draft_date, receive_dept, confirm_line_1, confirm_line_2, confirm_line_3) \n");
//            sql.append("values ('" + approvalDto.getDoc_num() + "', '" + approvalDto.getEmp_num() + "', '" + approvalDto.getDoc_type_num() + "', '" + approvalDto.getDoc_name() + "', '" + approvalDto.getDoc_state() + "', '" + approvalDto.getDoc_subject() + "', '" + approvalDto.getDoc_content() + "', '" + approvalDto.getDraft_date() + "', '" + approvalDto.getReceive_dept() + "', '" + approvalDto.getConfirm_line_1() + "', '" + approvalDto.getConfirm_line_2() + "', '" + approvalDto.getConfirm_line_3() + "')");
            sql.append("    values (doc_num_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt = conn.prepareStatement(sql.toString());
            int idx = 0;
            pstmt.setString(++idx, approvalDto.getEmp_num());
            pstmt.setString(++idx, approvalDto.getDoc_type_num());
            pstmt.setString(++idx, approvalDto.getDoc_name());
            pstmt.setString(++idx, approvalDto.getDoc_state());
            pstmt.setString(++idx, approvalDto.getDoc_subject());
            pstmt.setString(++idx, approvalDto.getDoc_content());
            pstmt.setString(++idx, approvalDto.getDraft_date());
            pstmt.setString(++idx, approvalDto.getReceive_dept());
            pstmt.setString(++idx, approvalDto.getConfirm_line_1());
            pstmt.setString(++idx, approvalDto.getConfirm_line_2());
            pstmt.setString(++idx, approvalDto.getConfirm_line_3());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, pstmt);
        }

        return cnt;
    }

    @Override
    public List<MemberDto> getMember() {
        List<MemberDto> list = new ArrayList<MemberDto>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("select a.EMP_NUM, a.NAME, a.DEPT_NAME, p.POSITION_NAME \n");
            sql.append("from ( \n");
            sql.append("        select EMP_NUM, NAME, DEPT_NAME, POSITION_NUM, d.DEPT_NUM \n");
            sql.append("        from MEMBER_INFO m, DEPT_INFO d \n");
            sql.append("        where m.DEPT_NUM = d.DEPT_NUM ) a, POSITION_INFO p \n");
            sql.append("where a.position_num = p.POSITION_NUM \n");
            sql.append("ORDER BY a.dept_num, p.POSITION_NUM \n");
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while(rs.next()) {
                MemberDto memberDto = new MemberDto();
                memberDto.setEmp_num(rs.getString("emp_num"));
                memberDto.setName(rs.getString("name"));
                memberDto.setDept_num(rs.getString("dept_name"));
                memberDto.setPosition_num(rs.getString("position_name"));

                list.add(memberDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, pstmt, rs);
        }

        return list;
    }

    @Override
    public List<DeptDto> getDept() {
        List<DeptDto> list = new ArrayList<DeptDto>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("select * from dept_info");
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while(rs.next()) {
                DeptDto deptDto = new DeptDto();
                deptDto.setDept_name(rs.getString("dept_name"));
                deptDto.setDept_num(rs.getString("dept_num"));

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
    public List<ApprovalDto> confirmList(int type, String emp_num) {
        List<ApprovalDto> list = new ArrayList<ApprovalDto>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("select * \n");
            sql.append("from DOCUMENT_INFO d, member_info m\n");
            sql.append("where d.emp_num = m.emp_num \n");
            sql.append("    and ((CONFIRM_LINE_1 = ? and CONFIRM_LINE_1_OK = ?) \n");
            sql.append("    or (CONFIRM_LINE_2 = ? and CONFIRM_LINE_2_OK = ?) \n");
            sql.append("    or (CONFIRM_LINE_3 = ? and CONFIRM_LINE_3_OK = ?)) ");
            pstmt = conn.prepareStatement(sql.toString());
            int idx = 0;
            pstmt.setString(++idx, emp_num);
            pstmt.setString(++idx, type + "");
            pstmt.setString(++idx, emp_num);
            pstmt.setString(++idx, type + "");
            pstmt.setString(++idx, emp_num);
            pstmt.setString(++idx, type + "");
            rs = pstmt.executeQuery();
            while(rs.next()) {
                ApprovalDto approvalDto = new ApprovalDto();
                approvalDto.setDoc_num(rs.getString("doc_num"));
                approvalDto.setEmp_num(rs.getString("emp_num"));
                approvalDto.setEmp_name(rs.getString("name"));
                approvalDto.setDoc_type_num(rs.getString("doc_type_num"));
                approvalDto.setDoc_subject(rs.getString("doc_subject"));
                approvalDto.setDoc_state(rs.getString("doc_state"));
                approvalDto.setDraft_date(rs.getString("draft_date"));
                approvalDto.setReceive_dept(rs.getString("receive_dept"));
                approvalDto.setConfirm_line_1(rs.getString("confirm_line_1"));
                approvalDto.setConfirm_line_2(rs.getString("confirm_line_2"));
                approvalDto.setConfirm_line_3(rs.getString("confirm_line_3"));
                approvalDto.setConfirm_line_ok_1(rs.getString("confirm_line_1_ok"));
                approvalDto.setConfirm_line_ok_2(rs.getString("confirm_line_2_ok"));
                approvalDto.setConfirm_line_ok_3(rs.getString("confirm_line_3_ok"));
                approvalDto.setAttachment_path(rs.getString("attachment_path"));

                list.add(approvalDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, pstmt, rs);
        }
        return list;
    }

    @Override
    public ApprovalDto viewPaper(int seq) {
        ApprovalDto approvalDto = new ApprovalDto();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("select * \n");
            sql.append("from document_info d, member_info m \n");
            sql.append("where d.emp_num = m.emp_num and doc_num = ?");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, seq);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                approvalDto.setDoc_num(rs.getString("doc_num"));
                approvalDto.setEmp_num(rs.getString("emp_num"));
                approvalDto.setEmp_name(rs.getString("emp_name"));
                approvalDto.setDoc_type_num(rs.getString("doc_type_num"));
                approvalDto.setDoc_name(rs.getString("doc_name"));
                approvalDto.setDoc_state(rs.getString("doc_state"));
                approvalDto.setDoc_subject(rs.getString("doc_subject"));
                approvalDto.setDraft_date(rs.getString("draft_date"));
                approvalDto.setReceive_dept(rs.getString("receive_dept"));
                approvalDto.setConfirm_line_1(rs.getString("confirm_line_1"));
                approvalDto.setConfirm_line_2(rs.getString("confirm_line_2"));
                approvalDto.setConfirm_line_3(rs.getString("confirm_line_3"));
                approvalDto.setConfirm_line_ok_1(rs.getString("confirm_line_ok_1"));
                approvalDto.setConfirm_line_ok_2(rs.getString("confirm_line_ok_2"));
                approvalDto.setConfirm_line_ok_3(rs.getString("confirm_line_ok_3"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, pstmt, rs);
        }

        return approvalDto;
    }
}
