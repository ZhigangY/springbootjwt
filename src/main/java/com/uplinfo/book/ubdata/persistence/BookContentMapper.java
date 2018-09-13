package com.uplinfo.book.ubdata.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.uplinfo.book.ubdata.domain.BookContent;

/**
  * @ClassName: BookContentMapper
  * @Description:
  * @author: Ray Yu
  * @date:  August 2, 2018
  * @version: 1.0
  */
public interface BookContentMapper {

  void insertBookContent(BookContent bookContent) throws DataAccessException;

  void updateBookContent(BookContent bookContent) throws DataAccessException;

  void deleteBookContentById(String id) throws DataAccessException;
  
  BookContent getBookContentById(String id) throws DataAccessException;

  List<BookContent> getBookContentList() throws DataAccessException;
  
   int getBookContentCount(Map<String,Object> param) throws DataAccessException;

  List<BookContent> getBookContentListByPage(Map<String,Object> param) throws DataAccessException;
  
    
  Integer getIdByPosition(Map<String,Object> map) throws DataAccessException;
}
