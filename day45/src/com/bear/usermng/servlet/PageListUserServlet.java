package com.bear.usermng.servlet;

import com.bear.usermng.domain.PageBean;
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

@WebServlet(value = "/PageListUserServlet")
public class PageListUserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取当前页数
        String currentPage = request.getParameter("cp");

        PageBean pageBean = new PageBean();

        // 设置当前页
        if (currentPage != null) {
            pageBean.setCurrentPage(Integer.parseInt(currentPage));
        } else {
            pageBean.setCurrentPage(1);
        }
        pageBean.setPageSize(5);
        // 查询并设置总记录数
        int totalRecord = userService.getTotalRecord();
        pageBean.setTotalRecord(totalRecord);
        // 查询并设置查询页的记录对象集合
        List<User> users = userService.findUserByPage(pageBean);
        System.out.println("分页查询结果：" + users);


        if (users == null || users.size() == 0) {
            if (pageBean.getCurrentPage() > 1) {
                System.out.println("此页无结果，尝试查询上一页...");
                currentPage = String.valueOf(Integer.parseInt(currentPage) - 1);
                request.getRequestDispatcher("/PageListUserServlet?cp=" + currentPage).forward(request, response);
                return;
            } else {
                System.out.println("无结果");
            }
        }

        pageBean.setUsers(users);

        // 存储数据，跳转页面
        request.getSession().setAttribute("pageBean", pageBean);
        response.sendRedirect(request.getContextPath() + "/user/listUser.jsp" + "?cp=" + pageBean.getCurrentPage());

    }
}
