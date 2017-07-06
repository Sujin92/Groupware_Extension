package com.moaware.factory;

import com.moaware.action.Action;
import com.moaware.approval.action.ApprovalGetAction;
import com.moaware.approval.action.ApprovalWriteAction;
import com.moaware.approval.action.approvalOutstandingAction;

/**
 * Created by gwasan on 2017. 6. 24..
 */
public class ApprovalFactory {
    private static Action approvalWriteAction;
    private static Action approvalGetAction;
    private static Action approvalOutstandingAction;

    static {
        approvalWriteAction = new ApprovalWriteAction();
        approvalGetAction = new ApprovalGetAction();
        approvalOutstandingAction = new approvalOutstandingAction();


    }

    public static Action getApprovalOutstandingAction() {
        return approvalOutstandingAction;
    }

    public static Action getApprovalGetAction() {
        return approvalGetAction;
    }

    public static Action getApprovalWriteAction() {
        return approvalWriteAction;
    }
}
