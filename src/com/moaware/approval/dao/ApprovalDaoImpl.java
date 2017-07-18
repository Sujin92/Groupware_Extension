package com.moaware.approval.dao;

import com.moaware.approval.model.ApprovalDto;
import com.moaware.approval.model.ConfirmDto;
import com.moaware.approval.model.DeptDto;
import com.moaware.member.model.MemberDto;
import com.moaware.util.db.DBClose;
import com.moaware.util.db.DBConnection;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gwasan on 2017. 6. 20..
 */
public class ApprovalDaoImpl implements ApprovalDao {
    private static ApprovalDao approvalDaoImpl;

    static {
        approvalDaoImpl = new ApprovalDaoImpl();
    }

    private ApprovalDaoImpl() {
    }

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
            while (rs.next()) {
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
            while (rs.next()) {
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
            while (rs.next()) {
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
            sql.append("select d.doc_num, m.emp_num, m.name, d.doc_type_num, d.doc_name, d.doc_state, d.doc_content, d.doc_subject, d.draft_date, d.receive_dept, d.confirm_line_1, d.confirm_line_2, d.confirm_line_3, d.confirm_line_1_ok, d.confirm_line_2_ok, d.confirm_line_3_ok, de.dept_name \n");
            sql.append("from document_info d, member_info m, dept_info de \n");
            sql.append("where d.emp_num = m.emp_num and de.dept_num = m.dept_num and doc_num = ?");
            sql.append("order by d.doc_num");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, seq);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                approvalDto.setDoc_num(rs.getString("doc_num"));
//                approvalDto.setEmp_num(rs.getString("m.emp_num"));
                approvalDto.setEmp_name(rs.getString("name"));
                approvalDto.setDoc_type_num(rs.getString("doc_type_num"));
                approvalDto.setDoc_name(rs.getString("doc_name"));
                approvalDto.setDoc_state(rs.getString("doc_state"));
                approvalDto.setDoc_subject(rs.getString("doc_subject"));
                approvalDto.setDoc_content(rs.getString("doc_content"));
                approvalDto.setDraft_date(rs.getString("draft_date"));
                approvalDto.setReceive_dept(rs.getString("receive_dept"));
                approvalDto.setDept_name(rs.getString("dept_name"));
                approvalDto.setConfirm_line_1(rs.getString("confirm_line_1"));
                approvalDto.setConfirm_line_2(rs.getString("confirm_line_2"));
                approvalDto.setConfirm_line_3(rs.getString("confirm_line_3"));
                approvalDto.setConfirm_line_ok_1(rs.getString("confirm_line_1_ok"));
                approvalDto.setConfirm_line_ok_2(rs.getString("confirm_line_2_ok"));
                approvalDto.setConfirm_line_ok_3(rs.getString("confirm_line_3_ok"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, pstmt, rs);
        }

        return approvalDto;
    }

    @Override
    public ConfirmDto getConfirmList(String con1, String con2, String con3) {
        ConfirmDto confirmDto = new ConfirmDto();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("select p.position_name, name \n");
            sql.append("from member_info m, position_info p \n");
            sql.append("where m.position_num = p.position_num and emp_num = ? ");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, con1);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                confirmDto.setConfirm1_name(rs.getString("name"));
                confirmDto.setConfirm1_position(rs.getString("position_name"));
            }

