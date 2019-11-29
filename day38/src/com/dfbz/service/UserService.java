package com.dfbz.service;

import com.dfbz.domain.User;
import com.dfbz.exception.UserException;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/18 17:13
 */
public interface UserService {
    public abstract void login(User user) throws UserException;

    public abstract void regist(User user) throws UserException;

    public abstract List<User> showAllUser();

    public abstract void deleteUser(String username) throws UserException;
}
