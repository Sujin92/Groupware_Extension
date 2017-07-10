package com.moaware.factory;

import com.moaware.action.Action;
import com.moaware.approval.action.*;

/**
 * Created by gwasan on 2017. 6. 24..
 */
public class ApprovalFactory {
    private static Action approvalWriteAction;
    private static Action approvalGetAction;
    private static Action approvalOutstandingAction;
    private static Action approvalViewAction;
    private static Action approvalCompelteAction;

    static {
        approvalWriteAction = new ApprovalWriteAction();
        approvalGetAction = new ApprovalGetAction();
        approvalOutstandingAction = new ApprovalOutstandingAction();
        approvalViewAction = new ApprovalViewAction();
        approvalCompelteAction = new ApprovalCompleteAction();
    }

    public static Action getApprovalCompelteAction() {
        return approvalCompelteAction;
    }

    public static Action getApprovalViewAction() {
        return approvalViewAction;
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
