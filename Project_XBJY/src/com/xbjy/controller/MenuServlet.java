package com.xbjy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xbjy.domain.Menu;
import com.xbjy.service.MenuService;
import com.xbjy.service.impl.MenuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/2 12:24
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {

    private static final String TYPE_DAD = "1";
    private static final String TYPE_SON = "2";

    private MenuService menuService = new MenuServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        resp.setContentType("text/html;charset=utf-8");

        List<Menu> menus = menuService.listMenu();

        // 分类
        List<Menu> dadMenus = new ArrayList<>();
        List<Menu> sonMenus = new ArrayList<>();
        menus.forEach(m -> {
            if (TYPE_DAD.equals(m.getType())) {
                dadMenus.add(m);
            } else if (TYPE_SON.equals(m.getType())) {
                sonMenus.add(m);
            }
        });

        Map<String, List<Menu>> data = new HashMap<>();
        data.put("dad", dadMenus);
        data.put("son", sonMenus);

        ObjectMapper om = new ObjectMapper();
        resp.getWriter().append(om.writeValueAsString(data));

    }
}
