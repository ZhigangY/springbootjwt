package com.uplinfo.book.ubdata.utils;

import com.uplinfo.book.ubdata.domain.ResponseData;

public class StringUtil {
	public static ResponseData success(Object object){
		ResponseData rd = new ResponseData();
		rd.setData(object);
		rd.setStatus(200);
		rd.setMessage("OK");
		return rd;
	}
}
 