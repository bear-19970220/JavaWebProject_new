package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/25 17:16
 */
@WebServlet(value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");


        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("获取到用户信息：" + username + "-" + password);


        String remb = req.getParameter("rembPassword");
        if ("true".equalsIgnoreCase(remb)) {
            System.out.println("是否保存账户信息：" + "是");

            username = URLEncoder.encode(username, "UTF-8");
            password = URLEncoder.encode(password, "UTF-8");


            Cookie cookieUsername = new Cookie("username", username);
            Cookie cookiePassword = new Cookie("password", password);

            System.out.println("设置保留时长");
            cookieUsername.setMaxAge(7 * 24 * 60 * 60);
            cookiePassword.setMaxAge(7 * 24 * 60 * 60);

            resp.addCookie(cookieUsername);
            resp.addCookie(cookiePassword);
            System.out.println("保存成功");

        } else {
            System.out.println("是否保存账户信息：" + "否");
        }

        resp.sendRedirect(req.getContextPath() + "/welcome.jsp");

    }
}
