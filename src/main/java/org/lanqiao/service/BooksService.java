package org.lanqiao.service;

import org.lanqiao.pojo.Books;
import org.lanqiao.pojo.Category;

import java.util.List;

public interface BooksService {
    List<Category> findAllType();


    List<Books> findAllBooks(String page,String limit);

    List<Books> findByCid(String cid);

    int count();

    boolean del(String[] bid);
}
