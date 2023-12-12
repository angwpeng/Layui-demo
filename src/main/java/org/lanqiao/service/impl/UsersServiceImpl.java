package org.lanqiao.service.impl;

import org.lanqiao.dao.UsersDao;
import org.lanqiao.dao.impl.UsersDaoImpl;
import org.lanqiao.pojo.Users;
import org.lanqiao.service.UsersService;

import java.util.List;

public class UsersServiceImpl implements UsersService {

    @Override
    public List<Users> login(Users users) {
        //调用dao层的登录方法
        UsersDao usersDao = new UsersDaoImpl();
        List<Users> list = usersDao.login(users);
        return list;
    }

    //注册
    @Override
    public boolean reg(Users users) {
        boolean boo = false;
        //调用dao层的登录方法
        UsersDao usersDao = new UsersDaoImpl();
        int i = usersDao.reg(users);
        if(i>0){//注册成功
            boo = true;
        }
        return boo;
    }

    //根据名字查询
    @Override
    public List<Users> findByName(String username) {
        //调用dao层的登录方法
        UsersDao usersDao = new UsersDaoImpl();
        List<Users> list = usersDao.findByName(username);
        return list;
    }
}
