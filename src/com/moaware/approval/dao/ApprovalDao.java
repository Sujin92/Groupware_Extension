package com.moaware.approval.dao;

import com.moaware.approval.model.ApprovalDto;
import com.moaware.approval.model.ConfirmDto;
import com.moaware.approval.model.DeptDto;
import com.moaware.member.model.MemberDto;

import java.util.List;

/**
 * Created by gwasan on 2017. 6. 20..
 */
public interface ApprovalDao {
    int writePaper(ApprovalDto approvalDto);
    List<MemberDto> getMember();
    List<DeptDto> getDept();
    List<ApprovalDto> confirmList(int type, String emp_num);
    ApprovalDto viewPaper(int seq);
    ConfirmDto getConfirmList(String con1, String con2, String con3);
    void confirm(String doc_num, String type);
    void cancel(String doc_num, String type);
}
