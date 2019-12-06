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

        String uid = req.getParameter("uid");

        if (uid == null ||  uid.isEmpty()) {
            System.out.println("uid 为空！");
            return;
        }

        User user = userService.findUser(Integer.parseInt(uid));
        System.out.println("即将修改：" + user);

        req.setAttribute("user", user);
        req.getRequestDispatcher("/view/update-user.jsp").forward(req, resp);

    }
}
