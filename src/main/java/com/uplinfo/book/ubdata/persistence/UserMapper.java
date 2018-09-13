package com.uplinfo.book.ubdata.persistence;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.uplinfo.book.ubdata.domain.User;

/**
 * @ClassName: UserMapper
 * @Description:
 * @author: Ray Yu
 * @date: June 17, 2015
 * @version: 1.0
 */
public interface UserMapper {

	void insertUser(User user) throws DataAccessException;

	void updateUser(User user) throws DataAccessException;

	User getUserByUserId(int userId) throws DataAccessException;

	User getUserByUsername(String username) throws DataAccessException;
	
	//
	//editUserPassword
	void updateUserPassword(User user) throws DataAccessException;
	void updateUserAvatar(User user) throws DataAccessException;
	void updateUserProfile(User user) throws DataAccessException;
	
	void deleteUser(int userId) throws DataAccessException;

	int getUserCount(Map<String, Object> map) throws DataAccessException;
	
}
