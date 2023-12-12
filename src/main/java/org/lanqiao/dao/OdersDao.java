package org.lanqiao.dao;

import org.lanqiao.pojo.Orders;

import java.util.List;

public interface OdersDao {
    int findAllCount(String username);

    List<Orders> findAll(String username, int startNum);
}
