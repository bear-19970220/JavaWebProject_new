package com.dfbz.test;

import com.dfbz.dao.impl.UserDaoImpl;
import com.dfbz.domain.User;
import com.dfbz.utils.DruidUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/18 17:13
 */
public class UserTest {

    @Test
    public void test_findAllUser() throws SQLException {

        String username = "root";
        System.out.println(new UserDaoImpl().findUserByUsername(username));
    }
}
