package com.xbjy.dao.impl;

import com.xbjy.dao.DeptDao;
import com.xbjy.domain.Dept;
import com.xbjy.utils.DBUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/2 19:13
 */
public class DeptDaoImpl implements DeptDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DBUtils.createDataSource());

    @Override
    public List<Dept> findAllDept() {
        String sql = "select * from sys_dept";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dept.class));
    }

    @Test
    public void test() {
        findAllDept().forEach(x-> System.out.println(x));
    }

}
