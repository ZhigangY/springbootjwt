package com.uplinfo.book.ubdata.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.uplinfo.book.ubdata.domain.BookValume;

/**
  * @ClassName: BookValumeMapper
  * @Description:
  * @author: Ray Yu
  * @date:  August 2, 2018
  * @version: 1.0
  */
public interface BookValumeMapper {

  void insertBookValume(BookValume bookValume) throws DataAccessException;

  void updateBookValume(BookValume bookValume) throws DataAccessException;

  void deleteBookValumeById(String id) throws DataAccessException;
  
  BookValume getBookValumeById(String id) throws DataAccessException;

  List<BookValume> getBookValumeList() throws DataAccessException;
  
   int getBookValumeCount(Map<String,Object> param) throws DataAccessException;

  List<BookValume> getBookValumeListByPage(Map<String,Object> param) throws DataAccessException;
  
    
  Integer getIdByPosition(Map<String,Object> map) throws DataAccessException;
}
