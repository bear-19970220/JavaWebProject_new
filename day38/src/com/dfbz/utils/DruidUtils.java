package com.dfbz.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/20 12:24
 */
public class DruidUtils {

    private static DataSource ds = null;

    static{
        Properties props = new Properties();
        try {
            props.load(DruidUtils.class.getClassLoader().getResourceAsStream("db_user.properties"));
            ds = DruidDataSourceFactory.createDataSource(props);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }

    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
