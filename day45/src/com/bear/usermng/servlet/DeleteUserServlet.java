package com.bear.usermng.servlet;

import com.bear.usermng.service.UserService;
import com.bear.usermng.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/28 13:13
 */
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        String uid = req.getParameter("uid");
        String currentPage = req.getParameter("cp");

        userService.deleteUser(uid);

//        req.getRequestDispatcher("/ListUserServlet").forward(req, resp);
        req.getRequestDispatcher("/PageListUserServlet?cp=" + currentPage).forward(req, resp);
    }
}
