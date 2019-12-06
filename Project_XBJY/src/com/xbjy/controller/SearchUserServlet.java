package com.xbjy.controller;

import com.xbjy.domain.Page;
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
 * @date 2019/12/4 13:47
 */
@WebServlet("/SearchUserServlet")
public class SearchUserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    private static final Integer PAGE_SIZE = 5;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        String uname = req.getParameter("uname");
        String sex = req.getParameter("sex");
        String deptId = req.getParameter("deptId");

        // 条件拼接
        StringBuilder sb = new StringBuilder();
        if (uname != null && !uname.isEmpty()) {
            sb.append(" and name like \"%" + uname + "%\"");
        }
        if (sex != null && !sex.isEmpty()) {
            sb.append(" and sex = " + Integer.parseInt(sex));
        }
        if (deptId != null && !deptId.isEmpty()) {
            sb.append(" and dept_id = " + Integer.parseInt(deptId));
        }

        System.out.println("查询条件：" + sb);

        // 分页
        Page page = new Page();
        page.setCurrentPage(1);
        page.setPageSize(PAGE_SIZE);

        List<User> users = userService.searchUser(sb.toString(), page);
        users.forEach(x -> System.out.println(x));

        page.setBeanList(users);
        int totalRecord = userService.getTotalRecord(sb.toString());
        page.setTotalRecord(totalRecord);
        page.setTotalPage(totalRecord % PAGE_SIZE == 0 ? totalRecord / PAGE_SIZE : totalRecord / PAGE_SIZE + 1);

        System.out.println(page);


        req.setAttribute("page", page);
        req.getRequestDispatcher("/view/list-user.jsp").forward(req, resp);



    }
}
