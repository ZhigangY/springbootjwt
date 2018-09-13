package com.uplinfo.book.ubdata.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uplinfo.book.ubdata.domain.BookContent;
import com.uplinfo.book.ubdata.persistence.BookContentMapper;

/**
  * @ClassName: BookContentService
  * @Description:
  * @author: Ray Yu
  * @date:  August 2, 2018
  * @version: 1.0
  */
@Service
public class BookContentService {
	
	private final static Log logger = LogFactory.getLog(BookContentService.class);

	@Autowired
	private BookContentMapper bookContentMapper;

	/**
	 * insert BookContent
	 * @param BookContent
	 * @return
	 * @throws Exception
	 */	 
 	public void insertBookContent(BookContent bookContent) throws DataAccessException {
		bookContentMapper.insertBookContent(bookContent);
	}
	
	/**
	 * update BookContent
	 * @param BookContent
	 * @return
	 * @throws Exception
	 */
	public void updateBookContent(BookContent bookContent) throws DataAccessException{
		bookContentMapper.updateBookContent(bookContent);

	}
	
	/**
	 * delete BookContent by id
	 * @param id
	 * @return void
	 * @throws Exception
	 */
	public void deleteBookContentById(String id) throws DataAccessException{
		
		bookContentMapper.deleteBookContentById(id);

	}
	

	/**
	 * get BookContent by id
	 * @param id
	 * @return BookContent
	 * @throws Exception
	 */	
	public BookContent getBookContentById(String id) throws DataAccessException{
	
		return bookContentMapper.getBookContentById(id);
	}
	
	/**
	 * 
	 * @return the list of BookContent
	 */
	public List<BookContent> getBookContentList() throws DataAccessException {
		return bookContentMapper.getBookContentList();
	}
	
	/**
	 * 
	 * @return the count of bookContent
	 * @throws Exception
	 */
	public  int getBookContentCount(int bookId) throws DataAccessException{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("bookId", bookId);
		return bookContentMapper.getBookContentCount(map);
	}
	/**
	 * 
	 * @param map
	 * @return the bookContent limit pages
	 * @throws Exception
	 */
	public List<BookContent> getBookContentListByPage(int page,int pageSize,int bookId) throws DataAccessException{
		Map<String,Object> map = new HashMap<String,Object>();
		int start = page - 1 < 1 ? 0 : (page - 1) * pageSize;
		map.put("start", start);
		map.put("length", pageSize);
		map.put("bookId", bookId);
		return bookContentMapper.getBookContentListByPage(map);
	}
		
	
}
