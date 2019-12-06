package com.xbjy.controller;

import com.xbjy.service.UserService;
import com.xbjy.service.impl.UserServiceImpl;

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

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求链接：" + req.getRequestURI());
        String[] uids = req.getParameterValues("uid");
        System.out.println("即将删除：" + Arrays.toString(uids));

//        userService.deleteSelectedUser(uids);
        System.out.println("删除完毕！");


        StringBuilder sb = new StringBuilder();
        String cp = req.getParameter("cp");
        if (cp != null && !cp.isEmpty()) {
            sb.append("&cp=" + cp);
        }
        String uname = req.getParameter("uname");
        if (uname != null && !uname.isEmpty()) {
            sb.append("&uname=" + uname);
        }
        String sex = req.getParameter("sex");
        if (sex != null && !sex.isEmpty()) {
            sb.append("&sex=" + sex);
        }
        String deptId = req.getParameter("deptId");
        if (deptId != null && !deptId.isEmpty()) {
            sb.append("&deptId=" + deptId);
        }

        System.out.println("删除后，查询条件：" + sb.toString());

        resp.sendRedirect(req.getContextPath() + "/PageListUserServlet?1=1" + sb.toString());


    }
}
