package com.uplinfo.book.ubdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uplinfo.book.ubdata.domain.BookCategory;
import com.uplinfo.book.ubdata.domain.ResponseData;
import com.uplinfo.book.ubdata.service.BookCategoryService;
import com.uplinfo.book.ubdata.utils.StringUtil;


/**
  * @ClassName: BookCategoryController
  * @Description:
  * @author: Ray Yu
  * @date: July 25, 2018
  * @version: 1.0
  */
@RestController
public class BookCategoryController {
		
	
	@Autowired
	private BookCategoryService bookCategoryService;
	

	@RequestMapping(value = "/bookCategory", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseData handlerShowBookCategorys(){
		List<BookCategory> bookCategoryList = bookCategoryService.getBookCategoryList();
		return StringUtil.success(bookCategoryList);
	}
	
	@RequestMapping(value = "/bookCategory/{id}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseData handlerShowBookCategoryById(@PathVariable("id") String id){
		BookCategory bookCategory = bookCategoryService.getBookCategoryById(id);
		return StringUtil.success(bookCategory);
	}
	
	@RequestMapping(value = "/bookCategory", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseData handlerSaveBookCategory(@RequestBody BookCategory bookCategory){
		bookCategoryService.insertBookCategory(bookCategory);
		return StringUtil.success(bookCategory);
	} 
	
	@RequestMapping(value = "/bookCategory/{id}", method = RequestMethod.PUT, produces = { "application/json" })
	public ResponseData handlerUpdateBookCategory(@PathVariable("id") String id, @RequestBody BookCategory bookCategory){
		bookCategory.setId(id);
		bookCategoryService.updateBookCategory(bookCategory);
		return StringUtil.success(bookCategory);
	} 
	
	@RequestMapping(value = "/bookCategory/{id}", method = RequestMethod.DELETE, produces = { "application/json" })
	public ResponseData handlerDeleteBookCategory(@PathVariable("id") String id){	
		bookCategoryService.deleteBookCategoryById(id);
		return StringUtil.success(id);
	} 
}
