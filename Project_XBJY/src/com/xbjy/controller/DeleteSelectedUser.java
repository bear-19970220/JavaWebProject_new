package com.xbjy.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/5 19:27
 */
@WebServlet("/DeleteSelectedUser")
public class DeleteSelectedUser extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] uids = req.getParameterValues("check");
        System.out.println(Arrays.toString(uids));

    }
}
