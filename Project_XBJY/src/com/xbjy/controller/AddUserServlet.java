package com.xbjy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.HashMap;
import java.util.Map;

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

        // 设置编码
        req.setCharacterEncoding("utf-8");

        // 获取参数
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("passwordConfirm");
        String name = req.getParameter("uname");
        String deptId = req.getParameter("deptId");
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");
        String birthStr = req.getParameter("birthStr");

        // 表单输入对象
        User userInfo = new User();

        // 封装表单信息
        userInfo.setAccount(account);
        if (deptId != null && !deptId.isEmpty()) {
            userInfo.setDeptId(Integer.parseInt(deptId));
        }
        userInfo.setName(name);
        userInfo.setPassword(password);
        if (sex != null && !sex.isEmpty()) {
            userInfo.setSex(Integer.parseInt(sex));
        }
        userInfo.setEmail(email);
        userInfo.setCreateTime(new Date());
        if (birthStr != null && !birthStr.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date birth = null;
            try {
                birth = sdf.parse(birthStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            userInfo.setBirth(birth);
        }

        // 输入校验
        String addUserMsg;
        if (account == null || password == null || account.isEmpty() || password.isEmpty()) {
            addUserMsg = "账号密码不能为空";
            sendMessage(addUserMsg, userInfo, req, resp);
            return;
        }

        if (account.length() < 3 || account.length() > 16) {
            addUserMsg = "账号必须为3-16位的英文/数字/下划线";
            sendMessage(addUserMsg, userInfo, req, resp);
            return;
        }

        if (password.length() < 6 || password.length() > 20) {
            addUserMsg = "密码长度必须为6-20位";
            sendMessage(addUserMsg, userInfo, req, resp);
            return;
        }

        if (passwordConfirm == null || passwordConfirm.isEmpty()) {
            addUserMsg = "请再次确认密码";
            sendMessage(addUserMsg, userInfo, req, resp);
            return;
        }
        if (!passwordConfirm.equals(password)) {
            addUserMsg = "两次密码输入不一致";
            sendMessage(addUserMsg, userInfo, req, resp);
            return;
        }

        if (name == null || name.isEmpty()) {
            addUserMsg = "请填写客户姓名";
            sendMessage(addUserMsg, userInfo, req, resp);
            return;
        }

        if (name.length() > 50) {
            addUserMsg = "姓名长度不能超过50";
            sendMessage(addUserMsg, userInfo, req, resp);
            return;
        }

        if (deptId == null || deptId.isEmpty()) {
            addUserMsg = "请选择所属部门";
            sendMessage(addUserMsg, userInfo, req, resp);
            return;
        }

        // 添加
        userService.addUser(userInfo);
        System.out.println("已成功添加：" + userInfo);

        // 回传结果
        req.setAttribute("resultFlag", 1);
        req.getRequestDispatcher("/view/add-user.jsp").forward(req, resp);
    }

    /**
     * 回传信息
     *
     * @param addUserMsg
     * @param userInfo
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void sendMessage(String addUserMsg, User userInfo, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("addUserMsg", addUserMsg);
        request.setAttribute("userInfo", userInfo);
        request.getRequestDispatcher("/view/add-user.jsp").forward(request, response);
    }

}
