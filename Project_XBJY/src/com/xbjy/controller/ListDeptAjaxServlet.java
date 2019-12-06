package com.xbjy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xbjy.domain.Dept;
import com.xbjy.service.DeptService;
import com.xbjy.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/3 13:02
 */
@WebServlet("/ListDeptAjaxServlet")
public class ListDeptAjaxServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        DeptService deptService = new DeptServiceImpl();

        List<Dept> depts = deptService.listDept();

        ObjectMapper om = new ObjectMapper();
        String data = om.writeValueAsString(depts);
        resp.getWriter().append(data);


    }
}
