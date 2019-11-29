package com.dfbz.dao.impl;

import com.dfbz.dao.UserDao;
import com.dfbz.domain.User;
import com.dfbz.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/18 17:21
 */
public class UserDaoImpl implements UserDao {


    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());

    /**
     * 查找用户 by用户名
     *
     * @param username
     * @return
     */
    @Override
    public User findUserByUsername(String username) {
        String sql = "select * from t_user where username=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
    }



    /**
     * 添加用户
     *
     * @param user
     */
    @Override
    public void saveUser(User user) {
        String sql = "insert into t_user values(?,?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<User> findAllUser() {
        String sql = "select * from t_user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    @Override
    public void deleteUser(User userData) {
        String sql = "delete from t_user where username=?";
        jdbcTemplate.update(sql, userData.getUsername());
    }
}
