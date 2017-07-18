package com.moaware.approval.service;

import com.moaware.approval.model.ApprovalDto;
import com.moaware.approval.util.PageNavigation;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by gwasan on 2017. 6. 20..
 */
public interface ApprovalService {
    int writePaper(ApprovalDto approvalDto);
    void getMember(HttpServletResponse response);
    void getDept(HttpServletResponse response);
    List<ApprovalDto> confirmList(int type, String emp_num);
    ApprovalDto viewPaper(int seq);
    void confirm(String doc_num, String type);
    void cancel(String doc_num, String type);

    Map<Integer, Integer> approvalDoc(String emp_num);
    List<ApprovalDto> approvalList1(String emp_num);
    List<ApprovalDto> approvalList2(String emp_num);
    List<ApprovalDto> docList(String emp_num, String state, int pg);
    List<ApprovalDto> wholeList(String emp_num, int pg);

    PageNavigation makePageNavigation(int pg, String state, String emp_num);
}
