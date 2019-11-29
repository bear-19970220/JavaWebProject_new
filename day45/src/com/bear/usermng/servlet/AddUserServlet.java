package com.bear.usermng.servlet;

import com.bear.usermng.domain.User;
import com.bear.usermng.service.UserService;
import com.bear.usermng.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
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
 * @date 2019/11/29 14:14
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

//        System.out.println(req.getParameter("birth"));

//        String uid = req.getParameter("uid");
        String uname = req.getParameter("uname");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String birthStr = req.getParameter("birthStr");
        String email = req.getParameter("email");

        User user = new User();
//        user.setUid(Long.parseLong(uid));
        user.setUname(uname);
        user.setSex(sex);
        if (age != null && !age.isEmpty()) {
            user.setAge(Integer.parseInt(age));
        }

        Date birth = null;
        if (birthStr != null && !birthStr.isEmpty()) {
            try {
//            birth = new SimpleDateFormat("yyyy年MM月dd日").parse(birthStr);
                birth = new SimpleDateFormat("yyyy-MM-dd").parse(birthStr);
            } catch (ParseException e) {
                System.out.println("日期转换失败");
                e.printStackTrace();
            }
        }
        user.setBirth(birth);
        user.setEmail(email);

        userService.addUser(user);
        System.out.println("获取到新用户：" + user);

        System.out.println("总记录数" + userService.getTotalRecord());
        int totalPage = userService.getTotalRecord() % 5 == 0 ? userService.getTotalRecord() / 5 : userService.getTotalRecord() / 5 + 1;
        System.out.println("末页" + totalPage);

//        req.getRequestDispatcher("/PageListUserServlet?cp=" + currentPage).forward(req, resp);
//        req.getRequestDispatcher("/PageListUserServlet?cp=" + totalPage).forward(req, resp);
        resp.getWriter().append(String.valueOf(totalPage));
    }
}
