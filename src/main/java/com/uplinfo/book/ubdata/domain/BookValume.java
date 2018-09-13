package com.uplinfo.book.ubdata.domain;

import java.util.Date;
import java.io.Serializable;

/**
  * @ClassName: BookValume
  * @Description:
  * @author: Ray Yu
  * @date: August 2, 2018
  * @version: 1.0
  */
public class BookValume implements Serializable {
  
  private static final long serialVersionUID = 10666164063958653L;
  private String id; 
  private Integer bookid; 
  private String name; 
  private Integer orderline; 

  public String getId(){
  	return id;
  }
  public void setId(String id){
  	this.id = id;
  }
  public Integer getBookid(){
  	return bookid;
  }
  public void setBookid(Integer bookid){
  	this.bookid = bookid;
  }
  public String getName(){
  	return name;
  }
  public void setName(String name){
  	this.name = name;
  }
  public Integer getOrderline(){
  	return orderline;
  }
  public void setOrderline(Integer orderline){
  	this.orderline = orderline;
  }

}

