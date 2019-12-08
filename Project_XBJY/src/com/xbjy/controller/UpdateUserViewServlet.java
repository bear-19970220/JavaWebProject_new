package com.xbjy.controller;

import com.xbjy.domain.User;
import com.xbjy.service.UserService;
import com.xbjy.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/4 11:48
 */
@WebServlet("/UpdateUserViewServlet")
public class UpdateUserViewServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        // 封装条件查询参数
        String currentPage = req.getParameter("cp");
        String uname = req.getParameter("uname");
        String sex = req.getParameter("sex");
        String deptId = req.getParameter("deptId");
        System.out.println("获取到备用条件：" + currentPage + '-' + uname + '-' + sex + '-' + deptId + "，正在封装...");

        Map<String, String> updateCdMap = new HashMap<>(3);
        updateCdMap.put("cp", currentPage);
        updateCdMap.put("uname", uname);
        updateCdMap.put("sex", sex);
        updateCdMap.put("deptId", deptId);

        String uid = req.getParameter("uid");

        if (uid == null || uid.isEmpty()) {
            System.out.println("uid 为空！");
            return;
        }

        User userInfo = userService.findUser(Integer.parseInt(uid));
        System.out.println("即将修改：" + userInfo);

        req.getSession().setAttribute("userInfo", userInfo);
        req.getSession().setAttribute("updateCdMap", updateCdMap);
        resp.sendRedirect(req.getContextPath() + "/view/update-user.jsp");

    }
}
