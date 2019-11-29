package com.dfbz.servlet;


import com.dfbz.domain.Customer;
import com.dfbz.exception.UserException;
import com.dfbz.service.CustomerService;
import com.dfbz.service.impl.CustomerServiceImpl;
import com.mysql.fabric.xmlrpc.base.Array;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/21 10:48
 */
public class DeleteSelectedServlet extends HttpServlet {

    private CustomerService customerService = new CustomerServiceImpl();


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Map<String, String[]> map = request.getParameterMap();
//        map.forEach((s, ss)-> System.out.println(s + Arrays.toString(ss)));

        String[] cids = map.get("cid");
        try {
            customerService.deleteSelectedCustomer(cids);
            request.getRequestDispatcher("/ShowAllServlet").forward(request, response);


        } catch (UserException e) {
            e.printStackTrace();
        }


    }
}
