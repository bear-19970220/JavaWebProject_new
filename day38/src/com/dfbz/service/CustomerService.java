package com.dfbz.service;

import com.dfbz.domain.Customer;
import com.dfbz.exception.UserException;

import java.util.List;

public interface CustomerService {

    List<Customer> findAllCustomer();



    void deleteSelectedCustomer(String[] cids) throws UserException;

    void deleteCustomer(String cid);
}
