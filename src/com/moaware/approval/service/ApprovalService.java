package com.moaware.approval.service;

import com.moaware.approval.model.ApprovalDto;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by gwasan on 2017. 6. 20..
 */
public interface ApprovalService {
    int writePaper(ApprovalDto approvalDto);
    void getMember(HttpServletResponse response);
    void getDept(HttpServletResponse response);
    List<ApprovalDto> confirmList(int type, String emp_num);
}
