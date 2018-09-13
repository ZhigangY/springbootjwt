package com.uplinfo.book.ubdata.domain;

import java.util.Date;
import java.io.Serializable;

/**
  * @ClassName: BookContent
  * @Description:
  * @author: Ray Yu
  * @date: August 2, 2018
  * @version: 1.0
  */
public class BookContent implements Serializable {
  
  private static final long serialVersionUID = 6354352588779901L;
  private String id; 
  private Integer bookid; 
  private Integer volumeid; 
  private String title; 
  private String noteText; 
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
  public Integer getVolumeid(){
  	return volumeid;
  }
  public void setVolumeid(Integer volumeid){
  	this.volumeid = volumeid;
  }
  public String getTitle(){
  	return title;
  }
  public void setTitle(String title){
  	this.title = title;
  }
  public String getNoteText(){
  	return noteText;
  }
  public void setNoteText(String noteText){
  	this.noteText = noteText;
  }
  public Integer getOrderline(){
  	return orderline;
  }
  public void setOrderline(Integer orderline){
  	this.orderline = orderline;
  }

}

