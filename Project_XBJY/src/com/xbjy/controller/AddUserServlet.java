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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/3 12:42
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String deptId = req.getParameter("deptId");
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");
        String birthStr = req.getParameter("birthStr");

        User user = new User();
        user.setAccount(account);
        if(deptId != null && !deptId.isEmpty()) {
            user.setDeptId(Integer.parseInt(deptId));
        }
        user.setName(name);
        user.setPassword(password);
        user.setSex(Integer.parseInt(sex));
        user.setEmail(email);
        user.setCreateTime(new Date());

        if(birthStr != null && !birthStr.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date birth = null;
            try {
                birth = sdf.parse(birthStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            user.setBirth(birth);
        }

        System.out.println("请求添加：" + user);

        userService.addUser(user);

        req.getRequestDispatcher("/PageListUserServlet").forward(req, resp);






    }
}
