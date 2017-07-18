package com.moaware.approval.service;

import com.moaware.approval.dao.ApprovalDaoImpl;
import com.moaware.approval.model.ApprovalDto;
import com.moaware.approval.model.DeptDto;
import com.moaware.approval.util.PageNavigation;
import com.moaware.member.model.MemberDto;
import com.moaware.util.Constance;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gwasan on 2017. 6. 20..
 */
public class ApprovalServiceImpl implements ApprovalService{
    private static ApprovalService approvalServiceImpl;

    static {
        approvalServiceImpl = new ApprovalServiceImpl();
    }

    private ApprovalServiceImpl(){}

    public static ApprovalService getApprovalServiceImpl() {
        return approvalServiceImpl;
    }

    @Override
    public int writePaper(ApprovalDto approvalDto) {
        return ApprovalDaoImpl.getApprovalDaoImpl().writePaper(approvalDto);
    }

    @Override
    public void getMember(HttpServletResponse response) {
        List<MemberDto> list = ApprovalDaoImpl.getApprovalDaoImpl().getMember();
        String obj = "{ \"info\": [";

        int len = list.size();
        for (int i = 0; i < len; i++) {
            MemberDto memberDto = list.get(i);
            obj += "{ \"emp_num\": \"" + memberDto.getEmp_num() + "\", \"name\": \"" + memberDto.getName() + "\", \"dept_num\": \"" + memberDto.getDept_num() + "\", \"position_num\": \"" + memberDto.getPosition_num() + "\"}";
            if (i != len - 1)
                obj += ", ";
        }
        obj += "] }";
//        System.out.println(obj);

        PrintWriter out = null;
        try {
            response.setContentType("text/plain;charset=utf-8");
            out = response.getWriter();
            out.println(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getDept(HttpServletResponse response) {
        List<DeptDto> list = ApprovalDaoImpl.getApprovalDaoImpl().getDept();
        String obj = "{ \"info\": [";

        int len = list.size();
        for (int i = 0; i < len; i++) {
            DeptDto deptDto = list.get(i);
            obj += "{ \"dept_num\": \"" + deptDto.getDept_num() + "\", \"dept_name\": \"" + deptDto.getDept_name() + "\"}";
            if (i != len - 1)
                obj += ", ";
        }
        obj += "] }";
//        System.out.println(obj);

        PrintWriter out = null;
        try {
            response.setContentType("text/plain;charset=utf-8");
            out = response.getWriter();
            out.println(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ApprovalDto> confirmList(int type, String emp_num) {
        return ApprovalDaoImpl.getApprovalDaoImpl().confirmList(type, emp_num);
    }

    @Override
    public ApprovalDto viewPaper(int seq) {
        return ApprovalDaoImpl.getApprovalDaoImpl().viewPaper(seq);
    }

    @Override
    public void confirm(String doc_num, String type) {
        ApprovalDaoImpl.getApprovalDaoImpl().confirm(doc_num, type);
    }

    @Override
    public void cancel(String doc_num, String type) {
        ApprovalDaoImpl.getApprovalDaoImpl().cancel(doc_num, type);
    }

    @Override
    public Map<Integer, Integer> approvalDoc(String emp_num) {
        return ApprovalDaoImpl.getApprovalDaoImpl().approvalDoc(emp_num);
    }

    @Override
    public List<ApprovalDto> approvalList1(String emp_num) {
        return ApprovalDaoImpl.getApprovalDaoImpl().approvalList1(emp_num);
    }

    @Override
    public List<ApprovalDto> approvalList2(String emp_num) {
        return ApprovalDaoImpl.getApprovalDaoImpl().approvalList2(emp_num);
    }

    @Override
    public List<ApprovalDto> docList(String emp_num, String state, int pg) {
        int end = pg * Constance.LIST_SIZE;
        int start = end - Constance.LIST_SIZE;
        Map<String, String> map = new HashMap<String, String>();
        map.put("start", start + "");
        map.put("end", end + "");
        return ApprovalDaoImpl.getApprovalDaoImpl().docList(emp_num, state, map);
    }

    @Override
    public List<ApprovalDto> wholeList(String emp_num, int pg) {
        int end = pg * Constance.LIST_SIZE;
        int start = end - Constance.LIST_SIZE;
        Map<String, String> map = new HashMap<String, String>();
        map.put("start", start + "");
        map.put("end", end + "");
        return ApprovalDaoImpl.getApprovalDaoImpl().wholeList(emp_num, map);
    }

    @Override
    public PageNavigation makePageNavigation(int pg, String state, String emp_num) {
        PageNavigation pageNavigation = new PageNavigation();
        int totalArticleCount = ApprovalDaoImpl.getApprovalDaoImpl().totalArticleCount(state, emp_num); //��ü �Խù� ��
        pageNavigation.setTotalArticleCount(totalArticleCount);
        int totalPageCount = (totalArticleCount - 1) / Constance.LIST_SIZE + 1; //��ü ������ ��
        pageNavigation.setTotalPageCount(totalPageCount);

        pageNavigation.setNowFirst(pg <= Constance.PAGE_SIZE);
        pageNavigation.setNowEnd((totalPageCount - 1) / Constance.PAGE_SIZE * Constance.PAGE_SIZE < pg);
        pageNavigation.setPageNo(pg);
        return pageNavigation;
    }
}
