package com.xbjy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.ws.util.StringUtils;
import com.xbjy.domain.User;
import com.xbjy.service.UserService;
import com.xbjy.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/4 17:42
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        // 设置编码
        req.setCharacterEncoding("utf-8");

        // 封装表单信息
        String account = req.getParameter("account");
        String password = req.getParameter("password");

        User userInfo = new User();
        userInfo.setAccount(account);
        userInfo.setPassword(password);

        // 错误信息
        String loginMsg;

        // 验证码校验
        String sessionVcode = (String) session.getAttribute("session_vcode");
        session.removeAttribute("session_vcode");
        if (sessionVcode != null) {
            String vcode = req.getParameter("vcode");
            System.out.println("云端验证码：" + sessionVcode + "，用户输入：" + vcode + "，验证" + (sessionVcode.equalsIgnoreCase(vcode) ? "通过" : "不通过") + "！");
            if (!sessionVcode.equalsIgnoreCase(vcode)) {
                loginMsg = "验证码错误！";
                req.setAttribute("loginMsg", loginMsg);
                req.setAttribute("userInfo", userInfo);
                req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
                return;
            }
        }


        // 输入校验
        if (account == null || account.isEmpty() || password == null || password.isEmpty()) {
            loginMsg = "请填写用户名密码！";
            req.setAttribute("loginMsg", loginMsg);
            req.setAttribute("userInfo", userInfo);
            req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
            return;
        }


        // 登录
        User user = userService.loginUser(userInfo);
        if (user == null) {
            loginMsg = "用户名或密码错误！";
            req.setAttribute("loginMsg", loginMsg);
            req.setAttribute("userInfo", userInfo);
            req.getRequestDispatcher("view/login.jsp").forward(req, resp);
            return;
        }

        // 记住密码：保存 Cookie
        String remberLogin = req.getParameter("remberLogin");
        if ("on".equalsIgnoreCase(remberLogin)) {
            // 将用户信息以 JSON 格式存储 Cookie
            ObjectMapper om = new ObjectMapper();
            String userInfo_jsonStr = om.writeValueAsString(userInfo);
            System.out.println("即将存入 Cookie：" + userInfo_jsonStr);
//            System.out.println("Cookie 编码后：" + URLEncoder.encode(userInfo_jsonStr, "utf-8"));
            Cookie cookie = new Cookie("userInfo", URLEncoder.encode(userInfo_jsonStr, "utf-8"));
            cookie.setMaxAge(7 * 24 * 60 * 60);
            cookie.setPath(req.getContextPath());
            resp.addCookie(cookie);
        } else {
            Cookie[] cookies = req.getCookies();
            if (cookies != null && cookies.length != 0) {
                for (Cookie c : cookies) {
                    if ("userInfo".equals(c.getName())) {
                        System.out.println("即将移除：" + c.getName() + "-" + c.getValue());
                        c.setMaxAge(0);
                        c.setPath(req.getContextPath());
                        resp.addCookie(c);
                        System.out.println("成功移除登录 Cookie ...");
                    }
                }
            }
        }


        // 登陆成功
        System.out.println("登录成功！");
        req.getSession().setAttribute("user", user);
        resp.sendRedirect(req.getContextPath() + "/PageListUserServlet");

    }

}
