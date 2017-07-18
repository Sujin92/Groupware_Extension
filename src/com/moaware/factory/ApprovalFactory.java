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
    private static Action approvalMainAction;
    private static Action readyDocAction;
    private static Action returnDocAction;
    private static Action finishDocAction;
    private static Action wholeDocAction;

    static {
        approvalWriteAction = new ApprovalWriteAction();
        approvalGetAction = new ApprovalGetAction();
        approvalOutstandingAction = new ApprovalOutstandingAction();
        approvalViewAction = new ApprovalViewAction();
        approvalCompelteAction = new ApprovalCompleteAction();
        approvalMainAction = new ApprovalMainAction();
        readyDocAction = new ReadyDocAction();
        returnDocAction = new ReturnDocAction();
        finishDocAction = new FinishDocAction();
        wholeDocAction = new WholeDocAction();
    }

    public static Action getApprovalMainAction() {
        return approvalMainAction;
    }

    public static Action getReadyDocAction() {
        return readyDocAction;
    }

    public static Action getReturnDocAction() {
        return returnDocAction;
    }

    public static Action getFinishDocAction() {
        return finishDocAction;
    }

    public static Action getWholeDocAction() {
        return wholeDocAction;
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
