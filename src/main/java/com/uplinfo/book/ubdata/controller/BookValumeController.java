package com.uplinfo.book.ubdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uplinfo.book.ubdata.domain.BookValume;
import com.uplinfo.book.ubdata.domain.ResponseData;
import com.uplinfo.book.ubdata.service.BookValumeService;
import com.uplinfo.book.ubdata.utils.StringUtil;

/**
  * @ClassName: BookValumeController
  * @Description:
  * @author: Ray Yu
  * @date: August 2, 2018
  * @version: 1.0
  */
@RestController
public class BookValumeController {
		
	
	@Autowired
	private BookValumeService bookValumeService;
	

	@RequestMapping(value = "/bookValume", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseData handlerShowBookValumes(){
		List<BookValume> bookValumeList = bookValumeService.getBookValumeList();
		return StringUtil.success(bookValumeList);
	}
 	
 	@RequestMapping(value = "/bookValume/{id}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseData handlerBookValumeById(@PathVariable("id") String id){
		BookValume bookValume = bookValumeService.getBookValumeById(id);
		return StringUtil.success(bookValume);
	}
	
	@RequestMapping(value = "/bookValume", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseData handlerSaveBookValume(@RequestBody BookValume bookValume){
		bookValumeService.insertBookValume(bookValume);
		return StringUtil.success(bookValume);
	} 
	
	@RequestMapping(value = "/bookValume/{id}", method = RequestMethod.PUT, produces = { "application/json" })
	public ResponseData handlerUpdateBookValume(@PathVariable("id") String id, @RequestBody BookValume bookValume){
		bookValume.setId(id);
		bookValumeService.updateBookValume(bookValume);
		return StringUtil.success(bookValume);
	} 
	
	@RequestMapping(value = "/bookValume/{id}", method = RequestMethod.DELETE, produces = { "application/json" })
	public ResponseData handlerDeleteBookValume(@PathVariable("id") String id){	
		bookValumeService.deleteBookValumeById(id);
		return StringUtil.success(id);
	}	
}
