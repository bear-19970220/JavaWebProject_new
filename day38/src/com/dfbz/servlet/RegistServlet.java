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
 * @date 2019/11/18 18:03
 */
public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 封装参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);

        System.out.println(user);

        try {
            userService.regist(user);
            System.out.println("注册成功！");
            System.out.println("正在前往登录页面...");
            request.setAttribute("registMsg","success");
            request.setAttribute("userInput", user);
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
        } catch (UserException e) {
            request.setAttribute("registMsg", e.getMessage());
            request.setAttribute("userInput", user);
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
        }
    }
}
