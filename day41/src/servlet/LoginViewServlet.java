package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/25 17:58
 */
@WebServlet(value = "/LoginViewServlet")
public class LoginViewServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = "";
        String password = "";

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equalsIgnoreCase("username")) {
                username = cookie.getValue();
                username = URLDecoder.decode(username, "UTF-8");
            }
            if (cookie.getName().equalsIgnoreCase("password")) {
                password = cookie.getValue();
                password = URLDecoder.decode(password, "UTF-8");
            }
        }

        System.out.println("查找存留信息：" + username + "-" + password);

        Map<String, String> userInput = new HashMap<>(2);
        userInput.put("username", username);
        userInput.put("password", password);

        System.out.println("即将发送至登录请求域：" + userInput);

        req.setAttribute("userInput", userInput);
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
