package com.bear.usermng.servlet;

import com.bear.usermng.domain.User;
import com.bear.usermng.service.UserService;
import com.bear.usermng.service.impl.UserServiceImpl;

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
 * @date 2019/11/27 18:10
 */

@WebServlet("/ListUserServlet")
public class ListUserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.listUser();
        req.getSession().setAttribute("users", users);
        resp.sendRedirect(req.getContextPath() + "/user/listUser.jsp");
    }
}
