package com.xbjy.controller;

import com.xbjy.utils.VCodeUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/4 19:45
 */
@WebServlet("/VCodeServlet")
public class VCodeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int size = 4;
        int width = 100;
        int height = 50;
        ServletOutputStream os = resp.getOutputStream();

        String vcode = VCodeUtils.generateVerifyCode(size);
        System.out.println("验证码已生成：" + vcode);

        req.getSession().setAttribute("session_vcode", vcode);

        VCodeUtils.outputImage(width, height, os, vcode);

    }
}
