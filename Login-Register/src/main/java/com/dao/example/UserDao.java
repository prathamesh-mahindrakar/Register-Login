package com.dao.example;

public interface UserDao {

	boolean isValidUser(String username, String password);

	boolean addUser(User user);

}
