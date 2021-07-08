package com.bx.service;

import com.bx.dao.UsersDao;
import com.bx.entity.Users;

import java.util.List;

public class UsersService {
    private UsersDao ud = new UsersDao();

    public List<Users> queryUsers(Users users) {
        List<Users> list = null;
        if (users != null) {
            list = ud.queryUsers(users);
        }
        return list;
    }
}

