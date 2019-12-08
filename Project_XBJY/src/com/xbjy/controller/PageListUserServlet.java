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
import java.util.Map;

/**
 * 条件分页查询
 *
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/3 14:49
 */
@WebServlet("/PageListUserServlet")
public class PageListUserServlet extends HttpServlet {

    private static final Integer PAGE_SIZE = 5;

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");


        // 获取查询条件
        String uname = req.getParameter("uname");
        String sex = req.getParameter("sex");
        String deptId = req.getParameter("deptId");


        // 获取来自【修改】的查询条件
        Map<String, String> updateCdMap = (Map<String, String>) req.getSession().getAttribute("updateCdMap");
        if (updateCdMap != null && updateCdMap.size() != 0) {
            System.out.println("分页 Servlet 接收到修改条件Map：");
            updateCdMap.forEach((k, v) -> System.out.println(k + '-' + v));
        }
        uname = updateCdMap.get("uname");
        sex = updateCdMap.get("sex");
        deptId = updateCdMap.get("deptId");


        // 封装条件
        User cdUser = new User();

        // 条件拼接
        StringBuilder sb = new StringBuilder();
        if (uname != null && !uname.isEmpty()) {
            sb.append(" and u.name like \"%" + uname + "%\"");
            cdUser.setName(uname);
        }
        if (sex != null && !sex.isEmpty()) {
            sb.append(" and u.sex = " + Integer.parseInt(sex));
            cdUser.setSex(Integer.parseInt(sex));
        }
        if (deptId != null && !deptId.isEmpty()) {
            sb.append(" and u.dept_id = " + Integer.parseInt(deptId));
            cdUser.setDeptId(Integer.parseInt(deptId));
        }
        System.out.println("查询条件：" + sb);

        // 获取当前页
        String currentPage = req.getParameter("cp");

        // 填充 PageBean
        Page<User> page = new Page<User>();
        // 当前页
        page.setCurrentPage(currentPage == null ? 1 : Integer.parseInt(currentPage));
        // 页容
        page.setPageSize(PAGE_SIZE);

        // 页面数据
//        List<User> users = userService.pageListUser(page);    // 无条件查询
        List<User> users = userService.searchUser(sb.toString(), page);
//        System.out.println("查询结果：");
//        users.forEach(x-> System.out.println(x));
        page.setBeanList(users);

        // 总记录数
        int totalRecord = userService.getTotalRecord(sb.toString());
//        int totalRecord = users.size();   // 不可以：查询结果一次只有 5 条！
        page.setTotalRecord(totalRecord);
        // 总页数
        page.setTotalPage(totalRecord % PAGE_SIZE == 0 ? totalRecord / PAGE_SIZE : totalRecord / PAGE_SIZE + 1);

        System.out.println(page);
        req.setAttribute("cdUser", cdUser);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/view/list-user.jsp").forward(req, resp);

    }
}
