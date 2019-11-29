package com.dfbz.servlet;

import com.dfbz.domain.Customer;
import com.dfbz.domain.User;
import com.dfbz.service.CustomerService;
import com.dfbz.service.UserService;
import com.dfbz.service.impl.CustomerServiceImpl;
import com.dfbz.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/20 9:51
 */
public class ShowAllServlet extends HttpServlet {

    private CustomerService customerService = new CustomerServiceImpl();


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerService.findAllCustomer();

        System.out.println("获取到了：" + customers);

        request.getSession().setAttribute("customers", customers);
        response.sendRedirect(request.getContextPath() + "/customermng.jsp");
    }
}
