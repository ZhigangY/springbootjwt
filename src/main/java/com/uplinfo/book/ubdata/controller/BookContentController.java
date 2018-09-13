package com.uplinfo.book.ubdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uplinfo.book.ubdata.domain.BookContent;
import com.uplinfo.book.ubdata.domain.ResponseData;
import com.uplinfo.book.ubdata.service.BookContentService;
import com.uplinfo.book.ubdata.utils.StringUtil;

/**
 * @ClassName: BookContentController
 * @Description:
 * @author: Ray Yu
 * @date: August 2, 2018
 * @version: 1.0
 */
@RestController
public class BookContentController {

	@Autowired
	private BookContentService bookContentService;

	@RequestMapping(value = "/bookContent", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseData handlerShowBookContents() {
		List<BookContent> bookContentList = bookContentService.getBookContentList();
		return StringUtil.success(bookContentList);
	}

	@RequestMapping(value = "/bookContent/{id}/{page}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseData handlerShowBookContentsByIdPage(@PathVariable("id") Integer id,
			@PathVariable("page") Integer page) {
		List<BookContent> bookContentList = bookContentService.getBookContentListByPage(page, 20, id);
		return StringUtil.success(bookContentList);
	}

	@RequestMapping(value = "/bookContent/{id}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseData handlerBookContentById(@PathVariable("id") String id) {
		BookContent bookContent = bookContentService.getBookContentById(id);
		return StringUtil.success(bookContent);
	}
	
	@RequestMapping(value = "/bookContent/pages/{id}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseData handlerBookContentPagesById(@PathVariable("id") Integer id) {
		return StringUtil.success(bookContentService.getBookContentCount(id));
	}

	@RequestMapping(value = "/bookContent", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseData handlerSaveBookContent(@RequestBody BookContent bookContent) {
		bookContentService.insertBookContent(bookContent);
		return StringUtil.success(bookContent);
	}

	@RequestMapping(value = "/bookContent/{id}", method = RequestMethod.PUT, produces = { "application/json" })
	public ResponseData handlerUpdateBookContent(@PathVariable("id") String id, @RequestBody BookContent bookContent) {
		bookContent.setId(id);
		bookContentService.updateBookContent(bookContent);
		return StringUtil.success(bookContent);
	}

	@RequestMapping(value = "/bookContent/{id}", method = RequestMethod.DELETE, produces = { "application/json" })
	public ResponseData handlerDeleteBookContent(@PathVariable("id") String id) {
		bookContentService.deleteBookContentById(id);
		return StringUtil.success(id);
	}
}
