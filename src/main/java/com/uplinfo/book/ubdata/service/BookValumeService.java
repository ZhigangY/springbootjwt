package com.uplinfo.book.ubdata.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uplinfo.book.ubdata.domain.BookValume;
import com.uplinfo.book.ubdata.persistence.BookValumeMapper;

/**
  * @ClassName: BookValumeService
  * @Description:
  * @author: Ray Yu
  * @date:  August 2, 2018
  * @version: 1.0
  */
@Service
public class BookValumeService {
	
	private final static Log logger = LogFactory.getLog(BookValumeService.class);

	@Autowired
	private BookValumeMapper bookValumeMapper;

	/**
	 * insert BookValume
	 * @param BookValume
	 * @return
	 * @throws Exception
	 */	 
 	public void insertBookValume(BookValume bookValume) throws DataAccessException {
		bookValumeMapper.insertBookValume(bookValume);
	}
	
	/**
	 * update BookValume
	 * @param BookValume
	 * @return
	 * @throws Exception
	 */
	public void updateBookValume(BookValume bookValume) throws DataAccessException{
		bookValumeMapper.updateBookValume(bookValume);

	}
	
	/**
	 * delete BookValume by id
	 * @param id
	 * @return void
	 * @throws Exception
	 */
	public void deleteBookValumeById(String id) throws DataAccessException{
		
		bookValumeMapper.deleteBookValumeById(id);

	}
	

	/**
	 * get BookValume by id
	 * @param id
	 * @return BookValume
	 * @throws Exception
	 */	
	public BookValume getBookValumeById(String id) throws DataAccessException{
	
		return bookValumeMapper.getBookValumeById(id);
	}
	
	/**
	 * 
	 * @return the list of BookValume
	 */
	public List<BookValume> getBookValumeList() throws DataAccessException {
		return bookValumeMapper.getBookValumeList();
	}
	
	/**
	 * 
	 * @return the count of bookValume
	 * @throws Exception
	 */
	public  int getBookValumeCount(String s) throws DataAccessException{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("s", s);
		return bookValumeMapper.getBookValumeCount(map);
	}
	/**
	 * 
	 * @param map
	 * @return the bookValume limit pages
	 * @throws Exception
	 */
	public List<BookValume> getBookValumeListByPage(int page,int pageSize,String s) throws DataAccessException{
		Map<String,Object> map = new HashMap<String,Object>();
		int start = page - 1 < 1 ? 0 : (page - 1) * pageSize;
		map.put("start", start);
		map.put("length", pageSize);
		map.put("s", s);
		return bookValumeMapper.getBookValumeListByPage(map);
	}
		
	
	
	
}
