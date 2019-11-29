package com.dfbz.dao;

import com.dfbz.domain.User;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/18 17:13
 */
public interface UserDao {


    public abstract User findUserByUsername(String username);

    public abstract void saveUser(User user);

    public abstract List<User> findAllUser();

    public abstract void deleteUser(User userData);
}
