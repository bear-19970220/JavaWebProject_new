package servlet;

import utils.VerifyCodeUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/21 13:33
 */
public class Demo01Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");


        String filename = request.getParameter("filename");

//        String mimeType = request.getServletContext().getMimeType(filename);

        InputStream is = request.getServletContext().getResourceAsStream("image/" + filename);


        filename = URLEncoder.encode(filename, "utf-8");
        response.setHeader("content-disposition", "attachment;filename=" + filename);

        OutputStream os = response.getOutputStream();
        byte[] buf = new byte[1024];
        int len;
        while ((len = is.read(buf)) != -1) {
            os.write(buf, 0, len);
        }


    }
}
