package com.uplinfo.book.ubdata.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uplinfo.book.ubdata.domain.User;
import com.uplinfo.book.ubdata.persistence.UserMapper;

@RestController
public class UserController {
	
	@Autowired
	UserMapper userMapper;
	
	@RequestMapping(value = "/users", produces="application/json;charset=UTF-8")
	public List<String> usersList() {

        List<String> users =  new ArrayList<String>(){{
            add("freewolf");
            add("tom");
            add("jerry");
        }};

		return users;
	}
	
	 @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	 public  User getUser(@PathVariable int id){
		 return userMapper.getUserByUserId(id);
	 }
}
