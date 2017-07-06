package com.moaware.approval.model;

/**
 * Created by gwasan on 2017. 6. 20..
 */
public class ApprovalDto {
    String doc_num;
    String emp_num;
    String emp_name;
    String doc_type_num;
    String doc_name;
    String doc_state;
    String doc_subject;
    String doc_content;
    String draft_date;
    String receive_dept;
    String confirm_line_1;
    String confirm_line_2;
    String confirm_line_3;
    String confirm_line_ok_1;
    String confirm_line_ok_2;
    String confirm_line_ok_3;

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getDoc_content() {
        return doc_content;
    }

    public void setDoc_content(String doc_content) {
        this.doc_content = doc_content;
    }

    public String getDoc_num() {
        return doc_num;
    }

    public void setDoc_num(String doc_num) {
        this.doc_num = doc_num;
    }

    public String getEmp_num() {
        return emp_num;
    }

    public void setEmp_num(String emp_num) {
        this.emp_num = emp_num;
    }

    public String getDoc_type_num() {
        return doc_type_num;
    }

    public void setDoc_type_num(String doc_type_num) {
        this.doc_type_num = doc_type_num;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public String getDoc_state() {
        return doc_state;
    }

    public void setDoc_state(String doc_state) {
        this.doc_state = doc_state;
    }

    public String getDoc_subject() {
        return doc_subject;
    }

    public void setDoc_subject(String doc_subject) {
        this.doc_subject = doc_subject;
    }

    public String getDraft_date() {
        return draft_date;
    }

    public void setDraft_date(String draft_date) {
        this.draft_date = draft_date;
    }

    public String getReceive_dept() {
        return receive_dept;
    }

    public void setReceive_dept(String receive_dept) {
        this.receive_dept = receive_dept;
    }

    public String getConfirm_line_1() {
        return confirm_line_1;
    }

    public void setConfirm_line_1(String confirm_line_1) {
        this.confirm_line_1 = confirm_line_1;
    }

    public String getConfirm_line_2() {
        return confirm_line_2;
    }

    public void setConfirm_line_2(String confirm_line_2) {
        this.confirm_line_2 = confirm_line_2;
    }

    public String getConfirm_line_3() {
        return confirm_line_3;
    }

    public void setConfirm_line_3(String confirm_line_3) {
        this.confirm_line_3 = confirm_line_3;
    }

    public String getConfirm_line_ok_1() {
        return confirm_line_ok_1;
    }

    public void setConfirm_line_ok_1(String confirm_line_ok_1) {
        this.confirm_line_ok_1 = confirm_line_ok_1;
    }

    public String getConfirm_line_ok_2() {
        return confirm_line_ok_2;
    }

    public void setConfirm_line_ok_2(String confirm_line_ok_2) {
        this.confirm_line_ok_2 = confirm_line_ok_2;
    }

    public String getConfirm_line_ok_3() {
        return confirm_line_ok_3;
    }

    public void setConfirm_line_ok_3(String confirm_line_ok_3) {
        this.confirm_line_ok_3 = confirm_line_ok_3;
    }

    public String getAttachment_path() {
        return attachment_path;
    }

    public void setAttachment_path(String attachment_path) {
        this.attachment_path = attachment_path;
    }

    String attachment_path;

}
