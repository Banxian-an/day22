package com.bx.dao;

import com.bx.entity.Users;
import com.bx.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UsersDao {
    public List<Users> queryUsers(Users users) {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from users";
        List<Users> list = null;
        try {
             list = qr.query(sql, new BeanListHandler<>(Users.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
