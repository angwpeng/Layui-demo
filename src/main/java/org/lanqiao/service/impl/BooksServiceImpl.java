package org.lanqiao.service.impl;

import org.lanqiao.dao.BooksDao;
import org.lanqiao.dao.impl.BooksDaoImpl;
import org.lanqiao.pojo.Books;
import org.lanqiao.pojo.Category;
import org.lanqiao.service.BooksService;

import java.util.List;

public class BooksServiceImpl implements BooksService {
   //查询所有图书类别
    @Override
    public List<Category> findAllType() {
        //调用dao层方法
        BooksDao booksDao = new BooksDaoImpl();

        return booksDao.findAllType();
    }

    @Override
    public List<Books> findAllBooks(String page,String limit) {
        //调用dao层方法
        BooksDao booksDao = new BooksDaoImpl();
        //计算分页查询时候的起始值
        int startNum = (Integer.parseInt(page)-1)*Integer.valueOf(limit);
        return booksDao.findAllBooks(startNum,Integer.valueOf(limit));
    }

    @Override
    public List<Books> findByCid(String cid) {
        //调用dao层方法
        BooksDao booksDao = new BooksDaoImpl();

        return booksDao.findByCid(cid);

    }

    @Override
    public int count() {
        BooksDao booksDao = new BooksDaoImpl();

        int count = booksDao.count();

        return count;
    }

    @Override
    public boolean del(String[] bid) {
        BooksDao booksDao = new BooksDaoImpl();
        int i = booksDao.del(bid);
        boolean boo = false;
        if(i>0){
            boo = true;
        }
        return boo;
    }
}
