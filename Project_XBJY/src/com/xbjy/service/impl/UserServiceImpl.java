package com.xbjy.service.impl;

import com.xbjy.dao.UserDao;
import com.xbjy.dao.impl.UserDaoImpl;
import com.xbjy.domain.Page;
import com.xbjy.domain.User;
import com.xbjy.service.UserService;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/2 20:01
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> listUser() {
        return userDao.findAllUser();
    }

    @Override
    public int getTotalRecord() {
        return userDao.getUserCount();
    }

    @Override
    public int getTotalRecord(String condition) {
        return userDao.getUserCount(condition);
    }

    @Override
    public User loginUser(User userInfo) {
        User user = null;
        try {
            user = userDao.findUserByAccountAndPassword(userInfo.getAccount(), userInfo.getPassword());
        } catch (RuntimeException e) {
            System.out.println("查询失败！");
        }
        return user;
    }

    @Override
    public List<User> searchUser(String condition, Page page) {
        return userDao.findUserByCondition(condition, (page.getCurrentPage() - 1) * page.getPageSize(), page.getPageSize());
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User findUser(int uid) {
        return userDao.findUserById(uid);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> pageListUser(Page page) {
        return userDao.findAllUserByPage((page.getCurrentPage() - 1) * page.getPageSize(), page.getPageSize());
    }
}
