package com.uplinfo.book.ubdata.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.uplinfo.book.ubdata.domain.Book;

/**
  * @ClassName: BookMapper
  * @Description:
  * @author: Ray Yu
  * @date:  August 2, 2018
  * @version: 1.0
  */
public interface BookMapper {

  void insertBook(Book book) throws DataAccessException;

  void updateBook(Book book) throws DataAccessException;

  void deleteBookById(String id) throws DataAccessException;
  
  Book getBookById(String id) throws DataAccessException;

  List<Book> getBookList() throws DataAccessException;
  
   int getBookCount(Map<String,Object> param) throws DataAccessException;

  List<Book> getBookListByPage(Map<String,Object> param) throws DataAccessException;
  
    
  Integer getIdByPosition(Map<String,Object> map) throws DataAccessException;
}
