package com.uplinfo.book.ubdata.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uplinfo.book.ubdata.domain.BookCategory;
import com.uplinfo.book.ubdata.persistence.BookCategoryMapper;

/**
  * @ClassName: BookCategoryService
  * @Description:
  * @author: Ray Yu
  * @date:  July 25, 2018
  * @version: 1.0
  */
@Service
public class BookCategoryService {
	
	private final static Log logger = LogFactory.getLog(BookCategoryService.class);

	@Autowired
	private BookCategoryMapper bookCategoryMapper;

	/**
	 * insert BookCategory
	 * @param BookCategory
	 * @return
	 * @throws Exception
	 */	 
 	public void insertBookCategory(BookCategory bookCategory) throws DataAccessException {
		bookCategoryMapper.insertBookCategory(bookCategory);
	}
	
	/**
	 * update BookCategory
	 * @param BookCategory
	 * @return
	 * @throws Exception
	 */
	public void updateBookCategory(BookCategory bookCategory) throws DataAccessException{
		bookCategoryMapper.updateBookCategory(bookCategory);

	}
	
	/**
	 * delete BookCategory by id
	 * @param id
	 * @return void
	 * @throws Exception
	 */
	public void deleteBookCategoryById(String id) throws DataAccessException{
		
		bookCategoryMapper.deleteBookCategoryById(id);

	}
	

	/**
	 * get BookCategory by id
	 * @param id
	 * @return BookCategory
	 * @throws Exception
	 */	
	public BookCategory getBookCategoryById(String id) throws DataAccessException{
	
		return bookCategoryMapper.getBookCategoryById(id);
	}
	
	/**
	 * 
	 * @return the list of BookCategory
	 */
	public List<BookCategory> getBookCategoryList() throws DataAccessException {
		return bookCategoryMapper.getBookCategoryList();
	}
	


}
