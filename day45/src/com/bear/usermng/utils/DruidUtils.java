package com.bear.usermng.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.*;
import java.util.Properties;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/27 17:12
 */
public class DruidUtils {

    private static Properties props;
    private static DataSource ds = null;

    static {
        props = new Properties();
        try {
            props.load(DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(props);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource createDataSource() {
        return ds;
    }
}


