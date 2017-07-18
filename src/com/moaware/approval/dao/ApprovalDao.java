package com.moaware.approval.dao;

import com.moaware.approval.model.ApprovalDto;
import com.moaware.approval.model.ConfirmDto;
import com.moaware.approval.model.DeptDto;
import com.moaware.member.model.MemberDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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

    Map<Integer, Integer> approvalDoc(String emp_num);
    List<ApprovalDto> approvalList1(String emp_num);
    List<ApprovalDto> approvalList2(String emp_num);
    List<ApprovalDto> docList(String emp_num, String state, Map<String, String> map);
    List<ApprovalDto> wholeList(String emp_num, Map<String, String> map);

    int totalArticleCount(String state, String emp_num);

    String writePaper(HttpServletRequest request);
}
