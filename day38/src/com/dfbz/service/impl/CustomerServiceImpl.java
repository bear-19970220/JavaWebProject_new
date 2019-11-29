package com.dfbz.service.impl;

import com.dfbz.dao.CustomerDao;
import com.dfbz.dao.impl.CustomerDaoImpl;
import com.dfbz.domain.Customer;
import com.dfbz.exception.UserException;
import com.dfbz.service.CustomerService;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/20 19:04
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public List<Customer> findAllCustomer() {
        return customerDao.findAllCustomer();
    }

    @Override
    public void deleteSelectedCustomer(String[] cids) throws UserException {
        customerDao.deleteSelectedCustomer(cids);
    }

    @Override
    public void deleteCustomer(String cid) {
        customerDao.deleteCustomer(cid);
    }
}
