package org.lanqiao.service;

import org.lanqiao.pojo.Users;

import java.util.List;

public interface UsersService {

    List<Users> login(Users users);

    boolean reg(Users users);

    List<Users> findByName(String username);
}
