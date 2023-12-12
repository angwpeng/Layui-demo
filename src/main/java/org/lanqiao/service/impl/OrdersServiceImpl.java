package org.lanqiao.service.impl;

import org.lanqiao.dao.OdersDao;
import org.lanqiao.dao.impl.OrdersDaoImpl;
import org.lanqiao.pojo.Orders;
import org.lanqiao.service.OrdersService;

import java.util.List;

public class OrdersServiceImpl implements OrdersService {
    @Override
    public List<Orders> findAll(String username, int startNum) {
        OdersDao odersDao = new OrdersDaoImpl();

        return odersDao.findAll(username,startNum);
    }

    @Override
    public int findAllCount(String username) {
        OdersDao odersDao = new OrdersDaoImpl();

        return odersDao.findAllCount(username);
    }
}
