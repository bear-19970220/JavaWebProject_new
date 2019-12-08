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
 * @date 2019/12/4 10:00
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置编码
        req.setCharacterEncoding("utf-8");

        // 获取参数
        String uid = req.getParameter("uid");
        if (uid == null || uid.isEmpty()) {
            System.out.println("uid 为空");
            return;
        }
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

        // 封装对象
        userInfo.setUid(Integer.parseInt(uid));
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
        String updateUserMsg;
        if (account == null || password == null || account.isEmpty() || password.isEmpty()) {
            updateUserMsg = "账号密码不能为空";
            sendMessage(updateUserMsg, userInfo, req, resp);
            return;
        }

        if (account.length() < 3 || account.length() > 16) {
            updateUserMsg = "账号必须为3-16位的英文/数字/下划线";
            sendMessage(updateUserMsg, userInfo, req, resp);
            return;
        }

        if (password.length() < 6 || password.length() > 20) {
            updateUserMsg = "密码长度必须为6-20位";
            sendMessage(updateUserMsg, userInfo, req, resp);
            return;
        }

        if (passwordConfirm == null || passwordConfirm.isEmpty()) {
            updateUserMsg = "请再次确认密码";
            sendMessage(updateUserMsg, userInfo, req, resp);
            return;
        }
        if (!passwordConfirm.equals(password)) {
            updateUserMsg = "两次密码输入不一致";
            sendMessage(updateUserMsg, userInfo, req, resp);
            return;
        }

        if (name == null || name.isEmpty()) {
            updateUserMsg = "请填写客户姓名";
            sendMessage(updateUserMsg, userInfo, req, resp);
            return;
        }

        if (name.length() > 50) {
            updateUserMsg = "姓名长度不能超过50";
            sendMessage(updateUserMsg, userInfo, req, resp);
            return;
        }

        if (deptId == null || deptId.isEmpty()) {
            updateUserMsg = "请选择所属部门";
            sendMessage(updateUserMsg, userInfo, req, resp);
            return;
        }

        // 修改
        userService.updateUser(userInfo);
        System.out.println("成功修改：" + userInfo);

        // 跳转显示
        resp.sendRedirect(req.getContextPath() + "/PageListUserServlet");

    }

    /**
     * 回传信息
     *
     * @param updateUserMsg
     * @param userInfo
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void sendMessage(String updateUserMsg, User userInfo, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("updateUserMsg", updateUserMsg);
        request.setAttribute("userInfo", userInfo);
        request.getRequestDispatcher("/view/update-user.jsp").forward(request, response);
    }

}
