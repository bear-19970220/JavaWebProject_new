package com.dfbz.servlet;

import com.dfbz.domain.User;
import com.dfbz.exception.UserException;
import com.dfbz.service.UserService;
import com.dfbz.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/18 16:51
 */
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 处理编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");


        System.out.println("成功接收请求...");
        System.out.println("准备登录...");

        // 获取登录表单
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("成功获取账号密码：" + username + "-" + password);

        // 登陆校验
        User user = new User(username, password);
        try {
            userService.login(user);
            request.getSession().setAttribute("user", user);
//            response.sendRedirect(request.getContextPath() + "/welcome.jsp");
            request.getRequestDispatcher("/ShowAllServlet").forward(request, response);
        } catch (UserException e) {
            request.setAttribute("loginMsg", e.getMessage());
            request.setAttribute("userInput", user);

            System.out.println(request.getContextPath() + "/login.jsp");
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        }

    }
}
