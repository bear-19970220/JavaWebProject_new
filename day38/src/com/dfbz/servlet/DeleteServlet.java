package com.dfbz.servlet;

import com.dfbz.domain.Customer;
import com.dfbz.exception.UserException;
import com.dfbz.service.CustomerService;
import com.dfbz.service.UserService;
import com.dfbz.service.impl.CustomerServiceImpl;
import com.dfbz.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {

    private CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String cid = request.getParameter("cid");
        System.out.println("即将删除：" + cid);

        try {
            customerService.deleteCustomer(cid);
            request.getRequestDispatcher("/ShowAllServlet").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/customermng.jsp").forward(request, response);
        }
    }
}
