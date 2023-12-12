package org.lanqiao.dao;

import org.lanqiao.pojo.Users;

import java.util.List;

public interface UsersDao {
    //登录
    public List<Users> login(Users users);

    //查看是否同名  根据名字查询
    public List<Users>  findByName(String username);

    //注册
    public int reg(Users users);

}
