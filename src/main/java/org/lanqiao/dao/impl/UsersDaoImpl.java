package org.lanqiao.dao.impl;

import org.lanqiao.dao.UsersDao;
import org.lanqiao.pojo.Users;
import org.lanqiao.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UsersDaoImpl implements UsersDao {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    //登录
    @Override
    public List<Users> login(Users users) {
        List<Users> list = new ArrayList<Users>();
        try {
            //编写sql语句
            String sql = "select * from users where username=? and password =?";
            //sql语句的参数数组
            Object[] obj = {users.getUsername(), users.getPassword()};
            rs = JDBCUtil.exeQuery(sql, obj);
            //处理结果集
            while (rs.next()) {
                //数据库的数据存到实体类
                Users user = new Users(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("contact"),
                        rs.getString("mobilephone"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getInt("type"));
                //实体类存到集合
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtil.close(conn, pst, rs);
        }
        return list;
    }

    //根据名字查询
    @Override
    public List<Users> findByName(String username) {
        //创建list对象
        List<Users> list = new ArrayList<>();
        try {
            //编写sql语句
            String sql = "select * from users where username=?";
            //sql语句的参数数组
            Object[] obj = {username};
            //执行sql语句
            rs = JDBCUtil.exeQuery(sql, obj);
            //处理结果集
            while (rs.next()) {
                //数据库的数据存到实体类
                Users user = new Users(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("contact"),
                        rs.getString("mobilephone"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getInt("type"));
                //实体类存到集合
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtil.close(conn, pst, rs);
        }
        return list;
    }

    //注册
    @Override
    public int reg(Users users) {
        int i=0;
        //编写sql
        String sql = "insert into users values(0,?,?,?,?,?,?,?)";
//赋值
        Object [] obj={users.getUsername(),users.getPassword(),users.getContact(),users.getMobilephone(),users.getAddress(),users.getEmail(),users.getType()};
        //执行执行sql语句
        i=JDBCUtil.exechangc(sql,obj);
        return i;
    }
}
