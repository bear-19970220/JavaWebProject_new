package com.bear.usermng.service;

import com.bear.usermng.domain.PageBean;
import com.bear.usermng.domain.User;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/27 18:11
 */
public interface UserService {

    public abstract List<User> listUser();

    public abstract void updateUser(User user);

    public abstract void deleteUser(String uid);

    public abstract List<User> findUserByPage(PageBean pageBean);

    public abstract int getTotalRecord();

    public abstract void addUser(User user);
}
