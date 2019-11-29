package com.bear.usermng.test;

import com.bear.usermng.dao.UserDao;
import com.bear.usermng.dao.impl.UserDaoImpl;
import com.bear.usermng.domain.User;
import org.junit.Test;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/27 17:48
 */
public class UserTest {

    @Test
    public void test_dao() {
        UserDao userDao = new UserDaoImpl();
        List<User> users =  userDao.findAllUser();
        users.forEach(user-> System.out.println(user));
    }



}
