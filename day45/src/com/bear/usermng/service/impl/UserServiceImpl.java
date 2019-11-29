package com.bear.usermng.service.impl;

import com.bear.usermng.dao.UserDao;
import com.bear.usermng.dao.impl.UserDaoImpl;
import com.bear.usermng.domain.PageBean;
import com.bear.usermng.domain.User;
import com.bear.usermng.service.UserService;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/27 18:12
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> listUser() {
        return userDao.findAllUser();
    }


    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(String uid) {
        User user = userDao.findUserById(uid);
        if(user!=null) {
            userDao.deleteUser(uid);
            System.out.println("已删除");
        } else {
            System.out.println("该用户不存在！");
        }
    }

    @Override
    public int getTotalRecord() {
        return userDao.getTotalRecord();
    }

    @Override
    public List<User> findUserByPage(PageBean pageBean) {
        return userDao.findUserByPage(pageBean);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}

