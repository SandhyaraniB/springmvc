package com.bridgeit.dao;

import com.bridgeit.model.LoginInfo;
import com.bridgeit.model.User;

public interface UserDao 
{
	  int addUser(User user);
	  boolean checkUserIsPresent(LoginInfo login);
}