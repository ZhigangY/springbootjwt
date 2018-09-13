package com.uplinfo.book.ubdata.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uplinfo.book.ubdata.domain.Book;
import com.uplinfo.book.ubdata.persistence.BookMapper;

/**
  * @ClassName: BookService
  * @Description:
  * @author: Ray Yu
  * @date:  August 2, 2018
  * @version: 1.0
  */
@Service
public class BookService {
	
	private final static Log logger = LogFactory.getLog(BookService.class);

	@Autowired
	private BookMapper bookMapper;

	/**
	 * insert Book
	 * @param Book
	 * @return
	 * @throws Exception
	 */	 
 	public void insertBook(Book book) throws DataAccessException {
		bookMapper.insertBook(book);
	}
	
	/**
	 * update Book
	 * @param Book
	 * @return
	 * @throws Exception
	 */
	public void updateBook(Book book) throws DataAccessException{
		bookMapper.updateBook(book);

	}
	
	/**
	 * delete Book by id
	 * @param id
	 * @return void
	 * @throws Exception
	 */
	public void deleteBookById(String id) throws DataAccessException{
		
		bookMapper.deleteBookById(id);

	}
	

	/**
	 * get Book by id
	 * @param id
	 * @return Book
	 * @throws Exception
	 */	
	public Book getBookById(String id) throws DataAccessException{
	
		return bookMapper.getBookById(id);
	}
	
	/**
	 * 
	 * @return the list of Book
	 */
	public List<Book> getBookList() throws DataAccessException {
		return bookMapper.getBookList();
	}
	
	/**
	 * 
	 * @return the count of book
	 * @throws Exception
	 */
	public  int getBookCount(String s) throws DataAccessException{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("s", s);
		return bookMapper.getBookCount(map);
	}
	/**
	 * 
	 * @param map
	 * @return the book limit pages
	 * @throws Exception
	 */
	public List<Book> getBookListByPage(int page,int pageSize,String s) throws DataAccessException{
		Map<String,Object> map = new HashMap<String,Object>();
		int start = page - 1 < 1 ? 0 : (page - 1) * pageSize;
		map.put("start", start);
		map.put("length", pageSize);
		map.put("s", s);
		return bookMapper.getBookListByPage(map);
	}
		
	
}
