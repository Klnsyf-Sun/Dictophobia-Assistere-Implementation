package com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.service.user;

import java.sql.SQLException;

import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dao.UserDAOImpl;
import com.dictophobiaassistereimplementation.dictophobiaassistereimplementation.dto.User;

public class UserRegister {
	private static UserRegister userRegister = new UserRegister();

	public static UserRegister getInstance() {
		return userRegister;
	}

	public boolean register(User user) throws SQLException {
		return UserDAOImpl.getInstance().insertUser(user);
	}

}
