package com.uplinfo.book.ubdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uplinfo.book.ubdata.domain.Book;
import com.uplinfo.book.ubdata.domain.ResponseData;
import com.uplinfo.book.ubdata.service.BookService;
import com.uplinfo.book.ubdata.utils.StringUtil;

/**
  * @ClassName: BookController
  * @Description:
  * @author: Ray Yu
  * @date: August 2, 2018
  * @version: 1.0
  */
@RestController
public class BookController {
		
	
	@Autowired
	private BookService bookService;
	

	@RequestMapping(value = "/book", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseData handlerShowBooks(){
		List<Book> bookList = bookService.getBookList();
		return StringUtil.success(bookList);
	}
 	
 	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseData handlerBookById(@PathVariable("id") String id){
		Book book = bookService.getBookById(id);
		return StringUtil.success(book);
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseData handlerSaveBook(@RequestBody Book book){
		bookService.insertBook(book);
		return StringUtil.success(book);
	} 
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.PUT, produces = { "application/json" })
	public ResponseData handlerUpdateBook(@PathVariable("id") String id, @RequestBody Book book){
		book.setId(id);
		bookService.updateBook(book);
		return StringUtil.success(book);
	} 
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE, produces = { "application/json" })
	public ResponseData handlerDeleteBook(@PathVariable("id") String id){	
		bookService.deleteBookById(id);
		return StringUtil.success(id);
	}	
}
