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
import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/2 19:57
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = new UserServiceImpl();

        List<User> users = userService.listUser();

        req.setAttribute("users", users);
        req.getRequestDispatcher("/view/list-user.jsp").forward(req, resp);

    }
}
