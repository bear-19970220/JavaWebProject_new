package com.bear.usermng.dao;

import com.bear.usermng.domain.PageBean;
import com.bear.usermng.domain.User;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/27 17:02
 */
public interface UserDao {

    public abstract List<User> findAllUser();


    public abstract void updateUser(User user);

    public abstract User findUserById(String uid);

    public abstract void deleteUser(String uid);

    public abstract List<User> findUserByPage(PageBean pageBean);

    public abstract int getTotalRecord();

    public abstract void addUser(User user);
}
