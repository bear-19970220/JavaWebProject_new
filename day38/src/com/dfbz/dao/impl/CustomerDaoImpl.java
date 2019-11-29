package com.dfbz.dao.impl;

import com.dfbz.dao.CustomerDao;
import com.dfbz.domain.Customer;
import com.dfbz.exception.UserException;
import com.dfbz.utils.DruidUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/20 19:05
 */
public class CustomerDaoImpl implements CustomerDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());

    @Override
    public List<Customer> findAllCustomer() {
        return jdbcTemplate.query("select * from t_customer", new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    @Override
    public void deleteSelectedCustomer(String[] cids) throws UserException {
        StringBuilder sql = new StringBuilder("delete from t_customer where cid in(");
        for (int i = 0; i < cids.length; i++) {
            sql.append(cids[i]);
            if (i < cids.length - 1) {
                sql.append(",");
            }
        }
        sql.append(")");

        System.out.println(sql.toString());
        try {
            jdbcTemplate.update(sql.toString());
        } catch (Exception e) {
            throw new UserException("删除失败");
        }
    }


    @Override
    public void deleteCustomer(String cid) {
        String sql = "delete from t_customer where cid=?";
        jdbcTemplate.update(sql, cid);
    }
}
