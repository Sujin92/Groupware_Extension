package com.moaware.approval.service;

import com.moaware.approval.dao.ApprovalDaoImpl;
import com.moaware.approval.model.ApprovalDto;
import com.moaware.approval.model.DeptDto;
import com.moaware.member.model.MemberDto;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
}
