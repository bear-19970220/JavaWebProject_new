package com.xbjy.controller;

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
 * @date 2019/12/2 19:06
 */
@WebServlet("/DeptServlet")
public class DeptServlet extends HttpServlet {
//public class DeptServlet extends BasicServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DeptService deptService = new DeptServiceImpl();

        List<Dept> depts = deptService.listDept();

        req.setAttribute("depts", depts);

        req.getRequestDispatcher("view/list-dept.jsp").forward(req, resp);

    }
}
