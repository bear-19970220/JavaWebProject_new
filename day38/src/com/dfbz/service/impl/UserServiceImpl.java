package com.dfbz.service.impl;

import com.dfbz.dao.UserDao;
import com.dfbz.dao.impl.UserDaoImpl;
import com.dfbz.domain.User;
import com.dfbz.exception.UserException;
import com.dfbz.service.UserService;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/18 17:19
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void login(User user) throws UserException {
        User userData = userDao.findUserByUsername(user.getUsername());
        if (userData != null && userData.getPassword().equals(user.getPassword())) {
            return;
        } else {
            throw new UserException("账号或密码错误！");
        }
    }

    @Override
    public void regist(User user) throws UserException {
        if (userDao.findUserByUsername(user.getUsername()) == null) {
            userDao.saveUser(user);
        } else {
            throw new UserException("该用户已存在！");
        }
    }

    @Override
    public List<User> showAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public void deleteUser(String cid) throws UserException {
        User userData = userDao.findUserByUsername(cid);
        if(userData == null) {
            throw new UserException("查无此用户");
        }
        userDao.deleteUser(userData);


    }
}
