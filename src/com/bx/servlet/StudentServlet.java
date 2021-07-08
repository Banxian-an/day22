package com.bx.servlet;

import com.bx.entity.Users;
import com.bx.service.UsersService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/userServlet")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("html/text;charset=utf-8");
        Users users = new Users();
        UsersService us = new UsersService();

        List<Users> list = us.queryUsers(users);
        System.out.println(list);

        ObjectMapper mapper = new ObjectMapper();
        String msg = mapper.writeValueAsString(list);

        PrintWriter out = response.getWriter();
        out.print(msg);
        out.close();
    }
}