            pstmt.setString(1, con2);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                confirmDto.setConfirm2_name(rs.getString("name"));
                confirmDto.setConfirm2_position(rs.getString("position_name"));
            }

            pstmt.setString(1, con3);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                confirmDto.setConfirm3_name(rs.getString("name"));
                confirmDto.setConfirm3_position(rs.getString("position_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, pstmt, rs);
        }

        return confirmDto;
    }

    @Override
    public void confirm(String doc_num, String type) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("update document_info \n");
            if ("1".equals(type)) {
                sql.append("set confirm_line_1_ok = '1' \n");
            }
            else if ("2".equals(type)) {
                sql.append("set confirm_line_2_ok = '1' \n");
            }
            else if ("3".equals(type)) {
                sql.append("set confirm_line_3_ok = '1' \n");
            }
            sql.append("where doc_num = ?");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, doc_num);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, pstmt);
        }
    }

    @Override
    public void cancel(String doc_num, String type) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("update document_info \n");
            if ("1".equals(type)) {
                sql.append("set confirm_line_1_ok = '0' \n");
            }
            else if ("2".equals(type)) {
                sql.append("set confirm_line_2_ok = '0' \n");
            }
            else if ("3".equals(type)) {
                sql.append("set confirm_line_3_ok = '0' \n");
            }
            sql.append("where doc_num = ?");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, doc_num);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, pstmt);
        }
    }

    @Override
    public Map<Integer, Integer> approvalDoc(String emp_num) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        int cnt4 = 0;
        int cnt5 = 0;
        int cnt6 = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        try {
            conn = DBConnection.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("select count(*) count1 from document_info d, member_info m where d.emp_num = m.emp_num and d.emp_num = ? and doc_state = '�̰���'");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, emp_num);
            rs = pstmt.executeQuery();
            rs.next();
            cnt1 = rs.getInt("count1");
            map.put(1, cnt1);
            rs.close();
            pstmt.close();

            StringBuffer sql2 = new StringBuffer();
            sql2.append("select count(*) count2 from document_info d, member_info m where d.emp_num = m.emp_num and d.emp_num = ? and doc_state = '����'");
            pstmt = conn.prepareStatement(sql2.toString());
            pstmt.setString(1, emp_num);
            rs = pstmt.executeQuery();
            rs.next();
            cnt2 = rs.getInt("count2");
            map.put(2, cnt2);
            rs.close();
            pstmt.close();

            StringBuffer sql3 = new StringBuffer();
            sql3.append("select count(*) count3 from document_info d, member_info m where d.emp_num = m.emp_num and d.emp_num = ? and doc_state = '�ݷ�'");
            pstmt = conn.prepareStatement(sql3.toString());
            pstmt.setString(1, emp_num);
            rs = pstmt.executeQuery();
            rs.next();
            cnt3 = rs.getInt("count3");
            map.put(3, cnt3);
            rs.close();
            pstmt.close();

            StringBuffer sql4 = new StringBuffer();
            sql4.append("select count(*) count4 from document_info d, member_info m where d.emp_num = m.emp_num and d.emp_num = ?");
            pstmt = conn.prepareStatement(sql4.toString());
            pstmt.setString(1, emp_num);
            rs = pstmt.executeQuery();
            rs.next();
            cnt4 = rs.getInt("count4");
            map.put(4, cnt4);
            rs.close();
            pstmt.close();

            StringBuffer sql5 = new StringBuffer();
            sql5.append("select count(*) count5 \n");
            sql5.append("from DOCUMENT_INFO \n");
            sql5.append("where (CONFIRM_LINE_1 = ? and CONFIRM_LINE_1_OK = 0) \n");
            sql5.append("    or (CONFIRM_LINE_2 = ? and CONFIRM_LINE_2_OK = 0) \n");
            sql5.append("    or (CONFIRM_LINE_3 = ? and CONFIRM_LINE_3_OK = 0) \n");
            pstmt = conn.prepareStatement(sql5.toString());
            pstmt.setString(1, emp_num);
            pstmt.setString(2, emp_num);
            pstmt.setString(3, emp_num);
            rs = pstmt.executeQuery();
            rs.next();
            cnt5 = rs.getInt("count5");
            map.put(5, cnt5);
            rs.close();
            pstmt.close();

            StringBuffer sql6 = new StringBuffer();
            sql6.append("select count(*) count6 \n");
            sql6.append("from DOCUMENT_INFO \n");
            sql6.append("where (CONFIRM_LINE_1 = ? and CONFIRM_LINE_1_OK = 1) \n");
            sql6.append("    or (CONFIRM_LINE_2 = ? and CONFIRM_LINE_2_OK = 1) \n");
            sql6.append("    or (CONFIRM_LINE_3 = ? and CONFIRM_LINE_3_OK = 1) \n");
            pstmt = conn.prepareStatement(sql6.toString());
            pstmt.setString(1, emp_num);
            pstmt.setString(2, emp_num);
            pstmt.setString(3, emp_num);
            rs = pstmt.executeQuery();
            rs.next();
            cnt6 = rs.getInt("count6");
            map.put(6, cnt6);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, pstmt, rs);
        }
        return map;
    }

    @Override
    public List<ApprovalDto> approvalList1(String emp_num) {
        List<ApprovalDto> list = new ArrayList<ApprovalDto>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ApprovalDto approvalDto = null;
        try {
            conn = DBConnection.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("select doc_num, draft_date, doc_subject, emp_num \n");
            sql.append("from document_info \n");
            sql.append("where (CONFIRM_LINE_1 = ? and CONFIRM_LINE_1_OK = 0) \n");
            sql.append("    or (CONFIRM_LINE_2 = ? and CONFIRM_LINE_2_OK = 0) \n");
            sql.append("    or (CONFIRM_LINE_3 = ? and CONFIRM_LINE_3_OK = 0) \n");
            sql.append("order by draft_date desc");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, emp_num);
            pstmt.setString(2, emp_num);
            pstmt.setString(3, emp_num);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                approvalDto = new ApprovalDto();
                approvalDto.setDoc_num(rs.getString("doc_num"));
                approvalDto.setDraft_date(rs.getString("draft_date"));
                approvalDto.setDoc_subject(rs.getString("doc_subject"));
                approvalDto.setEmp_num(rs.getString("emp_num"));

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
    public List<ApprovalDto> approvalList2(String emp_num) {
        List<ApprovalDto> list = new ArrayList<ApprovalDto>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ApprovalDto approvalDto = null;
        try {
            conn = DBConnection.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("select doc_num, draft_date, doc_subject, doc_state from document_info d, member_info m \n");
            sql.append("where d.emp_num = m.emp_num and d.emp_num = ? \n");
            sql.append("order by draft_date desc");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, emp_num);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                approvalDto = new ApprovalDto();
                approvalDto.setDoc_num(rs.getString("doc_num"));
                approvalDto.setDraft_date(rs.getString("draft_date"));
                approvalDto.setDoc_subject(rs.getString("doc_subject"));
                approvalDto.setDoc_state(rs.getString("doc_state"));

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
    public List<ApprovalDto> docList(String emp_num, String state, Map<String, String> map) {
        List<ApprovalDto> list = new ArrayList<ApprovalDto>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ApprovalDto approvalDto = null;
        try {
            conn = DBConnection.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("select b.* \n");
            sql.append("from(select rownum rn, a.* \n");
            sql.append("	from (select doc_num, d.emp_num, doc_type_num, doc_name, doc_state, doc_subject, doc_content, draft_date, receive_dept, confirm_line_1, confirm_line_2, confirm_line_3 \n");
            sql.append("		from document_info d, member_info m \n");
            sql.append("		where d.emp_num = m.emp_num and d.emp_num = ? and doc_state = ? \n");
            sql.append("		order by draft_date desc \n");
            sql.append("		) a \n");
            sql.append("	where rownum <= ? \n");
            sql.append("	) b \n");
            sql.append("where b.rn > ?");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, emp_num);
            pstmt.setString(2, state);
            pstmt.setString(3, map.get("end"));
            pstmt.setString(4, map.get("start"));

            rs = pstmt.executeQuery();
            while(rs.next()) {
                approvalDto = new ApprovalDto();
                approvalDto.setDoc_num(rs.getString("doc_num"));
                approvalDto.setEmp_num(rs.getString("emp_num"));
                approvalDto.setDoc_type_num(rs.getString("doc_type_num"));
                approvalDto.setDoc_name(rs.getString("doc_name"));
                approvalDto.setDoc_state(rs.getString("doc_state"));
                approvalDto.setDoc_subject(rs.getString("doc_subject"));
                approvalDto.setDoc_content(rs.getString("doc_content"));
                approvalDto.setDraft_date(rs.getString("draft_date"));
                approvalDto.setReceive_dept(rs.getString("receive_dept"));
                approvalDto.setConfirm_line_1(rs.getString("confirm_line_1"));
                approvalDto.setConfirm_line_2(rs.getString("confirm_line_2"));
                approvalDto.setConfirm_line_3(rs.getString("confirm_line_3"));

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
    public List<ApprovalDto> wholeList(String emp_num, Map<String, String> map) {
        List<ApprovalDto> list = new ArrayList<ApprovalDto>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ApprovalDto approvalDto = null;
        try {
            conn = DBConnection.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("select b.* \n");
            sql.append("from(select rownum rn, a.* \n");
            sql.append("	from (select doc_num, emp_num, doc_type_num, doc_name, doc_state, doc_subject, doc_content, draft_date, receive_dept, confirm_line_1, confirm_line_2, confirm_line_3 \n");
            sql.append("		from document_info \n");
            sql.append("		where emp_num = ? \n ");
            sql.append("		order by draft_date desc \n");
            sql.append("		) a \n");
            sql.append("	where rownum <= ? \n");
            sql.append("	) b \n");
            sql.append("where b.rn > ?");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, emp_num);
            pstmt.setString(2, map.get("end"));
            pstmt.setString(3, map.get("start"));
            rs = pstmt.executeQuery();
            while(rs.next()) {
                approvalDto = new ApprovalDto();
                approvalDto.setDoc_num(rs.getString("doc_num"));
                approvalDto.setEmp_num(rs.getString("emp_num"));
                approvalDto.setDoc_type_num(rs.getString("doc_type_num"));
                approvalDto.setDoc_name(rs.getString("doc_name"));
                approvalDto.setDoc_state(rs.getString("doc_state"));
                approvalDto.setDoc_subject(rs.getString("doc_subject"));
                approvalDto.setDoc_content(rs.getString("doc_content"));
                approvalDto.setDraft_date(rs.getString("draft_date"));
                approvalDto.setReceive_dept(rs.getString("receive_dept"));
                approvalDto.setConfirm_line_1(rs.getString("confirm_line_1"));
                approvalDto.setConfirm_line_2(rs.getString("confirm_line_2"));
                approvalDto.setConfirm_line_3(rs.getString("confirm_line_3"));

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
    public int totalArticleCount(String state, String emp_num) {
        int count = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("select count(doc_num) \n");
            sql.append("from document_info \n");
            sql.append("where emp_num = ? \n");
            if(state.equals("�̰���"))
                sql.append("and doc_state = ? \n");
            else if(state.equals("�ݷ�"))
                sql.append("and doc_state = ? \n");
            else if(state.equals("����"))
                sql.append("and doc_state = ? \n");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, emp_num);
            if(!state.equals(""))
                pstmt.setString(2, state);
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
    public String writePaper(HttpServletRequest request) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("select last_number from user_sequences where sequence_name = upper('doc_num_seq') ");
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            rs.next();
            request.setAttribute("writePaper", rs.getInt("last_number") + "");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, pstmt, rs);
        }
        return "/approval/order_paper.jsp";

    }


}
