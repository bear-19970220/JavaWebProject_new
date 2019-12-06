package com.xbjy.dao;

import com.xbjy.domain.User;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/2 20:01
 */
public interface UserDao {
    List<User> findAllUser();

    int getUserCount();
    int getUserCount(String condition);

    List<User> findAllUserByPage(int begin, int count);

    void addUser(User user);

    User findUserById(int uid);

    void updateUser(User user);

    List<User> findUserByCondition(String condition, int begin, int count);

    User findUserByAccountAndPassword(String account, String password);
}
