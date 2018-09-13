package com.uplinfo.book.ubdata.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uplinfo.book.ubdata.domain.ResponseData;

@ControllerAdvice
public class GlobalExceptionHandler {
	 private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	 
	    /**
	     * 系统异常处理，比如：404,500
	     * @param req
	     * @param resp
	     * @param e
	     * @return
	     * @throws Exception
	     */
	    @ExceptionHandler(value = Exception.class)
	    @ResponseBody
	    public ResponseData defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
	        logger.error(e.getMessage(), e);
	        ResponseData r = new ResponseData();
	        r.setMessage(e.getMessage());
	        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
	             r.setStatus(404);
	        } else {
	             r.setStatus(500);
	        }
	        r.setData(null);
	        return r;
	    }
}
