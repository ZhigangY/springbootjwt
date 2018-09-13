package com.uplinfo.book.ubdata.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.uplinfo.book.ubdata.domain.BookCategory;

/**
 * @ClassName: BookCategoryMapper
 * @Description:
 * @author: Ray Yu
 * @date: July 25, 2018
 * @version: 1.0
 */
public interface BookCategoryMapper {

	void insertBookCategory(BookCategory bookCategory) throws DataAccessException;

	void updateBookCategory(BookCategory bookCategory) throws DataAccessException;

	void deleteBookCategoryById(String id) throws DataAccessException;

	BookCategory getBookCategoryById(String id) throws DataAccessException;

	List<BookCategory> getBookCategoryList() throws DataAccessException;

}
