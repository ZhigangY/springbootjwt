package com.uplinfo.book.ubdata.domain;

import java.util.Date;
import java.io.Serializable;

/**
  * @ClassName: Book
  * @Description:
  * @author: Ray Yu
  * @date: August 2, 2018
  * @version: 1.0
  */
public class Book implements Serializable {
  
  private static final long serialVersionUID = 106333009515704141L;
  private String id; 
  private String bookName; 
  private Integer category; 
  private String author; 
  private String summary; 
  private String bookCover; 
  private Integer orderline; 
  private String bookapi; 

  public String getId(){
  	return id;
  }
  public void setId(String id){
  	this.id = id;
  }
  public String getBookName(){
  	return bookName;
  }
  public void setBookName(String bookName){
  	this.bookName = bookName;
  }
  public Integer getCategory(){
  	return category;
  }
  public void setCategory(Integer category){
  	this.category = category;
  }
  public String getAuthor(){
  	return author;
  }
  public void setAuthor(String author){
  	this.author = author;
  }
  public String getSummary(){
  	return summary;
  }
  public void setSummary(String summary){
  	this.summary = summary;
  }
  public String getBookCover(){
  	return bookCover;
  }
  public void setBookCover(String bookCover){
  	this.bookCover = bookCover;
  }
  public Integer getOrderline(){
  	return orderline;
  }
  public void setOrderline(Integer orderline){
  	this.orderline = orderline;
  }
  public String getBookapi(){
  	return bookapi;
  }
  public void setBookapi(String bookapi){
  	this.bookapi = bookapi;
  }

}

