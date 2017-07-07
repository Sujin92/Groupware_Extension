package com.moaware.approval.action;

import com.moaware.action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gwasan on 2017. 6. 29..
 */
public class ApprovalGetAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = "";
        str = "hihi";
        return str;
    }
}
