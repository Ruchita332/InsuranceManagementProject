package com.ims.dao;
import java.util.List;

import com.ims.pojo.User;

public interface UserDAO {
		List<User> addUser(List<User> users);
		User verifyUser (String uname, String pwd);
		void forgotPassword(List<User> users);
		void userList (List<User> users);
}
