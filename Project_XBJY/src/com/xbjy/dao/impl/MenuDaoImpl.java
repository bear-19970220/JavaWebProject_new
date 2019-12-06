package com.xbjy.dao.impl;

import com.xbjy.dao.MenuDao;
import com.xbjy.domain.Menu;
import com.xbjy.utils.DBUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/2 11:22
 */
public class MenuDaoImpl implements MenuDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DBUtils.createDataSource());

    @Override
    public List<Menu> findAllMenuItem() {
        String sql = "select * from sys_menu";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Menu.class));
    }

    @Test
    public void test_dao() {
        findAllMenuItem().forEach(m-> System.out.println(m));
    }




}
