package org.lanqiao.dao.impl;

import org.lanqiao.dao.OdersDao;
import org.lanqiao.pojo.Orders;
import org.lanqiao.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrdersDaoImpl implements OdersDao {
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public int findAllCount(String username) {
        int count = 0;
        try {
            String sql = "select count(*) count from orders o,users u where o.uid = u.uid and username = ?";
            Object[] obj = {username};
            rs = JDBCUtil.exeQuery(sql,obj);
            while (rs.next()){
                  count=  rs.getInt("count");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,pst,rs);
        }
     return  count;
    }

    @Override
    public List<Orders> findAll(String username, int startNum) {
       List<Orders> list = new ArrayList<Orders>();
        try {
            String sql = "select *  from orders o,users u where o.uid = u.uid and username = ? limit ?,3";
            Object[] obj = {username,startNum};
            rs = JDBCUtil.exeQuery(sql,obj);
            while (rs.next()){
                    Orders orders = new Orders(

                    );
                    list.add(orders);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,pst,rs);
        }
        return  list;
    }
}
