package com.bear.usermng.servlet;

import com.bear.usermng.domain.User;
import com.bear.usermng.service.UserService;
import com.bear.usermng.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/27 19:23
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

//        System.out.println(req.getParameter("birth"));

        String uid = req.getParameter("uid");
        String uname = req.getParameter("uname");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String birthStr = req.getParameter("birthStr");
        String email = req.getParameter("email");
        // 获取当前页
        String currentPage = req.getParameter("cp");

        User user = new User();
        user.setUid(Long.parseLong(uid));
        user.setUname(uname);
        user.setSex(sex);
        user.setAge(Integer.parseInt(age));
        Date birth = null;
        try {
//            birth = new SimpleDateFormat("yyyy年MM月dd日").parse(birthStr);
            birth = new SimpleDateFormat("yyyy-MM-dd").parse(birthStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setBirth(birth);
        user.setEmail(email);

        userService.updateUser(user);
        System.out.println("已更新：" + user);

//        req.getRequestDispatcher("/ListUserServlet").forward(req, resp);
        req.getRequestDispatcher("/PageListUserServlet?cp=" + currentPage).forward(req, resp);

    }
}
