package com.dfbz.dao;

import com.dfbz.domain.Customer;
import com.dfbz.exception.UserException;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/20 19:05
 */
public interface CustomerDao {
    List<Customer> findAllCustomer();

    void deleteSelectedCustomer(String[] cids) throws UserException;

    void deleteCustomer(String cid);
}
