package com.uplinfo.book.ubdata.domain;

import java.util.Date;
import java.io.Serializable;

/**
  * @ClassName: BookCategory
  * @Description:
  * @author: Ray Yu
  * @date: July 25, 2018
  * @version: 1.0
  */
public class BookCategory implements Serializable {
  
  private static final long serialVersionUID = 246555093859811517L;
  private String id; 
  private String name; 
  private Integer orderline; 

  public String getId(){
  	return id;
  }
  public void setId(String id){
  	this.id = id;
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

