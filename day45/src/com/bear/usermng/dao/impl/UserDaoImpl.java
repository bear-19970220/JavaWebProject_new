package com.bear.usermng.dao.impl;

import com.bear.usermng.dao.UserDao;
import com.bear.usermng.domain.PageBean;
import com.bear.usermng.domain.User;
import com.bear.usermng.utils.DruidUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/27 17:03
 */
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.createDataSource());

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<User> findAllUser() {
        String sql = "select * from t_user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    /**
     * 修改用户
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
        String sql = "update t_user set uname=?,sex=?,age=?,birth=?,email=? where uid=?";
        Object[] params = {user.getUname(), user.getSex(), user.getAge(), user.getBirth(), user.getEmail(), user.getUid()};
        jdbcTemplate.update(sql, params);
    }

    /**
     * 按 ID 查询用户
     *
     * @param uid
     * @return
     */
    @Override
    public User findUserById(String uid) {
        String sql = "select * from t_user where uid=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), uid);
    }

    /**
     * 删除用户
     *
     * @param uid
     */
    @Override
    public void deleteUser(String uid) {
        String sql = "delete from t_user where uid=?";
        jdbcTemplate.update(sql, uid);
    }

    /**
     * 查询总记录数
     *
     * @return
     */
    @Override
    public int getTotalRecord() {
        String sql = "select count(*) from t_user";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    /**
     * 分页查询
     *
     * @param pageBean
     * @return
     */
    @Override
    public List<User> findUserByPage(PageBean pageBean) {
        String sql = "select * from t_user limit ?,?";
        Object[] params = {(pageBean.getCurrentPage() - 1) * pageBean.getPageSize(), pageBean.getPageSize()};
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), params);
    }

    /**
     * 测试
     */
    @Test
    public void test_dao() {
        PageBean page = new PageBean();
        page.setPageSize(5);
        page.setCurrentPage(3);
        List<User> users = findUserByPage(page);
        users.forEach(u -> System.out.println(u));
    }


    /**
     * 添加用户
     * @param user
     */
    @Override
    public void addUser(User user) {
        String sql = "insert into t_user(uname,sex,age,birth,email) values(?,?,?,?,?)";
        Object[] params = {user.getUname(), user.getSex(), user.getAge(), user.getBirth(), user.getEmail()};
        jdbcTemplate.update(sql, params);
    }
}
