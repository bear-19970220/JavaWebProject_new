package com.xbjy.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/2 11:24
 */
public class DBUtils {

    private static DataSource ds;

    static {
        Properties props = new Properties();
        try {
            props.load(DBUtils.class.getResourceAsStream("/db.properties"));
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
