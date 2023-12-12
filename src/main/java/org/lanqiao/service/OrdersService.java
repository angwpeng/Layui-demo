package org.lanqiao.service;

import org.lanqiao.pojo.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> findAll(String s, int username);

    int findAllCount(String username);
}
