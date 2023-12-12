package org.lanqiao.dao;

import org.lanqiao.pojo.Books;
import org.lanqiao.pojo.Category;

import java.util.List;

public interface BooksDao {
    List<Category> findAllType();


    List<Books> findAllBooks(int startNum);

    List<Books> findByCid(String cid);

    int count();
}
