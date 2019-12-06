package com.xbjy.dao.impl;

import com.xbjy.dao.UserDao;
import com.xbjy.domain.User;
import com.xbjy.utils.DBUtils;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/2 20:02
 */
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DBUtils.createDataSource());

    @Override
    public User findUserByAccountAndPassword(String account, String password) {
        String sql = "select \n" +
                "u.id as uid,\n" +
                "u.dept_id as deptId,\n" +
                "d.name as dname,\n" +
                "u.account as account,\n" +
                "u.password as password,\n" +
                "u.name as name,\n" +
                "u.sex as sex,\n" +
                "u.email as email,\n" +
                "u.birth_date as birth,\n" +
                "u.create_time as createTime,\n" +
                "u.create_by as createBy,\n" +
                "u.del_flag as delFlag\n" +
                "from sys_user u\n" +
                "left outer join sys_dept d\n" +
                "on u.dept_id = d.id\n" +
                "where account = ? and password = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), account, password);

    }

    /**
     * 条件查询
     *
     * @param condition
     * @param begin
     * @param count
     * @return
     */
    @Override
    public List<User> findUserByCondition(String condition, int begin, int count) {
        String sql = "select \n" +
                "u.id as uid,\n" +
                "u.dept_id as deptId,\n" +
                "d.name as dname,\n" +
                "u.account as account,\n" +
                "u.password as password,\n" +
                "u.name as name,\n" +
                "u.sex as sex,\n" +
                "u.email as email,\n" +
                "u.birth_date as birth,\n" +
                "u.create_time as createTime,\n" +
                "u.create_by as createBy,\n" +
                "u.del_flag as delFlag\n" +
                "from sys_user u\n" +
                "left outer join sys_dept d\n" +
                "on u.dept_id = d.id\n" +
                "where 1 = 1" +
                condition + "\n" +
                "limit ?, ?";
        Object[] params = {begin, count};
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), params);
    }

    @Override
    public int getUserCount(String condition) {
        String sql = "select \n" +
                "count(*)" +
                "from sys_user u\n" +
                "where 1 = 1" +
                condition + "\n";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public void updateUser(User user) {
        String sql = "update sys_user set " +
                "dept_id = ?," +
                "account=?," +
                "password=?," +
                "name=?," +
                "sex=?," +
                "email=?," +
                "birth_date=?\n" +
                "where id=?";
        Object[] params = {user.getDeptId(), user.getAccount(), user.getPassword(), user.getName(), user.getSex(), user.getEmail(), user.getBirth(), user.getUid()};
        jdbcTemplate.update(sql, params);
    }

    @Override
    public User findUserById(int uid) {
        String sql = "select \n" +
                "u.id as uid,\n" +
                "u.dept_id as deptId,\n" +
                "d.name as dname,\n" +
                "u.account as account,\n" +
                "u.password as password,\n" +
                "u.name as name,\n" +
                "u.sex as sex,\n" +
                "u.email as email,\n" +
                "u.birth_date as birth,\n" +
                "u.create_time as createTime,\n" +
                "u.create_by as createBy,\n" +
                "u.del_flag as delFlag\n" +
                "from sys_user u\n" +
                "left outer join sys_dept d\n" +
                "on u.dept_id = d.id\n" +
                "where u.id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), uid);
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into sys_user" +
                "(dept_id, account, password, name, sex, email, birth_date, create_time) " +
                "values(?,?,?,?,?,?,?,?)";
        Object[] params = {user.getDeptId(), user.getAccount(), user.getPassword(), user.getName(),
                user.getSex(), user.getEmail(), user.getBirth(), user.getCreateTime()};

        jdbcTemplate.update(sql, params);
    }

    @Override
    public List<User> findAllUserByPage(int begin, int count) {
        String sql = "select \n" +
                "u.id as uid,\n" +
                "u.dept_id as deptId,\n" +
                "d.name as dname,\n" +
                "u.account as account,\n" +
                "u.password as password,\n" +
                "u.name as name,\n" +
                "u.sex as sex,\n" +
                "u.email as email,\n" +
                "u.birth_date as birth,\n" +
                "u.create_time as createTime,\n" +
                "u.create_by as createBy,\n" +
                "u.del_flag as delFlag\n" +
                "from sys_user u\n" +
                "left outer join sys_dept d\n" +
                "on u.dept_id = d.id\n" +
                "limit ?, ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), begin, count);
    }


    @Override
    public int getUserCount() {
        String sql = "select count(*) from sys_user";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public List<User> findAllUser() {
        String sql = "select \n" +
                "u.id as uid,\n" +
                "d.name as dname,\n" +
                "u.dept_id as deptId,\n" +
                "u.account as account,\n" +
                "u.password as password,\n" +
                "u.name as name,\n" +
                "u.sex as sex,\n" +
                "u.email as email,\n" +
                "u.birth_date as birth,\n" +
                "u.create_time as createTime,\n" +
                "u.create_by as createBy,\n" +
                "u.del_flag as delFlag\n" +
                "from sys_user u\n" +
                "left outer join sys_dept d\n" +
                "on u.dept_id = d.id";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Test
    public void test() {
        System.out.println(findUserByAccountAndPassword("jiguang", "123"));
    }
}
