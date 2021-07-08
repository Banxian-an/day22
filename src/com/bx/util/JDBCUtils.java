package com.bx.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * Druid 连接池工具类
 */
public class JDBCUtils {
    //定义DataSource变量
    private static DataSource ds;
    //加载配置文件 数据库连接池 连接数据库
    static {
        try {
            //1. 创建属性集对象 读取配置文件
            Properties p = new Properties();
            p.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //2.获取DataSource 连接池对象

            ds = DruidDataSourceFactory.createDataSource(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * 从连接池中获取一条连接线
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    /**
     * 关闭资源
     */
    public static void close(Statement statement,Connection connection) {
        /*if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        close(null,statement,connection);

    }

    public static void close(ResultSet resultSet,Statement statement,Connection connection){
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 获取连接池
     * @return
     */
    public static DataSource getDataSource(){
        return ds;
    }

}
